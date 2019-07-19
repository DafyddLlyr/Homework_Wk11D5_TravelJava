import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport departure;
    private Airport destination;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, Airport departure, Airport destination, String departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
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

    public String getDepartureTime() {
        return this.departureTime;
    }

    public int numberOfPassengers() {
        return this.passengers.size();
    }

    public int numberOfAvailableSeats() {
        return this.plane.getCapacity() - this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if(this.numberOfAvailableSeats() > 0) {
            this.passengers.add(passenger);
        }
    }
}
