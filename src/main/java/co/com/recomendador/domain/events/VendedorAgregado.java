package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class VendedorAgregado extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final Vendedor vendedor;


    public VendedorAgregado(RecomendadorId recoId, Vendedor vendedor) {
        super("recomendador.VendedorAgregado");
        this.recomendadorId = recoId;
        this.vendedor = vendedor;
    }
}
