package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long>
{

    Alumno findAlumnoById(Long id);

    List<Alumno> findAlumnosByNombre(String name);

}
