package com.todor.vehiclerentalsystem;

public abstract class Vehicle implements IVehicle {
  protected String brand;
  protected String model;
  protected double value;

  public Vehicle(String brand, String model, double value) {
    this.brand = brand;
    this.model = model;
    this.value = value;
  }

  @Override
  public String getBrand() {
    return brand;
  }

  @Override
  public String getModel() {
    return model;
  }

  @Override
  public double getValue() {
    return value;
  }

  @Override
  public abstract double getRentalCostPerDay(int rentalPeriod);

  @Override
  public abstract double getInsuranceCostPerDay();
}