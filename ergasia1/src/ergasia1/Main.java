package ergasia1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Person>  peopleArrayList = new ArrayList<>();//list with people in catalogue
        peopleArrayList=customDeserializeList("People Cataloge");//open the file that contains the people
        Scanner sc=new Scanner(System.in);

        while(true){
            showMenu();
            String choice=sc.nextLine();//read input

            if (choice.equals("1")){
                for(Person p:peopleArrayList)
                    p.print();
            }else if (choice.equals("2")) {
                boolean found=false;
                System.out.print("Give full name:");
                String n=sc.nextLine();
                for(Person p:peopleArrayList) {
                    if (p.getFullName().equals(n)) {
                        System.out.println(("This Person already exists!"));
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.print("Give number: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Give email: ");
                    String em = sc.nextLine();
                    System.out.print("Give Birthday: ");
                    String bd = sc.nextLine();
                    System.out.print("Give country: ");
                    String c = sc.nextLine();
                    System.out.print("Give address: ");
                    String ad = sc.nextLine();
                    for (Person p : peopleArrayList) {
                        if (p.getFullName().equals(n)) {
                            System.out.println(("This Person already exists!"));
                            found = true;
                            break;
                        }
                    }
                    peopleArrayList.add(new Person(n, num, ad, em, bd, c));
                    System.out.println("Added!");
                }
            }else if(choice.equals("3")) {
                System.out.println(("Give full name to search: "));
                String searchName = sc.nextLine();
                boolean found = false;//variable true if name exists or false if it doesn't
                for (Person p : peopleArrayList)
                    if (p.getFullName().equals(searchName)) {
                        p.print();
                        found = true;
                    }
                if (!found)//if name doesn't exist
                    System.out.println("This person doesn't exist");
            }else if(choice.equals("4")){
                System.out.println("Give full name to delete:");
                String nameDelete=sc.nextLine();//read name to delete
                boolean found = false;//variable true if name exists or false if it doesn't
                for (Person p : peopleArrayList)
                    if (p.getFullName().equals(nameDelete)) {
                        peopleArrayList.remove(p);
                        found = true;
                        System.out.println("Deleted!");
                        break;
                    }
                if(!found)//if name does not exist
                    System.out.println("This person doesn't exist");
            }else if (choice.equals("5")){
                customSerializeList(peopleArrayList,"People Cataloge");//put the changes in file
                System.out.println("Bye bye...");
                return;
            }
            else
                System.out.println("Not valid number!");
        }
    }
    static void customSerializeList(ArrayList<Person> person, String fileName){//method saves the file
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(person);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static ArrayList<Person> customDeserializeList(String fileName){//method loads the file
        ArrayList<Person> person = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            person= (ArrayList<Person>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    static void showMenu(){
        System.out.println("\t\tMENU");
        System.out.println("----------------------");
        System.out.println("1-print catalogue");
        System.out.println("2-add person");
        System.out.println("3-search person");
        System.out.println("4-delete person");
        System.out.println("5-exit program");
        System.out.print(("Give your choice:"));

    }
}

