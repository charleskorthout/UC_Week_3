/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceErrors;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Wrapper class voor eigen hashset klasse. 
 * 
 * @author erik
 */
public class AddCounterHashSet_Composition implements Set{

    private int addCounter = 0;
    private final HashSet set;  // final: not inheritable

        
    //
    // create constructors (like in JCF)
    //
    

    public AddCounterHashSet_Composition(HashSet set) {
        this.set = set;
    }

    public AddCounterHashSet_Composition(int initialCapacity, float loadFactor) {
        this.set = new HashSet(initialCapacity, loadFactor);
    }

    public AddCounterHashSet_Composition(int initialCapacity) {
        this.set = new HashSet(initialCapacity);
    }

    public AddCounterHashSet_Composition() {
        this.set = new HashSet();
    }

    // 2 methods for adding 
    public boolean add(Object e) {
        this.addCounter++;
        return this.set.add(e);
    }

    public boolean addAll(Collection c) {
        this.addCounter += c.size();
        return this.set.addAll(c);
    }

    // eigen methode voor addCounter
    public int getAddCounter() {
        return this.addCounter;
    }

    //
    // forward other methods of hashSet (if necessary)
    public void clear() {
        this.set.clear();
    }

    public boolean contains(Object o) {
        return this.set.contains(o);
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public int size() {
        return this.set.size();
    }

    public Iterator iterator() {
        return this.set.iterator();
    }

    public boolean remove(Object o) {
        return this.set.remove(o);
    }

    public boolean containsAll(Collection c) {
        return this.set.containsAll(c);
    }

    public boolean removeAll(Collection c) {
        return this.set.removeAll(c);
    }

    public boolean retainAll(Collection c) {
        return this.set.retainAll(c);
    }

    public Object[] toArray() {
        return this.set.toArray();
    }

    public Object[] toArray(Object[] a) {
        return this.set.toArray(a);
    }
}
