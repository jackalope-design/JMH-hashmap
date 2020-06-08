package com.jmh;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pkg.*;

public class JMHBro {
    public HashMap shm = new HashMap();
    public ConcurrentHashMap<String, Ticket> schm = new ConcurrentHashMap<>();
    public HashMap lhm = new HashMap();
    public ConcurrentHashMap<String, Ticket> lchm = new ConcurrentHashMap<>();
    public ArrayList<Ticket> largeDataSet = new ArrayList<>();
    public ArrayList<Ticket> smallDataSet = new ArrayList<>();
    public ArrayList<String> usernames = new ArrayList<>();
    Random r = new Random();
    //initalizing datasets and HashMaps

    public JMHBro(){
        try {
            TestEnv te  = new TestEnv();
            this.largeDataSet = te.largeDataSet;
            this.smallDataSet = te.smallDataSet;
            this.usernames = te.usernames;
            //initilizes datasets from TestEnv instance
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < smallDataSet.size(); i++){
            shm.put(smallDataSet.get(i).info, smallDataSet.get(i));
            schm.put(smallDataSet.get(i).info, smallDataSet.get(i));
        }

        for(int i = 0; i < largeDataSet.size(); i++){
            lhm.put(largeDataSet.get(i).info, largeDataSet.get(i));
            lchm.put(largeDataSet.get(i).info, largeDataSet.get(i));
        }
    }
    //puts all gotten data into hashmaps

    public void smallDataMHM() {
        String key = smallDataSet.get(r.nextInt(smallDataSet.size())).info;
        Ticket t = shm.remove(key);
        if(t != null){
             shm.put(t.info, t);
        }
    }
    
    //test method for a small dataset "Matt" Hashmap
    //It will remove a value, and then re-insert it
    public void smallDataCHM() {
        String key = smallDataSet.get(r.nextInt(smallDataSet.size())).info;
        Ticket t = schm.remove(key);
        if(t != null){
             schm.put(t.info, t);
        }
    }

    public void largeDataMHM() {
    String key = largeDataSet.get(r.nextInt(largeDataSet.size())).info;
        Ticket t = lhm.remove(key);
        if(t != null){
             lhm.put(t.info, t);
        }
    }
//test method for a small dataset JDK ConcurrentHashMap
//It will remove a value, and then re-insert it
    public void largeDataCHM() {
        String key = largeDataSet.get(r.nextInt(largeDataSet.size())).info;
        Ticket t = lchm.remove(key);
        if(t != null){
             lchm.put(t.info, t);
        }
    }
//test method for a large dataset JDK ConcurrentHashMap
//It will remove a value, and then re-insert it
}
