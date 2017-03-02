/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparablemaar_2;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author erik
 */
public class PersoonInTreeSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Persoon p1 = new Persoon("Erik",11,23);
        Persoon p2 = new Persoon("Erik",11,23);
        //
        // gevolgen voor Collections
        System.out.println("TreeSet");
        Set<Persoon> mijnSet = new TreeSet<>();
        mijnSet.add(p1);
        mijnSet.add(p2);
        // toon elementen
        for(Persoon p : mijnSet){
            System.out.println(p);
        }
        // verwacht?
    }
}
