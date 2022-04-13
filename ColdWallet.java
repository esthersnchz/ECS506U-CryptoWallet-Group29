import java.util.ArrayList;
import java.util.Scanner;

public class ColdWallet {

    public static void main(String[] args){

    }

    public static void ColdWalletDeposit (Investor person){
        System.out.println("Which wallet would you like to choose (Enter the name)");
        Scanner scanner = new Scanner(System.in);
        string usedWallet = scanner.nextLine();

        ArrayList<string> wallets = person.getWalletsNames();

        if (wallets.contains(usedWallet)){
            string PasswordAttempt = new Scanner(System.in);
            if (PasswordAttempt.equals(person.getPassword()){
                System.out.println("Transfer to cold wallet complete");
            else{
                System.out.println("Password Incorrect");
        }
        else {
            System.out.println("Transaction failed, wallet does not exist");
        }
    }
}

/*
Ask for which wallet
Wallet selection
transfer complete
 */
