package DATA;

import Collection.SetTestHash;
import Entity.Person;
import Server.LocalDateAdapter;
import Server.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static Client.Main.client;
import static Client.Main.server;

public class DataManager {

    /**
     * Saving a collection to a file
     */
    public static void Save(SetTestHash<Person> collection) {

        try {
            File file = new File("C:\\Users\\datar\\IdeaProjects\\Laba5ForMaksimFinal\\CollectionData.json");
            FileOutputStream outputStream = new FileOutputStream(file);
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                    new LocalDateTimeAdapter()).registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            String json = gson.toJson(collection);
            outputStream.write(json.getBytes());
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            client.printLine("Нет доступа к файлу");
        }

    }

    /**
     * Load a collection from file
     *
     * @return collection where we store Person objects
     */
    public static SetTestHash<Person> Load() {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                    new LocalDateTimeAdapter()).registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            File file = new File("C:\\Users\\datar\\IdeaProjects\\Laba5ForMaksimFinal\\CollectionData.json");
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
            Type setType = new TypeToken<SetTestHash<Person>>(){}.getType();
            Scanner sc = new Scanner(file);
            String s = sc.nextLine();
            SetTestHash<Person> persons = gson.fromJson(s, setType);
            inputStream.close();
            if (persons.isEmpty()) {
                client.printLine("Успешно загружено!");
            }
            return persons;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            client.printLine("Ошибка!");
            return new SetTestHash<>();
        }
    }

    /**
     * Load a script from file
     *
     * @param fileName the name of the file from which the script should be loaded
     * @return collection where we store script
     */
    public static ArrayList<String> LoadScript(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                list.add(line);

            }
        } catch (FileNotFoundException e) {
            client.printLine("К файлу нету доступа или он отсутствует!");
        }
        return list;
    }

}
