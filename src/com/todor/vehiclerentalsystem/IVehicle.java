package com.todor.vehiclerentalsystem;

// interface might be redundant, Vehicle is already an abstract class and all methods are abstract
public interface IVehicle {
  String getBrand();
  String getModel();
  double getValue();
  double getRentalCostPerDay(int rentalPeriod);
  double getInsuranceCostPerDay();
}