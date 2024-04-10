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

        System.out.println("Please select which menu you would like to view \n1. Items listed for sale\n2. Add item to Cart\n3. Go back to Home");
        int selection = scan.nextInt();
        scan.nextLine();
        switch (selection) {
            case 1:
                viewBuyList();
                break;
            case 2:
                addItemToCart();
                break;
            case 3:
                home();
                break;
            default:
                System.out.println("Invalid Input, try again");
                sell();
        }
    }

    public void viewBuyList(){
        System.out.println("Displayed below is the list of items ups for sale: ");
        if (shopList.isEmpty()){
            System.out.println("There are currently no items up for sale. Please wait for a new sale.");
            sell();
        } else {
            for (int i = 0; i < shopList.size(); i++) {
                System.out.println((i + 1) + ". Name: " + shopList.get(i).getItemName() + ", Category: " + shopList.get(i).getCategory() + ", Listed Price: $" + String.format("%.2f", shopList.get(i).getPrice() ));
            }

            System.out.println("Returning you to previous menu");
            sell();
        }
    }

    public void addItemToCart(){
        int buyIndex;
        System.out.println("Would you like to buy an item? Please type yes or no");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Which item would you like to buy?");
            buyIndex = scan.nextInt();
            if(buyIndex >= shopList.size() || buyIndex < 0){
                System.out.println("Which item would you like to buy?");
                buyIndex = scan.nextInt();
            }
            else if(-1 < buyIndex && buyIndex < shopList.size()){
                cart.add(shopList.remove(buyIndex));
            }
            
        } 
        else if (answer.equalsIgnoreCase("no")){
            System.out.println("Understood, now sending you to the previous menu");
            buy();
        } else {
            System.out.println("Invalid input, try again");
            addItemToCart();
        }

    }

    public void sell(){
        System.out.println("Please select which menu you would like to view \n1. Items listed for sale\n2. Add new item to Sell\n3. Go back to Home");
        int selection = scan.nextInt();
        scan.nextLine();
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
            for (int i = 0; i < sellList.size(); i++) {
                System.out.println((i + 1) + ". Name: " + sellList.get(i).getItemName() + ", Category: " + sellList.get(i).getCategory() + ", Listed Price: $" + String.format("%.2f", sellList.get(i).getPrice() ));
            }

            System.out.println("Returning you to previous menu");
            sell();
        }
    }

    public void addSell() {
        System.out.println("Would you like to list an item to sell? Please type yes or no");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Please enter item name");
            String itemName = scan.nextLine();

            System.out.println("Please enter the category for " + itemName);
            String category = scan.nextLine();

            System.out.println("Please enter listing price for " + itemName);
            double price = 0;
            if (!scan.hasNextDouble()){ //so the program doesn't crash if a double isn't inputted
                scan.nextLine();
                System.out.println("Invalid Input, entry must be restarted");
                addSell();
            } else {
                price = scan.nextDouble();
                scan.nextLine();
            }

            System.out.println("Please enter your first and last name");
            String name = scan.nextLine();

            System.out.println("Please enter your QU email");
            String email = scan.nextLine();

            sellList.add(new Item(itemName, category, name, email, price));

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
