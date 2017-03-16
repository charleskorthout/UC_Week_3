
package ObjectUtils;

/**
 * this class contains methods to check specific aspects of hashcode
 * @author YOU
 */
public class HashCodeUtils {
    // TODO: add utility methods to test specific parts of the hashcode JAVA
    // contract, as specified in the JavaDoc for Object.

    /**
     * Whenever it is invoked on the same object more than once, the hashCode method must consistently return the same integer
     */
    public static boolean testHashCodeConsistency(Object o1)
    {
        int firstcall = o1.hashCode();
        int secondcall = o1.hashCode();
        return firstcall == secondcall;
    }
    /**
     * if o1 is equals to o2, then o1.hashcode should be equal to o2.hashcode
     * @param o1
     * @param o2
     */
    public static boolean testHashCodeEquality(Object o1, Object o2)
    {
        return (o1.equals(o2)) ? (o1.hashCode()== o2.hashCode()) : false;
    }
}
