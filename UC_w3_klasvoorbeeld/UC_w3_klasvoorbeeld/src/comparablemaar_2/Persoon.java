package comparablemaar_2;



/**
 * persoon object met natuurlijke ordening
 * WEL overriden van equals. 
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
        return (this.compareTo(obj) == 0);
    }

    
}
