package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Alumno;
import es.iesjandula.SpringDataDemo.models.Profesor;
import es.iesjandula.SpringDataDemo.models.consultas.MyResponseProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

    Profesor findProfesorById(Long id);

    List<Profesor> findProfesorByNombre(String name);

    @Query("SELECT p FROM Profesor p JOIN p.idDepartamento d WHERE d.nombre = :nameDepartamento")
    List<Profesor> findByDepartamentoName(@Param("nameDepartamento") String nameDepartamento);

    @Query("SELECT COUNT(p) FROM Profesor p JOIN p.idDepartamento d WHERE d.nombre = :nameDepartamento")
    Long findByDepartamentoCountName(@Param("nameDepartamento") String nameDepartamento);

    @Query("SELECT new es.iesjandula.SpringDataDemo.models.consultas.MyResponseProfesor(d.nombre, COUNT(p)) FROM Profesor p JOIN p.idDepartamento d GROUP BY d HAVING COUNT(p) > 1")
    List<MyResponseProfesor> countProfesorByDepartamentoMoreThan1();


}
