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
import static org.mockito.ArgumentMatchers.*;

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
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajListuTreningGrupe.preduslovi(new Object());
        });
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanjeListe() throws Exception {
        TreningGrupa grupa1 = new TreningGrupa();
        grupa1.setNazivGrupe("Kadeti");

        TreningGrupa grupa2 = new TreningGrupa();
        grupa2.setNazivGrupe("Petlici");

        Raspored raspored1 = new Raspored();
        Raspored raspored2 = new Raspored();

        List<TreningGrupa> listaTreningGrupaIzBaze = Arrays.asList(grupa1, grupa2);
        List<Raspored> listaRasporedaIzBaze = Arrays.asList(raspored1, raspored2);

        when(repozitorijum.getAll(any(TreningGrupa.class))).thenReturn(listaTreningGrupaIzBaze);
        when(repozitorijum.getAll(any(Raspored.class))).thenReturn(listaRasporedaIzBaze);

        ucitajListuTreningGrupe.izvrsiOperaciju(new Object());

        assertEquals(listaTreningGrupaIzBaze, ucitajListuTreningGrupe.getListaTreningGrupa());
        assertEquals(listaRasporedaIzBaze, ucitajListuTreningGrupe.getListaRasporeda());
        verify(repozitorijum, times(1)).getAll(any(TreningGrupa.class));
        verify(repozitorijum, times(1)).getAll(any(Raspored.class));
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getAll(any(TreningGrupa.class))).thenThrow(new Exception("Greška u repozitorijumu"));
        when(repozitorijum.getAll(any(Raspored.class))).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajListuTreningGrupe.izvrsiOperaciju(new Object());
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getAll(any(TreningGrupa.class));
        verify(repozitorijum, times(1)).getAll(any(Raspored.class));
    }
}
