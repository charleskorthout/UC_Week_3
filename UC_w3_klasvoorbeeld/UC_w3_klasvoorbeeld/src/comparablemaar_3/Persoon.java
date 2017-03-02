package comparablemaar_3;

import java.util.Objects;



/**
 * persoon object met natuurlijke ordening
 * WEL overriden van equals. 
 * WEL overriden van hashcode
 *
 * @author erik
 */
public class Persoon implements Comparable
{
  private String naam;
  private int geboorteJaar;
  private int geboorteMaand;


  public Persoon(String naam, int gebJaar, int gebMaand) {
      this.naam = naam;
      this.geboorteJaar = gebJaar;
      this.geboorteMaand = gebMaand;
  }

    @Override
  public String toString()
  {
    return this.naam+","+this.geboorteJaar+","+this.geboorteMaand;
  }

    public int getGeboorteJaar() {
        return this.geboorteJaar;
    }

    public int getGeboorteMaand() {
        return this.geboorteMaand;
    }

    public String getNaam() {
        return this.naam;
    }

    /**
     * natuurlijke ordening op naam, geboortejaar en -maand.
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        // throw exceptions when necessary
        if(o == null){
            throw new NullPointerException();
        }
            if(! (o instanceof Persoon)){
            throw new ClassCastException();
        }
        // vergelijkingen
        Persoon p = (Persoon)o;
        int returnvalue = this.naam.compareTo(p.naam);
        if(returnvalue == 0){
            returnvalue = this.geboorteJaar - p.geboorteJaar;
        }
        if(returnvalue == 0){
            returnvalue = this.geboorteMaand - p.geboorteMaand;
        }
        return returnvalue;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        return (this.compareTo(obj) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.naam);
        hash = 53 * hash + this.geboorteJaar;
        hash = 53 * hash + this.geboorteMaand;
        return hash;
    }



    

    /**
     * gebruik bij genereren hashcode TENMINSTE dezelfde attributen, die
     * ook betrokken zijn bij compareTo & equals.
     * @return 
     */
 
    
    
}
