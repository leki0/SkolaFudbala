/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
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
public class TrenerTest {

    Trener t;

    @BeforeEach
    public void setUp() {
        t = new Trener();
    }

    @AfterEach
    public void tearDown() {
        t = null;
    }

    @Test
    void testTrener() {
        assertNotNull(t);
        assertEquals(0, t.getTrenerId());
        assertNull(t.getIme());
        assertNull(t.getPrezime());
        assertNull(t.getJmbg());
        assertEquals(0, t.getGodineIskustva());

    }

    @Test
    void testFudbalerParam() {
        Trener t1 = new Trener("Aleksa", "Stancic", "1805001749036", 5);

        assertNotNull(t1);
        assertEquals("Aleksa", t1.getIme());
        assertEquals("Stancic", t1.getPrezime());
        assertEquals("1805001749036", t1.getJmbg());
        assertEquals(5, t1.getGodineIskustva());
    }

    @Test
    void testFudbalerParamID() {
        Trener t1 = new Trener(1, "Aleksa", "Stancic", "1805001749036", 5);

        assertNotNull(t1);
        assertEquals(1, t1.getTrenerId());
        assertEquals("Aleksa", t1.getIme());
        assertEquals("Stancic", t1.getPrezime());
        assertEquals("1805001749036", t1.getJmbg());
        assertEquals(5, t1.getGodineIskustva());
    }

    @Test
    public void testSetIme() {
        t.setIme("Aleksa");
        assertEquals("Aleksa", t.getIme());
    }

    @Test
    public void testSetImeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setIme("Aleksa2"));
    }

    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setIme(null));
    }

    @Test
    public void testSetImeMaloSlovo() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setIme("aleksa"));

    }

    /**
     * Test of setPrezime method, of class Trener.
     */
    @Test
    public void testSetPrezime() {
        t.setPrezime("Stancic");
        assertEquals("Stancic", t.getPrezime());
    }

    @Test
    public void testSetPrezimeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setPrezime("Stancic2"));
    }

    @Test
    public void testSetPrezimeNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setPrezime(null));
    }

    @Test
    public void testSetPrezimeMaloSlovo() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setPrezime("stancic"));

    }

    /**
     * Test of setJmbg method, of class Trener.
     */
    @Test
    public void testSetJmbg() {
        t.setJmbg("1804001134995");
        assertEquals("1804001134995", t.getJmbg());
    }

    @Test
    public void testSetJmbgSlovo() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setPrezime("a123456789034"));
    }

    @Test
    public void testSetJmbgNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setJmbg(null));
    }

    @Test
    public void testSetJmbgBrojCifara() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setJmbg("12345"));

    }

    /**
     * Test of setGodineIskustva method, of class Trener.
     */
    @Test
    public void testSetGodineIskustva() {
        t.setGodineIskustva(5);
        assertEquals(5, t.getGodineIskustva());
    }

    @Test
    public void testSetGodineIskustvaNegativan() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setGodineIskustva(-2));

    }

    @Test
    void testEqualsObject() {
        Trener tren = t;
        assertTrue(t.equals(tren));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(t.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(t.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "Pera, Peric, Pera, Peric, true",
        "Pera, Peric, Mika, Peric, false",
        "Pera, Peric, Pera, Mikic, false",
        "Pera, Peric, Mika, Mikic, false"
    })
    void testEqualsObjectSveOk(String ime1, String prezime1,
            String ime2, String prezime2, boolean eq) {
        t.setIme(ime1);
        t.setPrezime(prezime1);

        Trener t2 = new Trener();
        t2.setIme(ime2);
        t2.setPrezime(prezime2);

        assertEquals(eq, t.equals(t2));
    }

    /**
     * Test of toString method, of class Trener.
     */
    @Test
    public void testToString() {
        t.setIme("Aleksa");
        t.setPrezime("Stancic");

        String trener = t.toString();
        assertTrue(trener.contains("Aleksa"));
        assertTrue(trener.contains("Stancic"));

    }

}
