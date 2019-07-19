import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void setup(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "OA815", Airport.SYD, Airport.LAX, "12:45");
        passenger1 = new Passenger("Jack", 2);
        passenger2 = new Passenger("Kate", 0);
        passenger3 = new Passenger("Hurley", 1);
    }

    @Test
    public void canCalculateBaggagePerPassenger(){
        assertEquals(388.89, FlightManager.passengerBaggageAllocation(flight), 0.01);
    }

    @Test
    public void canCalculateBaggageWeightForOnePassengerWithOneBag() {
        flight.addPassenger(passenger3);
        assertEquals(388.89, FlightManager.weightOfBaggage(flight), 0.01);
    }

    @Test
    public void canCalculateBaggageWeightForOnePassengerWithNoBags() {
        flight.addPassenger(passenger2);
        assertEquals(0, FlightManager.weightOfBaggage(flight), 0.01);
    }

    @Test
    public void canCalculateBaggageWeightForOnePassengerWithMultipleBags() {
        flight.addPassenger(passenger1);
        assertEquals(777.78, FlightManager.weightOfBaggage(flight), 0.01);
    }

    @Test
    public void canCalculateBaggageWeightForManyPassengerWithMultipleBags() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(1166.67, FlightManager.weightOfBaggage(flight), 0.01);
    }

}
