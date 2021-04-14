package co.com.recomendador.domain.valueObjets;

import co.com.sofka.domain.generic.Identity;

public class VendedorId extends Identity {


    public VendedorId(String uuid) {
        super(uuid);
    }

    public VendedorId() {
    }

    public static VendedorId of(String uid){
        return new VendedorId(uid);
    }
}
