/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.ai.skolafudbala.enums.Pozicija;

/**
 *
 * @author Korisnik
 */
public class FudbalerTest {

    private Fudbaler f;

    @BeforeEach
    public void setUp() {
        f = new Fudbaler();
    }

    @AfterEach
    public void tearDown() {
        f = null;
    }

    @Test
    void testFudbaler() {
        assertNotNull(f);
        assertEquals(0, f.getFudbalerId());
        assertNull(f.getIme());
        assertNull(f.getPrezime());
        assertNull(f.getJmbg());
        assertNull(f.getPozicija());
        assertEquals(new TreningGrupa(), f.getTreningGrupa());
        assertNull(f.getIme());
        assertNull(f.getDatumRodjenja());
    }

    @Test
    void testFudbalerParam() {
        Date datumRodj = new Date();
        f = new Fudbaler("Aleksa", "Stancic", "1805001749036", "Krilo", new TreningGrupa(), datumRodj);

        assertNotNull(f);
        assertEquals("Aleksa", f.getIme());
        assertEquals("Stancic", f.getPrezime());
        assertEquals("1805001749036", f.getJmbg());
        assertEquals("Krilo", f.getPozicija());
        assertEquals(new TreningGrupa(), f.getTreningGrupa());
        assertEquals(datumRodj, f.getDatumRodjenja());
    }

    @Test
    void testFudbalerParamID() {
        Date datumRodj = new Date();
        Fudbaler f1 = new Fudbaler(2, "Aleksa", "Stancic", "1805001749036", "Krilo", new TreningGrupa(), datumRodj);

        assertNotNull(f1);
        assertEquals(2, f1.getFudbalerId());
        assertEquals("Aleksa", f1.getIme());
        assertEquals("Stancic", f1.getPrezime());
        assertEquals("1805001749036", f1.getJmbg());
        assertEquals("Krilo", f1.getPozicija());
        assertEquals(new TreningGrupa(), f1.getTreningGrupa());
        assertEquals(datumRodj, f1.getDatumRodjenja());
    }

    /**
     * Test of setIme method, of class Fudbaler.
     */
    @Test
    public void testSetIme() {
        f.setIme("Aleksa");
        assertEquals("Aleksa", f.getIme());
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setIme("Aleksa2"));
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setIme("aleksa"));
        assertThrows(java.lang.NullPointerException.class, () -> f.setIme(null));
    }

    @Test
    public void testSetImeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setIme("Aleksa2"));
    }

    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class, () -> f.setIme(null));
    }

    @Test
    public void testSetImeMaloSlovo() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setIme("aleksa"));

    }

    /**
     * Test of setPrezime method, of class Fudbaler.
     */
    @Test
    public void testSetPrezime() {
        f.setPrezime("Stancic");
        assertEquals("Stancic", f.getPrezime());
    }

    @Test
    public void testSetPrezimeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setPrezime("Stancic2"));
    }

    @Test
    public void testSetPrezimeNull() {
        assertThrows(java.lang.NullPointerException.class, () -> f.setPrezime(null));
    }

    @Test
    public void testSetPrezimeMaloSlovo() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setPrezime("stancic"));

    }

    /**
     * Test of setJmbg method, of class Fudbaler.
     */
    @Test
    public void testSetJmbg() {
        f.setJmbg("1805001749036");
        assertEquals("1805001749036", f.getJmbg());
    }

    @Test
    public void testSetJmbgSlovo() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setPrezime("a123456789034"));
    }

    @Test
    public void testSetJmbgNull() {
        assertThrows(java.lang.NullPointerException.class, () -> f.setJmbg(null));
    }

    @Test
    public void testSetJmbgBrojCifara() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setJmbg("12345"));

    }

    /**
     * Test of setPozicija method, of class Fudbaler.
     */
    @Test
    public void testSetPozicija() {
        f.setPozicija("Krilo");
        assertEquals("Krilo", f.getPozicija());
    }

    @Test
    public void testSetPozicijaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> f.setPozicija(null));
    }

    /**
     * Test of setTreningGrupa method, of class Fudbaler.
     */
    @Test
    public void testSetTreningGrupa() {
        f.setTreningGrupa(new TreningGrupa());
        assertEquals(new TreningGrupa(), f.getTreningGrupa());
    }

    @Test
    public void testSetTreningGrupaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> f.setTreningGrupa(null));
    }

    /**
     * Test of setDatumRodjenja method, of class Fudbaler.
     */
    @Test
    public void testSetDatumRodjenja() throws ParseException {
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datumRodjenja = formater.parse(d);
        f.setDatumRodjenja(datumRodjenja);
        assertEquals(datumRodjenja, f.getDatumRodjenja());
    }

    @Test
    public void testSetDatumRodjenjaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> f.setDatumRodjenja(null));

    }

    @Test
    public void testSetDatumRodjenjaProslost() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> f.setDatumRodjenja(new Date()));

    }

    /**
     * Test of equals method, of class Fudbaler.
     */
    @Test
    void testEqualsObject() {
        Fudbaler fudb = f;

        assertTrue(f.equals(fudb));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(f.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(f.equals(new Korisnik()));
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
        f.setIme(ime1);
        f.setPrezime(prezime1);

        Fudbaler f2 = new Fudbaler();
        f2.setIme(ime2);
        f2.setPrezime(prezime2);

        assertEquals(eq, f.equals(f2));
    }

    /**
     * Test of toString method, of class Fudbaler.
     */
    @Test
    public void testToString() {
        f.setIme("Aleksa");
        f.setPrezime("Stancic");
        TreningGrupa tg = new TreningGrupa();
        tg.setNazivGrupe("Kadeti");
        f.setTreningGrupa(tg);
        f.setPozicija("KRILO");

        String fudbaler = f.toString();
        assertTrue(fudbaler.contains("Aleksa"));
        assertTrue(fudbaler.contains("Stancic"));
        assertTrue(fudbaler.contains("Kadeti"));
        assertTrue(fudbaler.contains("KRILO"));
    }

}
