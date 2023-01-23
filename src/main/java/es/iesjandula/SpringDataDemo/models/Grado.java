package es.iesjandula.SpringDataDemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grado")
public class Grado
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Grado()
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
