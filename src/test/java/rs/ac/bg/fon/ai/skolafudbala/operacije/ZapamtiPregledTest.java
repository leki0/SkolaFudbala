package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;
import rs.ac.bg.fon.ai.skolafudbala.model.LekarskiPregled;

@ExtendWith(MockitoExtension.class)
public class ZapamtiPregledTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiPregled zapamtiPregled;

    private LekarskiPregled lekarskiPregled;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        lekarskiPregled = new LekarskiPregled();

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiPregled, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoDodavanje() throws Exception {
        when(repozitorijum.add(lekarskiPregled)).thenReturn(3L);

        zapamtiPregled.izvrsiOperaciju(lekarskiPregled);

        assertEquals(3L, zapamtiPregled.getId());
        verify(repozitorijum, times(1)).add(lekarskiPregled);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.add(lekarskiPregled)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiPregled.izvrsiOperaciju(lekarskiPregled);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).add(lekarskiPregled);
    }

    @Test
    public void testPreduslovi_NevalidanObjekat() {
        assertThrows(Exception.class, () -> {
            zapamtiPregled.preduslovi(null);
        });

        assertThrows(Exception.class, () -> {
            zapamtiPregled.preduslovi(new Korisnik());
        });

    }

    @Test
    public void testPreduslovi_UspesnaValidacija() {
        assertDoesNotThrow(() -> {
            zapamtiPregled.preduslovi(lekarskiPregled);
        });
    }
}
