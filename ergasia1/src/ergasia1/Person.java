package ergasia1;

import java.io.Serializable;

public class Person implements Serializable {

    private String fullName;
    private int number;
    private String address;
    private String email;
    private String birthday;
    private String country;

    Person(String fullName,int number,String address,String email,String birthday,String country){//constructor
        this.fullName=fullName;
        this.address=address;
        this.birthday=birthday;
        this.country=country;
        this.email=email;
        this.number=number;
    }

    //getters
    public String getFullName() {return fullName;}

    public int getNumber() {return number;}

    public String getAddress() {return address;}

    public String getBirthday() {return birthday;}

    public String getEmail(){return email;}

    public String getCountry(){return country;}

    //Format printing
    public void print(){
        System.out.println("==================================================");
        System.out.println("Name:"+this.getFullName()+",Phone number: "+ this.getNumber() );
        System.out.println("Email:"+this.getEmail()+",Address: "+this.getAddress());
        System.out.println(("Birthday:"+this.getBirthday()+ ", Country:"+this.getCountry()));
        System.out.println("==================================================");
    }
}