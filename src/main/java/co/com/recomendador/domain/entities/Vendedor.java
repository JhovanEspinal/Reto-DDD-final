package co.com.recomendador.domain.entities;


import co.com.recomendador.domain.valueObjets.Cedula;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.recomendador.domain.valueObjets.VendedorId;
import co.com.sofka.domain.generic.Entity;

public class Vendedor extends Entity<VendedorId> {

    private final Nombre nombre;
    private final Cedula cedula;

    public Vendedor(VendedorId entityId, Nombre nombre, Cedula cedula) {
        super(entityId);
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public void agregarCliente(){

    }

}
