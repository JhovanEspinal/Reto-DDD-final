package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.AgregarCliente;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Objects;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarclienteRequestCommand) {

        var command = agregarclienteRequestCommand.getCommand();
        var recomendadorId = command.getRecomendadorId();
        var recomendador = Recomendador.from(recomendadorId,retrieveEvents());
        if (Objects.nonNull(recomendador.Vendedor().getCliente())){
            throw new BusinessException(recomendador.identity().value(),"No puede agregar otro cliente");
        }
        recomendador.agregarCliente(recomendadorId,command.getCliente());
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }



}
