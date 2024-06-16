package com.todor.vehiclerentalsystem;

public class Customer {
  private String name;
  private Integer age;
  private Integer drivingExperience;

  public Customer(String name, Integer age, Integer drivingExperience) {
    this.name = name;
    this.age = age;
    this.drivingExperience = drivingExperience;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Integer getDrivingExperience() {
    return drivingExperience;
  }
}
