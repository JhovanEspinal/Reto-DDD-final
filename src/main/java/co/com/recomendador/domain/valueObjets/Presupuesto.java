package co.com.recomendador.domain.valueObjets;

import co.com.sofka.domain.generic.ValueObject;

public class Presupuesto implements ValueObject<Integer>{

    private final Integer value;

    public Presupuesto(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
