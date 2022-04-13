import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Investor investor = createInvestor();
        useCase(investor);

    }

    public static void useCase(Investor investor) {
        boolean repeat = true;
        boolean checkreponse = false;
        String balance = "";
        String walletName = "";

        //user enters type of transaction they want to do
        while (repeat) {
            String response = input("What typo of transaction would you like to do? :Send or Receive Crypto?");
            checkreponse = checkresponse(response,"send","receive","\nWrong transaction name");
            while (!checkreponse) {
                response = input("try again");
                checkreponse = checkresponse(response,"send","receive","Wrong transaction name");
            }

            //a list of existing wallets is provided to the user
            print("\nThis is the list of your wallets \n" + investor.getWalletNames() + "\n");
            String response2 = input("Would you like to see the balance in any of your wallets ?(Yes/No)");
            boolean checkYesNo=checkresponse(response2,"yes","no","\nWrong option");
            while(!checkYesNo){
                response2=input("input Yes or No!");
                checkYesNo=checkresponse(response2,"yes","no","\nWrong option");
            }

            if (response2.equalsIgnoreCase("yes")) {
                //user selects the wallet from which they want to get the balance
                balance = input("\nEnter the wallet name to see its balance\nEnter all to see the balance of all your wallets");
                checkreponse = checkWalletName(balance, investor);
                while (!checkreponse) {
                    if (balance.equalsIgnoreCase("all")) {
                        break;
                    } else {
                        balance = input("Enter another wallet name");
                        checkreponse = checkWalletName(balance, investor);
                    }
                }
                if (balance.equalsIgnoreCase("all")) {
                    print("\nThis is the balance in all your wallets \n" + investor.getWalletsBalance());
                } else {
                    System.out.println("This is the balance for " + balance + "\n" + investor.getOneWallet(balance).getCryptos());
                }
            }

            //user selects the wallet in which they want to do the transaction
            checkreponse = false;
            //if the wallet name does nit exist the user will have to input another name
            while (!checkreponse) {
                walletName = input("\nIn which wallet would you like to perform the transaction?");
                checkreponse = checkWalletName(walletName, investor);
            }
            if (response.equalsIgnoreCase("send")) {
                performTransaction("send", investor, walletName);
            } else if (response.equalsIgnoreCase("receive")) {
                performTransaction("receive", investor, walletName);
            }

            String repeatTrans= input("\nWould you like to do any other transaction?(Yes/No)");
            Boolean repeatYes = checkresponse(repeatTrans,"yes","no","\nWrong option");
            while(!repeatYes){
                repeatTrans=input("input Yes or No!");
                repeatYes=checkresponse(repeatTrans,"yes","no","\nWrong option");
            }
            repeat=repeatTransaction(repeatTrans);
        }
    }


    //method to perform the transactions
    public static void performTransaction(String transactionType, Investor investor, String walletName) {

        String cryptoName = input("\nWhat Crypto would you like to " + transactionType + "?");
        if (transactionType.equalsIgnoreCase("send")) {
            //check if the crypto exists inside the wallet
            boolean cryptoExists = investor.getOneWallet(walletName).checkCryptoExists(cryptoName);
            while (!cryptoExists) {
                cryptoName = input("\nYou do not have this crypto in your wallet\nEnter another crypto");
                cryptoExists = investor.getOneWallet(walletName).checkCryptoExists(cryptoName);
            }
        }

        //check if the user has input a numeric value
        String cryptoAmount = input("\nEnter the amount");
        boolean checkinput=checkInput(cryptoAmount);
        while(!checkinput){
            cryptoAmount= input("\nRe enter the amount");
            checkinput= checkInput(cryptoAmount);
        }

        if (transactionType.equalsIgnoreCase("send")) {
            boolean checkBalance = investor.getOneWallet(walletName).checkFunds(cryptoName, Double.parseDouble(cryptoAmount));
            while (!checkBalance) {
                cryptoAmount = input("\nYou have insufficient funds\nEnter another amount");
                checkBalance = investor.getOneWallet(walletName).checkFunds(cryptoName, Double.parseDouble(cryptoAmount));
            }
            input("\nEnter the address of the destination wallet");
            print("\nVerifying destination wallet address.......");
            wait(100);
        }

        print("\nConnecting tot he blockchain...............");
        wait(100);
        print("...........................................");
        wait(1500);
        print("\nTransaction complete!");
        wait(100);
        print("\nThis is the summary of your transaction");
        if (transactionType.equalsIgnoreCase("send")) {
            print(investor.tradeCryto(walletName, cryptoName, -Double.parseDouble(cryptoAmount), transactionType));
        } else {
            print(investor.tradeCryto(walletName, cryptoName, Double.parseDouble(cryptoAmount), transactionType));
        }
        String newBalance = input("\nWould you like to see the current balance of " + walletName + "? (Yes/No)");
        boolean checkYes=checkresponse(newBalance,"yes","no","\nWrong option");
        while(!checkYes){
            newBalance=input("input Yes or No!");
            checkYes=checkresponse(newBalance,"yes","no","\nWrong option");
        }
        if (newBalance.equalsIgnoreCase("yes")) {
            print("\nThis si the new balance in " + walletName + "\n" + investor.getOneWallet(walletName).getCryptos());
        }

    }


    //ask user if they want to do another transaction
    public static Boolean repeatTransaction(String input) {
        if (input.equalsIgnoreCase("yes")) return true;
        return false;
    }

    //method to check if the wallet nam input by the user exists
    public static boolean checkWalletName(String input, Investor investor) {
        if (input.equalsIgnoreCase("all")) return true;
         else if (!investor.checkNameExist(input)) {
            print("\nWrong wallet name");
            return false;
        }

        return true;
    }

    //check if user has input the right transaction name
    public static boolean checkresponse(String response,String option1, String option2, String errormsg) {
        if (response.equalsIgnoreCase(option1) || response.equalsIgnoreCase(option2)) {
            return true;
        }
        print(errormsg);
        return false;
    }

    //check if the user has input a numeric value
    public static boolean checkInput(String cryptoAmount) {

        try { Double.parseDouble(cryptoAmount);
            return true;
        }
        catch(NumberFormatException e)
        {
            print("This is not a number");
            return false;
        }
    }


    public static String input(String message) {
        Scanner scanner = new Scanner(System.in);
        print(message);
        return scanner.nextLine();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    //hardcoding a sample investor to demonstratee the use case
    public static Investor createInvestor() {
        Investor investor = new Investor("esty19", "123456", "IDKwhattowrite", "Esther", "Sanchez");
        Wallet wallet1 = new Wallet("wallet1", "1234", "4567", "asdasdffsf34", false);
        Wallet wallet2 = new Wallet("wallet2", "4321", "4567", "werwerwer5466", false);
        investor.setWallets(wallet1);
        investor.setWallets(wallet2);
        investor.getOneWallet("wallet1").setCryptos("bitcoin", 40.00);
        investor.getOneWallet("wallet1").setCryptos("cardano", 56.00);
        investor.getOneWallet("wallet2").setCryptos("ethereum", 30.67);
        investor.getOneWallet("wallet2").setCryptos("filecoin", 27.33);
        return investor;
    }

}
