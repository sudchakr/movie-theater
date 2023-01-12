package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TheaterTests {
	
	@Test
    void testAddAndRemoveShowing() {
		Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100); 
    	
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now(), showing3);
        theater.addShowing(LocalDate.now(), showing2);
        theater.addShowing(LocalDate.now(), showing1);
        theater.addShowing(LocalDate.now(), showing4);
        theater.addShowing(LocalDate.now(), showing5);
        theater.addShowing(LocalDate.now(), showing6);
        theater.addShowing(LocalDate.now(), showing8);
        theater.addShowing(LocalDate.now(), showing7);
        theater.addShowing(LocalDate.now(), showing9);
        
        assertEquals(9,theater.searchShowing().size());
                
        theater.removeShowing(showing7);        
        
        assertEquals(8,theater.searchShowing().size());        
	}
    
    @Test
    void testPrintMovieScheduleForCurrentDate() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100); 
    	
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now(), showing3);
        theater.addShowing(LocalDate.now(), showing2);
        theater.addShowing(LocalDate.now(), showing1);
        theater.addShowing(LocalDate.now(), showing4);
        theater.addShowing(LocalDate.now(), showing5);
        theater.addShowing(LocalDate.now(), showing6);
        theater.addShowing(LocalDate.now(), showing8);
        theater.addShowing(LocalDate.now(), showing7);
        theater.addShowing(LocalDate.now(), showing9);
        
        theater.printSchedule();
    }
    
    @Test
    void testPrintMovieScheduleForAnyDate() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(60),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now().plusDays(1), showing3);
        theater.addShowing(LocalDate.now().plusDays(1), showing2);
        theater.addShowing(LocalDate.now().plusDays(1), showing1);
        theater.addShowing(LocalDate.now().plusDays(1), showing4);
        theater.addShowing(LocalDate.now().plusDays(1), showing5);
        theater.addShowing(LocalDate.now().plusDays(1), showing6);
        theater.addShowing(LocalDate.now().plusDays(1), showing8);
        theater.addShowing(LocalDate.now().plusDays(1), showing7);
        theater.addShowing(LocalDate.now().plusDays(1), showing9);
        
    	theater.printSchedule(LocalDate.now().plusDays(1));
    }
    
    @Test
    void testPrintEmptyMovieSchedule() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);    	
        
    	theater.printSchedule();//No Showing was added for current date
    	theater.printSchedule(LocalDate.now().plusDays(1)); //No Showing was added for next date
    }
    
    @Test
    void testSearchAllShowingsForCurrentDate() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100); 
    	
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now(), showing3);
        theater.addShowing(LocalDate.now(), showing2);
        theater.addShowing(LocalDate.now(), showing1);
        theater.addShowing(LocalDate.now(), showing4);
        theater.addShowing(LocalDate.now(), showing5);
        theater.addShowing(LocalDate.now(), showing6);
        theater.addShowing(LocalDate.now(), showing8);
        theater.addShowing(LocalDate.now(), showing7);
        theater.addShowing(LocalDate.now(), showing9);
        
        assertEquals(9,theater.searchShowing().size());
    }
    
    @Test
    void testSearchShowingsForMovieName() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100); 
    	
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now(), showing3);
        theater.addShowing(LocalDate.now(), showing2);
        theater.addShowing(LocalDate.now(), showing1);
        theater.addShowing(LocalDate.now(), showing4);
        theater.addShowing(LocalDate.now(), showing5);
        theater.addShowing(LocalDate.now(), showing6);
        theater.addShowing(LocalDate.now(), showing8);
        theater.addShowing(LocalDate.now(), showing7);
        theater.addShowing(LocalDate.now(), showing9);
        
        assertEquals(3,theater.searchShowing(LocalDate.now(),"Turning Red").size());
    }
    
    @Test
    void testSearchShowingsForNullDateAndNullMovieName() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100); 
    	
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now(), showing3);
        theater.addShowing(LocalDate.now(), showing2);
        theater.addShowing(LocalDate.now(), showing1);
        theater.addShowing(LocalDate.now(), showing4);
        theater.addShowing(LocalDate.now(), showing5);
        theater.addShowing(LocalDate.now(), showing6);
        theater.addShowing(LocalDate.now(), showing8);
        theater.addShowing(LocalDate.now(), showing7);
        theater.addShowing(LocalDate.now(), showing9);
        
        assertEquals(9,theater.searchShowing(null,null).size());
    }
    
    @Test
    void testPrintJSONMovieScheduleForCurrentDate() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100); 
    	
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now(), showing3);
        theater.addShowing(LocalDate.now(), showing2);
        theater.addShowing(LocalDate.now(), showing1);
        theater.addShowing(LocalDate.now(), showing4);
        theater.addShowing(LocalDate.now(), showing5);
        theater.addShowing(LocalDate.now(), showing6);
        theater.addShowing(LocalDate.now(), showing8);
        theater.addShowing(LocalDate.now(), showing7);
        theater.addShowing(LocalDate.now(), showing9);
        
        theater.printJSONSchedule();
    }
    
    @Test
    void testPrintJSONMovieScheduleForAnyDate() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
    	Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(60),12.5, 1);
    	Movie turningRed = new Movie("2","Turning Red", Duration.ofMinutes(85), 11, 0);
    	Movie theBatMan = new Movie("3","The Batman",Duration.ofMinutes(95), 9, 0);	
    	
    	Showing showing1 = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(9,0)),theater);
    	Showing showing2 = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(11,0)),theater);
        Showing showing3 = new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(12,50)),theater);
        Showing showing4 = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(14,30)),theater);
        Showing showing5 = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(16,10)),theater);
        Showing showing6 = new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(17,50)),theater);
        Showing showing7 = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(19,30)),theater);
        Showing showing8 = new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(21,10)),theater);
        Showing showing9 = new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(23,0)),theater);
        
        theater.addShowing(LocalDate.now().plusDays(1), showing3);
        theater.addShowing(LocalDate.now().plusDays(1), showing2);
        theater.addShowing(LocalDate.now().plusDays(1), showing1);
        theater.addShowing(LocalDate.now().plusDays(1), showing4);
        theater.addShowing(LocalDate.now().plusDays(1), showing5);
        theater.addShowing(LocalDate.now().plusDays(1), showing6);
        theater.addShowing(LocalDate.now().plusDays(1), showing8);
        theater.addShowing(LocalDate.now().plusDays(1), showing7);
        theater.addShowing(LocalDate.now().plusDays(1), showing9);
        
    	theater.printJSONSchedule(LocalDate.now().plusDays(1));
    }
    
    @Test
    void testPrintJSONEmptyMovieSchedule() {
    	Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);    	
        
    	theater.printJSONSchedule();//No Showing was added for current date
    	theater.printJSONSchedule(LocalDate.now().plusDays(1)); //No Showing was added for next date
    }
}
