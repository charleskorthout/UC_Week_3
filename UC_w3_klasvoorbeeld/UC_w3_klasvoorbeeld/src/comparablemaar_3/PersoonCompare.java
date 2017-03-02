/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparablemaar_3;

/**
 *
 * @author erik
 */
public class PersoonCompare {

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
    }
}
