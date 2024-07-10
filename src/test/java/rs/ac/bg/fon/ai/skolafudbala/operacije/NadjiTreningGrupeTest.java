package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.model.Raspored;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import rs.ac.bg.fon.ai.skolafudbala.model.Korisnik;

@ExtendWith(MockitoExtension.class)
public class NadjiTreningGrupeTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private NadjiTreningGrupe nadjiTreningGrupe;

    private TreningGrupa treningGrupa;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        treningGrupa = new TreningGrupa();
        treningGrupa.setNazivGrupe("Kadeti");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(nadjiTreningGrupe, repozitorijum);
    }


    @Test
    public void testIzvrsiOperaciju_UspesnaPretraga() throws Exception {
        List<TreningGrupa> rezultatiPretrage = Arrays.asList(treningGrupa);
        List<Raspored> rezultatiRasporeda = Arrays.asList(new Raspored());
        
        when(repozitorijum.pretraga(treningGrupa)).thenReturn(rezultatiPretrage);
        when(repozitorijum.getAll(new Raspored())).thenReturn(rezultatiRasporeda);

        nadjiTreningGrupe.izvrsiOperaciju(treningGrupa);

        assertEquals(rezultatiPretrage, nadjiTreningGrupe.getListaTreningGrupaPretraga());
        assertEquals(rezultatiRasporeda, nadjiTreningGrupe.getListaRasporeda());
        verify(repozitorijum, times(1)).pretraga(treningGrupa);
        verify(repozitorijum, times(1)).getAll(new Raspored());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.pretraga(treningGrupa)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTreningGrupe.izvrsiOperaciju(treningGrupa);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).pretraga(treningGrupa);
    }
    
    
    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTreningGrupe.preduslovi(null);
        });

        assertEquals("Objekat trening grupa nije validan za pretragu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTreningGrupe.preduslovi(new Korisnik());
        });

        assertEquals("Objekat trening grupa nije validan za pretragu. VALIDACIJA!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            nadjiTreningGrupe.preduslovi(treningGrupa);
        });
    }

}
