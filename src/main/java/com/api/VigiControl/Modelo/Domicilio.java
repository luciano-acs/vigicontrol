package com.api.VigiControl.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Domicilio {

    @Id
    private int idDomicilio;
    private String calle;
    private int nroCalle;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "localidadId")
    private Localidad localidad;

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNroCalle() {
        return nroCalle;
    }

    public void setNroCalle(int nroCalle) {
        this.nroCalle = nroCalle;
    }
}
