package com.todor.vehiclerentalsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalReturn {
  private RentalAgreement rentalAgreement;
  private LocalDate actualReturnDate;

  public RentalReturn(RentalAgreement rentalAgreement, LocalDate actualReturnDate) {
    this.rentalAgreement = rentalAgreement;
    this.actualReturnDate = actualReturnDate;
  }

  public double getRentalCostPerDay() {
    return rentalAgreement.getVehicle().getRentalCostPerDay((int) ChronoUnit.DAYS.between(rentalAgreement.getStartDate(), rentalAgreement.getEndDate()));
  }

  public double getInsuranceCostPerDay() {
    return rentalAgreement.getVehicle().getInsuranceCostPerDay();
  }

  public RentalReturnResult calculateReturn() {
    Customer customer = rentalAgreement.getCustomer();
    IVehicle vehicle = rentalAgreement.getVehicle();
    LocalDate startDate = rentalAgreement.getStartDate();
    LocalDate endDate = rentalAgreement.getEndDate();
    // LocalDate actualReturnDate = LocalDate.now(); // changed to accept actual return date as parameter for easier testing

    long reservedDays = ChronoUnit.DAYS.between(startDate, endDate);
    long actualDays = ChronoUnit.DAYS.between(startDate, actualReturnDate);
    double rentalCostPerDay = getRentalCostPerDay();
    double insuranceCostPerDay = getInsuranceCostPerDay();

    // check what vehicle type against customer specifications determine insurance increase/discounts
    // and calculate initial insurance cost per day
    double initialInsuranceCostPerDay = 0;
    double insuranceAddition = 0;
    double insuranceDiscount = 0;
    if (vehicle instanceof Car) {
      // cast to Car to access the hasHighSafetyRating method (not available in IVehicle interface)
      if (((Car)vehicle).hasHighSafetyRating()) {
        // get initial insurance cost per day
        initialInsuranceCostPerDay = vehicle.getValue() * 0.0001;
        // assign the 10% discount for high safety rating to insuranceDiscount
        insuranceDiscount = initialInsuranceCostPerDay * 0.1;
      } else {
        // get initial insurance cost per day
        initialInsuranceCostPerDay = vehicle.getValue() * 0.0001;
      }
    } else if (vehicle instanceof Motorcycle) {
      if (customer.getAge() < 25) {
        // get initial insurance cost per day
        initialInsuranceCostPerDay = vehicle.getValue() * 0.0002;
        // assign the 20% increase for customers under 25 to insuranceAddition
        insuranceAddition = initialInsuranceCostPerDay * 0.2;
      } else {
        // get initial insurance cost per day
        initialInsuranceCostPerDay = vehicle.getValue() * 0.0002;
      }
    } else if (vehicle instanceof CargoVan) {
      if (customer.getDrivingExperience() > 5) {
        // get initial insurance cost per day
        initialInsuranceCostPerDay = vehicle.getValue() * 0.0003;
        // assign the 15% discount for customers with more than 5 years of driving experience to insuranceDiscount
        insuranceDiscount = initialInsuranceCostPerDay * 0.15;
      } else {
        // get initial insurance cost per day
        initialInsuranceCostPerDay = vehicle.getValue() * 0.0003;
      }
    }

    // check if the vehicle is returned ahead of schedule to calculate discounts on rental and insurance
    double earlyReturnRentDiscount = 0;
    double earlyReturnInsuranceDiscount = 0;
    if (actualDays < reservedDays) {
      earlyReturnRentDiscount = (reservedDays - actualDays) * (rentalCostPerDay / 2);
      earlyReturnInsuranceDiscount = (reservedDays - actualDays) * insuranceCostPerDay; // insuranceCostPerDay is already calculated against customer or car specifications in Vehicle subclasses
    }

    // calculate total rent, total insurance, and total
    double totalRentCost = rentalCostPerDay * actualDays + earlyReturnRentDiscount;
    double totalInsuranceCost = insuranceCostPerDay * actualDays;

    // changed return type to RentalReturnResult POJO class from List<Object>
    // return Arrays.asList(actualReturnDate, customer.getName(), vehicle.getBrand(), vehicle.getModel(), startDate, endDate, reservedDays, actualDays, rentalCostPerDay, initialInsuranceCostPerDay, insuranceAddition, insuranceDiscount, earlyReturnRentDiscount, earlyReturnInsuranceDiscount, totalRentCost, totalInsuranceCost);
    return new RentalReturnResult(actualReturnDate, customer.getName(), vehicle.getBrand() + " " + vehicle.getModel(), startDate, endDate, reservedDays, actualDays, rentalCostPerDay, initialInsuranceCostPerDay, insuranceAddition, insuranceDiscount, earlyReturnRentDiscount, earlyReturnInsuranceDiscount, totalRentCost, totalInsuranceCost);
  }
}
