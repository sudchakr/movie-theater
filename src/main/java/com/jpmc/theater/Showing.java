package com.jpmc.theater;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;
    private Theater theater;
    private volatile int availableTickets;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime, Theater theater) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
        this.theater = theater;
        this.availableTickets = theater.getNumOfSeats();
    }

    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
		this.movie = movie;
	}

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }
    
    public void setSequenceOfTheDay(int sequenceOfTheDay) {
		this.sequenceOfTheDay = sequenceOfTheDay;
	}

    public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}	

	public double calculateFee(int audienceCount) {
        return movie.calculateTicketPrice(this) * audienceCount;
    }
	
	public synchronized Optional<Reservation> reserve(Customer customer, int howManyTickets) {
		if (howManyTickets>0 && availableTickets>=howManyTickets) {
			Reservation reservation = new Reservation(customer,this,howManyTickets,LocalDateTime.now());
			availableTickets -= howManyTickets;
			return Optional.of(reservation);
		} else {
			System.out.println("Tickets not available!");
			return Optional.empty();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(movie, sequenceOfTheDay, showStartTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Showing other = (Showing) obj;
		return Objects.equals(movie, other.movie) && sequenceOfTheDay == other.sequenceOfTheDay
				&& Objects.equals(showStartTime, other.showStartTime);
	}
    
    
}
