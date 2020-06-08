package pkg;

//just  some data to represent a ticket

public class Ticket {

    public String info = "";
    public double price = 0;
    public boolean isAvalabe = true;
    public String user = "";

    public Ticket(String info, double price){
        this.info = info;
        this.price = price;
    }
}
