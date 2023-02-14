package es.iesjandula.SpringDataDemo.models.consultas;

import es.iesjandula.SpringDataDemo.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultasProfesor
{

    @Autowired
    private IProfesorRepository iProfesorRepository;

    public void buscarProfesorPorId(Long id)
    {

        System.out.println(iProfesorRepository.findProfesorById(id));

    }

    public void buscarProfesorPorNombre(String nombre)
    {

        System.out.println(iProfesorRepository.findProfesorByNombre(nombre));

    }

}
