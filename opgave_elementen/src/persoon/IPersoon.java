package persoon;

import java.util.Date;

/**
 * Created by Charles Korthout on 3/22/2017.
 */
public interface IPersoon extends Comparable {

    /**
     * Two persons are equal when:
     * - their BSN , firstname and familay name are equal
     * or
     * - their firstname, familyname, birthdate, birthplace and birthcountry are the sames
     * @param other The object to compare with
     * @return the logical value of the compare based on the above conditions
     */
    boolean equals(Object other);

    /**
     * * Two persons are equal when:
     * - their BSN , firstname and familay name are equal
     * or
     * - their firstname, familyname, birthdate, birthplace and birthcountry are the sames
     * The Hashcode must align with this, the only two parameters in the set are firstname and last name
     * @return the hashcode
     */
    int hashCode();

    /**
     * natuurlijke ordening op birthDate, vervolgens op familyname, vervolgens
     * op firstname.
     *
     * @param other The object to comapre with
     * @return the result of the compare
     */
    int compareTo(Object other);

    // properties required to enable the compareTo for persoon
    Date getBirthDate();
    String getFirstName();
    String getFamilyName();
}
