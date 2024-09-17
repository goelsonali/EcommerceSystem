# Simple shopping cart system for an e-commerce website. 

## The cart should allow users to:

* Add items to the cart.
* Remove items from the cart.
* View all items in the cart.
* Calculate the total price of items in the cart.

## Each item in the cart has the following attributes:

* Item Name (String)
* Quantity (int)
* Price per unit (double)

## Requirements:
- Implement the shopping cart system in both ArrayList and LinkedList.
- Compare the time complexity for adding, removing, and retrieving items.
- After adding or removing items, the system should display all items in the cart along with the total price.

### Detailed Tasks:
- Add Items:

Create a method addItem(String itemName, int quantity, double pricePerUnit) that adds an item to the cart.
If the item already exists, increase the quantity instead of adding a new entry.

- Remove Items:

Create a method removeItem(String itemName) that removes an item from the cart.
If the item doesn't exist, output an appropriate message.

- View Cart:

Create a method viewCart() that displays all items in the cart, showing:
1. Item Name
2. Quantity
3. Price per unit
3. Total price of each item (quantity * price per unit)
4. Show the total price of all items in the cart.

- Calculate Total Price:

Create a method calculateTotal() that sums the total price of all items in the cart and returns the value.
### Constraints:
- Assume you have a maximum of 1,000 items.
- Perform add, remove, and view operations for 1000 iterations to compare performance between ArrayList and LinkedList.