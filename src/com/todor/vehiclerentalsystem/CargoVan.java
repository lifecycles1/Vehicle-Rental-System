package com.todor.vehiclerentalsystem;

public class CargoVan extends Vehicle {
  private Customer customer;

  public CargoVan(String brand, String model, double value, Customer customer) {
    super(brand, model, value);
    this.customer = customer;
  }

  @Override
  public double getRentalCostPerDay(int rentalPeriod) {
    return rentalPeriod <= 7 ? 50.00 : 40.00;
  }

  @Override
  public double getInsuranceCostPerDay() {
    double baseInsuranceCost = value  * 0.0003; // 0.03% of the cargo van's value
    if (customer.getDrivingExperience() != null && customer.getDrivingExperience() > 5) {
      return baseInsuranceCost * 0.85; // 15% discount for customers with more than 5 years of driving experience
    } else {
      return baseInsuranceCost;
    }
  }
}
