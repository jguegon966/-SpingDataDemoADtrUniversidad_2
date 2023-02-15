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

    public void consultaAsignaturaPorGrado(String nombreGrado)
    {

        System.out.println(iAsignaturaRepository.findByGradoName(nombreGrado));

    }

    public void selectAsignaturaporIdGrado(String nombreGrado)
    {

        System.out.println(iAsignaturaRepository.findAsignaturaPorNombreGrado(nombreGrado));

    }

}
