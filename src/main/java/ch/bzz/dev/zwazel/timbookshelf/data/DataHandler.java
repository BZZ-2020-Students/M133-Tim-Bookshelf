package ch.bzz.dev.zwazel.timbookshelf.data;

import ch.bzz.dev.zwazel.timbookshelf.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


@Getter
@Setter
public class DataHandler<T> {
    @NonNull
    private final Class<T> tClass;

    public DataHandler(Class<T> tClass) {
        this.tClass = tClass;
    }

    public ArrayList<T> getArrayFromJson(String propertyName) throws IOException {
        String path = Config.getProperty(propertyName);
        byte[] jsonData = Files.readAllBytes(
                Paths.get(path)
        );
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonData, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
    }

    public <Key> T getSingleFromJsonArray(String propertyName, String keyName, Key key) throws IOException, NoSuchFieldException, IllegalAccessException {
        ArrayList<T> arrayList = getArrayFromJson(propertyName);

        for (T t : arrayList) {
            Field privateField = t.getClass().getDeclaredField(keyName);
            privateField.setAccessible(true);
            if (privateField.get(t).equals(key)) {
                return t;
            }
        }

        return null;
    }
}
