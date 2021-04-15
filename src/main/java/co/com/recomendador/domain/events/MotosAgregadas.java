package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashMap;
import java.util.Map;

public class MotosAgregadas extends DomainEvent {

    private final Map<MotoId,Moto> motos ;

    public MotosAgregadas(Map<MotoId, Moto> motos) {
        super("recomendador.MotosAgregadas");
        this.motos = motos;
    }

    public Map<MotoId, Moto> getMotos() {
        return motos;
    }


}
