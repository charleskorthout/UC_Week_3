/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparablemaar_3;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author erik
 */
public class PersoonInHashSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Persoon p1 = new Persoon("Erik",11,23);
        Persoon p2 = new Persoon("Erik",11,23);
        //
        
        System.out.println("HashSet");
        Set<Persoon> mijnSet2 = new HashSet<>();
        mijnSet2.add(p1);
        mijnSet2.add(p2);
        // toon elementen
        for(Persoon p : mijnSet2){
            System.out.println(p);
        }
        // verwacht?
    }
}
