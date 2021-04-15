package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.*;
import co.com.recomendador.domain.events.RecomendadorCreado;
import co.com.recomendador.domain.events.SedeAgregada;
import co.com.recomendador.domain.events.VendedorAgregado;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.Presupuesto;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.Sede;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
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

    public void agregarVendedor(RecomendadorId recoId, Vendedor vendedor){
    appendChange(new VendedorAgregado(recoId, vendedor)).apply();
    }

    public void generarCotizacion(){


    }

    public Sede Sede() {
        return sede;
    }

    public Vendedor Vendedor() {
        return vendedor;
    }

    public Cliente Cliente() {
        return cliente;
    }

    public TipoMoto TipoM() {
        return tipoM;
    }

    public Presupuesto Presupuesto() {
        return presupuesto;
    }

    public Cilindraje Cilindraje() {
        return cilindraje;
    }

    public Map<MotoId, Moto> Motos() {
        return motos;
    }

    public Boolean Generado() {
        return generado;
    }
}
