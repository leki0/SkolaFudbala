package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;

@ExtendWith(MockitoExtension.class)
public class ObrisiTreningGrupuTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ObrisiTreningGrupu obrisiTreningGrupu;

    private TreningGrupa treningGrupa;
    private Raspored raspored;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        raspored = new Raspored();
        treningGrupa = new TreningGrupa();
        treningGrupa.setNazivGrupe("Kadeti");
        treningGrupa.setListaRasporeda(Arrays.asList(raspored));

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(obrisiTreningGrupu, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoBrisanje() throws Exception {
        when(repozitorijum.delete(raspored)).thenReturn(1);
        when(repozitorijum.delete(treningGrupa)).thenReturn(1);

        obrisiTreningGrupu.izvrsiOperaciju(treningGrupa);

        assertEquals(1, obrisiTreningGrupu.getObrisanaTreningGrupa());
        assertEquals(1, obrisiTreningGrupu.getObrisanaTreningGrupa());
        verify(repozitorijum, times(1)).delete(raspored);
        verify(repozitorijum, times(1)).delete(treningGrupa);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.delete(raspored)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            obrisiTreningGrupu.izvrsiOperaciju(treningGrupa);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).delete(raspored);
    }

    @Test
    public void testIzvrsiOperaciju_NemaRasporeda() throws Exception {
        treningGrupa.setListaRasporeda(null);
        when(repozitorijum.delete(treningGrupa)).thenReturn(1);

        obrisiTreningGrupu.izvrsiOperaciju(treningGrupa);

        assertEquals(1, obrisiTreningGrupu.getObrisanaTreningGrupa());
        verify(repozitorijum, never()).delete(any(Raspored.class));
        verify(repozitorijum, times(1)).delete(treningGrupa);
    }

    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            obrisiTreningGrupu.preduslovi(null);
        });

        assertEquals("Objekat trening grupa nije validan za brisanje. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            obrisiTreningGrupu.preduslovi(new Korisnik());
        });

        assertEquals("Objekat trening grupa nije validan za brisanje. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            obrisiTreningGrupu.preduslovi(treningGrupa);
        });
    }
}
