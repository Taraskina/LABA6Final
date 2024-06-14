package Entity;

public class Location {
    private long x;
    private Long y; //Поле не может быть null
    private float z;

    public Location(long x, Long y, float z) {
        this.x = x;
        this.y = y;
    }
}
