package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.AgregarCliente;
import co.com.recomendador.domain.command.IndicarTipoMoto;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Objects;

public class AgregarTipoMotoUseCase extends UseCase<RequestCommand<IndicarTipoMoto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<IndicarTipoMoto> indicarTipoMotoRequestCommand) {

        var command = indicarTipoMotoRequestCommand.getCommand();
        var recomendadorId = command.getRecomendadorId();

        var recomendador = Recomendador.from(recomendadorId,retrieveEvents());
        if(Objects.nonNull(recomendador.Vendedor().getCliente().TipoM()) || recomendador.Generado() == Boolean.TRUE){
            throw new BusinessException(recomendador.identity().value(),"No puede agregar el Tipo de moto");
        }

        recomendador.agregarTipoMoto(recomendadorId,command.getTipoMoto());
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));

    }
}
