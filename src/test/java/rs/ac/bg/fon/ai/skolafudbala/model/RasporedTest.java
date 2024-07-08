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
public class RasporedTest {

    private Raspored r;

    @BeforeEach
    public void setUp() {
        r = new Raspored();
    }

    @AfterEach
    public void tearDown() {
        r = null;
    }

    @Test
    void testRaspored() {
        assertNotNull(r);
        assertEquals(0, r.getRasporedId());
        assertEquals(new TreningGrupa(), r.getGrupa());
        assertEquals(new TipTreninga(), r.getTipTreninga());
        assertNull(r.getDatumOd());
        assertNull(r.getDatumDo());
    }

    @Test
    void testRasporedParam() throws ParseException {
        String d1 = "21-10-2025";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datumOd = formater.parse(d1);

        String d2 = "21-10-2026";
        String patern2 = "dd-MM-yyyy";
        SimpleDateFormat formater2 = new SimpleDateFormat(patern2);
        Date datumDo = formater2.parse(d2);
        r = new Raspored(1, new TreningGrupa(1, "Kadeti", 20,
                new Trener(1, "Igor", "Duljaj", "1234567890345", 5)), datumOd,
                datumDo, new TipTreninga(1, "KONDICIONI_TRENING"));

        assertEquals(1, r.getTipTreninga().getTipId());
        assertEquals("KONDICIONI_TRENING", r.getTipTreninga().getNazivTipa());

        assertEquals(1, r.getGrupa().getGrupaId());
        assertEquals("Kadeti", r.getGrupa().getNazivGrupe());
        assertEquals(20, r.getGrupa().getKapacitet());
        assertEquals(1, r.getGrupa().getTrener().getTrenerId());
        assertEquals("Igor", r.getGrupa().getTrener().getIme());
        assertEquals("Duljaj", r.getGrupa().getTrener().getPrezime());
        assertEquals("1234567890345", r.getGrupa().getTrener().getJmbg());
        assertEquals(5, r.getGrupa().getTrener().getGodineIskustva());

        assertEquals(1, r.getRasporedId());
        assertEquals(datumOd, r.getDatumOd());
        assertEquals(datumDo, r.getDatumDo());
    }

    @Test
    public void testSetGrupa() {
        r.setGrupa(new TreningGrupa(1, "Kadeti", 20,
                new Trener(1, "Igor", "Duljaj", "1234567890345", 5)));
        assertEquals(1, r.getGrupa().getGrupaId());
        assertEquals("Kadeti", r.getGrupa().getNazivGrupe());
        assertEquals(20, r.getGrupa().getKapacitet());
        assertEquals(1, r.getGrupa().getTrener().getTrenerId());
        assertEquals("Igor", r.getGrupa().getTrener().getIme());
        assertEquals("Duljaj", r.getGrupa().getTrener().getPrezime());
        assertEquals("1234567890345", r.getGrupa().getTrener().getJmbg());
        assertEquals(5, r.getGrupa().getTrener().getGodineIskustva());
    }

    @Test
    public void testSetGrupaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> r.setGrupa(null));
    }

    @Test
    public void testSetDatumOd() throws ParseException {
        String d1 = "21-10-2025";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datumOd = formater.parse(d1);

        r.setDatumOd(datumOd);

        assertEquals(datumOd, r.getDatumOd());
    }

    @Test
    public void testSetDatumOdNull() throws ParseException {
        assertThrows(java.lang.NullPointerException.class, () -> r.setDatumOd(null));

    }

    @Test
    public void testSetDatumOdBuducnost() throws ParseException {
        assertThrows(java.lang.IllegalArgumentException.class, () -> r.setDatumOd(new Date()));

    }

    @Test
    public void testSetDatumDo() throws ParseException {
        String d1 = "21-10-2025";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datumDo = formater.parse(d1);

        r.setDatumDo(datumDo);

        assertEquals(datumDo, r.getDatumDo());
    }

    @Test
    public void testSetDatumDoNull() throws ParseException {
        assertThrows(java.lang.NullPointerException.class, () -> r.setDatumDo(null));

    }

    @Test
    public void testSetDatumDoBuducnost() throws ParseException {
        assertThrows(java.lang.IllegalArgumentException.class, () -> r.setDatumDo(new Date()));

    }

    @Test
    public void testSetTipTreninga() {
        r.setTipTreninga(new TipTreninga(1, "KONDICIONI_TRENING"));

        assertEquals(1, r.getTipTreninga().getTipId());
        assertEquals("KONDICIONI_TRENING", r.getTipTreninga().getNazivTipa());
    }

    @Test
    public void testSetTipTreningaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> r.setTipTreninga(null));

    }

    @Test
    void testEqualsObject() {
        Raspored ras = r;

        assertTrue(r.equals(ras));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(r.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(r.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 21-10-2025, 21-10-2026, kondicioni, true",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 21-10-2025, 21-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 22-10-2025, 21-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 21-10-2025, 22-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 21-10-2025, 21-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 22-10-2025, 21-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 21-10-2025, 22-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 21-10-2025, 21-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 22-10-2025, 22-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 22-10-2025, 21-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 21-10-2025, 22-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 22-10-2025, 22-10-2026, kondicioni, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 22-10-2025, 21-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 21-10-2025, 22-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Kadeti, 22-10-2025, 22-10-2026, tehnički, false",
        "Kadeti, 21-10-2025, 21-10-2026, kondicioni, Juniori, 22-10-2025, 22-10-2026, tehnički, false"
    })
    void testEqualsObjectSveOk(String grupa1, String datumOd1, String datumDo1, String tip1,
            String grupa2, String datumOd2, String datumDo2, String tip2,
            boolean eq) throws ParseException {
        TreningGrupa tg1 = new TreningGrupa();
        tg1.setNazivGrupe(grupa1);
        TipTreninga tt1 = new TipTreninga();
        tt1.setNazivTipa(tip1);

        TreningGrupa tg2 = new TreningGrupa();
        tg2.setNazivGrupe(grupa2);
        TipTreninga tt2 = new TipTreninga();
        tt2.setNazivTipa(tip2);

        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datumOd1D = formater.parse(datumOd1);

        SimpleDateFormat formater2 = new SimpleDateFormat(patern);
        Date datumDo1D = formater2.parse(datumDo1);

        SimpleDateFormat formater3 = new SimpleDateFormat(patern);
        Date datumOd2D = formater3.parse(datumOd2);

        SimpleDateFormat formater4 = new SimpleDateFormat(patern);
        Date datumDo2D = formater4.parse(datumDo2);

        r.setGrupa(tg1);
        r.setDatumOd(datumOd1D);
        r.setDatumDo(datumDo1D);
        r.setTipTreninga(tt1);

        Raspored r2 = new Raspored();

        r2.setGrupa(tg2);
        r2.setDatumOd(datumOd2D);
        r2.setDatumDo(datumDo2D);
        r2.setTipTreninga(tt2);

        assertEquals(eq, r.equals(r2));

    }

    @Test
    public void testToString() throws ParseException {
        TreningGrupa tg = new TreningGrupa();
        tg.setNazivGrupe("Kadeti");
        TipTreninga tt = new TipTreninga();
        tt.setNazivTipa("Kondicioni");

        String d1 = "21-10-2025";
        String patern = "dd-MM-yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(patern);
        Date datumOd = formater.parse(d1);

        String d2 = "21-10-2026";
        String patern2 = "dd-MM-yyyy";
        SimpleDateFormat formater2 = new SimpleDateFormat(patern2);
        Date datumDo = formater2.parse(d2);

        r.setGrupa(tg);
        r.setDatumOd(datumOd);
        r.setDatumDo(datumDo);
        r.setTipTreninga(tt);

        String s = r.toString();
        System.out.println(datumOd);
        System.out.println(datumDo);
        assertTrue(s.contains("Kadeti"));
        assertTrue(s.contains("Tue Oct 21 00:00:00 CEST 2025"));
        assertTrue(s.contains("Wed Oct 21 00:00:00 CEST 2026"));
        assertTrue(s.contains("Kondicioni"));

    }

}
