/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceErrors;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class AddCounterHashSet_CompositionTest {
     private static Object e1,e2;
    private static List list;
   
    public AddCounterHashSet_CompositionTest() {
    }

     @BeforeClass
    public static void setUpClass() throws Exception {
        // maak 2 losse objecten die gebruikt kunnen worden
        e1 = "een eerste object";
        e2 = "een tweede object";
 
        // maak een collectie die gebruikt kan worden
        list = new ArrayList();
        list.add("jan");
        list.add("piet");
        list.add("joris");
        
    }

 
    /**
     * Test of add method, of class AddCounterHashSet_Composition.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        AddCounterHashSet_Composition instance = new AddCounterHashSet_Composition();
        int expResult = 2;
        //
        instance.add(e1);
        instance.add(e2);
        int result = instance.getAddCounter();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAll method, of class AddCounterHashSet_Composition.
     */
    @Test
     public void testAddAll() {
        System.out.println("addAll");
        Collection c = list;
        AddCounterHashSet_Composition instance = new AddCounterHashSet_Composition();
        int expResult = list.size();
        //
        instance.addAll(list);
        int result = instance.getAddCounter();
        assertEquals(expResult, result);
    }

 
}
