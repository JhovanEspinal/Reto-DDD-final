package co.com.recomendador.domain.entities;

import co.com.sofka.domain.generic.ValueObject;

public class Cilindraje implements ValueObject<Integer> {

    private final Integer value;

    public Cilindraje(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
