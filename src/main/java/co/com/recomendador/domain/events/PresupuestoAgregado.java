package co.com.recomendador.domain.events;

import co.com.recomendador.domain.valueObjets.Presupuesto;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.sofka.domain.generic.DomainEvent;

public class PresupuestoAgregado extends DomainEvent {
    private final RecomendadorId recomendadorId;
    private final Presupuesto presupuesto;

    public PresupuestoAgregado(RecomendadorId recoId,Presupuesto presupuesto) {
        super("recomendador.PresupuestoAgregado");
        this.recomendadorId = recoId;
        this.presupuesto = presupuesto;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }
}
