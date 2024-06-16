# Hello, the approach I took follows the 5 SOLID principles and ensures a good, scalable starting point to apply design patterns in case of a larger project

- All classes follow the Single Responsibility Principle.
- "Vehicle" can be extended by adding new vehicle types without modifying existing code, adhering to Open/Closed Principle.
- "Car", "Motorcycle", and "CargoVan" can be used wherever "Vehicle" is expected, aligning with Liskov Substitution Principle.
- The current setup doesn't force any unused methods on clients, aligning with Interface Segregation Principle.
- I introduced IVehicle so that the Vehicle module depends on abstractions, aligning with the Dependency Inversion Principle.

Of course, there are many ways to implement this Vehicle Rental System. I have added a Customer class although it can be done without it.

It can go without the interface IVehicle since we have an abstract class Vehicle with only abstract methods that the subclasses inherit from.

And finally, the RentalReturnResult is a POJO that can be skipped if we use some other data structure to pass the calculations RentalReturn class to Invoice class.

Run the application from the Main class.
