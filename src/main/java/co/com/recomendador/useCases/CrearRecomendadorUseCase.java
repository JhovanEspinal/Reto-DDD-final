package co.com.recomendador.useCases;

import co.com.recomendador.domain.Recomendador;
import co.com.recomendador.domain.command.CrearRecomendador;
import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.HashMap;
import java.util.Map;

public class CrearRecomendadorUseCase extends UseCase<RequestCommand<CrearRecomendador>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearRecomendador> input) {
        var commad = input.getCommand();
        var recomendadorId = commad.getRecomendadorId();

        Map<MotoId,Moto> motos =new HashMap<>();
        var setMotosId = commad.getNombres().keySet();

        setMotosId.forEach(idMoto ->{
            motos.put(idMoto,
                    new Moto(idMoto,commad.getNombres().get(idMoto)
                            ,commad.getPrecio().get(idMoto)
                            ,commad.getTipoMoto().get(idMoto)
                            ,commad.getCilindraje().get(idMoto)));
        });



        var recomendador = new Recomendador(recomendadorId);
        recomendador.agregarMotos(motos);

        emit().onResponse(new ResponseEvents(recomendador.getUncommittedChanges()));
    }
}
