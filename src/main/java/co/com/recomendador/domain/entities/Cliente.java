package co.com.recomendador.domain.entities;

import co.com.recomendador.domain.valueObjets.Cedula;
import co.com.recomendador.domain.valueObjets.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {

    private final Nombre nombre;
    private final Cedula cedula;
    private final Telefono telefono;


    public Cliente(Nombre nombre, Cedula cedula, Telefono telefono) {
        super();
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }
}
