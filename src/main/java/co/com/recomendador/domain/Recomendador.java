package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.*;
import co.com.recomendador.domain.events.*;
import co.com.recomendador.domain.valueObjets.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recomendador extends AggregateEvent<RecomendadorId> {

    protected Sede sede;
    protected Vendedor vendedor;
    protected Map<MotoId,Moto> motos;
    protected Moto motoRecomendada;
    protected Boolean generado;

    public Recomendador(RecomendadorId entityId,Map<MotoId,Moto> motos) {
        super(entityId);
        appendChange(new RecomendadorCreado(entityId,motos)).apply();


    }

    private Recomendador(RecomendadorId recoId) {
        super(recoId);
        subscribe(new RecomendadorChange(this));

    }

    public static Recomendador from(RecomendadorId recoId, List<DomainEvent> events){

        var recomendador = new Recomendador(recoId);
        events.forEach(recomendador::applyEvent);
        return recomendador;
    }

    public void agregarSede(RecomendadorId recoId, Sede sede){
        appendChange(new SedeAgregada(recoId,sede)).apply();
    }

    public void agregarVendedor(RecomendadorId recoId,VendedorId vendedorId,Nombre nombre,Cedula cedula){
    appendChange(new VendedorAgregado(recoId,vendedorId,nombre,cedula)).apply();
    }



    public void agregarCliente(RecomendadorId recoId,Cliente cliente){
        appendChange(new ClienteAgregado(recoId,cliente)).apply();
    }

    public void agregarTipoMoto(RecomendadorId recoId,TipoMoto tipoM){
        appendChange(new TipoMotoAgregado(recoId,tipoM)).apply();
    }

    public void agregarPresupuesto(RecomendadorId recoId, Presupuesto presupuesto){
        appendChange(new PresupuestoAgregado(recoId,presupuesto)).apply();
    }

    public void agregarCilindraje(RecomendadorId recoId,Cilindraje cilindraje){
        appendChange(new CilindrajeAgregado(recoId,cilindraje)).apply();
    }

    public void definirMoto(RecomendadorId recoId, Moto moto){
        appendChange(new MotoDefinida(recoId,moto)).apply();
    }

    public void generarRecomendador(RecomendadorId recoId){
        appendChange(new RecomendadorGenerado(recoId)).apply();
    }
    public Sede Sede() {
        return sede;
    }


    public void filtrarXTipo(TipoMoto tipoMoto){
        var MotosN = new HashMap<MotoId,Moto>();
        this.motos.forEach(((motoId, moto) ->{
            if(moto.getTipoM().value().equals(tipoMoto.value())){
                MotosN.put(motoId,moto);
            }
        }));

        this.motos = MotosN;
    }

    public void filtrarXPresupuesto(Presupuesto presupuesto){
        var MotosN = new HashMap<MotoId,Moto>();
        this.motos.forEach(((motoId, moto) ->{
            if(moto.getPrecio().value() <= presupuesto.value()){
                MotosN.put(motoId,moto);
            }
        }));

        this.motos = MotosN;
    }

    public void filtrarXCilindraje(Cilindraje cilindraje){
        var MotosN = new HashMap<MotoId,Moto>();
        this.motos.forEach(((motoId, moto) ->{
            if(moto.getCilindraje().value() == cilindraje.value()){
                MotosN.put(motoId,moto);
            }
        }));

        this.motos = MotosN;
    }

    public Moto definirMotoFinal(){
        var motosN = new ArrayList<Moto>();
        this.motos.forEach((motoid,moto)->{
            motosN.add(moto);
        });

        Moto motoD = null;
        Integer mayor = 0;

        for (int i= 0; i < motosN.size(); i++){
            if(motosN.get(i).getPrecio().value() > mayor ){
                mayor = motosN.get(i).getPrecio().value();
                motoD = motosN.get(i);
            }

        }
        return motoD;

    }

    public Vendedor Vendedor() {
        return vendedor;
    }

    public Moto motoRecomendada(){
        return motoRecomendada;
    }

    public Boolean Generado() {
        return generado;
    }
}
