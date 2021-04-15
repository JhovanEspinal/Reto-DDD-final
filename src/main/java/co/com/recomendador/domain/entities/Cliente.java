package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.*;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {

    private final Nombre nombre;
    private final Cedula cedula;
    private final Telefono telefono;
    protected TipoMoto tipoM;
    protected Presupuesto presupuesto;
    protected Cilindraje cilindraje;


    public Cliente(ClienteId entityId,Nombre nombre, Cedula cedula, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Telefono getTelefono() {
        return telefono;
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


    public void IndicarTipoMoto(TipoMoto tipoM){
        this.tipoM = tipoM;
    }

    public void indicarPresupuesto(Presupuesto presupuesto){
        this.presupuesto = presupuesto;

    }

    public void elegirCilindraje(Cilindraje cilindraje){
    this.cilindraje = cilindraje;
    }


}
