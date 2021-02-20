package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Snack> snacks = Snacks.getSnacks("snacks.csv");

        for(Snack snack : snacks ) {
            System.out.printf("%s $%.2f %d %s\n", snack.getName(), snack.getPrice(), snack.getQty(), snack.getDesc());
        }
    }
}
