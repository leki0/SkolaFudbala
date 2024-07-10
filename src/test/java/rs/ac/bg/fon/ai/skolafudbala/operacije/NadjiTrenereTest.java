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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NadjiTrenereTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private NadjiTrenere nadjiTrenere;

    private Trener trener;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        trener = new Trener();
        trener.setIme("Marko");
        trener.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(nadjiTrenere, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnaPretraga() throws Exception {
        List<Trener> rezultatiPretrage = Arrays.asList(trener);
        when(repozitorijum.pretraga(trener)).thenReturn(rezultatiPretrage);

        nadjiTrenere.izvrsiOperaciju(trener);

        assertEquals(rezultatiPretrage, nadjiTrenere.getListaTreneraPretraga());
        verify(repozitorijum, times(1)).pretraga(trener);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        // Postavite ponašanje mock objekta da baci izuzetak kada se pozove pretraga
        when(repozitorijum.pretraga(trener)).thenThrow(new Exception("Greška u repozitorijumu"));

        // Proverite da li se izuzetak pravilno propagira
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTrenere.izvrsiOperaciju(trener);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).pretraga(trener);
    }
    
    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTrenere.preduslovi(null);
        });

        assertEquals("Objekat trener nije validan za pretragu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTrenere.preduslovi(new Object());
        });

        assertEquals("Objekat trener nije validan za pretragu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            nadjiTrenere.preduslovi(trener);
        });
    }

}
