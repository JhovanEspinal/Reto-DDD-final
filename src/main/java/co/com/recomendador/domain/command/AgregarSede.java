package co.com.recomendador.domain.command;

import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.Sede;
import co.com.sofka.domain.generic.Command;

public class AgregarSede implements Command {

    private final RecomendadorId recomendadorId;
    private final Sede sede;

    public AgregarSede(RecomendadorId recoId, Sede sede) {
        this.recomendadorId = recoId;
        this.sede = sede;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Sede getSede() {
        return sede;
    }
}
