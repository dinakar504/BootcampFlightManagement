package com.capg.bs.dto;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Flight 
{
    @Id
    @Column(name="flight_no")
    String flightNo;
    @Column(name="carrier_name")
    String carrierName;
    @Column(name="seat_capacity")
    int seatCapacity;
    /*@Column(name="weight")
    double weightAllowed;
    @Column(name="flight_rows")
    int rows;
    @Column(name="flight_cols")
    int columns; */
    public Flight() { }
	public Flight(String flightNo, String carrierName, int seatCapacity) 
	{
		this.flightNo = flightNo;		this.carrierName = carrierName;	 this.seatCapacity = seatCapacity;	//this.weightAllowed = weightAllowed;
		//this.rows = rows;		//this.columns = columns;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	/*public double getWeightAllowed() {
		return weightAllowed;
	}
	public void setWeightAllowed(double weightAllowed) {
		this.weightAllowed = weightAllowed;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	} */
}
