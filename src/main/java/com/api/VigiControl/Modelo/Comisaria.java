package com.api.VigiControl.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comisaria {

    @Id
    private int nroComisaria;
    private String nombre;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private Domicilio domicilio;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "distritoId")
    private Distrito distrito;


    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public int getNroComisaria() {
        return nroComisaria;
    }

    public void setNroComisaria(int nroComisaria) {
        this.nroComisaria = nroComisaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
