package co.com.recomendador.domain.entities;



import co.com.recomendador.domain.events.ClienteAgregado;
import co.com.recomendador.domain.valueObjets.*;
import co.com.sofka.domain.generic.Entity;

public class Vendedor extends Entity<VendedorId> {

    private final Nombre nombre;
    private final Cedula cedula;
    private Cliente cliente;

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

    public Cliente getCliente() {
        return cliente;
    }


    public void AgregarCliente(Cliente cliente){

        this.cliente = cliente;

    }

}
