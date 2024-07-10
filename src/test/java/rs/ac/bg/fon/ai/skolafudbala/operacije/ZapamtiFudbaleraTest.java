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
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;

@ExtendWith(MockitoExtension.class)
public class ZapamtiFudbaleraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiFudbalera zapamtiFudbalera;

    private Fudbaler fudbaler;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        fudbaler = new Fudbaler();
        fudbaler.setJmbg("1234567890123");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiFudbalera, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoDodavanje() throws Exception {
        when(repozitorijum.add(fudbaler)).thenReturn(1L);

        zapamtiFudbalera.izvrsiOperaciju(fudbaler);

        assertEquals(1L, zapamtiFudbalera.getId());
        verify(repozitorijum, times(1)).add(fudbaler);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.add(fudbaler)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiFudbalera.izvrsiOperaciju(fudbaler);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).add(fudbaler);
    }

    @Test
    public void testPreduslovi_DupliranJMBG() throws Exception {
        Fudbaler drugiFudbaler = new Fudbaler();
        drugiFudbaler.setJmbg("1234567890123");

        List<Fudbaler> listaFudbalera = Collections.singletonList(drugiFudbaler);
        when(repozitorijum.getAll(any(Fudbaler.class))).thenReturn(listaFudbalera);

        assertThrows(Exception.class, () -> {
            zapamtiFudbalera.preduslovi(fudbaler);
        });

    }

    @Test
    public void testPreduslovi_NevalidanObjekat() {
        assertThrows(Exception.class, () -> {
            zapamtiFudbalera.preduslovi(null);
        });

        assertThrows(Exception.class, () -> {
            zapamtiFudbalera.preduslovi(new Korisnik());
        });

    }

    @Test
    public void testPreduslovi_UspesnaValidacija() {
        assertDoesNotThrow(() -> {
            zapamtiFudbalera.preduslovi(fudbaler);
        });
    }
}
