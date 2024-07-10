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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NadjiFudbalereTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private NadjiFudbalere nadjiFudbalere;

    private Fudbaler fudbaler;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        fudbaler = new Fudbaler();
        fudbaler.setIme("Marko");
        fudbaler.setPrezime("Markovic");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(nadjiFudbalere, repozitorijum);
    }

    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiFudbalere.preduslovi(null);
        });

        assertEquals("Objekat fudbaler nije validan za pretragu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiFudbalere.preduslovi(new Object());
        });

        assertEquals("Objekat fudbaler nije validan za pretragu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            nadjiFudbalere.preduslovi(fudbaler);
        });
    }

    @Test
    public void testIzvrsiOperaciju_UspesnaPretraga() throws Exception {
        List<Fudbaler> rezultatiPretrage = Arrays.asList(fudbaler);
        when(repozitorijum.pretraga(fudbaler)).thenReturn(rezultatiPretrage);

        nadjiFudbalere.izvrsiOperaciju(fudbaler);

        assertEquals(rezultatiPretrage, nadjiFudbalere.getListaFudbaleraPretraga());
        verify(repozitorijum, times(1)).pretraga(fudbaler);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        // Postavite ponašanje mock objekta da baci izuzetak kada se pozove pretraga
        when(repozitorijum.pretraga(fudbaler)).thenThrow(new Exception("Greška u repozitorijumu"));

        // Proverite da li se izuzetak pravilno propagira
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiFudbalere.izvrsiOperaciju(fudbaler);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).pretraga(fudbaler);
    }

}
