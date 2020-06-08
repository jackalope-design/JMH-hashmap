package pkg;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class HashMap extends ReentrantLock {

    public double resizeRate = 0.75;
    public int tableSize = 16;
    List[] map;
    public int size = 0;
    int capacity = 0;
    //Some basic varibles for table management

    public HashMap() {
        map = new List[tableSize];
        for (int i = 0; i < tableSize; i++) {
            map[i] = new List();
        }
        //initalizes array of Lists, we got buckets!
        //This is how collisons are handled

        this.capacity = (int) Math.round(tableSize * resizeRate);
    }

    private int hash(String key) {
        int first = Math.abs(key.hashCode());
        return Math.abs((first * 167) % tableSize);
        // multiplies the .hashCode()  by an arbatrary prime number
        // the mod of this number and table size gives us a hash
    }

    public void put(String key, Ticket t) {
        int hashedkey = this.hash(key);
        lock();
        //prevents other treads from modifing data in the table 
        map[hashedkey].add(t);
        size++;
        //book keeping for table size
        //Yikes, we gotta fix add more buckets
        if (size >= capacity) {
            this.size = 0;
            this.reHash();
            //itterates through the new table and re-adds all values
        }
        //now other threads can make adjustments
        unlock();
    }


    public void reHash() {

        this.tableSize = this.tableSize * 2;
        this.capacity = (int) Math.round(tableSize * resizeRate);
        //book keeping for the growing table 

        List[] tempmap = new List[map.length];
        //List of old buckets
        for (int i = 0; i < tempmap.length; i++) {
            tempmap[i] = map[i];
        }
        //initalizes all the temparary data for rehash
        
        map = new List[tableSize];
        //redefine map
        
        for (int i = 0; i < map.length; i++) {
            map[i] = new List();
        }
        //initalize blank lists 
        
        for (int i = 0; i < tempmap.length; i++) {
            for (int j = 0; j < tempmap[i].tickets.size(); j++)
                this.put(tempmap[i].tickets.get(j).info, tempmap[i].tickets.get(j));
        }
    }
    
    //itterates through all nodes in old map and adds them to the 
    //re initilized map

    public Ticket getTicket(String key){
        List ll = this.map[hash(key)];
        return ll.get(key);
    }
    //finds a hash of a key and returns its associated value
    
    //gets, removes, and returns what is found
    public Ticket remove(String key){
        lock();
        //prevents other treads from modifing data in the table 
        List ll = this.map[hash(key)];
        size--;
        unlock();
        //now new opperations can be made
        return ll.remove(key);
    }
}
