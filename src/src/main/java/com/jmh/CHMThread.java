package com.jmh;

import java.util.concurrent.ConcurrentHashMap;

import pkg.*;

import static java.lang.Thread.sleep;
//IRRELAVANT CLASS
class CHMThread implements Runnable {

    //final Ticket t;
    final String username;
    final ConcurrentHashMap<String, Ticket> chm;
    final String key;
    final Ticket t;

    public CHMThread(String username, String key, ConcurrentHashMap<String, Ticket> chm){
        this.key = key;
        this.username = username;
        this.chm = chm;
        this.t = chm.get(key);

    }

    @Override
    public void run(){
	Ticket t = chm.remove(key);
	if(t != null){
	    chm.put(t.info, t);
	}
    }
}
