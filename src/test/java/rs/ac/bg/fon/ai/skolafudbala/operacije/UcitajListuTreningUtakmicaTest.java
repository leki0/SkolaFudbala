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
import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcitajListuTreningUtakmicaTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajListuTreningUtakmica ucitajListuTreningUtakmica;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajListuTreningUtakmica, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanjeListe() throws Exception {
        TreningUtakmica tu1 = new TreningUtakmica();
        tu1.setRedniBroj(2);

        TreningUtakmica tu2 = new TreningUtakmica();
        tu2.setRedniBroj(3);

        List<TreningUtakmica> listaTreningUtakmica = Arrays.asList(tu1, tu2);

        when(repozitorijum.getAll(new TreningUtakmica())).thenReturn(listaTreningUtakmica);

        ucitajListuTreningUtakmica.izvrsiOperaciju(new Object());

        assertEquals(listaTreningUtakmica, ucitajListuTreningUtakmica.getListaTreningUtakmica());
        verify(repozitorijum, times(1)).getAll(new TreningUtakmica());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getAll(new TreningUtakmica())).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajListuTreningUtakmica.izvrsiOperaciju(new Object());
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getAll(new TreningUtakmica());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajListuTreningUtakmica.preduslovi(new Object());
        });
    }
}
