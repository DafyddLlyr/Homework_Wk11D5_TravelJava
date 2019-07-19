import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PassengerTest {

    private Passenger passenger;
    private Flight flight;
    private Date departureTime;
    private Plane plane;

    @Before
    public void setup() {
        passenger = new Passenger("Bob", 2);
        departureTime = new Date(2004, 9, 22, 8, 55);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "OA815", Airport.SYD, Airport.LAX, departureTime);
    }

    @Test
    public void passengerHasName() {
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void passengerHasNumberOfBags() {
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void passengerHasNoFlightInitially() {
        assertNull(passenger.getFlight());
    }

    @Test
    public void passengerHasFlightPropertyWhenAddedToFlight() {
        flight.addPassenger(passenger);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void passengerDoesNotHaveFlightNumberWithoutFlight(){
        assertNull(passenger.getSeatNumber());
    }

    @Test
    public void passengerCanBeAssingedSeatThroughSetter(){
        passenger.setSeatNumber(13);
        assertEquals(13, passenger.getSeatNumber(), 0.00);
    }

    @Test
    public void passengerHasSeatNumberWhenAssignedFlight(){
        flight.addPassenger(passenger);
        Integer passengerSeatNumber = passenger.getSeatNumber();
        assertFalse(flight.getRemainingSeatNumbers().contains(passengerSeatNumber));
    }

}
