/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparablemaar_2;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author erik
 */
public class AlleGedragInEen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Persoon p1 = new Persoon("Erik",11,23);
        Persoon p2 = new Persoon("Erik",11,23);
        //
        // zijn deze 2 personen gelijk?
        // volgens compare:
        System.out.println("resultaat is 0 indien gelijk: "+p1.compareTo(p2));
        // andersom?
        System.out.println("resultaat is 0 indien gelijk: "+p2.compareTo(p1));
        // volgens equals
        System.out.println("resultaat is TRUE indien gelijk: "+p1.equals(p2));
        // volgens equals, andersom
        System.out.println("resultaat is TRUE indien gelijk: "+p2.equals(p1));
        //
        // Verwacht?
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
