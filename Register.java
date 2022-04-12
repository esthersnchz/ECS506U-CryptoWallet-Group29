
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import java.util.Random;

class Register{

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int phoneNumber;
    private String emailID;
    private String accountType;


    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;

    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
        
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getEmailID(){
        return emailID;
    }

    public void setEmailID(String emailID){
        this.emailID = emailID;

    }

    public String getAccountType(){
        return accountType;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;

    }



    public static void main(String args[]){
        Register user = new Register();
        Scanner obj = new Scanner(System.in);

        try {
            File myFile = new File("details.txt");
            myFile.createNewFile();

        }
       catch (Exception e) {
       }
        System.out.println("First Name: ");
        String firstName = obj.nextLine();
        user.setFirstName(firstName);

        System.out.println("Last Name: ");
        String lastName = obj.nextLine();
        user.setLastName(lastName);

        System.out.println("Email ID: ");
        String emailID = obj.nextLine();
        user.setEmailID(emailID);

        System.out.println("User Name: ");
        String userName = obj.nextLine();
        user.setUserName(userName);

        System.out.println("Choose a password: ");
        String password = obj.nextLine();
        user.setPassword(password);

        System.out.println("Phone Number: ");
        String phoneNumber = obj.nextLine();
        user.setPassword(phoneNumber);

     

        System.out.println("Account Type (Personal or Professional): ");
        String accountType = obj.nextLine();
        user.setAccountType(accountType);

        
        try{


            File writeDetails = new File("details.txt");
            FileOutputStream fileStream = new FileOutputStream(writeDetails);
            BufferedWriter myFile = new BufferedWriter(new OutputStreamWriter(fileStream));
            myFile.write(user.getFirstName());
            myFile.newLine();
            myFile.write(user.getLastName());
            myFile.newLine();
            myFile.write(user.getEmailID());
            myFile.newLine();
            myFile.write(user.getUserName());
            myFile.newLine();
            myFile.write(user.getPassword());
            myFile.newLine();
            myFile.write(user.getPhoneNumber());
            myFile.newLine();
            myFile.write(user.getAccountType());
            myFile.newLine();

            myFile.close();

        }
        catch(IOException e){

            System.out.println("Invalid Information");
            e.printStackTrace();
        }




    }
}