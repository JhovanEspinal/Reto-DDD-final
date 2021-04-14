package co.com.recomendador.domain.valueObjets;

import co.com.sofka.domain.generic.ValueObject;

public class Sede implements ValueObject<String> {

    private  final String value;

    public Sede(String sede) {
        this.value = sede;
    }

    public String value(){
        return value;
    }
}
