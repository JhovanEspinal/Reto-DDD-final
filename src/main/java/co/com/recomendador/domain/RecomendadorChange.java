package co.com.recomendador.domain;

import co.com.recomendador.domain.entities.*;
import co.com.recomendador.domain.events.MotosAgregadas;
import co.com.recomendador.domain.events.RecomendadorCreado;
import co.com.recomendador.domain.valueObjets.MotoId;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecomendadorChange extends EventChange {

    public RecomendadorChange(Recomendador recomendador){

        apply((RecomendadorCreado event) -> {
            recomendador.motos = new HashMap<>();

        });

        apply((MotosAgregadas event) ->{
            event.getMotos().forEach((motoId, moto) ->{
                recomendador.motos.put(motoId,moto);

            });
        });










    }

}
