package co.com.recomendador.domain.valueObjets;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Debe ingresar el nombre");
        }
    }

    public static Nombre of(String nombre){
        return new Nombre(nombre);}

    public String value() {
        return value;
    }
}
