package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.Alumno;
import es.iesjandula.SpringDataDemo.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase publica ParseaAlumno que contiene la logica del parseador para la tabla alumnos
 */
@Service
public class ParseaAlumno
{

    @Autowired
    private IAlumnoRepository iAlumnoRepository;

    public void parsearAlumno()
    {

        final String separadorCampo = ",";

        List<Alumno> listaAlumnos = new ArrayList<Alumno>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try
        {
            fileReader = new FileReader("src/main/resources/alumno.csv");
            bufferedReader = new BufferedReader(fileReader);

            String linea;

            //lee la cabecera y se la salta
            bufferedReader.readLine();

            while((linea = bufferedReader.readLine()) != null)
            {

                String[] alumnoArray = linea.split(separadorCampo);

                Alumno alumno = new Alumno();
                alumno.setId(Long.parseLong(alumnoArray[0]));
                alumno.setNif(alumnoArray[1]);
                alumno.setNombre(alumnoArray[2]);
                alumno.setApellido1(alumnoArray[3]);
                alumno.setApellido2(alumnoArray[4]);
                alumno.setCiudad(alumnoArray[5]);
                alumno.setDireccion(alumnoArray[6]);
                alumno.setTelefono(alumnoArray[7]);
                alumno.setFechaNacimiento((Date) formato.parse(alumnoArray[8]));
                alumno.setSexo(alumnoArray[9]);

                this.iAlumnoRepository.saveAndFlush(alumno);

            }

            System.out.println(listaAlumnos);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
