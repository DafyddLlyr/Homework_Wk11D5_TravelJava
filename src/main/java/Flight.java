import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport departure;
    private Airport destination;
    private Date departureTime;
    private ArrayList<Integer> remainingSeatNumbers;

    public Flight(Plane plane, String flightNumber, Airport departure, Airport destination, Date departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.remainingSeatNumbers = new ArrayList<Integer>();
        createSeats();
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public Airport getDeparture() {
        return this.departure;
    }

    public Airport getDestination() {
        return this.destination;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public int numberOfPassengers() {
        return this.passengers.size();
    }

    public void createSeats() {
        for(Integer i = 0; i < this.plane.getCapacity(); i++) {
            this.remainingSeatNumbers.add(i);
        }
    }

    public ArrayList<Integer> getRemainingSeatNumbers() {
        return this.remainingSeatNumbers;
    }

    public int numberOfAvailableSeats() {
        return this.plane.getCapacity() - this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if(this.numberOfAvailableSeats() > 0) {
            Random rand = new Random();
            Integer randomSeat = this.remainingSeatNumbers.get(rand.nextInt(this.remainingSeatNumbers.size()));

            passenger.setSeatNumber(randomSeat);
            passenger.setFlight(this);

            this.passengers.add(passenger);
            this.remainingSeatNumbers.remove(randomSeat);
        }
    }

}
