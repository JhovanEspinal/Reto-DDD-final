package co.com.recomendador.useCases;

import co.com.recomendador.domain.events.CilindrajeAgregado;
import co.com.recomendador.domain.Recomendador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class DefinirMotoUseCase extends UseCase<TriggeredEvent<CilindrajeAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CilindrajeAgregado> cilindrajeAgregadoTriggeredEvent) {
        var event = cilindrajeAgregadoTriggeredEvent.getDomainEvent();
        var recomendadorId = event.getRecomendadorId();
        var recomendador = Recomendador.from(recomendadorId,retrieveEvents());
        var moto = recomendador.definirMotoFinal();

        recomendador.definirMoto(recomendadorId,moto);
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }
}
