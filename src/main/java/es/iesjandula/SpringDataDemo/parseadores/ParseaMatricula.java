package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.*;
import es.iesjandula.SpringDataDemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Clase publica ParseaMatricula que contiene la logica del parseador para la tabla matricula
 */
@Service
public class ParseaMatricula
{

    @Autowired
    private IMatriculaRepository iMatriculaRepository;

    @Autowired
    private IAlumnoRepository iAlumnoRepository;
    @Autowired
    private IAsignaturaRepository iAsignaturaRepository;
    @Autowired
    private ICursoRepository iCursoRepository;

    public void parseaMatriculas()
    {
        String matriculas = "src/main/resources/matricula.csv";

        List<Matricula> listaMatricula = new ArrayList<>();

        File file = new File(matriculas);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Matricula matricula = new Matricula();

                Optional<Alumno> optionalAlumno = this.iAlumnoRepository.findById(Long.valueOf(stLineaFichero[0]));
                matricula.setIdAlumno(optionalAlumno.get());

                Optional<Asignatura> optionalAsignatura = this.iAsignaturaRepository.findById(Long.valueOf(stLineaFichero[1]));
                matricula.setIdAsignatura(optionalAsignatura.get());

                Optional<Curso> optionalCurso = this.iCursoRepository.findById(Long.valueOf(stLineaFichero[2]));
                matricula.setIdCurso(optionalCurso.get());

                //añadimos instancia tambien de matriculaId ya que si no no funcionará, seteando los mismos datos optional de matricula
                MatriculaId matriculaId = new MatriculaId() ;
                matriculaId.setIdAlumno(optionalAlumno.get().getId());
                matriculaId.setIdCurso(optionalCurso.get().getId());
                matriculaId.setIdAsignatura(optionalAsignatura.get().getId());

                matricula.setMatriculaId(matriculaId);

                this.iMatriculaRepository.saveAndFlush(matricula);

            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
    }

}
