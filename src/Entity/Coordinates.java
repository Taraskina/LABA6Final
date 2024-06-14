package Entity;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Long y; //Значение поля должно быть больше -867, Поле не может быть null

    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }
}
