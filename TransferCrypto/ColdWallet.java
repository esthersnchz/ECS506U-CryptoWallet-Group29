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
            System.out.println("Transfer to cold wallet complete");
        }
        else {
            System.out.println("Transaction failed, wallet does not exist");
        }
    }
}

/*
Ask for which wallet
Wallet selection
Password entry
Check Password
Amount selection?
Remove amount from account?
Hard code transfer complete
 */