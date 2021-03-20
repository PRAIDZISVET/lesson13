package by.itacademy.lesson13;

import by.itacademy.lesson13.model.Manager;
import by.itacademy.lesson13.model.Person;
import by.itacademy.lesson13.util.SerialisationUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerialisationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("resources", "test.b");
        Person person = new Manager("Ivan", "Ivanov", BigDecimal.TEN);

        SerialisationUtil.serializeObject(path, person);

        Person object = SerialisationUtil.deserializeObject(path);
        System.out.println(object);
    }
}

