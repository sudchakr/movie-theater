package com.jpmc.theater;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;
    private LocalDateTime reserveTime;

    public Reservation(Customer customer, Showing showing, int audienceCount, LocalDateTime reserveTime) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        this.reserveTime = reserveTime;
    }    
    

    public Customer getCustomer() {
		return customer;
	}


	public Showing getShowing() {
		return showing;
	}


	public int getAudienceCount() {
		return audienceCount;
	}


	public LocalDateTime getReserveTime() {
		return reserveTime;
	}


	public double totalFee() {
        return showing.calculateFee(audienceCount);
    }


	@Override
	public int hashCode() {
		return Objects.hash(audienceCount, customer, reserveTime, showing);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return audienceCount == other.audienceCount && Objects.equals(customer, other.customer)
				&& Objects.equals(reserveTime, other.reserveTime) && Objects.equals(showing, other.showing);
	}
	
	
}