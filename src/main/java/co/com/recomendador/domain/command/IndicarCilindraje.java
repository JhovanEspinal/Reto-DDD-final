package co.com.recomendador.domain.command;

import co.com.recomendador.domain.valueObjets.Cilindraje;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.sofka.domain.generic.Command;

public class IndicarCilindraje implements Command  {

    private final RecomendadorId recomendadorId;
    private final Cilindraje cilindraje;

    public IndicarCilindraje(RecomendadorId recomendadorId,Cilindraje cilindraje) {
        this.recomendadorId = recomendadorId;
        this.cilindraje = cilindraje;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }
}

