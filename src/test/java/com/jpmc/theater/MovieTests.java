package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void testSpecialMovieDiscount() {
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }
    
    @Test
    void testFirstShowingDiscount() {
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }
    
    @Test
    void testSecondShowingDiscount() {
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }
    
    @Test
    void testSpecialMovieBiggerDiscount() { //Special Movie has a bigger discount than Sequence Discount
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }
    
    @Test
    void testSequenceBiggerDiscount() { //Sequence discount is more than Special Movie Discount
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }
    
    @Test
    void testShowTimeDiscount() {
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),10.0, 0);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing1 = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2023,01,01), LocalTime.of(11,0)),theater); //11 AM
        
        assertEquals(7.5, spiderMan.calculateTicketPrice(showing1));
        
        Showing showing2 = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2023,01,01), LocalTime.of(14,0)),theater); //2 PM
        
        assertEquals(7.5, spiderMan.calculateTicketPrice(showing2));
        
        Showing showing3 = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2023,01,01), LocalTime.of(16,0)),theater); //4 PM
        
        assertEquals(7.5, spiderMan.calculateTicketPrice(showing3));
    }
    
    @Test
    void testDateDiscount() {
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),10.0, 0);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2023,01,07), LocalTime.of(17,0)),theater); //7th of the month
        
        assertEquals(9.0, spiderMan.calculateTicketPrice(showing));        
        
    }
    
    @Test
    void testBiggestDiscount() { //Biggest of all possible discounts
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),10.0, 1);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2023,01,07), LocalTime.of(14,0)),theater);
        
        assertEquals(7.0, spiderMan.calculateTicketPrice(showing));        
        
    }
    
    @Test
    void testNoDiscount() { //No Discount applicable
        Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),10.0, 0);
        
        Theater theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2023,01,01), LocalTime.of(17,0)),theater);
        
        assertEquals(10.0, spiderMan.calculateTicketPrice(showing));        
        
    }
}
