package es.iesjandula.SpringDataDemo.models.consultas;

import es.iesjandula.SpringDataDemo.repository.IAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultasAsignatura
{

    @Autowired
    private IAsignaturaRepository iAsignaturaRepository;

    public void buscar10primerasAsignaturas()
    {

        System.out.println(iAsignaturaRepository.findFirst10ByOrderByCursoAsc());

    }

}
