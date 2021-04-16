package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.Cedula;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.VendedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class VendedorAgregado extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final VendedorId vendedorid;
    private final Nombre nombre;
    private final Cedula cedula;


    public VendedorAgregado(RecomendadorId recoId, VendedorId vendedorid, Nombre nombre, Cedula cedula) {
        super("recomendador.VendedorAgregado");
        this.recomendadorId = recoId;
        this.vendedorid = vendedorid;
        this.nombre = nombre;
        this.cedula = cedula;

    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public VendedorId getVendedorid() {
        return vendedorid;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cedula getCedula() {
        return cedula;
    }
}
