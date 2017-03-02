/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceErrors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * eigen implementatie van een hashset met aparte teller 
 * voor aantal toegevoegde elementen. 
 * Er zit iets raars in......
 * @author erik
 */
public class AddCounterHashSet_Inherited extends HashSet{
    private int addCounter = 0; // aantal toegevoegde elementen aan de hashset

    
    //
    // create constructors (like in JCF)
    //
    
    // constructor(s)
    public AddCounterHashSet_Inherited(Collection c) {
        super(c);
    }

    public AddCounterHashSet_Inherited(int initialCapacity) {
        super(initialCapacity);
    }

    public AddCounterHashSet_Inherited(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public AddCounterHashSet_Inherited() {
        super();
    }

    
    // override 2 methods for adding 

    @Override
    public boolean add(Object e) {
        this.addCounter++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection c) {
        this.addCounter += c.size();
        return super.addAll(c);
    }
    
    // eigen methode voor ophalen waarde van addCounter
    public int getAddCounter(){
        return this.addCounter;
    }
}
