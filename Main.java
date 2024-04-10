package challenge1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Item> shopList = new ArrayList<Item>(); //for Buy methods
    ArrayList<Item> sellList = new ArrayList<Item>(); //for Sell methods
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
        System.out.println("Please select which menu you would like to view \n1. Items listed for sale\n2. Add new item to Sell\n3. Go back to Home");
        int selection = scan.nextInt();
        switch (selection) {
            case 1:
                viewSellList();
                break;
            case 2:
                addSell();
                break;
            case 3:
                home();
                break;
            default:
                System.out.println("Invalid Input, try again");
                sell();
        }

    }

    public void viewSellList() {
        System.out.println("Displayed below is a list of items you are selling: ");
        if (sellList.isEmpty()){
            System.out.println("You currently do not have any items for sale. Please go to add new item to sell to your page");
            sell();
        } else {

        }
    }


    /*When the sell option is chosen, the user is presented with two more menu options to either see their
current items up for sale or add a new item for sale.
If the user selects to see their current items up for sale, all of their current item names should be listed
alongside the category and price in a nicely presented manner.
If the user selects add new item, they should be prompted to enter in a name for the item, a category
for the item, and a price for the item. The item should then be added to the system and show up when
the user goes to the previously mentioned option for seeing their current items up for sale.
An option to go back to the main menu must be available to the user as well*/

    public void addSell() {
        System.out.println("Would you like to list an item to sell? Please type yes or no");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Please enter item name");
            String itemName = scan.nextLine();

            System.out.println("Please enter the category for " + itemName);
            String category = scan.nextLine();

            System.out.println("Please enter listing price for " + itemName);
            double price = scan.nextDouble();

            sellList.add(new Item(itemName, category, null, null, price));

            System.out.println(itemName + " has been added to sell list successfully\nReturning you to the previous menu");
            sell();

        } else if (answer.equalsIgnoreCase("no")){
            System.out.println("Understood, now sending you to the previous menu");
            sell();
        } else {
            System.out.println("Invalid input, try again");
            addSell();
        }
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
        //proof of concept
        ArrayList<String> credUserName = new ArrayList<String>();
        credUserName.add("student1");
        credUserName.add("student2");
        credUserName.add("student3");

        ArrayList<String> credPassWord = new ArrayList<String>();
        credPassWord.add("testing1");
        credPassWord.add("testing2");
        credPassWord.add("testing3");

        //String[] credUserName = {"student1", "student2", "student3"};
        //String[] credPassWord = {"testing1", "testing2", "testing3"};
        //List<String> credPassWord = Arrays.asList("testing1", "testing2", "testing3");

        Scanner scan = new Scanner(System.in); //same name as other scanner, just so it can be accessed here
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

        //establishing variables outside do
        String userName = "";
        String passWord = "";
        //cred mistake counter
        int mistake = 1;

        System.out.println("Please enter Your QU Username below");
        userName = scan.nextLine(); //userName variable for login

        System.out.println("Please enter Your QU Password below");
        passWord = scan.nextLine(); //password variable for password

        while (mistake < 3) {
            int userNameIndex = credUserName.indexOf(userName);
            if (userNameIndex != -1 && credPassWord.get(userNameIndex).equals(passWord)) {
                System.out.println("Welcome user " + userName + "!");
                mistake = 4;
            } else {
                System.out.println("Incorrect Username or Password. You have have " + (3 - mistake) + " mistakes left");
                System.out.println("Please enter Your QU Username below");
                userName = scan.nextLine(); //userName variable for login

                System.out.println("Please enter Your QU Password below");
                passWord = scan.nextLine(); //password variable for password

                mistake++;
            }

        }
        
        if (mistake == 3) {
            System.out.println("You have made 3 mistakes and have been locked out due to suspicious activity.\nGoodbye");
            System.exit(0);
        }

        //so it can access home
        Main homeMethod = new Main();
        homeMethod.home();
                                  
    }
    
}
