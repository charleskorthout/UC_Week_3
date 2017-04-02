package persoon;

import ObjectUtils.CompareToUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 * persoon object
 *
 * @author erik
 */
public class Persoon implements IPersoon{

    private long BSN; // burgerservicenummer
    private String familyname; // familie naam
    private String firstname; // voornaam
    private Date birthDate;   // birthDate in EPOCH time
    private String birthPlace; // birthplace during birth
    private String birthCountry; // birth county during birth

    public Persoon(String familyname, String firstname, Date birthDate, String birthPlace, String birthCountry) {
        this.familyname = familyname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.birthCountry = birthCountry;
    }
    
    public long getBSN() {
        return BSN;
    }

    public void setBSN(long BSN) {
        this.BSN = BSN;
    }

    @Override
    public String toString() {
        return this.firstname + "," + this.familyname + "," + 
                DateFormat.getInstance().format(birthDate) 
                + "," + this.birthPlace + " ," + this.birthCountry;
    }

    @Override
    public int compareTo(Object t) {
        if (null == t) return CompareToUtils.nullSafeComparator(this,t);
        if (t instanceof IPersoon)
        {
                IPersoon p = (IPersoon) t;
                if (!(CompareToUtils.nullSafeComparator(birthDate,p.getBirthDate()) == 0)) return CompareToUtils.nullSafeComparator(birthDate,p.getBirthDate());
                else {
                    if (!(CompareToUtils.nullSafeComparator(familyname,p.getFamilyName())==0)) return CompareToUtils.nullSafeComparator(familyname,p.getFamilyName());
                    else return CompareToUtils.nullSafeComparator(firstname,p.getFirstName());
                }
        }
        else return CompareToUtils.nullSafeComparator(this,t);
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getFamilyName() {
        return familyname;
    }

    @Override
    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * helper method to compare two strings
     * @param left the left hand string
     * @param right the right hand string
     * @return the logical value of the compare
     */
    private static boolean compStrMember(String left, String right) {
        if (left != null ? !left.equals(right) : right != null) return false;
        return true;
    }

    /**
     * * Two persons are equal when:
     * - their BSN , firstname and familay name are equal
     * @param persoon The persoons object to compare
     * @return
     */
    private boolean equalFirstCase(IPersoon persoon) {
        boolean nameValidated = compStrMember(firstname, persoon.getFirstName()) &&  compStrMember(familyname, persoon.getFamilyName());
        // first Clause , a Primitative value (long) cannot be null so we can compare without any risk
        return ((BSN == persoon.getBSN()) && nameValidated);
    }


    private boolean equalSecondCase(IPersoon persoon) {

        boolean nameValidated = compStrMember(firstname, persoon.getFirstName()) &&  compStrMember(familyname, persoon.getFamilyName());
        boolean dateValidated = birthDate != null ? birthDate.equals(persoon.getBirthDate()) : persoon.getBirthDate() == null;
        return nameValidated
                        &&  compStrMember(birthPlace,persoon.getBirthPlace())
                        &&  compStrMember(birthCountry, persoon.getBirthCountry())
                        &&  dateValidated;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;                 // If we are comparing with myself return true
        if (!(other instanceof IPersoon)) return false;  // if we are not a IPersoon return false
        IPersoon opersoon = (IPersoon) other;              // we are an instance of Peroon so perform a cast
        return equalFirstCase(opersoon) || equalSecondCase(opersoon);
    }


    @Override
    public int hashCode() {
        return (firstname + familyname).hashCode();
    }

}
