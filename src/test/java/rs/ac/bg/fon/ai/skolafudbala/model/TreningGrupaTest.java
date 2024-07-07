/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Korisnik
 */
public class TreningGrupaTest {

    private TreningGrupa tg;

    @BeforeEach
    public void setUp() {
        tg = new TreningGrupa();
    }

    @AfterEach
    public void tearDown() {
        tg = null;
    }

    @Test
    void testTreningGrupa() {
        assertNotNull(tg);
        assertEquals(0, tg.getGrupaId());
        assertNull(tg.getNazivGrupe());
        assertEquals(0, tg.getKapacitet());
        assertEquals(new Trener(), tg.getTrener());
    }

    @Test
    void testTreningGrupaParam() {
        tg = new TreningGrupa(1, "Kadeti", 20,
                new Trener(1, "Igor", "Duljaj", "1234567890345", 5));

        assertEquals(1, tg.getGrupaId());
        assertEquals("Kadeti", tg.getNazivGrupe());
        assertEquals(20, tg.getKapacitet());
        assertEquals(1, tg.getTrener().getTrenerId());
        assertEquals("Igor", tg.getTrener().getIme());
        assertEquals("Duljaj", tg.getTrener().getPrezime());
        assertEquals("1234567890345", tg.getTrener().getJmbg());
        assertEquals(5, tg.getTrener().getGodineIskustva());
    }

    @Test
    public void testSetNazivGrupe() {
        tg.setNazivGrupe("Kadeti");
        assertEquals("Kadeti", tg.getNazivGrupe());
    }

    @Test
    public void testSetNazivGrupeNull() {
        assertThrows(java.lang.NullPointerException.class, () -> tg.setNazivGrupe(null));
    }

    @Test
    public void testSetNazivGrupeCifre() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> tg.setNazivGrupe("K23deti"));
    }

    @Test
    public void testSetKapacitet() {
        tg.setKapacitet(0);
        assertEquals(0, tg.getKapacitet());
    }

    @Test
    public void testSetKapacitetNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> tg.setKapacitet(-1));
    }

    @Test
    public void testSetTrener() {
        tg.setTrener(new Trener(1, "Igor", "Duljaj", "1234567890345", 5));

        assertEquals(1, tg.getTrener().getTrenerId());
        assertEquals("Igor", tg.getTrener().getIme());
        assertEquals("Duljaj", tg.getTrener().getPrezime());
        assertEquals("1234567890345", tg.getTrener().getJmbg());
        assertEquals(5, tg.getTrener().getGodineIskustva());
    }

    @Test
    void testEqualsObject() {
        TreningGrupa grupa = tg;

        assertTrue(tg.equals(grupa));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(tg.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(tg.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "Kadeti, 1, Kadeti, 1, true",
        "Kadeti, 2, Kadeti, 1, false",
        "Kadeti, 1, Petlici, 1, false",
        "Kadeti, 2, Petlici, 1, false"

    })
    void testEqualsObjectSveOk(String naziv1, String kap1, String naziv2, String kap2,
            boolean eq) {

        tg.setNazivGrupe(naziv1);
        tg.setKapacitet(Integer.parseInt(kap1));

        TreningGrupa tg2 = new TreningGrupa();
        tg2.setNazivGrupe(naziv2);
        tg2.setKapacitet(Integer.parseInt(kap2));

        assertEquals(eq, tg.equals(tg2));
    }

    @Test
    public void testToString() {
        tg.setNazivGrupe("Kadeti");
        String s = tg.toString();
        assertTrue(s.contains("Kadeti"));
    }

}
