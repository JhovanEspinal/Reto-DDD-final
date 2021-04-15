package co.com.recomendador.domain;

import co.com.recomendador.domain.valueObjets.Cilindraje;
import co.com.recomendador.domain.valueObjets.Presupuesto;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class CilindrajeAgregado extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final Cilindraje cilindraje;

    public CilindrajeAgregado(RecomendadorId recoId, Cilindraje cilindraje) {
        super("recomendador.CilindrajeAgregado");
        this.recomendadorId = recoId;
        this.cilindraje = cilindraje;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }
}
