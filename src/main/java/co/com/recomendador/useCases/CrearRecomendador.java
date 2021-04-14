package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.Command;

public class CrearRecomendador implements Command {

    private final RecomendadorId recomendadorId;


    public CrearRecomendador(RecomendadorId recomendadorId) {
        this.recomendadorId = recomendadorId;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }
}
