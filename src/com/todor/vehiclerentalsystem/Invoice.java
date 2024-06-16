package com.todor.vehiclerentalsystem;

public class Invoice {
  private RentalReturn rentalReturn;

  public Invoice(RentalReturn rentalReturn) {
    this.rentalReturn = rentalReturn;
    }
    
    public void printInvoice() {
      RentalReturnResult result = rentalReturn.calculateReturn();

      System.out.println("XXXXXXXXXX");
      System.out.println("Date: " + result.getActualReturnDate());
      System.out.println("Customer Name: " + result.getCustomerName());
      System.out.println("Rented Vehicle: " + result.getRentedVehicle());
      System.out.println();
      System.out.println("Reservation start date: " + result.getStartDate());
      System.out.println("Reservation end date: " + result.getEndDate());
      System.out.println("Reserved rental days: " + result.getReservedDays());
      System.out.println();
      System.out.println("Actual return date: " + result.getActualReturnDate());
      System.out.println("Actual rental days: " + result.getActualDays());
      System.out.println();
      System.out.println("Rental cost per day: $" + String.format("%.2f", result.getRentalCostPerDay()));
      
      // note: if there is insurance addition - it'll be the case motorcycle + customer under 25
      if (result.getInsuranceAddition() > 0) {
        System.out.println("Initial insurance per day: $" + String.format("%.2f", result.getInitialInsuranceCostPerDay()));
        System.out.println("Insurance addition per day: $" + String.format("%.2f", result.getInsuranceAddition()));
        System.out.println("Insurance per day: $" + String.format("%.2f", (result.getInitialInsuranceCostPerDay() + result.getInsuranceAddition())));
      // note: if there is insurance discount - it'll be the case car + high safety rating or cargo van + customer with more than 5 years of driving experience
      } else if (result.getInsuranceDiscount() > 0) {
        System.out.println("Initial insurance per day: $" + String.format("%.2f", result.getInitialInsuranceCostPerDay()));
        System.out.println("Insurance discount per day: $" + String.format("%.2f", result.getInsuranceDiscount()));
        System.out.println("Insurance per day: $" + String.format("%.2f", (result.getInitialInsuranceCostPerDay() - result.getInsuranceDiscount())));
      // note: all other cases will have base insurance cost
      } else {
        System.out.println("Insurance per day: $" + String.format("%.2f", result.getInitialInsuranceCostPerDay()));
      }


      System.out.println();
      // if there is early return - there will be discount for rent and insurance 
      if (result.getEarlyReturnRentDiscount() > 0) {
        System.out.println("Early return rent discount: $" + String.format("%.2f", result.getEarlyReturnRentDiscount()));
        System.out.println("Early return insurance discount: $" + String.format("%.2f", result.getEarlyReturnInsuranceDiscount()));
      }

      System.out.println();
      System.out.println("Total rent: $" + String.format("%.2f", result.getTotalRentCost()));
      System.out.println("Total insurance: $" + String.format("%.2f", result.getTotalInsuranceCost()));
      System.out.println("Total: $" + String.format("%.2f", (result.getTotalRentCost() + result.getTotalInsuranceCost())));
      System.out.println("XXXXXXXXXX");
  }
}
