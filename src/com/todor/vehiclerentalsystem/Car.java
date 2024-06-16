package com.todor.vehiclerentalsystem;

public class Car extends Vehicle {
  private int safetyRating;

  public Car(String brand, String model, double value, int safetyRating) {
    super(brand, model, value);
    setSafetyRating(safetyRating);
  }

  // set safety rating between 1 and 5
  public void setSafetyRating(int safetyRating) {
    if (safetyRating >= 1 && safetyRating <= 5) {
      this.safetyRating = safetyRating;
    } else {
      System.out.println("Safety rating must be between 1 and 5");
      // throw new IllegalArgumentException("Safety rating must be between 1 and 5");
    }
  }

  // check if car has high safety rating
  public boolean hasHighSafetyRating() {
    return safetyRating >= 4;
  }

  @Override
  public double getRentalCostPerDay(int rentalPeriod) {
    return rentalPeriod <= 7 ? 20.00 : 15.00;
  }

  @Override
  public double getInsuranceCostPerDay() {
    double baseInsuranceCost = value * 0.0001; // 0.01% of the car's value
    return hasHighSafetyRating() ? baseInsuranceCost * 0.9 : baseInsuranceCost; // 10% discount for high safety rating
  }
}