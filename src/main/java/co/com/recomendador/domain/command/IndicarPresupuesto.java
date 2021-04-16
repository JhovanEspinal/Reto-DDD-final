package co.com.recomendador.domain.command;

import co.com.recomendador.domain.valueObjets.Presupuesto;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.sofka.domain.generic.Command;

public class IndicarPresupuesto implements Command {

    private final RecomendadorId recomendadorId;
    private final Presupuesto presupuesto;

    public IndicarPresupuesto(RecomendadorId recomendadorId, Presupuesto presupuesto) {
        this.recomendadorId = recomendadorId;
        this.presupuesto = presupuesto;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }
}
