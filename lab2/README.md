***Structural Design Patterns***
**Author: Durbailo Daniel FAF-222**
# Modular Shopping Cart System

## Introduction  
Design patterns are essential in modern software development as they offer reusable solutions to common challenges, making code more flexible and easier to maintain.  
This project demonstrates the use of **Structural** and **Creational Design Patterns**—including **Facade**, **Adapter**, **Decorator**, **Factory**, and **Builder**—in the development of a modular shopping cart system. These patterns were implemented to create a scalable and efficient solution for managing products, processing orders, and handling dynamic pricing adjustments.

---

## Design Patterns Used  

### Structural Design Patterns:
- **Facade Pattern**: Simplifies the interaction between complex subsystems in the shopping cart system.
- **Adapter Pattern**: Integrates incompatible interfaces to ensure seamless communication between components.
- **Decorator Pattern**: Dynamically adds or modifies the functionality of objects, such as applying discounts or promotions.

### Creational Design Patterns:
- **Factory Pattern**: Handles object creation for different product types in a consistent manner.
- **Builder Pattern**: Constructs complex objects step by step, such as building customized orders.

---

## Folder Structure  

```plaintext
lab2/
├── adapters
│   ├── external_product_adapter.py  # Implements Adapter Pattern for external product systems.
├── client
│   ├── shopping_facade.py           # Implements Facade Pattern for simplified subsystem interaction.
├── decorators
│   ├── discount_decorator.py        # Implements Decorator Pattern for dynamic pricing adjustments.
├── domain
│   ├── product.py                   # Core product models for the shopping cart system.
├── factories
│   ├── product_builder.py           # Implements Builder Pattern for constructing complex products.
│   ├── product_factory.py           # Implements Factory Pattern for managing product creation.
├── models
│   # Additional data models, if any.
├── main.py                          # Entry point for running or demonstrating the system.
├── README.md                        # Project documentation (this file).

**Implementation & Explanation**
*Creational Patterns: Builder and Factory*
*Factory Pattern*
The Factory Pattern centralizes object creation, 
simplifying code maintenance. In this implementation, 
it creates product instances.
*Code Snippet*
```python
class ProductFactory:
    @staticmethod
    def create_product(name, price, description=''):
        return Product(name, price, description)
```
*Main Idea & Motivation*
By encapsulating product creation logic, the factory promotes loose coupling, 
ensuring easier maintenance and extension when adding new product types.
*Builder Pattern*
The Builder Pattern constructs complex objects step-by-step,
 useful when objects have many optional attributes.
*Code Snippet:*
```python
class ProductBuilder:
    def __init__(self, name, price):
        self.product = Product(name, price)
    def set_description(self, description):
        self.product.description = description
        return self
    def build(self):
        return self.product
```
*Main Idea & Motivation:* 
The builder provides a flexible way to create products with various optional details,
 preventing complex constructor calls and ensuring required fields are set.
**Structural Patterns: Facade, Adapter, Decorator**
*Facade Pattern*
The Facade Pattern simplifies interactions by providing 
a high-level interface for managing the shopping cart.
*Code Snippet:*
```python
class ShoppingFacade:
    def __init__(self):
        self.cart = ShoppingCart()
    def add_product(self, name, price, description=''):
        product = ProductFactory.create_product(name, price, description)
        self.cart.add_product(product)
    def view_cart(self):
        self.cart.display_products()
```
*Main Idea & Motivation:*
The facade hides the complexity of cart operations, 
offering a streamlined interface for users to interact with the system without dealing with its internal workings.
*Adapter Pattern*
The Adapter Pattern integrates external systems by converting incompatible interfaces.
*Code Snippet:*
```python
class ExternalProductAdapter:
    def __init__(self, external_data):
        self.external_data = external_data
    def to_product(self):
        return Product(
            name=self.external_data['title'],
            price=self.external_data['cost'],
            description=self.external_data.get('info', 'No description')
        )
```
*Main Idea & Motivation:* 
This adapter bridges the gap between external data formats and the internal Product class,
 allowing seamless integration of third-party data without altering existing code.
*Decorator Pattern*
The Decorator Pattern dynamically adds behavior, such as discounts,
 to products without modifying their core structure.
*Code Snippet:*
```python
class DiscountedProductDecorator(ProductDecorator):
    def __init__(self, product, discount):
        super().__init__(product)
        self.discount = discount
    @property
    def price(self):
        return self._product.price * (1 - self.discount)
```
*Main Idea and Motivation:* 
The decorator enables dynamic pricing adjustments (like discounts)
 without altering the core Product class, enhancing code flexibility and extensibility.
**Results/Conclusions**
*Results*
The implementation of design patterns resulted in a modular, flexible shopping cart system. Each pattern contributed to specific benefits:
Factory: Simplified object creation.
Builder: Flexible product construction.
Facade: Streamlined client interaction.
Adapter: Seamless integration of external data.
Decorator: Dynamic behavior extension.
*Conclusions*
This laboratory work demonstrated how design patterns enhance software design by improving maintainability, 
flexibility, and scalability. The combination of creational and structural patterns in the shopping
 cart system created a robust architecture, allowing new features to be added with minimal impact on existing code.