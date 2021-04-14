package co.com.recomendador.domain.valueObjets;

import co.com.sofka.domain.generic.Identity;

public class RecomendadorId extends Identity {

    private RecomendadorId(String uid){
        super(uid);
    }

    public RecomendadorId(){}

    public static RecomendadorId of(String uid){
        return new RecomendadorId(uid);
    }
}
