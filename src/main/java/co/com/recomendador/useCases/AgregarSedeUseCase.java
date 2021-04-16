package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.AgregarSede;
import co.com.recomendador.domain.events.RecomendadorCreado;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class AgregarSedeUseCase extends UseCase<RequestCommand<AgregarSede>, ResponseEvents>{


    @Override
    public void executeUseCase(RequestCommand<AgregarSede> agregarSedeRequestCommand) {

        var command = agregarSedeRequestCommand.getCommand();
        var recomendadorId = command.getRecomendadorId();
        var recomendador = Recomendador.from(recomendadorId,retrieveEvents());
        if (Objects.nonNull(recomendador.Sede()) || recomendador.Generado() == Boolean.TRUE){
            throw new BusinessException(recomendador.identity().value(),"No puede ingresar la sede");
        }

        recomendador.agregarSede(command.getRecomendadorId(), command.getSede());
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }
}



