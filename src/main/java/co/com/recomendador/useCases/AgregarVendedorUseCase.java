package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.AgregarSede;
import co.com.recomendador.domain.command.AgregarVendedor;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Objects;

public class AgregarVendedorUseCase extends UseCase<RequestCommand<AgregarVendedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVendedor> agregarVendedorRequestCommand) {

        var command = agregarVendedorRequestCommand.getCommand();
        var recomendadorId = command.getRecomendadorId();
        var recomendador = Recomendador.from(recomendadorId,retrieveEvents());
        if (Objects.nonNull(recomendador.Vendedor()) || recomendador.Generado() == Boolean.TRUE){
            throw new BusinessException(recomendador.identity().value(),"Ya tiene asignado un vendedor");
        }

        recomendador.agregarVendedor(command.getRecomendadorId(), command.getVendedor());
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }
}
