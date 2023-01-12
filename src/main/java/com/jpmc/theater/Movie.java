package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

public class Movie {
    private static final int MOVIE_CODE_SPECIAL = 1;

    private String id;
    private String title;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String id, String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.id = id;
    	this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getId() {
		return id;
	}
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
		this.title = title;
	}

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
		this.runningTime = runningTime;
	}	

    public double getTicketPrice() {
        return ticketPrice;
    }    
    
    public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}    

	public int getSpecialCode() {
		return specialCode;
	}

	public void setSpecialCode(int specialCode) {
		this.specialCode = specialCode;
	}	

	
	public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing);
    }

    private double getDiscount(Showing showing) {
    	List<Double> applicableDiscounts = new ArrayList<Double>();
    	
        if (MOVIE_CODE_SPECIAL == specialCode) {
        	applicableDiscounts.add(ticketPrice * 0.2);  // 20% discount for special movie
        }

        int showSequence = showing.getSequenceOfTheDay();
        if (showSequence == 1) {
        	applicableDiscounts.add(3.0); // $3 discount for 1st show
        } else if (showSequence == 2) {
        	applicableDiscounts.add(2.0); // $2 discount for 2nd show
        }
        
        LocalDateTime showTime = showing.getStartTime();
        int hour = showTime.getHour();
        int day = showTime.getDayOfMonth();
        
        if (hour>=11 && hour<=16) {
        	applicableDiscounts.add(ticketPrice * 0.25); //25% discount for show between 11 AM and 4 PM
        }
        
        if (day == 7) {
        	applicableDiscounts.add(1.0); //$1 discount for show on 7th of the month
        }

        // biggest discount wins
        return max(applicableDiscounts);
    }
    
    private double max(List<Double> discounts) {
    	
    	OptionalDouble opt = discounts.stream().mapToDouble(Double::doubleValue).max();
    	
    	if (opt.isPresent()) {
    		return opt.getAsDouble();
    	} else {
    		return 0.0;
    	}
    }

    @Override
    public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Movie movie = (Movie) o;
		
		return Objects.equals(id, movie.id) &&
		Double.compare(movie.ticketPrice, ticketPrice) == 0 &&
		Objects.equals(title, movie.title) && Objects.equals(runningTime, movie.runningTime) &&
		Objects.equals(specialCode, movie.specialCode);
		 
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, runningTime, ticketPrice, specialCode);    	
    }
}