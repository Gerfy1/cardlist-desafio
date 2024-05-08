package br.com.purchaseControl.main;

import br.com.purchaseControl.CreditCard;
import br.com.purchaseControl.Purchase;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                *****************************************************
                        Welcome to ShopApplication - V0.035.1b
                   contact: test@shopping.com for bugs and feedbacks
                *****************************************************
                                Enter your card limit:""");
        double limit = scanner.nextDouble();
        scanner.nextLine();

        CreditCard card = new CreditCard(limit);
        List<Purchase> listPurchase = new LinkedList<>();

        while (true){
            System.out.println("|+ Enter your purchase description: ");
            String description = scanner.nextLine();
            System.out.println("|+ Enter your purchase amount: ");
            double amount = scanner.nextDouble();
            if (card.purchase(amount)){
                System.out.println("|- Added!");
            } else {
                System.out.println("|== Insufficient funds! ==|");
                break;
            }
            scanner.nextLine();

            listPurchase.add(new Purchase(amount, description));

            System.out.println("Do you want to add a new purchase? (Digit 1 for Yes and 0 for No)\n");
            int query = scanner.nextInt();
            if (query == 0){
                break;
            }
            scanner.nextLine();
        }
        System.out.println("| Your CreditCard limit: $" + String.format("%.2f", card.getLimit()));
        listPurchase.sort(Comparator.comparingDouble(Purchase::getAmount).reversed());
        for (Purchase purchase : listPurchase){
            System.out.println("| Description: " +purchase.getDescription() + " | Amount: $" + String.format("%.2f", purchase.getAmount()));
        }
    }
}