package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.Asignatura;
import es.iesjandula.SpringDataDemo.models.Grado;
import es.iesjandula.SpringDataDemo.models.Profesor;
import es.iesjandula.SpringDataDemo.repository.IAsignaturaRepository;
import es.iesjandula.SpringDataDemo.repository.IGradoRepository;
import es.iesjandula.SpringDataDemo.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Clase publica ParseaAsignatura que contiene la logica del parseador para la tabla asignatura
 */
@Service
public class ParseaAsignatura
{

    @Autowired
    private IAsignaturaRepository iAsignaturaRepository;
    @Autowired
    private IProfesorRepository iProfesorRepository;
    @Autowired
    private IGradoRepository iGradoRepository;

    public void parseaAsignaturas()
    {
        String asignaturas = "src/main/resources/asignatura.csv";

        List<Asignatura> listaAsignatura = new ArrayList<>();

        File file = new File(asignaturas);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Asignatura asignatura= new Asignatura();

                asignatura.setId(Long.valueOf(stLineaFichero[0]));
                asignatura.setCreditos(Double.valueOf(stLineaFichero[2]));
                asignatura.setCuatrimestre(Integer.valueOf(stLineaFichero[5]));
                asignatura.setCurso(Integer.valueOf(stLineaFichero[4]));
                asignatura.setNombre(stLineaFichero[1]);
                asignatura.setTipo(stLineaFichero[3]);

                Optional<Grado> optionalGrado = this.iGradoRepository.findById(Long.valueOf(stLineaFichero[7]));
                asignatura.setIdGrado(optionalGrado.get());
                Optional<Profesor> optionalProfesor = this.iProfesorRepository.findById(Long.valueOf(stLineaFichero[6]));
                asignatura.setIdProfesor(optionalProfesor.get());

                this.iAsignaturaRepository.saveAndFlush(asignatura);

            }

            /**
             for(Asignatura asignatura : listaAsignatura)
             {
             System.out.println(asignatura);
             }
             **/

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }

}
