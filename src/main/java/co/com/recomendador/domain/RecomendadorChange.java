package co.com.recomendador.domain;

import co.com.recomendador.domain.events.ClienteAgregado;
import co.com.recomendador.domain.events.RecomendadorCreado;
import co.com.recomendador.domain.events.SedeAgregada;
import co.com.recomendador.domain.events.VendedorAgregado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class RecomendadorChange extends EventChange {

    public RecomendadorChange(Recomendador recomendador){

        apply((RecomendadorCreado event) -> {
            recomendador.motos = event.getMotos();
            recomendador.generado = Boolean.FALSE;
        });

        apply((SedeAgregada event) -> {
            recomendador.sede = event.getSede();
        });

        apply((VendedorAgregado event) -> {
            recomendador.vendedor = event.getVendedor();
        });

        apply((ClienteAgregado event) -> {
            recomendador.vendedor.AgregarCliente(event.getCliente());
        });

        apply((TipoMotoAgregado event) -> {
            recomendador.vendedor.getCliente().IndicarTipoMoto(event.getTipoMoto());
        });







    }

}
