package com;
import java.util.Random;
import java.util.Scanner;


public class AccRecover {
    public static void main(String[] args) {
        String code1 = recoverPhrase();
        String code2 = recoverPhrase();
        String code3 = recoverPhrase();
        String code4 = recoverPhrase();
        String code5 = recoverPhrase();
        String code6 = recoverPhrase();

        //
        String recoveryPhrase = code1 + " " + code2 + " " +  code3 + " " + code4 + " " + code5 + " " + code6;
        System.out.println("These are your recovery phrases:  ");
        System.out.println(recoveryPhrase);

        System.out.println(("Please enter the recovery phrases below: "));
        Scanner myObj = new Scanner(System.in);
        String attempt1 = myObj.nextLine();
        String attempt2 = myObj.nextLine();
        String attempt3 = myObj.nextLine();
        String attempt4 = myObj.nextLine();
        String attempt5 = myObj.nextLine();
        String attempt6 = myObj.nextLine();

        // If successful the recover is successful
        if (attempt1.equals(code1) && attempt2.equals(code2) && attempt3.equals(code3) && attempt4.equals(code4)
                && attempt5.equals(code5) && attempt6.equals(code6)){
            System.out.println("Recovery successful");
        }
        else{
            System.out.println("Recovery Unsuccessful");
        }

    }




    // generates a random phrase
    private static String recoverPhrase() {
        String[] recoverPhrases = {"Cat", "Phone", "Bottle", "Tiger", "Corn", "Nail", "Door", "Wire", "Mask", "Apple",
                "Bag", "Stairs", "Mug", "Table", "Chair", "Pen", "Paper", "Book", "Dog", "Map"};

        Random random = new Random();
        int codeindex= random.nextInt(20);

        String code = recoverPhrases[codeindex];


        return code;
    }
    }



