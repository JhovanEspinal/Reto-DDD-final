package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class RecomendadorCreado extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final Map<MotoId,Moto> motos;
    public RecomendadorCreado(RecomendadorId entityId, Map<MotoId, Moto> motos) {
        super("recomendador.RecomendadorCreado");
        this.recomendadorId = entityId;
        this.motos = motos;

    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Map<MotoId, Moto> getMotos() {
        return motos;
    }
}
