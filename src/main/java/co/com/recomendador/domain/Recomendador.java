package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.Sede;
import co.com.sofka.domain.generic.AggregateEvent;

public class Recomendador extends AggregateEvent<RecomendadorId> {

    protected Sede sede;
    protected Vendedor vendedor;
    protected Cliente cliente;


    public Recomendador(RecomendadorId entityId) {
        super(entityId);
    }
}
