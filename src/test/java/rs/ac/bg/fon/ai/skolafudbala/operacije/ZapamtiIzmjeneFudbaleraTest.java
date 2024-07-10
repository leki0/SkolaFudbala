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
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ZapamtiIzmjeneFudbaleraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiIzmjeneFudbalera zapamtiIzmjeneFudbalera;

    private Fudbaler fudbaler;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        fudbaler = new Fudbaler();
        fudbaler.setIme("Marko");
        fudbaler.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiIzmjeneFudbalera, repozitorijum);
    }
    
    @Test
    public void testIzvrsiOperaciju_UspesnaIzmjena() throws Exception {
        when(repozitorijum.addUpdate(fudbaler)).thenReturn(1);

        zapamtiIzmjeneFudbalera.izvrsiOperaciju(fudbaler);

        assertEquals(1, zapamtiIzmjeneFudbalera.getIzmjenjenFudbaler());
        verify(repozitorijum, times(1)).addUpdate(fudbaler);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.addUpdate(fudbaler)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneFudbalera.izvrsiOperaciju(fudbaler);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).addUpdate(fudbaler);
    }
    
    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneFudbalera.preduslovi(null);
        });

        assertEquals("Objekat fudbaler nije validan za izmjenu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneFudbalera.preduslovi(new Object());
        });

        assertEquals("Objekat fudbaler nije validan za izmjenu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            zapamtiIzmjeneFudbalera.preduslovi(fudbaler);
        });
    }

}
