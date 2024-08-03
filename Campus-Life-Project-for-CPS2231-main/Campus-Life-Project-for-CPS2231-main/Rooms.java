public class Rooms {
    private String floor;
    private int number;

    public Rooms(String floor, int number){
        this.floor = floor.toUpperCase();
        this.number = number;
    }

    @Override
    public String toString() {
        return floor + number;
    }
}
