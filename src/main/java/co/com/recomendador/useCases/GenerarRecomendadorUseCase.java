package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.events.MotosDefinidas;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class GenerarRecomendadorUseCase extends UseCase<TriggeredEvent<MotosDefinidas>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<MotosDefinidas> motoDefinidaTriggeredEvent) {

        var event = motoDefinidaTriggeredEvent.getDomainEvent();
        var recomendarId = event.getRecomendadorId();
        var recomendador = Recomendador.from(recomendarId,retrieveEvents());

        recomendador.generarRecomendador(recomendarId);
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }
    }

