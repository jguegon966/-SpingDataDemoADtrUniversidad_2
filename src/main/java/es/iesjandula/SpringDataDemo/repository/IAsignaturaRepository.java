package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Asignatura;
import es.iesjandula.SpringDataDemo.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long>
{

    List<Asignatura> findFirst10ByOrderByCursoAsc();

    @Query("SELECT a FROM Asignatura a JOIN a.idGrado g WHERE g.nombre = :nameGrado")
    List<Asignatura> findByGradoName(@Param("nameGrado") String nameGrado);

}
