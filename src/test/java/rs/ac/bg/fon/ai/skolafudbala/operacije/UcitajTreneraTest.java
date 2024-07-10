package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.skolafudbala.model.Trener;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcitajTreneraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajTrenera ucitajTrenera;

    private Trener trener;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        trener = new Trener();
        trener.setIme("Marko");
        trener.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajTrenera, repozitorijum);
    }
    
    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanje() throws Exception {
        Trener trenerIzBaze = new Trener();
        trenerIzBaze.setIme("Marko");
        trenerIzBaze.setPrezime("Markovic");

        when(repozitorijum.getWhere(trener)).thenReturn(trenerIzBaze);

        ucitajTrenera.izvrsiOperaciju(trener);

        assertEquals(trenerIzBaze, ucitajTrenera.getTrenerBaza());
        verify(repozitorijum, times(1)).getWhere(trener);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getWhere(trener)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajTrenera.izvrsiOperaciju(trener);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getWhere(trener);
    }

   @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajTrenera.preduslovi(null);
        });

        assertEquals("VALIDACIJA! Vrijednost parametra nije validna!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajTrenera.preduslovi(new Object());
        });

        assertEquals("VALIDACIJA! Vrijednost parametra nije validna!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajTrenera.preduslovi(trener);
        });
    }

}
