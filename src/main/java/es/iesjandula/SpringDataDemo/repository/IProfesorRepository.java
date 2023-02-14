package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Alumno;
import es.iesjandula.SpringDataDemo.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

    Profesor findProfesorById(Long id);

    List<Profesor> findProfesorByNombre(String name);

}
