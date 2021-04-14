package co.com.recomendador.domain.entities;

import co.com.sofka.domain.generic.ValueObject;

public class Precio implements ValueObject<Integer> {
    private final Integer value;

    public Precio(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
