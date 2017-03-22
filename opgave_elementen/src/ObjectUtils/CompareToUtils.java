package ObjectUtils;

import persoon.Persoon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * this class contains methods to check specific aspects of the
 * compareTo method of Comparable objects.
 * It is based on slides of week 3
 * 1. sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
 * 2. (x.compareTo(y)>0 && y.compareTo(z)>0) -> x.compareTo(z)>0.
 * 3. x.compareTo(y)==0 -> sgn(x.compareTo(z)) == sgn(y.compareTo(z)) voor alle z
 * 4. if x.compareTo(y) throws an exception then also y.compareTo(x)
 * 5. preferrably consistent with equals: (e1.compareTo(e2) == 0) == (e1.equals(e2))
 *
 * @author Charles Korthout
 */
public class CompareToUtils {

    /**
     * ensure 1. sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y.
     * (This implies that x.compareTo(y) must throw an exception iff y.compareTo(x) throws an exception.)
     *
     * @param x The left hand object
     * @param y The right hand object
     */
    public static boolean testComparisonReversal(Comparable x, Comparable y)
    {
        return Integer.signum(x.compareTo(y)) == -Integer.signum(y.compareTo(x) );
    }

    /*
     * ensure 2. (x.compareTo(y)>0 && y.compareTo(z)>0) -> x.compareTo(z)>0.
     *
     * @param x item 1
     * @param y item 2
     * @param z item 2
     */
    public static boolean testTransitivity(Comparable x, Comparable y, Comparable z)
    {
        return ((x.compareTo(y) > 0) && (y.compareTo(z) > 0 ) && ( x.compareTo(z) > 0 ));
    }

    /**
     * Utility function to compare with null safe
     * @param x item 1
     * @param y item 2
     * @return icompare result
     */
    public static int nullSafeComparator(Object x, Object y) {
        if (x == null ^ y == null) {
            return (x == null) ? -1 : 1;
        }
        if (x == null && y == null) {
            return 0;
        }
        if ((x instanceof Comparable) && (y instanceof Comparable)) {
            return ((Comparable)x).compareTo((Comparable)y);
        }
        else {
            throw new NotImplementedException(); // should not happen, we are comparing apples and oranges..
        }
    }


    /**
     * If the x compares throws an exception then also y  comapred with null must throw an exception.
     * @param x
     * @param y
     * @return
     */
    public static boolean testNullPointerException(Comparable x, Comparable y)
    {
        boolean xb = false;
        boolean yb = false;
        try
        {
            x.compareTo(y);
        }
        catch(Exception e)
        {
            xb =true;
        }
        try
        {
            y.compareTo(x);
        }
        catch(Exception e)
        {
            yb =true;
        }
        return xb == yb;
    }


    /**
     * Utility function to compare the values and check equals
     * @param x item 1
     * @param y item 2
     * @return icompare result
     */
    public static boolean testConsistencyWithEqual(Comparable x, Comparable y) {
        if (x.compareTo(y) == 0 ) {
            return x.equals(y);
        }
        else return true; // we do not care if they are not equal...
    }
}