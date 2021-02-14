package com.cognizant.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String productName;
	private String customerReview;
	private int HardDiskSize; 
	private int ramSize; 
	private double cpuSpeed; 
	private String operatingSystem; 
	private double weight; 
	private String cpu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCustomerReview() {
		return customerReview;
	}
	public void setCustomerReview(String customerReview) {
		this.customerReview = customerReview;
	}
	public int getHardDiskSize() {
		return HardDiskSize;
	}
	public void setHardDiskSize(int hardDiskSize) {
		HardDiskSize = hardDiskSize;
	}
	public int getRamSize() {
		return ramSize;
	}
	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}
	public double getCpuSpeed() {
		return cpuSpeed;
	}
	public void setCpuSpeed(double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", customerReview=" + customerReview
				+ ", HardDiskSize=" + HardDiskSize + ", ramSize=" + ramSize + ", cpuSpeed=" + cpuSpeed
				+ ", operatingSystem=" + operatingSystem + ", weight=" + weight + ", cpu=" + cpu + "]";
	}

	
	
}
