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
public class TipTreningaTest {

    private TipTreninga tt;

    @BeforeEach
    public void setUp() {
        tt = new TipTreninga();
    }

    @AfterEach
    public void tearDown() {
        tt = null;
    }

    @Test
    void testTipTreninga() {
        assertNotNull(tt);
        assertEquals(0, tt.getTipId());
        assertNull(tt.getNazivTipa());

    }

    @Test
    void testTipTreningaParam() {
        TipTreninga tt = new TipTreninga("KONDICIONI_TRENING");

        assertNotNull(tt);
        assertEquals("KONDICIONI_TRENING", tt.getNazivTipa());
    }

    @Test
    void testTipTreningaParamID() {
        TipTreninga tt = new TipTreninga(1, "KONDICIONI_TRENING");

        assertNotNull(tt);
        assertEquals(1, tt.getTipId());
        assertEquals("KONDICIONI_TRENING", tt.getNazivTipa());
    }

    @Test
    public void testSetNazivTipa() {
        tt.setNazivTipa("KONDICIONI_TRENING");
        assertEquals("KONDICIONI_TRENING", tt.getNazivTipa());
    }

    @Test
    public void testSetNazivTipaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> tt.setNazivTipa(null));
    }

    @Test
    void testEqualsObject() {
        TipTreninga tip = tt;
        assertTrue(tt.equals(tip));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(tt.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(tt.equals(new Korisnik()));
    }

    @ParameterizedTest
    @CsvSource({
        "Kondicioni, Kondicioni, true",
        "Kondicioni, Snaga, false",})
    void testEqualsObjectSveOk(String naziv1, String naziv2, boolean eq) {
        tt.setNazivTipa(naziv1);

        TipTreninga tt2 = new TipTreninga();
        tt2.setNazivTipa(naziv2);

        assertEquals(eq, tt.equals(tt2));
    }

    @Test
    public void testToString() {
        tt.setNazivTipa("Kondicioni");

        String tip = tt.toString();
        assertTrue(tip.contains("Kondicioni"));

    }

}
