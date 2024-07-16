package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;

@ExtendWith(MockitoExtension.class)
public class ZapamtiIzmjeneTreningGrupeTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiIzmjeneTreningGrupe zapamtiIzmjeneTreningGrupe;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiIzmjeneTreningGrupe, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoDodavanje() throws Exception {
        TreningGrupa tg = new TreningGrupa();
        tg.setId(1L);

        Raspored r1 = new Raspored();
        r1.setId(1L);
        r1.setGrupa(tg);

        Raspored r2 = new Raspored();
        r2.setId(2L);
        r2.setGrupa(tg);

        tg.setListaRasporeda(Arrays.asList(r1, r2));

        List<Raspored> rasporediIzBaze = Arrays.asList();

        when(repozitorijum.getAll(new Raspored())).thenReturn(rasporediIzBaze);
        when(repozitorijum.add(r1)).thenReturn(1L);
        when(repozitorijum.add(r2)).thenReturn(1L);
        when(repozitorijum.addUpdate(tg)).thenReturn(1);

        zapamtiIzmjeneTreningGrupe.izvrsiOperaciju(tg);

        assertEquals(3, zapamtiIzmjeneTreningGrupe.getIzmjenjenaTG());
        verify(repozitorijum, times(1)).getAll(new Raspored());
        verify(repozitorijum, times(1)).add(r1);
        verify(repozitorijum, times(1)).add(r2);
        verify(repozitorijum, times(1)).addUpdate(tg);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoBrisanje() throws Exception {
        TreningGrupa tg = new TreningGrupa();
        tg.setId(1L);

        Raspored r1 = new Raspored();
        r1.setId(1L);
        r1.setGrupa(tg);

        Raspored r2 = new Raspored();
        r2.setId(2L);
        r2.setGrupa(tg);

        List<Raspored> rasporediIzBaze = Arrays.asList(r1, r2);
        tg.setListaRasporeda(new ArrayList<>());

        when(repozitorijum.getAll(new Raspored())).thenReturn(rasporediIzBaze);
        when(repozitorijum.delete(r1)).thenReturn(1);
        when(repozitorijum.delete(r2)).thenReturn(1);
        when(repozitorijum.addUpdate(tg)).thenReturn(1);

        zapamtiIzmjeneTreningGrupe.izvrsiOperaciju(tg);

        assertEquals(3, zapamtiIzmjeneTreningGrupe.getIzmjenjenaTG());
        verify(repozitorijum, times(1)).getAll(new Raspored());
        verify(repozitorijum, times(1)).delete(r1);
        verify(repozitorijum, times(1)).delete(r2);
        verify(repozitorijum, times(1)).addUpdate(tg);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnaIzmena() throws Exception {
        TreningGrupa tg = new TreningGrupa();
        tg.setId(1L);

        Raspored r1 = new Raspored();
        r1.setId(1L);
        r1.setGrupa(tg);

        Raspored r2 = new Raspored();
        r2.setId(2L);
        r2.setGrupa(tg);

        List<Raspored> rasporediIzBaze = Arrays.asList(r1);
        tg.setListaRasporeda(Arrays.asList(r2));

        when(repozitorijum.getAll(new Raspored())).thenReturn(rasporediIzBaze);
        when(repozitorijum.add(r2)).thenReturn(1L);
        when(repozitorijum.delete(r1)).thenReturn(1);
        when(repozitorijum.addUpdate(tg)).thenReturn(1);

        zapamtiIzmjeneTreningGrupe.izvrsiOperaciju(tg);

        assertEquals(3, zapamtiIzmjeneTreningGrupe.getIzmjenjenaTG());
        verify(repozitorijum, times(1)).getAll(new Raspored());
        verify(repozitorijum, times(1)).add(r2);
        verify(repozitorijum, times(1)).delete(r1);
        verify(repozitorijum, times(1)).addUpdate(tg);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        TreningGrupa tg = new TreningGrupa();
        tg.setId(1L);

        when(repozitorijum.addUpdate(tg)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiIzmjeneTreningGrupe.izvrsiOperaciju(tg);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).addUpdate(tg);
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        TreningGrupa tg = new TreningGrupa();
        assertDoesNotThrow(() -> {
            zapamtiIzmjeneTreningGrupe.preduslovi(tg);
        });
    }

    @Test
    public void testPreduslovi_NevalidanObjekat() {
        assertThrows(Exception.class, () -> {
            zapamtiIzmjeneTreningGrupe.preduslovi(new Korisnik());
        });

        assertThrows(Exception.class, () -> {
            zapamtiIzmjeneTreningGrupe.preduslovi(null);
        });
    }
}
