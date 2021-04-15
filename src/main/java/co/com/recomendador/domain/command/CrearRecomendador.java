package co.com.recomendador.domain.command;

import co.com.recomendador.domain.valueObjets.Cilindraje;
import co.com.recomendador.domain.valueObjets.Precio;
import co.com.recomendador.domain.valueObjets.TipoMoto;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearRecomendador implements Command {

    private final RecomendadorId recomendadorId;
    private final Map<MotoId,Nombre> nombres;
    private final Map<MotoId,Precio> precio;
    private final Map<MotoId,TipoMoto> tipoMoto ;
    private final Map<MotoId,Cilindraje> cilindraje;



    public CrearRecomendador(RecomendadorId recomendadorId, Map<MotoId, Nombre> nombres, Map<MotoId, Precio> precio, Map<MotoId, TipoMoto> tipoMoto, Map<MotoId, Cilindraje> cilindraje) {
        this.recomendadorId = recomendadorId;
        this.nombres = nombres;
        this.precio = precio;
        this.tipoMoto = tipoMoto;
        this.cilindraje = cilindraje;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Map<MotoId, Nombre> getNombres() {
        return nombres;
    }

    public Map<MotoId, Precio> getPrecio() {
        return precio;
    }

    public Map<MotoId, TipoMoto> getTipoMoto() {
        return tipoMoto;
    }

    public Map<MotoId, Cilindraje> getCilindraje() {
        return cilindraje;
    }
}
