/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ObjectUtils.EqualsUtils;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persoon.Docent;
import persoon.Persoon;
import persoon.Student;

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
        Date d = new Date(-98011418);
        Date d2 = new Date(System.currentTimeMillis());
        Date d3 = new Date(-77777777);
        
        p1 = new Persoon("schriek","erik",d,"home","here");
        p2 = new Persoon("toma","tim",d,"home","here");
        p3 = new Student(1,"toma","tim",d,"home","here");
        p4 = new Student(2,"newton","newey",d2,"out","there");
        p5 = new Docent(10,"schriek","erik",d,"home","here");
        p6 = new Docent(20,"kuijpers","nico",d3,"home","there");
        
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
