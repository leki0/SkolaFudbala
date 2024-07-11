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
import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcitajListuTreningGrupeTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajListuTreningGrupe ucitajListuTreningGrupe;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajListuTreningGrupe, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanjeListe() throws Exception {
        TreningGrupa tg1 = new TreningGrupa();
        tg1.setId(1L);
        tg1.setNazivGrupe("Kadeti");

        TreningGrupa tg2 = new TreningGrupa();
        tg2.setId(2L);
        tg2.setNazivGrupe("Petlici");

        List<TreningGrupa> listaTreningGrupa = Arrays.asList(tg1, tg2);

        Raspored r1 = new Raspored();
        r1.setId(1L);

        Raspored r2 = new Raspored();
        r2.setId(2L);

        List<Raspored> listaRasporeda = Arrays.asList(r1, r2);

        when(repozitorijum.getAll(new TreningGrupa())).thenReturn(listaTreningGrupa);
        when(repozitorijum.getAll(new Raspored())).thenReturn(listaRasporeda);

        ucitajListuTreningGrupe.izvrsiOperaciju(new Object());

        assertEquals(listaTreningGrupa, ucitajListuTreningGrupe.getListaTreningGrupa());
        assertEquals(listaRasporeda, ucitajListuTreningGrupe.getListaRasporeda());
        verify(repozitorijum, times(1)).getAll(new TreningGrupa());
        verify(repozitorijum, times(1)).getAll(new Raspored());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getAll(new TreningGrupa())).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajListuTreningGrupe.izvrsiOperaciju(new Object());
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getAll(new TreningGrupa());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajListuTreningGrupe.preduslovi(new Object());
        });
    }
}
