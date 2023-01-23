package es.iesjandula.SpringDataDemo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "profesor")
public class Profesor
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 9, unique = true)
    private String nif;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido1;

    @Column(length = 50)
    private String apellido2;

    @Column(length = 25, nullable = false)
    private String ciudad;

    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(length = 9)
    private String telefono;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(length = 1, nullable = false)
    private String sexo;

    @ManyToOne
    private Departamento idDepartamento;

    public Profesor()
    {
        // Implementacion vacia
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
