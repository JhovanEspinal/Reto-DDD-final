package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.Sede;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Recomendador extends AggregateEvent<RecomendadorId> {

    protected Sede sede;
    protected Vendedor vendedor;
    protected List<Moto> motos;
    protected Cliente cliente;
    protected Presupuesto presupuesto;



    public Recomendador(RecomendadorId entityId) {
        super(entityId);
    }
}
