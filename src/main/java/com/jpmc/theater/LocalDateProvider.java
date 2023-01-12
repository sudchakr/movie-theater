package com.jpmc.theater;

import java.time.LocalDate;

public class LocalDateProvider {
    private static LocalDateProvider instance = null;
    
    private LocalDateProvider() {    	
    	//Prevent instantiation via Reflection
    	if (instance != null) {
    		throw new RuntimeException("Use singleton() method to get a single instance of this class");
    	}
    }

    /**
     * @return make sure to return singleton instance
     */
    public static LocalDateProvider singleton() {
        if (instance == null) {
        	synchronized(LocalDateProvider.class) { //Handle concurrency
        		if (instance == null) {
        			instance = new LocalDateProvider();
        		}
        	}
        }
        return instance;
    }
    
        
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public LocalDate currentDate() {
            return LocalDate.now();
    }
}
