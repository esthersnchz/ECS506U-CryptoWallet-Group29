import java.io.*;
import java.util.Scanner;

public class Login {

    public static void run2FA(){
        Scanner obj2 = new Scanner(System.in);
        
        int min = 1000;
        int max = 9999;
        int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println("Your 2FA: " + randomNumber);
        System.out.println("Enter your 2FA Code: ");
        int code = obj2.nextInt();


        
        System.out.println("Successful");



    }

    public static void checkLogin(String user, String pass){
        int attempt = 1;
        while(attempt < 4){
            Scanner obj = new Scanner(System.in);
            System.out.println("     LOGIN          ");
            System.out.println("\n\nUSER ID :");
            String username = obj.nextLine();
            System.out.println("Password: ");
            String password = obj.nextLine();
            

            if(username.equals(user) && password.equals(pass)){
                System.out.println("Login Successful");
                run2FA();
                attempt = 100;
                break;
                
            }
            else{
                System.out.println("Login Failed (Attempts Remaining: " + attempt + ")");
                attempt+=1;
            }
          
        }
    }
  

    public static void main(String args[]){
     
        int ln3 = 3;
        int ln5 = 5;
        String user = "";
        String pass = "";
        try{
            FileReader readFile = new FileReader("details.txt");
            BufferedReader read = new BufferedReader(readFile);
            for(int i = 1; i <7; i++){
                if(i == ln3){
                    user = read.readLine();

                }
                else if(i == ln5){
                    pass = read.readLine();
                }
                else{
                    read.readLine();
                }
                
                

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(user);
        System.out.println(pass);
        checkLogin(user,pass);

    }
}





    