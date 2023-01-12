package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class Theater {

    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private int numOfSeats;
	private LocalDateProvider localDateProvider;
    private Map<LocalDate,List<Showing>> schedule;	
    
    public Theater(String name, String streetAddress, String city, String state, int numOfSeats) {
    	this.name = name;
    	this.streetAddress = streetAddress;
    	this.city = city;
    	this.state = state;
    	this.numOfSeats = numOfSeats;
    	this.localDateProvider = LocalDateProvider.singleton();
    	this.schedule = new HashMap<LocalDate,List<Showing>>();
    }    
    
    
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}



	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getNumOfSeats() {
		return numOfSeats;
	}



	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	

	public LocalDateProvider getLocalDateProvider() {
		return localDateProvider;
	}


	public void addShowing(LocalDate date, Showing showing) {
    	schedule.computeIfAbsent(date, list -> new ArrayList<Showing>()).add(showing);
    }
    
	public void removeShowing(Showing showing){
		if (showing == null) {
			System.out.println("Class: Theater, Method: removeShowing, Error: showing is null");
			return;
		}
		
    	List<Showing> sList = schedule.get(showing.getShowStartTime().toLocalDate());
    	Iterator<Showing> itr = sList.iterator();
    	while (itr.hasNext()) {
    		if (itr.next().equals(showing)) {
    			itr.remove();
    			break;
    		}
    	}
    }	
	
	public List<Showing> searchShowing() {
		return searchShowing(localDateProvider.currentDate(),"");
	}

	public List<Showing> searchShowing(LocalDate date, String movieName) {    	
    	if (date == null) { //Default to current date
    		date = localDateProvider.currentDate();
    	}
    	
    	List<Showing> sList = schedule.getOrDefault(date,new ArrayList<Showing>());
    	
    	if (movieName == null || movieName.isBlank()) { //Return all showings for the date
    		sList.sort((s1,s2) -> Integer.compare(s1.getSequenceOfTheDay(), s2.getSequenceOfTheDay())); //Sort by ascending sequence
    		return sList;
    	} else {  //Filter by movie name  	
	    	List<Showing> result = sList.stream().filter(s -> s.getMovie().getTitle().equals(movieName)).collect(Collectors.toList());
	    	result.sort((s1,s2) -> Integer.compare(s1.getSequenceOfTheDay(), s2.getSequenceOfTheDay())); //Sort by ascending sequence
	    	return result;
    	}
    }
	
    public void printSchedule() {
    	printSchedule(localDateProvider.currentDate());        
    }
    
    public void printSchedule(LocalDate date) {
    	
        System.out.println(date);
        
        System.out.println("===================================================");
        
        List<Showing> sList = schedule.getOrDefault(date,new ArrayList<Showing>());
        
        sList.sort((s1,s2) -> Integer.compare(s1.getSequenceOfTheDay(), s2.getSequenceOfTheDay())); //Sort by ascending sequence
        sList.forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + formatTime(s.getStartTime()) + " " + s.getMovie().getTitle() + " " + humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee())
        );
        
        
        System.out.println("===================================================");
    }
    
    public void printJSONSchedule() {
    	printJSONSchedule(localDateProvider.currentDate());        
    }
    
    public void printJSONSchedule(LocalDate date) {
    	JSONArray jArr = new JSONArray();
        jArr.put(date.toString());
        
        List<Showing> sList = schedule.getOrDefault(date,new ArrayList<Showing>());
        sList.sort((s1,s2) -> Integer.compare(s1.getSequenceOfTheDay(), s2.getSequenceOfTheDay())); //Sort by ascending sequence
        
        sList.forEach(s -> {
        	JSONObject jObj = new JSONObject();
        	jObj.put("sequence", s.getSequenceOfTheDay());
        	jObj.put("startTime", formatTime(s.getStartTime()));
        	jObj.put("title", s.getMovie().getTitle());
        	jObj.put("runningTime", humanReadableFormat(s.getMovie().getRunningTime()));
        	jObj.put("ticketPrice", "$" + s.getMovieFee());
        	
        	jArr.put(jObj);
        });
        
        System.out.println(jArr.toString(4));
    }
    

    private String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value <= 1) {
            return "";
        }
        else {
            return "s";
        }
    }
    
    private String formatTime(LocalDateTime localDateTime) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    	return formatter.format(localDateTime);
    }

	
	/*
	 * public static void main(String[] args) { Theater theater = new
	 * Theater(LocalDateProvider.singleton()); theater.printSchedule(); }
	 */
	 
}
