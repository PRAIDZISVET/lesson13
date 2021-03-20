package by.itacademy.lesson13.model;

import jdk.nashorn.internal.codegen.CompilerConstants;
import lombok.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString (callSuper = true)
public class Manager extends Person {

    private static final Manager SINGLTON = new Manager("Singl","Singl",BigDecimal.ZERO);
    private static final long serialVersionUID = -6181303366932736943L;
    private BigDecimal salary;

    public Manager(String lastName, String firstName, BigDecimal salary) {
        super(lastName, firstName);
        this.salary = salary;
    }

    private void readObject (ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        this.salary = BigDecimal.valueOf(10_000);
        System.out.println();
    }


    private void writeObject (ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        System.out.println();
    }

    private Object readResolve() {
        return SINGLTON;
    }

}
