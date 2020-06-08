package com.jmh;

import static java.lang.Thread.sleep;

import pkg.*;

//IRRELAVANT CLASS
class MHMThread implements Runnable {

    //final Ticket t;
    final String username;
    final HashMap hm;
    final String key;
    final Ticket t;

    public MHMThread(String username, String key, HashMap hm){
        this.key = key;
        this.username = username;
        this.hm = hm;
        this.t = hm.getTicket(key);

    }

    @Override
    public void run(){
        Ticket t = hm.remove(key);
	if(t != null){
             hm.put(t.info, t);
	}
    }
}
