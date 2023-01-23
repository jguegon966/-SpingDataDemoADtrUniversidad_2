package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.Curso;
import es.iesjandula.SpringDataDemo.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase publica ParseaCurso que contiene la logica del parseador para la tabla curso
 */
@Service
public class ParseaCurso
{

    @Autowired
    private ICursoRepository iCursoRepository;

    public void parsearCurso()
    {

        final String separadorCampo = ",";

        List<Curso> listaCursos = new ArrayList<Curso>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try
        {
            fileReader = new FileReader("src/main/resources/curso.csv");
            bufferedReader = new BufferedReader(fileReader);

            String linea;

            //lee la cabecera y se la salta
            bufferedReader.readLine();

            while((linea = bufferedReader.readLine()) != null)
            {

                String[] cursosArray = linea.split(separadorCampo);

                Curso curso = new Curso();

                curso.setId(Long.valueOf(cursosArray[0]));
                curso.setAnioInicio(Integer.parseInt(cursosArray[1]));
                curso.setAnioFin(Integer.parseInt(cursosArray[2]));

                this.iCursoRepository.saveAndFlush(curso);

            }

            System.out.println(listaCursos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
