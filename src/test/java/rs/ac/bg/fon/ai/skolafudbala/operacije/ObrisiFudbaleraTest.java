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
public class ObrisiFudbaleraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ObrisiFudbalera obrisiFudbalera;

    private Fudbaler fudbaler;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        fudbaler = new Fudbaler();
        fudbaler.setIme("Marko");
        fudbaler.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(obrisiFudbalera, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoBrisanje() throws Exception {
        when(repozitorijum.delete(fudbaler)).thenReturn(1);

        obrisiFudbalera.izvrsiOperaciju(fudbaler);

        assertEquals(1, obrisiFudbalera.getObrisanFudbaler());
        verify(repozitorijum, times(1)).delete(fudbaler);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.delete(fudbaler)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            obrisiFudbalera.izvrsiOperaciju(fudbaler);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).delete(fudbaler);
    }
    
    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            obrisiFudbalera.preduslovi(null);
        });

        assertEquals("Objekat fudbaler nije validan za brisanje. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            obrisiFudbalera.preduslovi(new Object());
        });

        assertEquals("Objekat fudbaler nije validan za brisanje. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            obrisiFudbalera.preduslovi(fudbaler);
        });
    }
}
