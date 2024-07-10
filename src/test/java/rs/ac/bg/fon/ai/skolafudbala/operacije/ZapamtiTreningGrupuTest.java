package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import java.util.Collections;
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
public class ZapamtiTreningGrupuTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiTreningGrupu zapamtiTreningGrupu;

    private TreningGrupa treningGrupa;
    private Raspored raspored;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        treningGrupa = new TreningGrupa();
        treningGrupa.setNazivGrupe("Kadeti");
        raspored = new Raspored();
        
        treningGrupa.setListaRasporeda(Collections.singletonList(raspored));

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiTreningGrupu, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoDodavanje() throws Exception {
        when(repozitorijum.add(treningGrupa)).thenReturn(1L);
        when(repozitorijum.add(raspored)).thenReturn(2L);

        zapamtiTreningGrupu.izvrsiOperaciju(treningGrupa);

        assertEquals(1L, zapamtiTreningGrupu.getId());
        verify(repozitorijum, times(1)).add(treningGrupa);

        verify(repozitorijum, times(1)).add(raspored);
        assertEquals(treningGrupa, raspored.getGrupa());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.add(treningGrupa)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiTreningGrupu.izvrsiOperaciju(treningGrupa);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).add(treningGrupa);
    }

    @Test
    public void testPreduslovi_DupliranNazivGrupe() throws Exception {
        TreningGrupa drugaGrupa = new TreningGrupa();
        drugaGrupa.setNazivGrupe("Kadeti");

        List<TreningGrupa> listaGrupa = Collections.singletonList(drugaGrupa);
        when(repozitorijum.getAll(any(TreningGrupa.class))).thenReturn(listaGrupa);

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiTreningGrupu.preduslovi(treningGrupa);
        });

        assertEquals("Trening grupa sa ovim imenom već postoji!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_NevalidanObjekat() {
        assertThrows(Exception.class, () -> {
            zapamtiTreningGrupu.preduslovi(null);
        });

        assertThrows(Exception.class, () -> {
            zapamtiTreningGrupu.preduslovi(new Raspored());
        });
    }

    @Test
    public void testPreduslovi_UspesnaValidacija() throws Exception {
        when(repozitorijum.getAll(any(TreningGrupa.class))).thenReturn(Collections.emptyList());

        assertDoesNotThrow(() -> {
            zapamtiTreningGrupu.preduslovi(treningGrupa);
        });
    }
}
