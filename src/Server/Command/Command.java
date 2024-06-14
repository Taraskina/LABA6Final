package Server.Command;

import Entity.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

import static Client.Main.client;

/**
 * The command class is the ancestor for all commands
 */
public abstract class Command {
    //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    protected String elementName; //Поле не может быть null, Строка не может быть пустой
    protected Entity.Coordinates elementCoordinates; //Поле не может быть null
    protected java.time.LocalDateTime elementcreationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    protected double elementHeight; //Значение поля должно быть больше 0
    protected java.time.LocalDate elementBirthday; //Поле может быть null
    protected Integer elementWeight; //Поле может быть null, Значение поля должно быть больше 0
    protected Entity.Color elementHairColor; //Поле не может быть null
    protected Entity.Location elementLocation;
    protected ArrayList<Entity.Person> spisok;
    protected BufferedReader readercommand = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<String> scripts = new ArrayList<>();
    public static ArrayList<String> listHistory = new ArrayList<>();



    public void execute(String id) throws IOException {
    }

    protected Entity.Person checkElement() throws IOException {
        while (true) {
            client.printLine("Введите имя:");
            this.elementName = client.readLine();
            if ((elementName.isEmpty()) || (elementName.equals(" "))) {
                client.printLine("Невернный ввод");
            } else {
                break;
            }
        }
        this.elementcreationDate = java.time.LocalDateTime.now();
        while (true) {
            client.printLine("Введите рост:");
            String red = client.readLine();
            try {
                this.elementHeight = Double.parseDouble(red);
                if (elementHeight > 0) {
                    break;
                } else {
                    client.printLine("Error");
                }
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение double!");
            }

        }
        while (true) {
            client.printLine("Введите вес:");
            String red = client.readLine();
            try {
                this.elementWeight = Integer.parseInt(red);
                if (elementWeight > 0) {
                    break;
                } else {
                    client.printLine("Error");
                }
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение long!");
            }
        }
        Long elementCX;
        Long elementCY;
        while (true) {
            client.printLine("Введите координату х:");
            String red = client.readLine();
            try {
                elementCX = Long.parseLong(red);
                break;
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение long!");
            }

        }
        while (true) {
            client.printLine("Введите координату у:");
            String red = client.readLine();
            try {
                elementCY = Long.parseLong(red);
                if (elementCY > (-867)) {
                    break;
                } else {
                    client.printLine("Error");
                }
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение long!");
            }

        }
        this.elementCoordinates = new Entity.Coordinates(elementCX, elementCY);

        long elementX;
        Long elementY;
        float elementZ;
        while (true) {
            client.printLine("Введите локацию по х:");
            String red = client.readLine();
            try {
                elementX = Long.parseLong(red);
                break;
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение long!");
            }
        }
        while (true) {
            client.printLine("Введите локацию по у:");
            String red = client.readLine();
            try {
                elementY = Long.parseLong(red);
                break;
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение long!");
            }
        }
        while (true) {
            client.printLine("Введите локацию по z:");
            String red = client.readLine();
            try {
                elementZ = Float.parseFloat(red);
                break;
            } catch (NumberFormatException e) {
                client.printLine("Надо ввести значение float!");
            }
        }
        this.elementLocation = new Location(elementX, elementY, elementZ);

        while (true) {
            int flag = 0;
            client.printLine("Введите цвет волос: (GREEN, RED, BLUE, YELLOW)");
            String red = client.readLine().toUpperCase();
            for (Entity.Color e : Entity.Color.values()) {
                if (e.name().equals(red)) {
                    elementHairColor = e;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            } else {
                client.printLine("Невернный ввод");
            }
        }
        while (true) {
            client.printLine("Введите дату рождения: (year-month-day)");
            String red = client.readLine();
            try {
                String[] date = red.split("-");
                if (date.length == 3) {
                    this.elementBirthday = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                    break;
                } else {
                    client.printLine("Error");
                }
            } catch (Exception e) {
                client.printLine("Вы ввели неправильную дату");
            }
        }
        Entity.Person person = new Entity.Person(this.elementName, this.elementCoordinates, this.elementHeight, this.elementBirthday, this.elementWeight, this.elementHairColor, this.elementLocation);
        return person;
    }
}