package co.com.recomendador.domain.command;

import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.valueObjets.Cedula;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.VendedorId;
import co.com.sofka.domain.generic.Command;

public class AgregarVendedor implements Command {

    private final RecomendadorId recomendadorId;
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Cedula cedula;

    public AgregarVendedor(RecomendadorId recomendadorId,VendedorId vendedorId,Nombre nombre, Cedula cedula) {
        this.recomendadorId = recomendadorId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cedula getCedula() {
        return cedula;
    }
}
