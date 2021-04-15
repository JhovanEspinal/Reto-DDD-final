package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.*;
import co.com.recomendador.domain.events.MotosAgregadas;
import co.com.recomendador.domain.events.RecomendadorCreado;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.Sede;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Map;

public class Recomendador extends AggregateEvent<RecomendadorId> {

    protected Sede sede;
    protected Vendedor vendedor;
    protected Cliente cliente;
    protected TipoMoto tipoM;
    protected Presupuesto presupuesto;
    protected Cilindraje cilindraje;
    protected Map<MotoId,Moto> motos;
    protected Boolean generado;



    public Recomendador(RecomendadorId entityId) {
        super(entityId);
        appendChange(new RecomendadorCreado(entityId)).apply();
    }

    public void agregarMotos(Map<MotoId,Moto> motos){
        appendChange(new MotosAgregadas(motos)).apply();
    }

    public void agregarSede(RecomendadorId recoId, Sede sede){
        appendChange(new SedeAgregada(recoId,sede)).apply();
    }
    public void agregarVendedor(){

    }

    public void generarCotizacion(){


    }

}
