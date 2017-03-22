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
public class Student implements IPersoon{
    private long studentNr;
    private Persoon persoon = null;

    public Student(long studentNr, String familyname, String firstname, Date birthDate, String birthPlace, String birthCountry) {
        persoon = new Persoon(familyname, firstname, birthDate, birthPlace, birthCountry);
        this.studentNr = studentNr;
    }

    public long getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(long studentNr) {
        this.studentNr = studentNr;
    }

    @Override
    public int hashCode() {
        return persoon.hashCode();
    }

    @Override
    public boolean equals(Object o){
        return persoon.equals(o);
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
}
