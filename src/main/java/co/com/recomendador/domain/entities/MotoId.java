package co.com.recomendador.domain.entities;

import co.com.sofka.domain.generic.Identity;

public class MotoId extends Identity {

    public MotoId(String uuid) {
        super(uuid);
    }

    public MotoId() {
    }

    public static MotoId of(String uid){
        return new MotoId((uid));
    }
}
