package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;

@ExtendWith(MockitoExtension.class)
public class ZapamtiTreneraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiTrenera zapamtiTrenera;

    private Trener trener;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        trener = new Trener();
        trener.setJmbg("1234567890123");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiTrenera, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoDodavanje() throws Exception {
        when(repozitorijum.add(trener)).thenReturn(9L);

        zapamtiTrenera.izvrsiOperaciju(trener);

        assertEquals(9L, zapamtiTrenera.getId());
        verify(repozitorijum, times(1)).add(trener);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.add(trener)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiTrenera.izvrsiOperaciju(trener);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).add(trener);
    }

    @Test
    public void testPreduslovi_DupliranJMBG() throws Exception {
        Trener drugiTrener = new Trener();
        drugiTrener.setJmbg("1234567890123");

        List<Trener> listaTrenera = Collections.singletonList(drugiTrener);
        when(repozitorijum.getAll(any(Trener.class))).thenReturn(listaTrenera);

        assertThrows(Exception.class, () -> {
            zapamtiTrenera.preduslovi(trener);
        });

    }

    @Test
    public void testPreduslovi_NevalidanObjekat() {
        assertThrows(Exception.class, () -> {
            zapamtiTrenera.preduslovi(null);
        });

        assertThrows(Exception.class, () -> {
            zapamtiTrenera.preduslovi(new Korisnik());
        });

    }

    @Test
    public void testPreduslovi_UspesnaValidacija() {
        assertDoesNotThrow(() -> {
            zapamtiTrenera.preduslovi(trener);
        });
    }
}
