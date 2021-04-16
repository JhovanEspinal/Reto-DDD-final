package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.events.MotoDefinida;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class GenerarRecomendacionUseCase extends UseCase<TriggeredEvent<MotoDefinida>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<MotoDefinida> motoDefinidaTriggeredEvent) {

        var event = motoDefinidaTriggeredEvent.getDomainEvent();
        var recomendarId = event.getRecomendadorId();
        var recomendador = Recomendador.from(recomendarId,retrieveEvents());

        recomendador.generarRecomendacion(recomendarId);
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }
    }

