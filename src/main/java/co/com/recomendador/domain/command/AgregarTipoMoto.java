package co.com.recomendador.domain.command;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.sofka.domain.generic.Command;

public class AgregarTipoMoto implements Command {

    private final RecomendadorId recomendadorId;
    private final TipoMoto tipoMoto;

    public AgregarTipoMoto(RecomendadorId recomendadorId, TipoMoto tipoMoto) {
        this.recomendadorId = recomendadorId;
        this.tipoMoto = tipoMoto;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
}
