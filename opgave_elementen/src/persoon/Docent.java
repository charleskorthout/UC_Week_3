/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persoon;

import java.util.Date;

/**
 *
 * @author erik
 */
public class Docent implements IPersoon {

    private long loginAccountNr;
    private Persoon persoon = null;

    public Docent(long loginAccountNr, String familyname, String firstname, Date birthDate, String birthPlace, String birthCountry) {
        persoon = new Persoon(familyname, firstname, birthDate, birthPlace, birthCountry);
        this.loginAccountNr = loginAccountNr;
    }

    public long getLoginAccountNr() {
        return loginAccountNr;
    }

    public void setLoginAccountNr(long loginAccountNr) {
        this.loginAccountNr = loginAccountNr;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;                 // If we are comparing with myself return true
        if (!(other instanceof IPersoon)) return false;  // if we are not a Persoon return false
        IPersoon opersoon = (IPersoon) other;              // we are an instance of Peroon so perform a cast
        return persoon.equals(opersoon);
    }

    @Override
    public int hashCode() {
        return persoon.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return persoon.compareTo(o);
    }

    @Override
    public Date getBirthDate() {
        return persoon.getBirthDate();
    }

    @Override
    public String getFirstName() {
        return persoon.getFirstName();
    }

    @Override
    public String getFamilyName() {
        return persoon.getFamilyName();
    }

    @Override
    public String getBirthPlace() {
        return persoon.getBirthPlace();
    }

    @Override
    public String getBirthCountry() {
        return persoon.getBirthCountry();
    }

    @Override
    public long getBSN() {
        return persoon.getBSN();
    }

    @Override
    public void setBSN(long BSN) {
            persoon.setBSN(BSN);
    }


}
