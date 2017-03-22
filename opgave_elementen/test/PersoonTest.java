/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ObjectUtils.CompareToUtils;
import ObjectUtils.EqualsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ObjectUtils.HashCodeUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persoon.Docent;
import persoon.Persoon;
import persoon.Student;
import persoon.IPersoon;

/**
 *
 * @author erik
 */
public class PersoonTest {

    IPersoon p1, p2, p3, p4, p5, p6, p7;
    List<IPersoon> personen;

    public PersoonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Date d = new Date(-98011418);
        Date d2 = new Date(System.currentTimeMillis());
        Date d3 = new Date(-77777777);

        p1 = new Persoon("schriek","erik",d,"home","here");
        p2 = new Persoon("toma","tim",d,"home","here");
        p3 = new Student(1,"toma","tim",d,"home","here");
        p4 = new Student(2,"newton","newey",d2,"out","there");
        p5 = new Docent(10,"schriek","erik",d,"home","here");
        p6 = new Docent(20,"kuijpers","nico",d3,"home","there");
        // added one to check transitivity rule, erik becomes also a student ;-)
        p7 = new Student(1,"schriek","erik",d,"home","here");

        //initialize personen
        personen = new ArrayList<>();
    }
        

    @After
    public void tearDown() {
    }


    /**
     * Test of equals method, of class Persoon.
     */
    @Test
    public void testEquals() {
        // test null waarde
        assertTrue(EqualsUtils.testNullIsFalse(p1));
        // test reflexiviteit 
        assertTrue(EqualsUtils.testReflexitivity(p1));
        // test symmetrie met gelijke waarden
        assertTrue(EqualsUtils.testSymmetry(p1, p2));
        // test symmetrie met ongelijke waarden
        assertTrue(EqualsUtils.testSymmetry(p1, p4));
        // test transitiviteit met gelijke waarden
        assertTrue(EqualsUtils.testTransitivity(p1, p5, p7));
        // test transitiviteit met ongelijke waarden
        assertTrue(EqualsUtils.testTransitivity(p4, p5, p6));
    }

    
//    /**
//     * Test of hashCode method, of class Persoon.
//     */
    @Test
    public void testHashCode() {
        // use HashCodeUtils for tests
        assertTrue(HashCodeUtils.testHashCodeConsistency(p1));
        assertTrue(HashCodeUtils.testHashCodeEquality(p1,p1));
        assertTrue(HashCodeUtils.testHashCodeEquality(p1,p5));
    }
//
    /**
     * Test of compareTo method, of class Persoon.
     */
    @Test
    public void testCompareTo() {
        // use CompareToUtils for tests
        // ensure 1. sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y.
        assertTrue(CompareToUtils.testComparisonReversal(p1,p2));
        // ensure 2. (x.compareTo(y)>0 && y.compareTo(z)>0) -> x.compareTo(z)>0.
        assertTrue(CompareToUtils.testTransitivity(p4, p6, p1));
        // 4. if x.compareTo(y) throws an exception then also y.compareTo(x)
        assertTrue(CompareToUtils.testNullPointerException(p1,p2));
        // 5. preferrably consistent with equals: (e1.compareTo(e2) == 0) == (e1.equals(e2))
        assertTrue(CompareToUtils.testConsistencyWithEqual(p1,p2));
    }

    /**
     * Simpel test if we can add an person
     */
    @Test
    public void testAddPersonToList(){
        int expected = 1;
        personen.add(p1);
        int actual = personen.size();
        assertEquals(expected,  actual);
        expected = 2;
        personen.add(p2);
        actual = personen.size();
        assertEquals(expected,  actual);
    }
}
