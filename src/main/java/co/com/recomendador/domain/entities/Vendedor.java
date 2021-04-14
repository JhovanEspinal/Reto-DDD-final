package co.com.recomendador.domain.entities;

import javax.swing.text.html.parser.Entity;

public class Vendedor extends Entity<VendedorId> {

    private final Nombre nombre;
    private final Cedula cedula;

    public Vendedor(String name, int type, char[] data, Nombre nombre, Cedula cedula) {
        super(name, type, data);
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cedula getCedula() {
        return cedula;
    }
}
