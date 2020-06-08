
import pkg.Ticket;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

//OLD CLASS

public class TKTS {
    ArrayList<Ticket> tickets = new ArrayList<>();

//This class is used to genarate ticket datasets, and put them in .txt files
    public void genTickets(){
        tickets.clear();
        Random r = new Random();

        double curPrice = 500;
//This is modeling a very large concert of 20,280 seats
//k  is the section, i is the row,  j is the seat;
//The price gets lowered the further it is from the stage
        for(int i = 0; i  < 260; i++){
            for(int j = 0; j < 26; j++){
                for(int k = 0; k < 3; k++){
                    String temp = (i + "" + j + "" + (k + 1));
                    tickets.add(new Ticket(temp, curPrice));
                }
            }
            curPrice--;
        }
//Pushes the generated tickets to a file
        try {
            FileWriter fw = new FileWriter("ds2.txt");
            PrintWriter pw = new PrintWriter(fw);
            while(!tickets.isEmpty()) {
                Ticket temp = tickets.remove(r.nextInt(tickets.size()));
                pw.println(temp.info + "," + temp.price);
                //helps the delimiter later
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        tickets.clear();
        curPrice = 100;
//generates tickets for a much smaller concert 
//i is the row, j is the seat
//The price gets lowered the further it is from the stage
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                String temp = (i + "" + j);
                tickets.add(new Ticket(temp, curPrice));
            }
            curPrice = curPrice  - 2;
        }
//Pushes the generated tickets to a file
        try {
            FileWriter fw2 = new FileWriter("ds1.txt");
            PrintWriter pw = new PrintWriter(fw2);
            while(!tickets.isEmpty()) {
                Ticket temp = tickets.remove(r.nextInt(tickets.size()));
                pw.println(temp.info + "," + temp.price);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//generate method
    public ArrayList<Ticket> getTickets(){
        return tickets;
    }
}
