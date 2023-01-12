package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void testTotalFee() {
        var customer = new Customer("John Doe", "unused-id");
        
        var spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        
        var theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        var showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        assertTrue(new Reservation(customer, showing, 3, LocalDateTime.now()).totalFee() == 37.5);
    }
    
    @Test
    void testDifferentCustomerWithSameName() {
        var customer1 = new Customer("John Doe", "id1");
        var customer2 = new Customer("John Doe", "id2");
        
        var spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        
        var theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",100);
        
        var showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
        
        var reserveTime = LocalDateTime.now();
        
        assertFalse(new Reservation(customer1, showing, 3, reserveTime).equals(new Reservation(customer2, showing, 3, reserveTime)));
        
    }
}
