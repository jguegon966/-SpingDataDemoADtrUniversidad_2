package es.iesjandula.SpringDataDemo.models.consultas;

public class MyResponseProfesor
{

    private String name;
    private Long cuenta;

    public MyResponseProfesor(String name, Long cuenta)
    {
        this.name = name;
        this.cuenta = cuenta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "MyResponseProfesor{" +
                "name='" + name + '\'' +
                ", cuenta=" + cuenta +
                '}';
    }
}
