import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void setup(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "OA815", Airport.SYD, Airport.LAX, "12:45");
        passenger1 = new Passenger("Jack", 2);
        passenger2 = new Passenger("Kate", 0);
        passenger3 = new Passenger("Hurley", 1);
    }

    @Test
    public void flightStartsWithNoPassengers(){
        assertEquals(0, flight.numberOfPassengers());
    }

    @Test
    public void flightHasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void flightHasFlightNumber() {
        assertEquals("OA815", flight.getFlightNumber());
    }

    @Test
    public void flightHasDepartureAirport(){
        assertEquals(Airport.SYD, flight.getDeparture());
    }

    @Test
    public void flightHasDestination(){
        assertEquals(Airport.LAX, flight.getDestination());
    }

    @Test
    public void flightHasDepartureTime(){
        assertEquals("12:45", flight.getDepartureTime());
    }

    @Test
    public void flightCanAddPassengers(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.numberOfPassengers());
    }

    @Test
    public void flightCanGetNumberOfAvailableSeatsWhenEmpty(){
        assertEquals(450, flight.numberOfAvailableSeats());
    }

    @Test
    public void flightCanGetNumberOfAvailableSeatsWhenNotEmpty(){
        flight.addPassenger(passenger1);
        assertEquals(449, flight.numberOfAvailableSeats());
    }

    @Test
    public void flightCannotAddPassengerWithoutCapacity(){
        Plane tinyPlane = new Plane(PlaneType.ICONA5);
        Flight flight = new Flight(tinyPlane, "AD001", Airport.GLA, Airport.EDI, "10:00");
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(2, flight.numberOfPassengers());
        assertEquals(0, flight.numberOfAvailableSeats());
    }

}
