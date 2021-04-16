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
    protected List<Moto> motosRecomendadas;
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

    public void definirMotos(RecomendadorId recoId, List<Moto> motosF){
        appendChange(new MotosDefinidas(recoId,motosF)).apply();
    }

    public void generarRecomendador(RecomendadorId recoId){
        appendChange(new RecomendadorGenerado(recoId)).apply();
    }
    public Sede Sede() {
        return sede;
    }



    public Vendedor Vendedor() {
        return vendedor;
    }

    public List<Moto> getMotosRecomendadas() {
        return motosRecomendadas;
    }

    public Map<MotoId, Moto> getMotos() {
        return motos;
    }

    public Boolean Generado() {
        return generado;
    }
}
