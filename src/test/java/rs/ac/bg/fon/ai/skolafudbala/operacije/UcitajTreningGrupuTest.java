package rs.ac.bg.fon.ai.skolafudbala.operacije;

import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UcitajTreningGrupuTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private UcitajTreningGrupu ucitajTreningGrupu;

    private TreningGrupa treningGrupa;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        treningGrupa = new TreningGrupa();
        treningGrupa.setNazivGrupe("Kadeti");

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(ucitajTreningGrupu, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoUcitavanje() throws Exception {
        TreningGrupa treningGrupaIzBaze = new TreningGrupa();
        treningGrupaIzBaze.setNazivGrupe("Kadeti");

        when(repozitorijum.getWhere(treningGrupa)).thenReturn(treningGrupaIzBaze);

        ucitajTreningGrupu.izvrsiOperaciju(treningGrupa);

        assertEquals(treningGrupaIzBaze, ucitajTreningGrupu.getTreningGrupaBaza());
        verify(repozitorijum, times(1)).getWhere(treningGrupa);
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.getWhere(treningGrupa)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            ucitajTreningGrupu.izvrsiOperaciju(treningGrupa);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).getWhere(treningGrupa);
    }

    @Test
    public void testPreduslovi_NullObjekat() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajTreningGrupu.preduslovi(null);
        });

        assertEquals("VALIDACIJA! Vrijednost parametra nije validna!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_PogresanTip() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajTreningGrupu.preduslovi(new Object());
        });

        assertEquals("VALIDACIJA! Vrijednost parametra nije validna!", exception.getMessage());
    }

    @Test
    public void testPreduslovi_ValidanObjekat() {
        assertDoesNotThrow(() -> {
            ucitajTreningGrupu.preduslovi(treningGrupa);
        });
    }
}
