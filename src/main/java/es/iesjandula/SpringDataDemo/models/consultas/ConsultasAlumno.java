package es.iesjandula.SpringDataDemo.models.consultas;

import es.iesjandula.SpringDataDemo.models.Alumno;
import es.iesjandula.SpringDataDemo.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultasAlumno
{

    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    public void buscarAlumnoPorId(Long id)
    {

        System.out.println(iAlumnoRepository.findAlumnoById(id));

    }

    public void buscarAlumnoPorNombre(String nombre)
    {

        System.out.println(iAlumnoRepository.findAlumnosByNombre(nombre));

    }

}
