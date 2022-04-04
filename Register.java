
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.Random;

class Register{

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int phoneNumber;
    private String emailID;
    private String walletAddress;
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

    public String getPublicKey(){
        return publicKey;
    }

    public void generatePublicKey(){
        Random key = new Random();
        int publicKey = key.nextInt();
        String hexKey = Integer.toHexString(publicKey);
        System.out.println(hexKey);
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

        user.generatePublicKey();
        // System.out.println("First Name: ");
        // String firstName = obj.nextLine();
        // user.setFirstName(firstName);

        // System.out.println("Last Name: ");
        // String lastName = obj.nextLine();
        // user.setLastName(lastName);


        // System.out.println("User Name: ");
        // String userName = obj.nextLine();
        // user.setUserName(userName);


        
        try{

            FileWriter writeDetails = new FileWriter("details.txt");
            
            // writeDetails.write(user.getFirstName());
            // writeDetails.write(user.getLastName());
            // writeDetails.write(user.getEmailID());
            // writeDetails.write(user.getUserName());
            // writeDetails.write(user.getPassword());
            // writeDetails.write(user.getPhoneNumber());
            // writeDetails.write(user.getAccountType());


            writeDetails.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }




    }
}