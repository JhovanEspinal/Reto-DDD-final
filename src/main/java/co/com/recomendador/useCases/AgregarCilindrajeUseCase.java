package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.IndicarCilindraje;
import co.com.recomendador.domain.command.IndicarPresupuesto;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Objects;

public class AgregarCilindrajeUseCase extends UseCase<RequestCommand<IndicarCilindraje>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<IndicarCilindraje> indicarCilindrajeRequestCommand) {
        var command = indicarCilindrajeRequestCommand.getCommand();
        var recomendadorId =command.getRecomendadorId();

        var recomendador = Recomendador.from(recomendadorId, retrieveEvents());
        if (Objects.nonNull(recomendador.Vendedor().getCliente().Cilindraje()) || recomendador.Generado() == Boolean.TRUE) {
            throw new BusinessException(recomendador.identity().value(), "No puede agregar el cilindraje");
        }

        recomendador.agregarCilindraje(recomendadorId,command.getCilindraje());
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));


    }
}
