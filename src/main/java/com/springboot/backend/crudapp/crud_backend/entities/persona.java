package com.springboot.backend.crudapp.crud_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class persona {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_persona")
    private Long id;

    private String dui;
    private String nit;
    private String nombres;
    private String apellidos;
    private String sexo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_actividad_economica")
    private actividadesEconomicas actividadesEconomicas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_civil")
    private estadoCivil estadoCivil;
    //private Long id_actividad_economica;
    //private Long id_estado_civil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public actividadesEconomicas getActividadEconomica() {
        return actividadesEconomicas;
    }

    public void setActividadEconomica(actividadesEconomicas actividadesEconomicas) {
        this.actividadesEconomicas = actividadesEconomicas;
    }

    public estadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(estadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
