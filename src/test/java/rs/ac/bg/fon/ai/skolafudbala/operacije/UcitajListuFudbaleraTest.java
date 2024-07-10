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
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcitajListuFudbaleraTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajListuFudbalera ucitajListuFudbalera;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajListuFudbalera, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanjeListe() throws Exception {
        Fudbaler fudbaler1 = new Fudbaler();
        fudbaler1.setIme("Marko");
        fudbaler1.setPrezime("Markovic");

        Fudbaler fudbaler2 = new Fudbaler();
        fudbaler2.setIme("Jovan");
        fudbaler2.setPrezime("Jovanovic");

        List<Fudbaler> listaFudbaleraIzBaze = Arrays.asList(fudbaler1, fudbaler2);

        when(repozitorijum.getAll(new Fudbaler())).thenReturn(listaFudbaleraIzBaze);

        ucitajListuFudbalera.izvrsiOperaciju(new Object());

        assertEquals(listaFudbaleraIzBaze, ucitajListuFudbalera.getListaFudbalera());
        verify(repozitorijum, times(1)).getAll(new Fudbaler());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getAll(new Fudbaler())).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajListuFudbalera.izvrsiOperaciju(new Object());
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getAll(new Fudbaler());
    }
    
        @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajListuFudbalera.preduslovi(new Object());
        });
    }
}
