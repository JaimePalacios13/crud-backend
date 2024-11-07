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
@Table(name="solicitud")
public class solicitud {

    @Id
    @GeneratedValue(strategy=IDENTITY)

    @Column(name="id_solicitud")
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    private persona persona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_forma_pago")
    private formasDePago formasDePago;

    private String fecha_creacion;
    private String monto;
    private String plazo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public persona getPersona() {
        return persona;
    }

    public void setPersona(persona persona) {
        this.persona = persona;
    }

    public formasDePago getFormasDePago() {
        return formasDePago;
    }

    public void setFormasDePago(formasDePago formasDePago) {
        this.formasDePago = formasDePago;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }
    
}
