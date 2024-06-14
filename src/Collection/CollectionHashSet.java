package Collection;

import DATA.DataManager;
import Entity.Person;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is responsible for interacting with the collection
 */

public class CollectionHashSet {
    private String name;
    private int size;
    private LocalDateTime timeInicilization;
    private SetTestHash<Person> collection;
    private ArrayList<Person> listCollection;


    public CollectionHashSet(String name) {
        this.name = name;
        this.timeInicilization = LocalDateTime.now();
        this.collection = DataManager.Load();
        this.listCollection = new ArrayList<>();
    }

    public LocalDateTime getTimeInicilization() {
        return this.timeInicilization;
    }

    public String getName() {
        return this.name;
    }

    public void addElement(Person person) {
        this.collection.add(person);
        this.size = collection.size();
    }

    public void clearCollection(){
        collection.clear();
    }

    public int sizeCollection() {
        return this.collection.size();
    }

    public void removeElement(Person person) {
        this.collection.remove(person);
        this.size = collection.size();
    }

    public ArrayList getCollection() {
        //this.listCollection.clear();
//        for (HMCustom.Entry<Person, Object> e : this.collection.getHashMapCustom().getTable()) {
//            this.listCollection.add(e.key);
//        }
        for (Object person : this.collection.getPersons()) {
            this.listCollection.add((Person) person);
        }

        return this.listCollection;
    }

    public SetTestHash<Person> getHashsetCollection() {
        return collection;
    }

}
