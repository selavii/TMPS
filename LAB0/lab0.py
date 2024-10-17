from abc import ABC, abstractmethod
import json

# Vehicle class following SRP
class Vehicle:
    def __init__(self, make, model, price):
        self.make = make
        self.model = model
        self.price = price

    def get_make(self):
        return self.make

    def get_model(self):
        return self.model

    def get_price(self):
        return self.price

# Printer interface for OCP
class Printer(ABC):
    @abstractmethod
    def print_vehicle(self, vehicle):
        pass

# Concrete implementation for text printing
class TextVehiclePrinter(Printer):
    def print_vehicle(self, vehicle):
        print(f"Vehicle: {vehicle.get_make()} {vehicle.get_model()}, Price: {vehicle.get_price()} USD")

# Concrete implementation for JSON printing
class JsonVehiclePrinter(Printer):
    def print_vehicle(self, vehicle):
        vehicle_data = {
            "make": vehicle.get_make(),
            "model": vehicle.get_model(),
            "price": vehicle.get_price()
        }
        print(json.dumps(vehicle_data, indent=4))

# Main execution
if __name__ == "__main__":
    # Create a vehicle
    car = Vehicle("Tesla", "Model S", 85000)

    # Print vehicle details using text format
    text_printer = TextVehiclePrinter()
    text_printer.print_vehicle(car)

    # Print vehicle details using JSON format
    json_printer = JsonVehiclePrinter()
    json_printer.print_vehicle(car)
