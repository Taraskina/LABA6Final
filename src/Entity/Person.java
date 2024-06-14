package Entity;

/**
 * Objects of this class are stored in a collection
 */


public class Person {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double height; //Значение поля должно быть больше 0
    private java.time.LocalDate birthday; //Поле может быть null
    private Integer weight; //Поле может быть null, Значение поля должно быть больше 0
    private Color hairColor; //Поле не может быть null
    private Location location; //Поле может быть null
    static long countId = 0;


    public Person(String name, Coordinates coordinates, Double height, java.time.LocalDate birthday, Integer weight, Color haircolor, Location location){
        this.id = countId + 1;
        countId = this.id;
        this.name = name;
        this.coordinates = coordinates;
        this.height = height;
        this.birthday = birthday;
        this.hairColor = haircolor;
        this.weight = weight;
        this.location = location;
        this.creationDate = java.time.LocalDateTime.now();
        System.out.println(creationDate);
    }
    public long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getHeight(){
        return this.height;
    }
    public Integer getWeight(){
        return this.weight;
    }
    public Color getHairColor(){
        return this.hairColor;
    }
    public void setId(long id){
        this.id = id;
    }

}


