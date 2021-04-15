package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteAgregado extends DomainEvent {
    private final RecomendadorId recomendadorId;
    private final Cliente cliente;

    public ClienteAgregado(RecomendadorId recoId,Cliente cliente) {
        super("recomendador.ClienteAgregado");
        this.recomendadorId = recoId;
        this.cliente = cliente;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

