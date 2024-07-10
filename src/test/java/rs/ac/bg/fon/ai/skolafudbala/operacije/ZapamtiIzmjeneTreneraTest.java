package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
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
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ZapamtiIzmjeneTreneraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiIzmjeneTrenera zapamtiIzmjeneTrenera;

    private Trener trener;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        trener = new Trener();
        trener.setIme("Marko");
        trener.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiIzmjeneTrenera, repozitorijum);
    }
    
    @Test
    public void testIzvrsiOperaciju_UspesnaIzmjena() throws Exception {
        when(repozitorijum.addUpdate(trener)).thenReturn(1);

        zapamtiIzmjeneTrenera.izvrsiOperaciju(trener);

        assertEquals(1, zapamtiIzmjeneTrenera.getIzmjenjenTrener());
        verify(repozitorijum, times(1)).addUpdate(trener);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.addUpdate(trener)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneTrenera.izvrsiOperaciju(trener);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).addUpdate(trener);
    }
    
    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneTrenera.preduslovi(null);
        });

        assertEquals("Objekat trener nije validan za izmjenu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneTrenera.preduslovi(new Object());
        });

        assertEquals("Objekat trener nije validan za izmjenu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            zapamtiIzmjeneTrenera.preduslovi(trener);
        });
    }

}
