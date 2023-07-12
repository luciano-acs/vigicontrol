package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Distrito {

    @Id
    private int idDistrito;
    private String nombre;
    @OneToOne(fetch = FetchType.EAGER)
    private Domicilio domicilio;
    @OneToMany(mappedBy = "distrito")
    @JsonIgnore
    private List<Comisaria> comisarias;

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Comisaria> getComisarias() {
        return comisarias;
    }

    public void setComisarias(List<Comisaria> comisarias) {
        this.comisarias = comisarias;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public Distrito(int idDistrito, String nombre, Domicilio domicilio, List<Comisaria> comisarias) {
//        this.idDistrito = idDistrito;
//        this.nombre = nombre;
//        this.domicilio = domicilio;
//        this.comisarias = comisarias;
//    }
}
