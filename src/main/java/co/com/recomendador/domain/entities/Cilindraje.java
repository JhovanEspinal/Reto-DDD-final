package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.sofka.domain.generic.ValueObject;

public class Cilindraje implements ValueObject<Integer> {

    private final Integer value;

    public Cilindraje(Integer value) {
        this.value = value;
    }

    public static Cilindraje of(Integer cilindraje ){
        return new Cilindraje(cilindraje);}

    public Integer value() {
        return value;
    }
}
