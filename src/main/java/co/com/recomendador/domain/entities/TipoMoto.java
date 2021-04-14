package co.com.recomendador.domain.entities;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoMoto implements ValueObject<String>{

    private final String value;

    public TipoMoto(String value) {
        this.value = Objects.requireNonNull(value);
        if (value.isBlank()){

            throw new IllegalArgumentException("Debe ingresar el tipo de moto");
        }
    }

    public String value() {
        return value;
    }
}
