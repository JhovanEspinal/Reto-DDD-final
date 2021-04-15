package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.sofka.domain.generic.ValueObject;

public class Precio implements ValueObject<Integer> {
    private final Integer value;

    public Precio(Integer value) {
        this.value = value;
    }

    public static Precio of(Integer precio){
        return new Precio(precio);}

    public Integer value() {
        return value;
    }
}
