public class FlightManager {


    public static double passengerBaggageAllocation(Flight flight) {
        int planeWeight = flight.getPlane().getWeight();
        int planeCapacity = flight.getPlane().getCapacity();
        return (planeWeight / 2.00) / planeCapacity;
    }

    public static double weightOfBaggage(Flight flight) {
        double totalWeight = 0.00;
        double bagWeight = passengerBaggageAllocation(flight);
        for(Passenger passenger: flight.getPassengers()) {
            totalWeight += (passenger.getBags() * bagWeight);
        }
        return totalWeight;
    }

    public static double availableBaggageWeight(Flight flight) {
        double baggageCapacity = flight.getPlane().getWeight() / 2;
        double checkedInBaggage = weightOfBaggage(flight);
        return baggageCapacity - checkedInBaggage;
    }
}
