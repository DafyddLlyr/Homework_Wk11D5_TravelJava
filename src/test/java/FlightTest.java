import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Date departureTime1;
    Date departureTime2;

    @Before
    public void setup(){
        departureTime1 = new Date(2004, 9, 22, 8, 55);
        departureTime2 = new Date(2019, 1, 15, 23, 15);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "OA815", Airport.SYD, Airport.LAX, departureTime1);
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
        assertEquals(departureTime1, flight.getDepartureTime());
    }

    @Test
    public void flightHasListOfAllSeatNumbers() {
        assertEquals(450, flight.getRemainingSeatNumbers().size());
    }

    @Test
    public void flightCanAddPassengers(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.numberOfPassengers());
    }

    @Test
    public void flightCanReturnAllPassengers(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(3, flight.getPassengers().size());
        assertTrue(flight.getPassengers().containsAll(Arrays.asList(passenger1, passenger2, passenger3)));
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
        Flight flight = new Flight(tinyPlane, "AD001", Airport.GLA, Airport.EDI, departureTime2);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(2, flight.numberOfPassengers());
        assertEquals(0, flight.numberOfAvailableSeats());
    }

    @Test
    public void seatNumberRemovedFromRemainingSeatNumbers(){
        flight.addPassenger(passenger1);
        Integer passengerSeatNumber = passenger1.getSeatNumber();
        assertFalse(flight.getRemainingSeatNumbers().contains(passengerSeatNumber));
        assertEquals(449, flight.getRemainingSeatNumbers().size());
    }

}
