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
        System.out.println("\r\n" + //
                        " _    _        _                                 _                  ______                \r\n" + //
                        "| |  | |      | |                               | |                 | ___ \\               \r\n" + //
                        "| |  | |  ___ | |  ___   ___   _ __ ___    ___  | |_   ___     __ _ | |_/ /  __ _  _   _  \r\n" + //
                        "| |/\\| | / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\ | __| / _ \\   / _` || ___ \\ / _` || | | | \r\n" + //
                        "\\  /\\  /|  __/| || (__ | (_) || | | | | ||  __/ | |_ | (_) | | (_| || |_/ /| (_| || |_| | \r\n" + //
                        " \\/  \\/  \\___||_| \\___| \\___/ |_| |_| |_| \\___|  \\__| \\___/   \\__, |\\____/  \\__,_| \\__, | \r\n" + //
                        "                                                                 | |                __/ | \r\n" + //
                        "                                                                 |_|               |___/  \r\n" + //
                        "");                                                                                                             
        System.out.println("*Insert Selection Message Here*");
    }
    
}

/*This POC app should first welcome the user with a fun welcome message with associated ASCII art
(websites like the one here can help you with this), and then ask a student user to login using their
Quinnipiac email and password. You do not need to setup a real-world login system – just have a couple
of accounts hardcoded that can be used. If the student fails to login three times due to incorrect
username/password, tell the user that they are locked out of their account due to suspicious activity and
force exit the application.*/
