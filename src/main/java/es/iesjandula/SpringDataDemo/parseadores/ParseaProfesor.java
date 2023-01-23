package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.Departamento;
import es.iesjandula.SpringDataDemo.models.Profesor;
import es.iesjandula.SpringDataDemo.repository.IDepartamentoRepository;
import es.iesjandula.SpringDataDemo.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase publica ParseaProfesor que contiene la logica del parseador para la tabla Profesor
 */
@Service
public class ParseaProfesor
{

    @Autowired
    private IProfesorRepository iProfesorRepository;
    @Autowired
    private IDepartamentoRepository iDepartamentoRepository;

    public void parseaProfesores()
    {
        String profesores = "src/main/resources/profesor.csv";

        List<Profesor> listaProfesores = new ArrayList<>();
        File file = new File(profesores);

        try
        {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String lineaFichero = scanner.nextLine();
                String[] stLineaFichero = lineaFichero.split(",");

                Profesor profesor = new Profesor();

                profesor.setId(Long.valueOf(stLineaFichero[0]));
                profesor.setNif(stLineaFichero[1]);
                profesor.setNombre(stLineaFichero[2]);
                profesor.setApellido1(stLineaFichero[3]);
                profesor.setApellido2(stLineaFichero[4]);
                profesor.setCiudad(stLineaFichero[5]);
                profesor.setDireccion(stLineaFichero[6]);
                profesor.setTelefono(stLineaFichero[7]);
                profesor.setFechaNacimiento(convertStringToDateFormatddMMyyyy(stLineaFichero[8]));
                profesor.setSexo(stLineaFichero[9]);

                Optional<Departamento> optionalDepartamento = this.iDepartamentoRepository.findById(Long.valueOf(stLineaFichero[10]));
                profesor.setIdDepartamento(optionalDepartamento.get());

                this.iProfesorRepository.saveAndFlush(profesor);

            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }


    }
    public Date convertStringToDateFormatddMMyyyy(final String dateString)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }

}
