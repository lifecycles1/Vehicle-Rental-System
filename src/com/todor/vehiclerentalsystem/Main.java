package com.todor.vehiclerentalsystem;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    // test inputs - car
    Customer customer = new Customer("John Doe", null, null);
    IVehicle car = new Car("Mitsubishi", "Mirage", 15000.00, 3);
    LocalDate startDate = LocalDate.of(2024, 6, 03);
    LocalDate endDate = LocalDate.of(2024, 6, 13);
    RentalAgreement rentalAgreement = new RentalAgreement(customer, car, startDate, endDate);
    RentalReturn rentalReturn = new RentalReturn(rentalAgreement, LocalDate.of(2024, 6, 13));
    Invoice invoice = new Invoice(rentalReturn);
    invoice.printInvoice();

    System.out.println();
    // test inputs - motorcycle
    customer = new Customer("Mary Johnson", 20, null);
    IVehicle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000.00, customer);
    startDate = LocalDate.of(2024, 6, 03);
    endDate = LocalDate.of(2024, 6, 13);
    rentalAgreement = new RentalAgreement(customer, motorcycle, startDate, endDate);
    rentalReturn = new RentalReturn(rentalAgreement, LocalDate.of(2024, 6, 13));
    invoice = new Invoice(rentalReturn);
    invoice.printInvoice();

    System.out.println();
    // test inputs - cargo van
    customer = new Customer("John Markson", null, 8);
    IVehicle cargoVan = new CargoVan("Citroen", "Jumper", 20000.00, customer);
    startDate = LocalDate.of(2024, 6, 03);
    endDate = LocalDate.of(2024, 6, 18);
    rentalAgreement = new RentalAgreement(customer, cargoVan, startDate, endDate);
    rentalReturn = new RentalReturn(rentalAgreement, LocalDate.of(2024, 6, 13));
    invoice = new Invoice(rentalReturn);
    invoice.printInvoice();
  }
}
