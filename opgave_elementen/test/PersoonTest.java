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
import org.apache.velocity.util.ArrayListWrapper;
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

    /**
     * Simpel test if we can add an person and a docent
     */
    @Test
    public void testAddPersonAndDocentToList(){
        personen.clear();
        int expected = 1;
        personen.add(p1);
        int actual = personen.size();
        assertEquals(expected,  actual);
        expected = 2;
        personen.add(p5);
        actual = personen.size();
        assertEquals(expected,  actual);
    }

    /**
     * Simpel test if we can add an person and a student
     */
    @Test
    public void testAddPersonAndStudenttToList(){
        personen.clear();
        int expected = 1;
        personen.add(p1);
        int actual = personen.size();
        assertEquals(expected,  actual);
        expected = 2;
        personen.add(p3);
        actual = personen.size();
        assertEquals(expected,  actual);
    }

    @Test
    public void testContainsForSameDocent_Student_Person(){
        personen.clear();
        boolean expected = true;
        personen.add(p1); // Erik as persoon
        personen.add(p5); // Erik as docent
        personen.add(p7); // Erik as student
        boolean actual = personen.contains(p1);
        assertEquals(expected,  actual);
        actual = personen.contains(p5);
        assertEquals(expected,  actual);
        actual = personen.contains(p7);
        assertEquals(expected,  actual);
    }

    @Test
    public void testContainsSameDocent_Student_Person_with_proper_type(){
        personen.clear();
        boolean expected = true;
        personen.add(p1); // Erik as persoon
        personen.add(p5); // Erik as docent
        personen.add(p7); // Erik as student
        IPersoon p1a = personen.get(0);
        IPersoon p5a = personen.get(1);
        IPersoon p7a = personen.get(2);
        boolean actual = ((p1 == p1a) && (p1a instanceof Persoon));
        assertEquals(expected,  actual);
        actual = ((p5 == p5a) && (p5a instanceof Docent));
        assertEquals(expected,  actual);
        actual = ((p7 == p7a) && (p7a instanceof Student));
        assertEquals(expected,  actual);
    }

    @Test
    public void createCompareAllPersons(){
        personen.clear();
        boolean expected = true;
        personen.add(p1);
        personen.add(p2);
        personen.add(p3);
        personen.add(p4);
        personen.add(p5);
        personen.add(p6);
        personen.add(p7);
        IPersoon p1a = personen.get(0);
        IPersoon p5a = personen.get(1);
        IPersoon p7a = personen.get(2);
        boolean actual = ((p1 == p1a) && (p1a instanceof Persoon));
        assertEquals(expected,  actual);
        actual = ((p5 == p5a) && (p5a instanceof Docent));
        assertEquals(expected,  actual);
        actual = ((p7 == p7a) && (p7a instanceof Student));
        assertEquals(expected,  actual);
    }

    private class Pair<X extends IPersoon,Y> {
        private X x_;
        private Y y_;
        public Pair(X x, Y y) {
            x_ = x;
            y_ = y;
        }

        public X fst() {
            return x_;
        }

        public Y snd() {
            return y_;
        }

        public void print(Pair p2){

            System.out.println("| " + x_.getFirstName() + " " + x_.getFamilyName() + "(" +y_.toString() + ") | "
                                  + p2.fst().getFirstName() + " " + p2.fst().getFamilyName()+ "(" + p2.snd().toString() + ") | "
                                  + x_.equals(p2.fst()) + " | " + x_.compareTo(p2.fst()) + " |");
        }
    }

    @Test
    public void exercise1_7() {
        List<Pair<IPersoon,String>> personen = new ArrayList<>();
        personen.add(new Pair(p1,"p1"));
        personen.add(new Pair(p2,"p2"));
        personen.add(new Pair(p3,"p3"));
        personen.add(new Pair(p4,"p4"));
        personen.add(new Pair(p5,"p5"));
        personen.add(new Pair(p6,"p6"));
        personen.add(new Pair(p7,"p7"));
        System.out.println("| Persoon1 |\tPersoon2 |\tEquals (T/F) | compareTo(+,0,-) |");
        System.out.println("|:--------:|:-----------:|:-------------:|:----------------:|");
        personen
            .stream()
            .forEach((x) -> personen
                            .stream()
                            .forEach( (y) -> x.print(y)));
        assertTrue(true);
    }


}
