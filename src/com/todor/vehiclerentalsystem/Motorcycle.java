package com.todor.vehiclerentalsystem;

public class Motorcycle extends Vehicle {
  private Customer customer;

  public Motorcycle(String brand, String model, double value, Customer customer) {
    super(brand, model, value);
    this.customer = customer;
  }

  @Override
  public double getRentalCostPerDay(int rentalPeriod) {
    return rentalPeriod <= 7 ? 15.00 : 10.00;
  }

  @Override
  public double getInsuranceCostPerDay() {
    double baseInsuranceCost = value * 0.0002; // 0.02% of the motorcycle's value
    if (customer.getAge() != null && customer.getAge() < 25) {
      return baseInsuranceCost * 1.2; // 20% increase for customers under 25
    } else {
      return baseInsuranceCost;
    }
  }
}
