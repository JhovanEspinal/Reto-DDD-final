package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.*;
import co.com.sofka.domain.generic.Entity;

import java.util.HashMap;
import java.util.Map;

public class Moto extends Entity<MotoId>{

    private final Nombre nombre;
    private final Precio precio;
    private final TipoMoto tipoM;
    private final Cilindraje cilindraje;
    private  Map<MotoId,Moto> motos;


    public Moto(MotoId entityId, Nombre nombre, Precio precio,TipoMoto tipoM, Cilindraje cilindraje) {

        super(entityId);
        this.nombre = nombre;
        this.precio = precio;
        this.tipoM = tipoM;
        this.cilindraje = cilindraje;

    }

    public void agregarMotos(Map<MotoId,Moto> setMotos){
        this.motos = setMotos;
    }

    public void filtrarXTipo(TipoMoto tipoMoto){
       var Motos = new HashMap<MotoId,Moto>();
        this.motos.forEach(((motoId, moto) ->{
          if(moto.tipoM.value().equals(tipoMoto.value())){
             Motos.put(motoId,moto);
          }
        }));

        this.motos = Motos;
    }


    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }

    public TipoMoto getTipoM() {
        return tipoM;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }

    public Map<MotoId, Moto> getMotos() {
        return motos;
    }
}
