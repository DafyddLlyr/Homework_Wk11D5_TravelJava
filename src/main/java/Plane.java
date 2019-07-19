public class Plane {

    private int weight;
    private int capacity;

    public Plane(PlaneType planeType) {
        this.weight = planeType.getWeight();
        this.capacity = planeType.getCapacity();
    }

    public int getWeight() {
        return this.weight;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
