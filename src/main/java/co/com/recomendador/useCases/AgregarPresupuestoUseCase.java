package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.IndicarPresupuesto;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Objects;

public class AgregarPresupuestoUseCase extends UseCase<RequestCommand<IndicarPresupuesto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<IndicarPresupuesto> indicarPresupuestoRequestCommand) {

        var command = indicarPresupuestoRequestCommand.getCommand();
        var recomendadorId = command.getRecomendadorId();

        var recomendador = Recomendador.from(recomendadorId, retrieveEvents());
        if (Objects.nonNull(recomendador.Vendedor().getCliente().Presupuesto()) || recomendador.Generado() == Boolean.TRUE) {
            throw new BusinessException(recomendador.identity().value(), "No puede agregar el presupuesto");
        }

        recomendador.agregarPresupuesto(recomendadorId,command.getPresupuesto());
        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));

    }
}
