package com.jpmc.theater;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelReservationUnavailableSeatTest { //Reservation methods will be invoked concurrently from TestSuite, not enough seats for all the reservations
	private Theater theater;
	private Showing showing;
	private List<Customer> reserveList;
	
	@BeforeClass
	public void setup() {
		theater = new Theater("Test Theater","1 Main Street","Pleasantville","NJ",50);
		Movie spiderMan = new Movie("1","Spider-Man: No Way Home", Duration.ofMinutes(61),12.5, 1);
		showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()),theater);
		reserveList = new ArrayList<Customer>();
	}
	
	@AfterClass
	public void validate() {
		assertEquals(reserveList.size(),2); //2 out of 3 customers will be able to reserve
		assertEquals(showing.getAvailableTickets(),10); //2 customers will reserve 40 seats, 10 will be remaining
	}
	
	@Test
	public void testReserve1() {
		System.out.println("The thread ID for testReserve1 is "+ Thread.currentThread().getId());
		Customer customer = new Customer("John Doe", "1");
		Optional<Reservation> reservation = showing.reserve(customer, 20);
		reservation.ifPresent(r -> reserveList.add(r.getCustomer()));
	}
	
	@Test
	public void testReserve2() {
		System.out.println("The thread ID for testReserve2 is "+ Thread.currentThread().getId());
		Customer customer = new Customer("John Smith", "2");
		Optional<Reservation> reservation = showing.reserve(customer, 20);
		reservation.ifPresent(r -> reserveList.add(r.getCustomer()));
	}
	
	@Test
	public void testReserve3() {
		System.out.println("The thread ID for testReserve3 is "+ Thread.currentThread().getId());
		Customer customer = new Customer("Peter Parker", "3");
		Optional<Reservation> reservation = showing.reserve(customer, 20);
		reservation.ifPresent(r -> reserveList.add(r.getCustomer()));
	}

}
