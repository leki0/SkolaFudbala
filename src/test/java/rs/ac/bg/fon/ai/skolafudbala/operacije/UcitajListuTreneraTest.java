package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import java.util.Arrays;
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

@ExtendWith(MockitoExtension.class)
public class UcitajListuTreneraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajListuTrenera ucitajListuTrenera;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajListuTrenera, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanjeListe() throws Exception {
        Trener fudbaler1 = new Trener();
        fudbaler1.setIme("Marko");
        fudbaler1.setPrezime("Markovic");

        Trener fudbaler2 = new Trener();
        fudbaler2.setIme("Jovan");
        fudbaler2.setPrezime("Jovanovic");

        List<Trener> listaFudbaleraIzBaze = Arrays.asList(fudbaler1, fudbaler2);

        when(repozitorijum.getAll(new Trener())).thenReturn(listaFudbaleraIzBaze);

        ucitajListuTrenera.izvrsiOperaciju(new Object());

        assertEquals(listaFudbaleraIzBaze, ucitajListuTrenera.getListaTrenera());
        verify(repozitorijum, times(1)).getAll(new Trener());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getAll(new Trener())).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajListuTrenera.izvrsiOperaciju(new Object());
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getAll(new Trener());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajListuTrenera.preduslovi(new Object());
        });
    }
}
