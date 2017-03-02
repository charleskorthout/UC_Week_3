/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparablemaar_3;

import ObjectUtils.EqualsUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erik
 */
public class PersoonTest {

    Persoon p1, p2, p3, p4, p5, p6;

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
        p1 = new Persoon("erik", 1966, 11);
        p2 = new Persoon("erik", 1966, 11);
        p3 = new Persoon("erik", 1966, 11);
        p4 = new Persoon("jan", 1999, 12);
        p5 = new Persoon("emin", 2005, 5);
        p6 = new Persoon("rose", 1980, 3);
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
        assertTrue(EqualsUtils.testTransitivity(p1, p2, p3));
        // test transitiviteit met ongelijke waarden
        assertTrue(EqualsUtils.testTransitivity(p4, p5, p6));
    }

    
//    /**
//     * Test of hashCode method, of class Persoon.
//     */
//    @Test
//    public void testHashCode() {
//        // use HashCodeUtils for tests
//        // TODO
//        fail("The test case is a prototype.");
//    }
//
//        /**
//     * Test of compareTo method, of class Persoon.
//     */
//    @Test
//    public void testCompareTo() {
//        // use CompareToUtils for tests
//        // TODO
//        fail("The test case is a prototype.");
//    }

    
}
