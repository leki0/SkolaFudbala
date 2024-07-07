/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class LekarskiPregledTest {

    private LekarskiPregled lp;

    @BeforeEach
    public void setUp() {
        lp = new LekarskiPregled();
    }

    @AfterEach
    public void tearDown() {
        lp = null;
    }

    @Test
    void testLekarskiPregled() {
        assertNotNull(lp);
        assertEquals(0, lp.getPregledId());
        assertEquals(0, lp.getVisina());
        assertEquals(0, lp.getTezina());
        assertNull(lp.getStanje());
        assertNull(lp.getDatum());
        assertEquals(new Fudbaler(), lp.getFudbaler());

    }

    @Test
    void testLekarskiPregledParam() throws ParseException {
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        lp = new LekarskiPregled(1, new Fudbaler("Aleksa", "Stancic", "1805001749036", "Krilo",
                new TreningGrupa(1, "Kadeti", 20,
                        new Trener(1, "Igor", "Duljaj", "1234567890345", 5)),
                datum), datum, 178, 78, "Odlicno");

        assertNotNull(lp);
        assertEquals(1, lp.getPregledId());
        assertEquals(datum, lp.getDatum());
        assertEquals(178, lp.getVisina());
        assertEquals(78, lp.getTezina());
        assertEquals("Odlicno", lp.getStanje());

        assertEquals("Aleksa", lp.getFudbaler().getIme());
        assertEquals("Stancic", lp.getFudbaler().getPrezime());
        assertEquals("1805001749036", lp.getFudbaler().getJmbg());
        assertEquals("Krilo", lp.getFudbaler().getPozicija());
        assertEquals(datum, lp.getFudbaler().getDatumRodjenja());

        assertEquals(1, lp.getFudbaler().getTreningGrupa().getGrupaId());
        assertEquals("Kadeti", lp.getFudbaler().getTreningGrupa().getNazivGrupe());
        assertEquals(20, lp.getFudbaler().getTreningGrupa().getKapacitet());
        assertEquals(1, lp.getFudbaler().getTreningGrupa().getTrener().getTrenerId());
        assertEquals("Igor", lp.getFudbaler().getTreningGrupa().getTrener().getIme());
        assertEquals("Duljaj", lp.getFudbaler().getTreningGrupa().getTrener().getPrezime());
        assertEquals("1234567890345", lp.getFudbaler().getTreningGrupa().getTrener().getJmbg());
        assertEquals(5, lp.getFudbaler().getTreningGrupa().getTrener().getGodineIskustva());
    }

    @Test
    public void testSetFudbaler() throws ParseException {
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        Fudbaler f = new Fudbaler("Aleksa", "Stancic", "1805001749036", "Krilo",
                new TreningGrupa(1, "Kadeti", 20,
                        new Trener(1, "Igor", "Duljaj", "1234567890345", 5)), datum);
        assertEquals("Aleksa", f.getIme());
        assertEquals("Stancic", f.getPrezime());
        assertEquals("1805001749036", f.getJmbg());
        assertEquals("Krilo", f.getPozicija());
        assertEquals(datum, f.getDatumRodjenja());

    }

    @Test
    public void testSetVisina() {
        lp.setVisina(178);
        assertEquals(178, lp.getVisina());
    }

    @Test
    public void testSetVisinaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> lp.setVisina(-1));
    }

    @Test
    public void testSetTezina() {
        lp.setTezina(78);
        assertEquals(78, lp.getTezina());
    }

    @Test
    public void testSetTezinaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> lp.setTezina(-1));
    }

    @Test
    public void testSetStanje() {
        lp.setStanje("Odlicno");
        assertEquals("Odlicno", lp.getStanje());
    }

    @Test
    public void testSetStanjeNull() {
        assertThrows(java.lang.NullPointerException.class, () -> lp.setStanje(null));

    }

    @Test
    public void testSetDatum() throws ParseException {
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        lp.setDatum(datum);
        assertEquals(datum, lp.getDatum());
    }

    @Test
    public void testSetDatumNull() {
        assertThrows(java.lang.NullPointerException.class, () -> lp.setDatum(null));

    }

    @Test
    public void testSetDatumBuducnost() throws ParseException {
        String d = "21-10-2030";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        assertThrows(java.lang.IllegalArgumentException.class, () -> lp.setDatum(datum));

    }

    @Test
    void testEqualsObject() {
        LekarskiPregled pregled = lp;

        assertTrue(lp.equals(pregled));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(lp.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(lp.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "178, 78, 178, 78, true",
        "178, 78, 178, 79, false",
        "178, 78, 179, 78, false",
        "178, 78, 179, 79, false"
    })
    void testEqualsObjectSveOk(String visina1, String tezina1, String visina2, String tezina2,
            boolean eq) {

        lp.setVisina(Integer.parseInt(visina1));
        lp.setTezina(Integer.parseInt(tezina1));

        LekarskiPregled lp2 = new LekarskiPregled();

        lp2.setVisina(Integer.parseInt(visina2));
        lp2.setTezina(Integer.parseInt(tezina2));

        assertEquals(eq, lp.equals(lp2));
    }

    @Test
    public void testToString() throws ParseException {
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        lp.setDatum(datum);
        lp.setPregledId(0);
        lp.setStanje("Odlicno");
        lp.setTezina(78);
        lp.setVisina(178);
        Fudbaler f = new Fudbaler();
        TreningGrupa tg = new TreningGrupa();
        f.setIme("Aleksa");
        f.setPrezime("Stancic");
        f.setPozicija("Krilo");
        tg.setNazivGrupe("Kadeti");
        f.setTreningGrupa(tg);
        lp.setFudbaler(f);

        String s = lp.toString();
        assertTrue(s.contains("Sat Oct 21 00:00:00 CEST 2000"));
        assertTrue(s.contains("0"));
        assertTrue(s.contains("Odlicno"));
        assertTrue(s.contains("78"));
        assertTrue(s.contains("178"));
        assertTrue(s.contains("Aleksa"));
        assertTrue(s.contains("Stancic"));
        assertTrue(s.contains("Krilo"));
        assertTrue(s.contains("Kadeti"));

    }

}
