## Hello, the approach I took follows the 5 SOLID principles and ensures a good, scalable starting point to apply design patterns in case of a larger project

- All classes follow the Single Responsibility Principle.
- "Vehicle" can be extended by adding new vehicle types without modifying existing code, adhering to Open/Closed Principle.
- "Car", "Motorcycle", and "CargoVan" can be used wherever "Vehicle" is expected, aligning with Liskov Substitution Principle.
- The current setup doesn't force any unused methods on clients, aligning with Interface Segregation Principle.
- I introduced IVehicle so that the Vehicle module depends on abstractions, aligning with the Dependency Inversion Principle.

P.S.

- only 3 example inputs have been generated in Main class according to business case.
- In case of testing with more examples - assumptions have been made that the automated system will have valid- and within range inputs (e.g, 0 < Car safetyRating <= 5). Customer fields which are not required for insurance re-evaluation calculations in certain vehicles can be left as null during object creation.

- IVehicle interface can be redundant since we already have an abstract class Vehicle where all methods are abstract methods.

- RentalReturnResult is a POJO class that acts as an intermediary to transfer results from RentalReturn class to Invoice class.

Run the application from the Main class.
