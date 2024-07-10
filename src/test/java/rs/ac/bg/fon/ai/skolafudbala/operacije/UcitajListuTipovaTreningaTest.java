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
import rs.ac.bg.fon.ai.skolafudbala.model.TipTreninga;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcitajListuTipovaTreningaTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajListuTipovaTreninga ucitajListuTipova;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajListuTipova, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanjeListe() throws Exception {
        TipTreninga tip1 = new TipTreninga();
        tip1.setNazivTipa("Kondicioni");

        TipTreninga tip2 = new TipTreninga();
        tip2.setNazivTipa("Snaga");

        List<TipTreninga> listaTipova = Arrays.asList(tip1, tip2);

        when(repozitorijum.getAll(new TipTreninga())).thenReturn(listaTipova);

        ucitajListuTipova.izvrsiOperaciju(new Object());

        assertEquals(listaTipova, ucitajListuTipova.getListaTipova());
        verify(repozitorijum, times(1)).getAll(new TipTreninga());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getAll(new TipTreninga())).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajListuTipova.izvrsiOperaciju(new Object());
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getAll(new TipTreninga());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajListuTipova.preduslovi(new Object());
        });
    }
}
