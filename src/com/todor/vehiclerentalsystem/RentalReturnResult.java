package com.todor.vehiclerentalsystem;

import java.time.LocalDate;

public class RentalReturnResult {
  private LocalDate actualReturnDate;
  private String customerName;
  private String rentedVehicle;
  private LocalDate startDate;
  private LocalDate endDate;
  private long reservedDays;
  private long actualDays;
  private double rentalCostPerDay;
  private double initialInsuranceCostPerDay;
  private double insuranceAddition;
  private double insuranceDiscount;
  private double earlyReturnRentDiscount;
  private double earlyReturnInsuranceDiscount;
  private double totalRentCost;
  private double totalInsuranceCost;

  public RentalReturnResult(LocalDate actualReturnDate, String customerName, String rentedVehicle, LocalDate startDate, LocalDate endDate, long reservedDays, long actualDays, double rentalCostPerDay, double initialInsuranceCostPerDay, double insuranceAddition, double insuranceDiscount, double earlyReturnRentDiscount, double earlyReturnInsuranceDiscount, double totalRentCost, double totalInsuranceCost) {
    this.actualReturnDate = actualReturnDate;
    this.customerName = customerName;
    this.rentedVehicle = rentedVehicle;
    this.startDate = startDate;
    this.endDate = endDate;
    this.reservedDays = reservedDays;
    this.actualDays = actualDays;
    this.rentalCostPerDay = rentalCostPerDay;
    this.initialInsuranceCostPerDay = initialInsuranceCostPerDay;
    this.insuranceAddition = insuranceAddition;
    this.insuranceDiscount = insuranceDiscount;
    this.earlyReturnRentDiscount = earlyReturnRentDiscount;
    this.earlyReturnInsuranceDiscount = earlyReturnInsuranceDiscount;
    this.totalRentCost = totalRentCost;
    this.totalInsuranceCost = totalInsuranceCost;
  }

  public LocalDate getActualReturnDate() {
    return actualReturnDate;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getRentedVehicle() {
    return rentedVehicle;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public long getReservedDays() {
    return reservedDays;
  }

  public long getActualDays() {
    return actualDays;
  }

  public double getRentalCostPerDay() {
    return rentalCostPerDay;
  }

  public double getInitialInsuranceCostPerDay() {
    return initialInsuranceCostPerDay;
  }

  public double getInsuranceAddition() {
    return insuranceAddition;
  }

  public double getInsuranceDiscount() {
    return insuranceDiscount;
  }

  public double getEarlyReturnRentDiscount() {
    return earlyReturnRentDiscount;
  }

  public double getEarlyReturnInsuranceDiscount() {
    return earlyReturnInsuranceDiscount;
  }

  public double getTotalRentCost() {
    return totalRentCost;
  }

  public double getTotalInsuranceCost() {
    return totalInsuranceCost;
  }
}