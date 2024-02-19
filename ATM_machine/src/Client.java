public class Client {
    private int id;
    private String name;
    private String lname;
    private float bill;
    private String password;


    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLname(){
        return lname;
    }
    public float getBill(){
        return bill;
    }
    public String getPassword(){
        return password;
    }
    public String getClientInfo(){
        return (name+" "+lname+": "+bill);
    }

    public void setMoneyIntoBill(float amount){
        this.bill+=amount;
        System.out.println("Account is updated!");
    }
    public void getMoneyFromBill(float amount){
        if (amount <= bill) {
            this.bill -= amount;
            System.out.println("Account is updated!");
        }
        else{
            System.out.println("Not enough money! Available amount: "+bill);
        }
    }

//    constructor
    public Client(int id, String name, String lname, String password){
        this.id = id;
        this.name = name;
        this.lname = lname;
        this.password = password;
        bill = 0;
    }


}
