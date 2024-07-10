package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
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

@ExtendWith(MockitoExtension.class)
public class UcitajFudbaleraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajFudbalera ucitajFudbalera;

    private Fudbaler fudbaler;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        fudbaler = new Fudbaler();
        fudbaler.setIme("Marko");
        fudbaler.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajFudbalera, repozitorijum);
    }

    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajFudbalera.preduslovi(null);
        });

        assertEquals("VALIDACIJA! Vrijednost parametra nije validna!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajFudbalera.preduslovi(new Object());
        });

        assertEquals("VALIDACIJA! Vrijednost parametra nije validna!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajFudbalera.preduslovi(fudbaler);
        });
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanje() throws Exception {
        Fudbaler fudbalerIzBaze = new Fudbaler();
        fudbalerIzBaze.setIme("Marko");
        fudbalerIzBaze.setPrezime("Markovic");

        when(repozitorijum.getWhere(fudbaler)).thenReturn(fudbalerIzBaze);

        ucitajFudbalera.izvrsiOperaciju(fudbaler);

        assertEquals(fudbalerIzBaze, ucitajFudbalera.getFudbalerBaza());
        verify(repozitorijum, times(1)).getWhere(fudbaler);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getWhere(fudbaler)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajFudbalera.izvrsiOperaciju(fudbaler);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getWhere(fudbaler);
    }
}
