package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Asignatura;
import es.iesjandula.SpringDataDemo.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long>
{

    List<Asignatura> findFirst10ByOrderByCursoAsc();

}
