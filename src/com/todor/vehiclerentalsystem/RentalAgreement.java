package com.todor.vehiclerentalsystem;

import java.time.LocalDate;

public class RentalAgreement {
  Customer customer;
  IVehicle vehicle;
  private LocalDate startDate;
  private LocalDate endDate;

  public RentalAgreement(Customer customer, IVehicle vehicle, LocalDate startDate, LocalDate endDate) {
    this.customer = customer;
    this.vehicle = vehicle;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public IVehicle getVehicle() {
    return vehicle;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }
}