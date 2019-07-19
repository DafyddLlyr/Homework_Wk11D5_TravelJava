public class Flight {

    private Plane plane;
    private String flightNumber;
    private Airport departure;
    private Airport destination;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, Airport departure, Airport destination, String departureTime) {
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
}
