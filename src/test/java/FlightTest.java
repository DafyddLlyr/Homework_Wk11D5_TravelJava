import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;

    @Before
    public void setup(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "OA815", Airport.SYD, Airport.LAX, "12:45");
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
}
