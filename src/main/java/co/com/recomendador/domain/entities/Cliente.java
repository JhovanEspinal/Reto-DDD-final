package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.Cedula;
import co.com.recomendador.domain.valueObjets.ClienteId;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.recomendador.domain.valueObjets.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {

    private final Nombre nombre;
    private final Cedula cedula;
    private final Telefono telefono;


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

    public void elegirTipoMoto(){

    }

    public void indicarPresupuesto(){

    }

    public void elegirCilindraje(){

    }

}
