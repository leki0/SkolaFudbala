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
public class StatistikaFudbaleraTest {

    private StatistikaFudbalera sf;

    @BeforeEach
    public void setUp() {
        sf = new StatistikaFudbalera();
    }

    @AfterEach
    public void tearDown() {
        sf = null;
    }

    @Test
    void testFudbaler() {
        assertNotNull(sf);
        assertNull(sf.getFudbaler());
        assertNull(sf.getTreningUtakmica());
        assertEquals(0, sf.getBrojGolova());
        assertEquals(0, sf.getBrojAsistencija());
        assertEquals(0, sf.getBrojPromasenihSuteva());
        assertEquals(0, sf.getBrojProvedenihMinuta());
        assertEquals(0, sf.getBrojOdbrana());
        assertEquals(0, sf.getBrojPrimljenihGolova());
        assertEquals(0, sf.getOcjena());
        assertNull(sf.isPrvaPostava());
    }

    @Test
    void testFudbalerParam() {
        sf = new StatistikaFudbalera(new Fudbaler(2, "Aleksa", "Stancic", "1805001749036", "Krilo",
                new TreningGrupa(1, "Kadeti", 20,
                        new Trener(1, "Igor", "Duljaj", "1234567890345", 5)), new Date()),
                new TreningUtakmica(1, 1, new Date(), 1, 1,
                        new TreningGrupa(1, "Kadeti", 20,
                                new Trener(1, "Igor", "Duljaj", "1234567890345", 5)),
                        new TreningGrupa(2, "Kadeti", 20,
                                new Trener(2, "Igor", "Duljaj", "1234547890345", 5))),
                1, 1, 1, 80, true, 1, 1, 4);

        assertEquals(2, sf.getFudbaler().getFudbalerId());
        assertEquals("Aleksa", sf.getFudbaler().getIme());
        assertEquals("Stancic", sf.getFudbaler().getPrezime());
        assertEquals("1805001749036", sf.getFudbaler().getJmbg());
        assertEquals("Krilo", sf.getFudbaler().getPozicija());
        assertEquals(new Date(), sf.getFudbaler().getDatumRodjenja());

        assertEquals(1, sf.getFudbaler().getTreningGrupa().getGrupaId());
        assertEquals("Kadeti", sf.getFudbaler().getTreningGrupa().getNazivGrupe());
        assertEquals(20, sf.getFudbaler().getTreningGrupa().getKapacitet());
        assertEquals(1, sf.getFudbaler().getTreningGrupa().getTrener().getTrenerId());
        assertEquals("Igor", sf.getFudbaler().getTreningGrupa().getTrener().getIme());
        assertEquals("Duljaj", sf.getFudbaler().getTreningGrupa().getTrener().getPrezime());
        assertEquals("1234567890345", sf.getFudbaler().getTreningGrupa().getTrener().getJmbg());
        assertEquals(5, sf.getFudbaler().getTreningGrupa().getTrener().getGodineIskustva());

        assertEquals(1, sf.getTreningUtakmica().getTreningUtakmicaId());
        assertEquals(1, sf.getTreningUtakmica().getRedniBroj());
        assertEquals(new Date(), sf.getTreningUtakmica().getDatum());
        assertEquals(1, sf.getTreningUtakmica().getBrojGolovaTim1());
        assertEquals(1, sf.getTreningUtakmica().getBrojGolovaTikm2());

        assertEquals(1, sf.getTreningUtakmica().getTim1().getGrupaId());
        assertEquals("Kadeti", sf.getTreningUtakmica().getTim1().getNazivGrupe());
        assertEquals(20, sf.getTreningUtakmica().getTim1().getKapacitet());
        assertEquals(1, sf.getTreningUtakmica().getTim1().getTrener().getTrenerId());
        assertEquals("Igor", sf.getTreningUtakmica().getTim1().getTrener().getIme());
        assertEquals("Duljaj", sf.getTreningUtakmica().getTim1().getTrener().getPrezime());
        assertEquals("1234567890345", sf.getTreningUtakmica().getTim1().getTrener().getJmbg());
        assertEquals(5, sf.getTreningUtakmica().getTim1().getTrener().getGodineIskustva());

        assertEquals(2, sf.getTreningUtakmica().getTim2().getGrupaId());
        assertEquals("Kadeti", sf.getTreningUtakmica().getTim2().getNazivGrupe());
        assertEquals(20, sf.getTreningUtakmica().getTim2().getKapacitet());
        assertEquals(2, sf.getTreningUtakmica().getTim2().getTrener().getTrenerId());
        assertEquals("Igor", sf.getTreningUtakmica().getTim2().getTrener().getIme());
        assertEquals("Duljaj", sf.getTreningUtakmica().getTim2().getTrener().getPrezime());
        assertEquals("1234547890345", sf.getTreningUtakmica().getTim2().getTrener().getJmbg());
        assertEquals(5, sf.getTreningUtakmica().getTim2().getTrener().getGodineIskustva());

        assertEquals(1, sf.getBrojGolova());
        assertEquals(1, sf.getBrojAsistencija());
        assertEquals(1, sf.getBrojPromasenihSuteva());
        assertEquals(80, sf.getBrojProvedenihMinuta());
        assertEquals(1, sf.getBrojOdbrana());
        assertEquals(1, sf.getBrojPrimljenihGolova());
        assertEquals(4, sf.getOcjena());
        assertEquals(true, sf.isPrvaPostava());
    }

    @Test
    public void testSetFudbaler() {
        sf.setFudbaler(new Fudbaler(2, "Aleksa", "Stancic", "1805001749036", "Krilo",
                new TreningGrupa(1, "Kadeti", 20,
                        new Trener(1, "Igor", "Duljaj", "1234567890345", 5)), new Date()));

        assertEquals(2, sf.getFudbaler().getFudbalerId());
        assertEquals("Aleksa", sf.getFudbaler().getIme());
        assertEquals("Stancic", sf.getFudbaler().getPrezime());
        assertEquals("1805001749036", sf.getFudbaler().getJmbg());
        assertEquals("Krilo", sf.getFudbaler().getPozicija());
        assertEquals(new Date(), sf.getFudbaler().getDatumRodjenja());

        assertEquals(1, sf.getFudbaler().getTreningGrupa().getGrupaId());
        assertEquals("Kadeti", sf.getFudbaler().getTreningGrupa().getNazivGrupe());
        assertEquals(20, sf.getFudbaler().getTreningGrupa().getKapacitet());
        assertEquals(1, sf.getFudbaler().getTreningGrupa().getTrener().getTrenerId());
        assertEquals("Igor", sf.getFudbaler().getTreningGrupa().getTrener().getIme());
        assertEquals("Duljaj", sf.getFudbaler().getTreningGrupa().getTrener().getPrezime());
        assertEquals("1234567890345", sf.getFudbaler().getTreningGrupa().getTrener().getJmbg());
        assertEquals(5, sf.getFudbaler().getTreningGrupa().getTrener().getGodineIskustva());
    }

    @Test
    public void testSetFudbalerNull() {
        assertThrows(java.lang.NullPointerException.class, () -> sf.setFudbaler(null));

    }

    @Test
    public void testSetBrojGolova() {
        sf.setBrojGolova(3);
        assertEquals(3, sf.getBrojGolova());
    }

    @Test
    public void testSetBrojGolovaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setBrojGolova(-1));
    }

    @Test
    public void testSetBrojAsistencija() {
        sf.setBrojAsistencija(3);
        assertEquals(3, sf.getBrojAsistencija());
    }

    @Test
    public void testSetBrojAsistencijaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setBrojAsistencija(-1));
    }

    @Test
    public void testSetTreningUtakmica() {
        sf.setTreningUtakmica(new TreningUtakmica(1, 1, new Date(), 1, 1,
                new TreningGrupa(1, "Kadeti", 20,
                        new Trener(1, "Igor", "Duljaj", "1234567890345", 5)),
                new TreningGrupa(2, "Kadeti", 20,
                        new Trener(2, "Igor", "Duljaj", "1234547890345", 5))));
        assertEquals(1, sf.getTreningUtakmica().getTreningUtakmicaId());
        assertEquals(1, sf.getTreningUtakmica().getRedniBroj());
        assertEquals(new Date(), sf.getTreningUtakmica().getDatum());
        assertEquals(1, sf.getTreningUtakmica().getBrojGolovaTim1());
        assertEquals(1, sf.getTreningUtakmica().getBrojGolovaTikm2());

        assertEquals(1, sf.getTreningUtakmica().getTim1().getGrupaId());
        assertEquals("Kadeti", sf.getTreningUtakmica().getTim1().getNazivGrupe());
        assertEquals(20, sf.getTreningUtakmica().getTim1().getKapacitet());
        assertEquals(1, sf.getTreningUtakmica().getTim1().getTrener().getTrenerId());
        assertEquals("Igor", sf.getTreningUtakmica().getTim1().getTrener().getIme());
        assertEquals("Duljaj", sf.getTreningUtakmica().getTim1().getTrener().getPrezime());
        assertEquals("1234567890345", sf.getTreningUtakmica().getTim1().getTrener().getJmbg());
        assertEquals(5, sf.getTreningUtakmica().getTim1().getTrener().getGodineIskustva());

        assertEquals(2, sf.getTreningUtakmica().getTim2().getGrupaId());
        assertEquals("Kadeti", sf.getTreningUtakmica().getTim2().getNazivGrupe());
        assertEquals(20, sf.getTreningUtakmica().getTim2().getKapacitet());
        assertEquals(2, sf.getTreningUtakmica().getTim2().getTrener().getTrenerId());
        assertEquals("Igor", sf.getTreningUtakmica().getTim2().getTrener().getIme());
        assertEquals("Duljaj", sf.getTreningUtakmica().getTim2().getTrener().getPrezime());
        assertEquals("1234547890345", sf.getTreningUtakmica().getTim2().getTrener().getJmbg());
        assertEquals(5, sf.getTreningUtakmica().getTim2().getTrener().getGodineIskustva());
    }

    @Test
    public void testSetTreningUtakmicaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> sf.setTreningUtakmica(null));
    }

    @Test
    public void testSetBrojPromasenihSuteva() {
        sf.setBrojPromasenihSuteva(3);
        assertEquals(3, sf.getBrojPromasenihSuteva());
    }

    @Test
    public void testSetBrojPromasenihSutevaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setBrojPromasenihSuteva(-1));

    }

    @Test
    public void testSetBrojProvedenihMinuta() {
        sf.setBrojProvedenihMinuta(3);
        assertEquals(3, sf.getBrojProvedenihMinuta());
    }

    @Test
    public void testSetBrojProvedenihMinutaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setBrojProvedenihMinuta(-1));

    }

    @Test
    public void testSetPrvaPostava() {
        sf.setPrvaPostava(true);
        assertEquals(true, sf.isPrvaPostava());
    }

    @Test
    public void testSetPrvaPostavaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> sf.setPrvaPostava(null));

    }

    @Test
    public void testSetBrojOdbrana() {
        sf.setBrojOdbrana(3);
        assertEquals(3, sf.getBrojOdbrana());
    }

    @Test
    public void testSetBrojOdbranaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setBrojOdbrana(-1));

    }

    @Test
    public void testSetBrojPrimljenihGolova() {
        sf.setBrojPrimljenihGolova(3);
        assertEquals(3, sf.getBrojPrimljenihGolova());
    }

    @Test
    public void testSetBrojPrimljenihGolovaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setBrojPrimljenihGolova(-1));

    }

    @Test
    public void testSetOcjena() {
        sf.setOcjena(7);
        assertEquals(7, sf.getOcjena());
    }

    @Test
    public void testSetOcjenaNeg() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> sf.setOcjena(-1));

    }

    @Test
    void testEqualsObject() {
        StatistikaFudbalera stat = sf;
        assertTrue(sf.equals(stat));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(sf.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(sf.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"
    })
    void testEqualsObjectSveOk(String rbr1, String rbr2, boolean eq) {
        TreningUtakmica tu = new TreningUtakmica();
        tu.setRedniBroj(Integer.parseInt(rbr1));
        sf.setTreningUtakmica(tu);

        TreningUtakmica tu2 = new TreningUtakmica();
        tu2.setRedniBroj(Integer.parseInt(rbr2));
        StatistikaFudbalera sf1 = new StatistikaFudbalera();
        sf1.setTreningUtakmica(tu2);

        assertEquals(eq, sf.equals(sf1));
    }

    @Test
    public void testToString() throws ParseException {
        Fudbaler f = new Fudbaler();
        TreningGrupa tg = new TreningGrupa();
        f.setIme("Aleksa");
        f.setPrezime("Stancic");
        f.setPozicija("Krilo");
        tg.setNazivGrupe("Mikosi");
        f.setTreningGrupa(tg);

        TreningUtakmica tu = new TreningUtakmica();

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

        sf.setFudbaler(f);
        sf.setTreningUtakmica(tu);
        sf.setBrojAsistencija(1);
        sf.setBrojGolova(2);
        sf.setBrojPromasenihSuteva(3);
        sf.setBrojProvedenihMinuta(80);
        sf.setPrvaPostava(true);
        sf.setBrojOdbrana(4);
        sf.setBrojPrimljenihGolova(5);
        sf.setOcjena(8);

        String s = sf.toString();

        System.out.println(datum);
        assertTrue(s.contains("1"));
        assertTrue(s.contains("2"));
        assertTrue(s.contains("Sat Oct 21 00:00:00 CEST 2000"));
        assertTrue(s.contains("3"));
        assertTrue(s.contains("4"));
        assertTrue(s.contains("Kadeti"));
        assertTrue(s.contains("Petlici"));
        assertTrue(s.contains("Aleksa"));
        assertTrue(s.contains("Stancic"));
        assertTrue(s.contains("Krilo"));
        assertTrue(s.contains("Mikosi"));
        assertTrue(s.contains("1"));
        assertTrue(s.contains("2"));
        assertTrue(s.contains("3"));
        assertTrue(s.contains("4"));
        assertTrue(s.contains("5"));
        assertTrue(s.contains("8"));
        assertTrue(s.contains("80"));
        assertTrue(s.contains("true"));

    }

}
