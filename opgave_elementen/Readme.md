# Opdracht Week 3 Objecten
## Doel: Gebruiken standaard implementaties bij Objecten in Collections

## Inleiding.
Objecten (Elementen),  worden in collecties opgeslagen als Elementen. Deze elementen weten zelf niet in wat voor Collectie zij zich bevinden. Ook de ontwikkelaar weet niet in welke collecties de elementen in de toekomst gebruikt zullen gaan worden. Om dit op te lossen, dienen Objecten die in Collections gebruikt worden, toekomstig bestendig geimplementeerd te worden. Lees als voorbereiding de PDF over “Effective JAVA Chapter3” van Joshua Bloch. 

Voorbereiding
Gegeven is de Persoon klasse in bijgeleverd netbeans project. Deze persoon objecten bevatten een aantal attributen, die apart of gezamenlijk een uniek persoon kunnen identificeren. Zie gegeven netbeans project ‘ opgave_elementen’.
 
## Opdracht 1.1 
Maak unittesten die de equals eigenschappen van Persoon objecten testen:
Override hiertoe de equals methode om aan te tonen of 2 persoon objecten gelijk zijn, volgens volgende specificatie:
2 personen zijn gelijk indien:
-hun bsn en hun firstname and familyname hetzelfde zijn.
-hun firstname, familyname, birthdate, birthplace and birthcountry hetzelfde zijn.

``` java

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
     * @param Other
     * @return
     */
    private boolean equalFirstCase(Object Other) {
        if (this == other) return true;                 // If we are comparing with myself return true
        if (!(other instanceof Persoon)) return false;  // if we are not a Persoon return false

        Persoon persoon = (Persoon) other;              // we are an instance of Peroon so perform a cast
        boolean nameValidated = compStrMember(firstname, persoon.firstname) &&  compStrMember(familyname, persoon.familyname);
        // first Clause , a Primitative value (long) cannot be null so we can compare without any risk
        return ((BSN == persoon.BSN) && nameValidated);
    }
    
    
    private boolean equalSecondCase(Object other) {
        if (this == other) return true;                 // If we are comparing with myself return true
        if (!(other instanceof Persoon)) return false;  // if we are not a Persoon return false

        Persoon persoon = (Persoon) other;              // we are an instance of Peroon so perform a cast
        boolean nameValidated = compStrMember(firstname, persoon.firstname) &&  compStrMember(familyname, persoon.familyname);
        boolean dateValidated = birthDate != null ? birthDate.equals(persoon.birthDate) : persoon.birthDate == null;
        return nameValidated 
                        &&  compStrMember(birthPlace,persoon.birthPlace)
                        &&  compStrMember(birthCountry, persoon.birthCountry)
                        &&  dateValidated;
    }
    
    /**
     * Two persons are equal when:
     * - their BSN , firstname and familay name are equal
     * or
     * - their firstname, familyname, birthdate, birthplace and birthcountry are the sames
     * @param other The object to compare with
     * @return the logical value of the compare based on the above conditions
     */
    @Override
    public boolean equals(Object other) {
        return equalFirstCase(other) || equalSecondCase(other);
    }

    /**
     * * Two persons are equal when:
     * - their BSN , firstname and familay name are equal
     * or
     * - their firstname, familyname, birthdate, birthplace and birthcountry are the sames
     * The Hashcode must align with this, the only two parameters in the set are firstname and last name
     * @return the hashcode 
     */
    @Override
    public int hashCode() {
        int result = 31 * (familyname != null ? familyname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        return result;
    }
  
    
```
![test resultaat](https://github.com/charleskorthout/UC_Week_3/tree/master/opgave_elementen/img/2017-03-07_20-04-27.png "test resultaat" )
## Opdracht 1.2 
Breidt je specificatie en dus bovenstaande unittesten uit zodat ze voldoen aan de standaard eisen die aan equals gesteld worden (zie javadoc/voorbeeldcode klas). Gebruik hiertoe ook de gegeven klasse EqualsUtils.

## Opdracht 1.3
Maak unittesten om add, contains, delete/remove en size te testen als je bovenstaande Persoon objecten in een List implementatie stopt. Verklaar het gedrag dat je ziet en pas je tests en code aan indien nodig. Hou bij welke wijzigingen je uitgevoerd hebt.

## Opdracht 1.4
Stop nu de bovenstaande Objecten uit 1.1 in een HashSet implementatie. Maak een unittest om te laten zien of bovenstaande methoden van de collectie ook werken (Voeg hiertoe methoden toe in HashCodeUtils om het hashcode contract aan te tonen, en gebruik deze in je tests.). 
Verklaar het gedrag dat je ziet en pas je tests en code aan indien nodig. Hou bij welke wijzigingen je uitgevoerd hebt.

## Opdracht 1.5
Stop nu de bovenstaande Objecten uit 1.1 in een gesorteerde collectie. Gebruik hiervoor de natuurlijke ordening. (Voeg hiertoe methoden toe in CompareToUtils om het Comparable contract aan te tonen, en gebruik deze in je tests.). 
Verklaar het gedrag dat je ziet en pas je tests en code aan indien nodig. Hou bij welke wijzigingen je uitgevoerd hebt.

De Persoon objecten worden overerfd door gegeven 2 klassen: Student en Docent. 

Een Docent is gelijk als hun loginAccountNr hetzelfde is, of als ze gelijk zijn als Persoon. Docent objecten hebben een natuurlijke ordening net als Persoon.
Een Student is gelijk als hun studentNr hetzelfde is, of als ze gelijk zijn als Persoon. Student objecten hebben een natuurlijke ordening net als Persoon.

## Opdracht 1.6
Override hier dus ook alle relevante methoden, zodat deze objecten in diverse collections gebruikt kunnen worden. 

Aangezien Student en Docent ook Persoon objecten zijn, kunnen ze in elke collectie van Persoon objecten opgeslagen worden. 
Stop de gegeven objecten in PersoonTest in één HashSet<Persoon> . 

## Opdracht 1.7
Maak een unittest, waarbij je alle persoon objecten (p1-p6) ieder met elkaar vergelijkt door equals en compareTo te gebruiken. Sla het resultaat van de vergelijkingen op. Maak hiertoe een tabel net als onderstaande

| Persoon1 |	Persoon2 |	Equals (T/F) | compareTo(+,0,-) |
|:--------:|:-----------:|:-------------:|:----------------:|
| P1	   | P1	         |               |	                |
| P1	   | P2	         |               |	                |
| P1	   | P3	         |               |	                |
| P1	   | P4	         |               |	                |
| P1	   | P5	         |               |	                |
| P1	   | P6	         |               |	                |
| P2       | P1          |               |                  |
| P2       | P2          |               |                  |	
| P2       | P3          |               |                  |
| P2       | P4          |               |                  |
| P2       | P5          |               |                  |
| P2       | P6          |               |                  |
| P3       | P1          |               |                  |	
| P3       | P2          |               |                  |
| P3       | P3          |               |                  |
| P3       | P4          |               |                  |
| P3       | P5          |               |                  |
| ..       |             |               |                  |
| P6       | P5          |               |                  |
| P6       | P6          |               |                  |

Is het resultaat volgens je verwachtingen? Verklaar je antwoord.


## Opdracht 1.8
Vergelijk nu van bovenstaande 6 objecten of zij aan het JAVA contract van equals voldoen (gebuik hiervoor de voorbeeld testcode van het klasvoorbeeld) Verklaar je antwoorden (lees hiertoe de PDF over “Effective JAVA Chapter3” van Joshua Bloch). Besteed aan het verklaren maximaal ½ uur.


## Opdracht 1.9
Gebruik ‘Favor composition over inheritance’ om aan te tonen dat nu wel alle bovenstaande objecten voldoen aan het JAVA contract voor equals.

## Opdracht 1.10 (optioneel)
Voer 1.7 en 1.8 en 1.9 uit ook voor compareTo en hashCode. Geldt voor deze methoden hetzelfde principe als voor equals geldt? Verklaar je antwoord.

## Opdracht 1.11 (optioneel)
Check je antwoorden door verschillende collections te gebruiken voor 1.6-1.9. Neem in  ieder geval een gesorteerde, ongesorteerde, treebased en hashbased collectie op. Verklaar je antwoorden.


