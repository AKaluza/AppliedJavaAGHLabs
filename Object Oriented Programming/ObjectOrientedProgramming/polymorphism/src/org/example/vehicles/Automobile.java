package org.example.vehicles;

import org.example.behavior.Descriptable;
import org.example.behavior.Traceable;
import org.example.domain.Description;
import org.example.domain.Identifier;

import java.util.Objects;

public abstract class Automobile implements Descriptable, Traceable {
    private final Description description;
    private static int globalVIN = 100;

    protected Automobile(String name) {
        description = new Description(name, new Identifier(globalVIN));
        ++globalVIN;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Identifier getVin() {
        return description.vin();
    }



    @Override
    public int hashCode() {
        return Objects.hashCode(getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Automobile automobile) {
            return Objects.equals(getDescription(), automobile.getDescription());
        } else {
            return false;
        }
    }
}
