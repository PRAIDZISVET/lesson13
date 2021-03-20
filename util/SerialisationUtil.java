package by.itacademy.lesson13.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SerialisationUtil {

    public static void serializeObject(Path path, Object object) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            outputStream.writeObject(object);
        }
    }

    public static <T> T deserializeObject(Path path) throws IOException, ClassNotFoundException {
        T result = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path.toFile())))) {
            result = (T) objectInputStream.readObject();
        }

        return result;
    }
}
