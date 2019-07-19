import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void setup(){
        passenger = new Passenger("Bob", 2);
    }

    @Test
    public void passengerHasName(){
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void passengerHasNumberOfBags(){
        assertEquals(2, passenger.getBags());
    }

}
