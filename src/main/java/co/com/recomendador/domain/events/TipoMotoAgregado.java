package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoMotoAgregado extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final TipoMoto tipoMoto;

    public TipoMotoAgregado(RecomendadorId recoId, TipoMoto tipoM) {
        super("recomendador.TipoMotoAgregado");
        this.recomendadorId = recoId;
        this.tipoMoto = tipoM;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
}
