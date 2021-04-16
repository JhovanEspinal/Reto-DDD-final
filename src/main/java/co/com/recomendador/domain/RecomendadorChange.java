package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.Vendedor;
import co.com.recomendador.domain.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class RecomendadorChange extends EventChange {

    public RecomendadorChange(Recomendador recomendador){

        apply((RecomendadorCreado event) -> {
            recomendador.motos = new HashMap<>();
            recomendador.motos = event.getMotos();
            recomendador.generado = Boolean.FALSE;

        });

        apply((SedeAgregada event) -> {
            recomendador.sede = event.getSede();
        });

        apply((VendedorAgregado event) -> {
            recomendador.vendedor = new Vendedor(event.getVendedorid(),event.getNombre(),event.getCedula());
        });

        apply((ClienteAgregado event) -> {
            recomendador.vendedor.AgregarCliente(event.getCliente());
        });

        apply((TipoMotoAgregado event) -> {
            recomendador.vendedor.getCliente().IndicarTipoMoto(event.getTipoMoto());
            recomendador.filtrarXTipo(event.getTipoMoto());

        });

        apply((PresupuestoAgregado event) -> {
            recomendador.vendedor.getCliente().indicarPresupuesto(event.getPresupuesto());
            recomendador.filtrarXPresupuesto(event.getPresupuesto());
        });

        apply((CilindrajeAgregado event) -> {
            recomendador.vendedor.getCliente().IndicarCilindraje(event.getCilindraje());
            recomendador.filtrarXCilindraje(event.getCilindraje());
        });

        apply((MotoDefinida event) -> {
            recomendador.motoRecomendada = event.getMoto();
        });

        apply((RecomendadorGenerado event) -> {
            recomendador.generado= Boolean.TRUE;
        });









    }

}
