package es.iesjandula.SpringDataDemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Departamento()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
