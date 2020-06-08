package pkg;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

class List  extends ReentrantLock {
 ArrayList<Ticket> tickets = new ArrayList<>();

 //this is or bucket management in the Hashmap
 public void add(Ticket t){
     tickets.add(t);
 }
//Finds a ticket with a specific 
 public Ticket remove(String key){
     int i = 0;
     while (i < tickets.size()){
         if(tickets.get(i).info.equals(key)){
             return tickets.remove(i);
         }
         i++;
     }
     return null;
 }
    //finds a ticket with a specific 
    public Ticket get(String key){
        int i = 0;
        while (i < tickets.size()){
            if(tickets.get(i).info.equals(key)){
                return tickets.get(i);
            }
            i++;
        }

        return null;
    }

}
