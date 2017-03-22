
package ObjectUtils;

/**
 * this class contains methods to check specific aspects of equality
 * @author erik
 */
public class EqualsUtils {

    /**
     * static method to test reflexivity
     * x.equals(x) = true;
     * @param p
     * @return
     */
    public static boolean testReflexitivity(Object p) {
        return p.equals(p);
    }

    /**
     * static method to test symmetry
     * p.equals(q) == q.equals(p)
     * @param p first
     * @param q second
     *
     */
    public static boolean testSymmetry(Object p, Object q) {

        return (p.equals(q) ? q.equals(p) : true);
    }

    /**
     * static method to test transitivity
     * p.equals(q) && q.equals(r) -> p.equals(r)
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    public static boolean testTransitivity(Object p1, Object p2, Object p3) {
        boolean eq1 = p1.equals(p2);
        boolean eq2 = p2.equals(p3);
        boolean eq3 = p1.equals(p3);
        return !((eq1 == true) && (eq2 == true)) || (eq3 == true);
    }    
    
    /**
     * static method to test equaling null object.
     * @param p1
     * @return 
     */
    public static boolean testNullIsFalse(Object p1){
        boolean eq1 = p1.equals(null);
        return (eq1 == false);
    }
}
