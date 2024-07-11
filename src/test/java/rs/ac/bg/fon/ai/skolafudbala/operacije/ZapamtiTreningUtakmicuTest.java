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
import rs.ac.bg.fon.ai.skolafudbala.model.StatistikaFudbalera;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningUtakmica;
import rs.ac.bg.fon.ai.skolafudbala.repozitorijum.Repozitorijum;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import rs.ac.bg.fon.ai.skolafudbala.model.Fudbaler;
import rs.ac.bg.fon.ai.skolafudbala.model.TreningGrupa;

@ExtendWith(MockitoExtension.class)
public class ZapamtiTreningUtakmicuTest {

    @Mock
    private Repozitorijum repozitorijum;

    @InjectMocks
    private ZapamtiTreningUtakmicu zapamtiTreningUtakmicu;

    private TreningUtakmica treningUtakmica;
    private StatistikaFudbalera statistikaFudbalera;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        treningUtakmica = new TreningUtakmica();
        treningUtakmica.setRedniBroj(1);
        TreningGrupa tim1 = new TreningGrupa();
        TreningGrupa tim2 = new TreningGrupa();
        tim1.setNazivGrupe("Kadeti");
        tim1.setNazivGrupe("Petlici");
        treningUtakmica.setTim1(tim1);
        treningUtakmica.setTim2(tim2);

        statistikaFudbalera = new StatistikaFudbalera();
        Fudbaler f = new Fudbaler();
        f.setIme("Aleksa");
        statistikaFudbalera.setFudbaler(f);

        treningUtakmica.setListaStatistika(Collections.singletonList(statistikaFudbalera));

        Field instanceRepozitorijum = ApstraktnaSistemskaOperacija.class.getDeclaredField("repozitorijum");
        instanceRepozitorijum.setAccessible(true);
        instanceRepozitorijum.set(zapamtiTreningUtakmicu, repozitorijum);
    }

    @Test
    public void testIzvrsiOperaciju_UspesnoDodavanje() throws Exception {
        when(repozitorijum.add(treningUtakmica)).thenReturn(1L);
        when(repozitorijum.add(statistikaFudbalera)).thenReturn(2L);

        zapamtiTreningUtakmicu.izvrsiOperaciju(treningUtakmica);

        assertEquals(1L, zapamtiTreningUtakmicu.getId());
        verify(repozitorijum, times(1)).add(treningUtakmica);

        verify(repozitorijum, times(1)).add(statistikaFudbalera);
        assertEquals(treningUtakmica, statistikaFudbalera.getTreningUtakmica());
    }

    @Test
    public void testIzvrsiOperaciju_RepozitorijumBacaException() throws Exception {
        when(repozitorijum.add(treningUtakmica)).thenThrow(new Exception("Greška u repozitorijumu"));

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiTreningUtakmicu.izvrsiOperaciju(treningUtakmica);
        });

        assertEquals("Greška u repozitorijumu", exception.getMessage());
        verify(repozitorijum, times(1)).add(treningUtakmica);
    }

    @Test
    public void testPreduslovi_DupliranRedniBroj() throws Exception {
        TreningUtakmica drugaUtakmica = new TreningUtakmica();
        drugaUtakmica.setRedniBroj(1);
        TreningGrupa tim1 = new TreningGrupa();
        TreningGrupa tim2 = new TreningGrupa();
        tim1.setNazivGrupe("Kadeti");
        tim1.setNazivGrupe("Petlici");
        treningUtakmica.setTim1(tim1);
        treningUtakmica.setTim2(tim2);

        List<TreningUtakmica> listaUtakmica = Collections.singletonList(drugaUtakmica);
        when(repozitorijum.getAll(any(TreningUtakmica.class))).thenReturn(listaUtakmica);

        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiTreningUtakmicu.preduslovi(drugaUtakmica);
        });

        assertEquals("Već postoji trening utakmica sa ovim rednim brojem!", exception.getMessage());

    }

    @Test
    public void testPreduslovi_NevalidanObjekat() {
        assertThrows(Exception.class,
                 () -> {
                    zapamtiTreningUtakmicu.preduslovi(
                            null);
                });

        assertThrows(Exception.class,
                 () -> {
                    zapamtiTreningUtakmicu.preduslovi(
                            new StatistikaFudbalera());
                });
    }

    @Test
    public void testPreduslovi_UspesnaValidacija() throws Exception {
        when(repozitorijum.getAll(any(TreningUtakmica.class
        ))).thenReturn(Collections.emptyList());

        assertDoesNotThrow(() -> {
            zapamtiTreningUtakmicu.preduslovi(treningUtakmica);
        });
    }
}
