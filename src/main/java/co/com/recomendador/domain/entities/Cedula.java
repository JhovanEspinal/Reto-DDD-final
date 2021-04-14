package co.com.recomendador.domain.entities;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject<String> {

    private final String value;

    public Cedula(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){

            throw new IllegalArgumentException("debe ingresar una cedula");
        }
    }

    public String value() {
        return value;
    }
}
