package co.com.recomendador.useCases;

import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.events.CilindrajeAgregado;
import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.bson.LazyBSONList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DefinirMotosRecomendadasUseCase extends UseCase<TriggeredEvent<CilindrajeAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CilindrajeAgregado> cilindrajeAgregadoTriggeredEvent) {
        var event = cilindrajeAgregadoTriggeredEvent.getDomainEvent();
        var recomendadorId = event.getRecomendadorId();
        var recomendador = Recomendador.from(recomendadorId,retrieveEvents());
        var tipoM = recomendador.Vendedor().getCliente().TipoM();
        var presupuesto = recomendador.Vendedor().getCliente().Presupuesto();
        var cilindraje = recomendador.Vendedor().getCliente().Cilindraje();
        var motos = recomendador.getMotos();

        var motosF = new ArrayList<Moto>();


        motos.forEach(((motoId, moto) -> {
                    if (moto.getPrecio().value() <= presupuesto.value()) {
                        motosF.add(moto);
                    }

                }));


      var motosFi =  motosF.stream().filter(moto -> {
          return  moto.getCilindraje().value() <= cilindraje.value();
        }).filter(moto -> {
         return moto.getTipoM().value() == tipoM.value();
        }).collect(Collectors.toList());

        recomendador.definirMotos(recomendadorId,motosFi);
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }


}