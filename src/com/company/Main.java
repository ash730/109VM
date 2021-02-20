package com.company;
// haha
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void snacksDisplay(ArrayList<Snack> snacks){
        System.out.println("Welcome to AA Vending! ");
        int index = 1;
        for (Snack snack : snacks) {
            /*
             * %s: String
             * %f: Float/double
             * %d: integer
             * */
            System.out.printf("%d: %s $%.2f\n", index, snack.getName(), snack.getPrice());
            index++;
        }
        System.out.print(" Choose a snack or press q to quit ");
    }

    public static void snackDisplay(Snack snack) {
        System.out.printf("%s $%.2f\n", snack.getName(), snack.getPrice());
        System.out.println(snack.getDesc());
    }


    public static void main(String[] args) {
        // write your code here
        double newBalance = 0.00;
        double balance = 0.00;
        double change = 0.00;

        ArrayList<Snack> snacks = Snacks.getSnacks("snacks.csv");
        Scanner scanner = new Scanner (System.in);

        while(true) {
            snacksDisplay(snacks);

            String choice = scanner.nextLine();
            choice = choice.replace("\n", "");

            if (choice.equals("q")  || choice.equals("Q") ) {
                System.out.println("Exiting!, have a nice day");
                break;
            }
            try {
                int snackIndex = Integer.parseInt(choice) -1;

                if (snackIndex < 0 || snackIndex >= snacks.size()) {
                    continue;
                }

                // Valid Snack
                Snack snack = snacks.get(snackIndex);

                boolean snackMenu = true;
                while(snackMenu){
                    snackDisplay(snack);
                    if (balance < snack.getPrice()) {
                        System.out.printf(" Balance $%.2f please press 1 to add $1 or c to cancel " , balance );
                        choice = scanner.nextLine();

                        if (choice.equals("1")){
                            balance+= 1.00;
                        }

                        if (choice.equals("c") ||choice.equals("C") ){
                            snackMenu = false;
                        }
                    } else {
                        System.out.printf("Balance: $%.2f press a to accept or c to cancel ", balance);
                        choice = scanner.nextLine();

                        switch (choice) {
                            case "a":
                                change =  balance - snack.getPrice();
                                System.out.printf("Thank you for purchasing with AA Vending. \nYour change is $%.2f. ", change);
                                System.out.printf("\nBlance: $%.2f   ",newBalance);
                                snackMenu = false;
                            case "A":
                                change =  balance - snack.getPrice();
                                System.out.printf("Thank you for purchasing with AA Vending. \nYour change is $%.2f. ", change);
                                System.out.printf("\nBlance: $%.2f   ",newBalance);
                                snackMenu = false;

                                // print out a thank you message
                                // print out the users change
                                // zero out the balance
                                // return to the main menu
                                break;
                            case "c":
                                snackMenu = false;
                            case "C":
                                snackMenu = false;
                                break;
                        }
                    }

                }

            } catch (Exception e) {
                System.out.println("Invalid selection, please choose a snack or press q to quit ");
            }

        }

    }
}
