public enum PlaneType {

    BOEING747(350000, 450);

    private final int weight;
    private final int capacity;

    PlaneType(int weight, int capacity) {
        this.weight = weight;
        this.capacity = capacity;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
