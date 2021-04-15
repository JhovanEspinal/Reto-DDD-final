package co.com.recomendador.domain.command;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.Command;

public class Agregarcliente  implements Command {

    private final RecomendadorId recomendadorId;
    private final Cliente cliente;

    public Agregarcliente(RecomendadorId recomendadorId, Cliente cliente) {
        this.recomendadorId = recomendadorId;
        this.cliente = cliente;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}


