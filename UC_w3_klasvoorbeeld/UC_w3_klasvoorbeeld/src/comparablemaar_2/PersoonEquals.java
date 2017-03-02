/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparablemaar_2;

/**
 *
 * @author erik
 */
public class PersoonEquals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Persoon p1 = new Persoon("Erik",11,23);
        Persoon p2 = new Persoon("Erik",11,23);
        //
        // zijn deze 2 personen gelijk?
        // volgens equals
        System.out.println("resultaat is TRUE indien gelijk: "+p1.equals(p2));
        // volgens equals, andersom
        System.out.println("resultaat is TRUE indien gelijk: "+p2.equals(p1));
        //
        // Verwacht?
        //
    }
}
