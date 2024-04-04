package challenge1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Item> shopList = new ArrayList<Item>(); //for Buy and Sell methods
    ArrayList<Item> cart = new ArrayList<Item>();// for viewCart method

    

    Scanner scan = new Scanner(System.in);

    public void home() {
        //for debugging only
        // cart.clear();
        // cart.add(new Item("Potion", "test2", "test3", "yeah@yeah.com", 9.99));
        // cart.add(new Item("Super Potion", "test2", "test3", "yeah@yeah.com", 14.99));

        System.out.println("Welcome to qBay!");
        System.out.println("Please input the selection you wish to make: \n1. Buy\n2. Sell\n3. Cart\n4. Logout");
        int selection = scan.nextInt();
        switch (selection) {
            case 1:
                buy();
                break;
            case 2:
                sell();
                break;
            case 3:
                viewCart();
                break;
            case 4:
                System.out.println("Thanks for logging into qBay. You have successfully logged out. We hope to see you again!");
                System.exit(0);
                break;
            default:
                home();
        }
    }

    public void buy(){

    }

    public void sell(){

    }

    public void viewCart(){
        double totalPrice = 0.0;
        System.out.println("Displayed below is your current cart: ");
        if (cart.isEmpty()) System.out.println("Your cart does not contain any items. Please select items from the Buy screen to add them to your cart.");
        else {
            for (Item item : cart) {
                System.out.println(item.getItemName() + " | " + item.getPrice());
                totalPrice = totalPrice + item.getPrice();
            }
            System.out.println("Your total comes out to: $" + totalPrice);
        }
        System.out.println("Please input the selection you wish to make:\n1. Proceed to checkout\n2. Go back");
        int selection = scan.nextInt();
        switch (selection) {
            case 1:
                if (cart.isEmpty()) viewCart();
                else checkout();
                break;
            case 2:
                home();
                break;
            default:
                viewCart();
        }
    }

    public void checkout() {
        System.out.println("Input 1 to confirm your purchase, type anything else to return to cart.");
        int confirm = scan.nextInt();
        if (confirm == 1) {
            System.out.println("Thank you for your patronage. Your items have been successfully purchased!");
            cart.clear();
            home();
        }
        else viewCart();
    }

    
    public static void main(String[] args) {
        new Main().home();
    }
    
}
