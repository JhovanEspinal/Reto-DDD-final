package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.AgregarVendedor;
import co.com.recomendador.domain.command.Agregarcliente;
import co.com.recomendador.domain.entities.Vendedor;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Objects;

public class AgregarClienteUseCase extends UseCase<RequestCommand<Agregarcliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<Agregarcliente> agregarclienteRequestCommand) {

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
