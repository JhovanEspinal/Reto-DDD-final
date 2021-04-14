package co.com.recomendador.domain.entities;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Debe ingregar un telefono");
        }
    }

    public String value(){
        return value;
    }
}
