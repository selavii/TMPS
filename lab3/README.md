***Behavioral Design Patterns - Command Pattern***

**Author:   Durbailo Daniel FAF-222**


*Introduction/Theory*

Behavioral design patterns define communication patterns between software entities, allowing systems to be more flexible and maintainable. This report explores the Command Pattern as applied to a shopping cart system. The Command Pattern encapsulates requests as objects, enabling the decoupling of the sender and receiver of a request.

In this case, the pattern is implemented to handle cart operations, such as adding/removing products, clearing the cart, and maintaining a history of actions.



# Project Structure

This project follows the structure outlined below, which organizes the code into logical modules for better maintainability and scalability.

lab3/ │ ├── domain/ │ └── main.py │ └── README.md


### **Explanation of the Project Structure:**

- **lab3/**: This is the main folder containing all the project files and directories.
- **domain/**: This folder contains the core business logic of the project. It includes the `main.py` file where the main operations and functionalities are defined.
- **README.md**: This file contains all the information about the project, such as instructions, design patterns used, and explanations of the code structure.

---

## How to Run the Project

1. Clone the repository or download the project files.
2. Open the project folder in your terminal or IDE.
3. Run the `main.py` file to see the functionality in action.

```bash
python main.py



**Implementation & Explanation**

*Command Pattern*


The Command Pattern transforms a request (e.g., adding a product) into an object that can be executed,
 undone, and tracked. This is useful when you need to decouple the request sender from the request receiver, 
 and it allows for keeping track of the commands that have been executed.

*Code Snippet*

```python
from .command_interface import Command

class AddProductCommand(Command):
    def __init__(self, cart, product_name, price):
        self.cart = cart
        self.product_name = product_name
        self.price = price

    def execute(self):
        self.cart.add_product(self.product_name, self.price)
        print(f"Added {self.product_name} (${self.price}) to the cart.")
```

*Main Idea & Motivation*
The AddProductCommand encapsulates the action of adding a product to the shopping cart.
 By using this pattern, we can execute the command without directly coupling the invoker 
 (the code that initiates the action) with the specific functionality inside the shopping cart.
 This promotes flexibility, as additional actions (such as product removal or cart clearing)
 can be added without modifying existing logic.

*CartInvoker Class*

The CartInvoker is responsible for invoking commands and storing them in a history list.
 This enables undo functionality and command tracking.

*Code Snippet:*

```python
class CartInvoker:
    def __init__(self):
        self.history = []

    def execute_command(self, command):
        command.execute()
        self.history.append(command)
```

*ClearCartCommand* 

Another command we implemented is the ClearCartCommand, which clears the cart's contents.


*Code Snippet:*

```python
from .command_interface import Command

class ClearCartCommand(Command):
    def __init__(self, cart):
        self.cart = cart

    def execute(self):
        self.cart.clear_cart()
        print("Cleared all products from the cart.")

```



*RemoveProductCommand*

The RemoveProductCommand removes a product from the cart. 
It uses the product name to identify the product to remove.

*Code Snippet:*

```python
from .command_interface import Command

class RemoveProductCommand(Command):
    def __init__(self, cart, product_name):
        self.cart = cart
        self.product_name = product_name

    def execute(self):
        self.cart.remove_product(self.product_name)
        print(f"Removed {self.product_name} from the cart.")
```


**Results/Conclusions**
*Results*


The implementation of the Command Pattern resulted in a highly flexible shopping cart system. The key benefits include:

Decoupling of sender and receiver: The invoker (client code) does not need to know about the details of the cart operations.
Command History: We can track the history of commands executed, making it possible to add features like undo functionality.
Scalability: New cart operations can be added easily by introducing new command classes without altering existing code.

*Conclusions*
This laboratory work demonstrated how the Command Pattern can be applied to improve software design by enhancing flexibility,
 scalability, and maintainability. The use of behavioral design patterns in this context allowed us to cleanly 
 separate concerns and make the shopping cart system more robust, while enabling features like command history
  and potential undo capabilities. The Command Pattern's integration into this project allows for smoother handling 
  of cart operations, making the code easier to extend and maintain.