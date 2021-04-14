package co.com.recomendador.domain.valueObjets;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {

    public ClienteId(String uid) {
        super(uid);
    }

    public ClienteId() {
    }

    public static ClienteId of(String uid){

        return new ClienteId();
    }
}
