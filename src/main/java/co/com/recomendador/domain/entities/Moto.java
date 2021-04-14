package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Moto extends Entity<MotoId>{

    private final Nombre nombre;
    private final Precio precio;
    private final TipoMoto tipoM;
    private final Cilindraje cilindraje;


    public Moto(MotoId entityId, Nombre nombre, Precio precio,TipoMoto tipoM, Cilindraje cilindraje) {

        super(entityId);
        this.nombre = nombre;
        this.precio = precio;
        this.tipoM = tipoM;
        this.cilindraje = cilindraje;

    }

    public void eliminarMoto(){

    }
}
