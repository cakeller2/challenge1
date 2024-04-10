## challenge1

# Authors
 Camryn Keller
 Joseph Noga
 Akshaj Illa

This code is a proof of concept of a possible item selling service. 

# Login
When the application is started, the user will be prompted to enter a valid username and then password. At this time, the username and password is hard coded in and can be seen in the code. 
The possible usernames are:
 "student1", "student2", "student3"

The possible passwords are
 "testing1", "testing2", "testing3"

The username and password must have corresponding numbers or it will not work. If the user makes a mistake 3 times, the application will exit. 

# Home

After a successful login, the user will be taken to the home menu. There they will be prompted to choose between buy, sell, view cart, and logout

# Buy

In this menu, the user will be prompted to pick between viewing items for sale, adding an item to cart, or going back to the home menu. If an invalid answer is entered, but system will reject it and ask the user again

If viewing items for sale is selected and the list of items for sale is empty, then the system will inform the user and go back to the previous menu. If the list of items is not empty, the list will be displayed and then the user will be moved back to the previous menu

If adding an item to cart is selected, there is a check for whether the user entered this menu by accident. The system then waits for a valid input. After that, the user enters the number for the item they want to add to their cart.

# Sell

In this menu, the user is prompted to pick between viewing the items that they have listed, add an item to be sold, or to return home. If an invalid answer is entered, but system will reject it and ask the user again

If the user has no items listed for sale, then the system will inform the user and return to the previous menu. If the list of items is not empty, the list will be displayed and then the user will be moved back to the previous menu.

If adding an item to be sold is selected, there is a check for whether the user entered this menu by accident. The system then waits for a valid input. After that, the user has to enter the information for the item they are listing. This includes item name, item category, item price, user's name, and user's email. When the item is added, a success message will be displayed.

# View Cart

In this menu, the user is shown the items in their cart. If the cart is empty, it informs the user and then asks them if they want to head to checkout or to go back to the home menu. If the user tries to head to checkout with an empty cart, they will be brought back to cart display to remind them that their cart is empty

If the cart is not empty when the user selects checkout, then the user is prompted to confirm purchase. After the purchase, the user will be brought back to the home menu. If the user does not confirm purchase, they will be brought back to cart display.

# Logout

In the home menu, the user has the choice of logging out. If the user decided to do this, there will be a nice message and the application will exit.