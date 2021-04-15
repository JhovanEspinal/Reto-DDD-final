package co.com.recomendador.domain.command;

import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.Command;

public class AgregarVendedor implements Command {

    private final RecomendadorId recomendadorId;
    private final Vendedor vendedor;

    public AgregarVendedor(RecomendadorId recomendadorId, Vendedor vendedor) {
        this.recomendadorId = recomendadorId;
        this.vendedor = vendedor;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
}
