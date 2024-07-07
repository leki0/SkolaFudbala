/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.skolafudbala.model;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TreningUtakmicaTest {

    private TreningUtakmica tu;

    @BeforeEach
    public void setUp() {
        tu = new TreningUtakmica();
    }

    @AfterEach
    public void tearDown() {
        tu = null;
    }

    @Test
    void testTreningUtakmica() {
        assertNotNull(tu);
        assertEquals(0, tu.getTreningUtakmicaId());
        assertEquals(0, tu.getRedniBroj());

        assertNull(tu.getDatum());
        assertEquals(0, tu.getBrojGolovaTim1());
        assertEquals(0, tu.getBrojGolovaTikm2());
        assertEquals(new TreningGrupa(), tu.getTim1());
        assertEquals(new TreningGrupa(), tu.getTim2());

    }

    @Test
    void testTreningUtakmicaParam() {
        tu = new TreningUtakmica(1, 1, new Date(), 1, 1,
                new TreningGrupa(1, "Kadeti", 20,
                        new Trener(1, "Igor", "Duljaj", "1234567890345", 5)),
                new TreningGrupa(2, "Kadeti", 20,
                        new Trener(2, "Igor", "Duljaj", "1234547890345", 5)));

        assertEquals(1, tu.getTreningUtakmicaId());
        assertEquals(1, tu.getRedniBroj());
        assertEquals(new Date(), new Date());
        assertEquals(1, tu.getBrojGolovaTim1());
        assertEquals(1, tu.getBrojGolovaTikm2());

        assertEquals(1, tu.getTim1().getGrupaId());
        assertEquals("Kadeti", tu.getTim1().getNazivGrupe());
        assertEquals(20, tu.getTim1().getKapacitet());
        assertEquals(1, tu.getTim1().getTrener().getTrenerId());
        assertEquals("Igor", tu.getTim1().getTrener().getIme());
        assertEquals("Duljaj", tu.getTim1().getTrener().getPrezime());
        assertEquals("1234567890345", tu.getTim1().getTrener().getJmbg());
        assertEquals(5, tu.getTim1().getTrener().getGodineIskustva());

        assertEquals(2, tu.getTim2().getGrupaId());
        assertEquals("Kadeti", tu.getTim2().getNazivGrupe());
        assertEquals(20, tu.getTim2().getKapacitet());
        assertEquals(2, tu.getTim2().getTrener().getTrenerId());
        assertEquals("Igor", tu.getTim2().getTrener().getIme());
        assertEquals("Duljaj", tu.getTim2().getTrener().getPrezime());
        assertEquals("1234547890345", tu.getTim2().getTrener().getJmbg());
        assertEquals(5, tu.getTim2().getTrener().getGodineIskustva());
    }

    @Test
    public void testSetDatum() throws ParseException {
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        tu.setDatum(datum);
        assertEquals(datum, tu.getDatum());
    }

    @Test
    public void testSetDatumNull() throws ParseException {
        assertThrows(java.lang.NullPointerException.class, () -> tu.setDatum(null));
    }

    @Test
    public void testSetDatumProslost() throws ParseException {
        String d = "21-10-2030";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        assertThrows(java.lang.IllegalArgumentException.class, () -> tu.setDatum(datum));
    }

    @Test
    public void testSetBrojGolovaTim1() {
        tu.setBrojGolovaTim1(1);
        assertEquals(1, tu.getBrojGolovaTim1());
    }

    @Test
    public void testSetBrojGolovaTim1Neg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> tu.setBrojGolovaTim1(-1));

    }

    @Test
    public void testSetBrojGolovaTikm2() {
        tu.setBrojGolovaTikm2(2);
        assertEquals(2, tu.getBrojGolovaTikm2());
    }

    @Test
    public void testSetBrojGolovaTikm2Neg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> tu.setBrojGolovaTim1(-1));

    }

    @Test
    public void testSetTim1() {
        tu.setTim1(new TreningGrupa(1, "Kadeti", 20,
                new Trener(1, "Igor", "Duljaj", "1234567890345", 5)));

        assertEquals(1, tu.getTim1().getGrupaId());
        assertEquals("Kadeti", tu.getTim1().getNazivGrupe());
        assertEquals(20, tu.getTim1().getKapacitet());

        assertEquals(1, tu.getTim1().getTrener().getTrenerId());
        assertEquals("Igor", tu.getTim1().getTrener().getIme());
        assertEquals("Duljaj", tu.getTim1().getTrener().getPrezime());
        assertEquals("1234567890345", tu.getTim1().getTrener().getJmbg());
        assertEquals(5, tu.getTim1().getTrener().getGodineIskustva());

    }

    @Test
    public void testSetTim1Null() {
        assertThrows(java.lang.NullPointerException.class, () -> tu.setTim1(null));

    }

    @Test
    public void testSetTim2() {
        tu.setTim2(new TreningGrupa(1, "Kadeti", 20,
                new Trener(1, "Igor", "Duljaj", "1234567890345", 5)));

        assertEquals(1, tu.getTim2().getGrupaId());
        assertEquals("Kadeti", tu.getTim2().getNazivGrupe());
        assertEquals(20, tu.getTim2().getKapacitet());

        assertEquals(1, tu.getTim2().getTrener().getTrenerId());
        assertEquals("Igor", tu.getTim2().getTrener().getIme());
        assertEquals("Duljaj", tu.getTim2().getTrener().getPrezime());
        assertEquals("1234567890345", tu.getTim2().getTrener().getJmbg());
        assertEquals(5, tu.getTim2().getTrener().getGodineIskustva());
    }

    @Test
    public void testSetTim2Null() {
        assertThrows(java.lang.NullPointerException.class, () -> tu.setTim2(null));

    }

    @Test
    public void testSetRedniBroj() {
        tu.setRedniBroj(3);
        assertEquals(3, tu.getRedniBroj());

    }

    @Test
    public void testSetRedniBrojNeg() {

        assertThrows(java.lang.IllegalArgumentException.class, () -> tu.setRedniBroj(-1));

    }

    @Test
    void testEqualsObject() {
        TreningUtakmica tekma = tu;

        assertTrue(tu.equals(tekma));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(tu.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(tu.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"

    })
    void testEqualsObjectSveOk(String rb1, String rb2,
            boolean eq) {
        tu.setRedniBroj(Integer.parseInt(rb1));

        TreningUtakmica tu2 = new TreningUtakmica();
        tu2.setRedniBroj(Integer.parseInt(rb2));

        assertEquals(eq, tu.equals(tu2));
    }

    @Test
    public void testToString() throws ParseException {
        tu.setTreningUtakmicaId(1);
        tu.setRedniBroj(2);
        String d = "21-10-2000";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datum = formater.parse(d);
        tu.setDatum(datum);
        tu.setBrojGolovaTim1(3);
        tu.setBrojGolovaTikm2(4);
        TreningGrupa t1 = new TreningGrupa();
        t1.setNazivGrupe("Kadeti");

        TreningGrupa t2 = new TreningGrupa();
        t2.setNazivGrupe("Petlici");

        tu.setTim1(t1);
        tu.setTim2(t2);
        String utakmica = tu.toString();

        System.out.println(datum);
        assertTrue(utakmica.contains("1"));
        assertTrue(utakmica.contains("2"));
        assertTrue(utakmica.contains("Sat Oct 21 00:00:00 CEST 2000"));
        assertTrue(utakmica.contains("3"));
        assertTrue(utakmica.contains("4"));
        assertTrue(utakmica.contains("Kadeti"));
        assertTrue(utakmica.contains("Petlici"));
    }

}
