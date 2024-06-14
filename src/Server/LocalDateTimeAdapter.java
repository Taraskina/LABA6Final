package Server;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The class adapts LocalDateTime type fields to save to a file
 */
public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(formatter.format(value));
        }
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        if (in != null) {
            return LocalDateTime.parse(in.nextString(), formatter);
        }
        return null;
    }
}