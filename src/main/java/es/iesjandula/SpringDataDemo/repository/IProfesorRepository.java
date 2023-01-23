package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

}
