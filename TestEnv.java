package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestEnv {
//This class extracts data from files and makes it ready to be used

    public ArrayList<Ticket> largeDataSet = new ArrayList<>();
    public ArrayList<Ticket> smallDataSet = new ArrayList<>();
    public ArrayList<String> usernames = new ArrayList<>();
    //THATS WHERE WE PUT THE DATA
    
    //this constructs scanners wih delimeters for file parseing
    public TestEnv() throws FileNotFoundException {
        File lds = new File("ds2.txt");
        File sds = new File("ds1.txt");
        File userFile = new File("usernames.txt");
        Scanner ldsscan = new Scanner(lds);
        Scanner sdsscan = new Scanner(sds);
        Scanner userScaner = new Scanner(userFile);
        ldsscan.useDelimiter(",");
        sdsscan.useDelimiter(",");


        while(sdsscan.hasNext()){
            String info = sdsscan.next();
            Double price = Double.parseDouble(sdsscan.nextLine().substring(1));
            smallDataSet.add(new Ticket(info, price));
        }
        while(ldsscan.hasNext()){
            String info = ldsscan.next();
            Double price = Double.parseDouble(ldsscan.nextLine().substring(1));
            largeDataSet.add(new Ticket(info, price));
        }
        while(userScaner.hasNext()){
            usernames.add(userScaner.nextLine());
        }
        //3 Loops for extracting all the data from the files, and putting it into arraylists
    }
}
