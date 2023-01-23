package es.iesjandula.SpringDataDemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "asignatura")
public class Asignatura
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 20)
    private double creditos;

    @Column(length = 2)
    private int cuatrimestre;

    @Column(length = 2)
    private int curso;

    @Column(length = 100)
    private String nombre;

    @Column(length = 50)
    private String tipo;

    @ManyToOne
    private Grado idGrado;

    @ManyToOne
    private Profesor idProfesor;

    public Asignatura()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }
}
