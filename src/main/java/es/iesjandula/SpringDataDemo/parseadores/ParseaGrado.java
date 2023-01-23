package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.Grado;
import es.iesjandula.SpringDataDemo.repository.IGradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase publica ParseaGrado que contiene la logica del parseador para la tabla grado
 */
@Service
public class ParseaGrado
{

    @Autowired
    private IGradoRepository iGradoRepository;

    public void parsearGrado()
    {

        final String separadorCampo = ",";

        List<Grado> listaGrados = new ArrayList<Grado>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try
        {
            fileReader = new FileReader("src/main/resources/grado.csv");
            bufferedReader = new BufferedReader(fileReader);

            String linea;

            //lee la cabecera y se la salta
            bufferedReader.readLine();

            while((linea = bufferedReader.readLine()) != null)
            {

                String[] gradoArray = linea.split(separadorCampo);

                Grado grado = new Grado();

                grado.setId(Long.valueOf(gradoArray[0]));
                grado.setNombre(gradoArray[1]);

                this.iGradoRepository.saveAndFlush(grado);

            }

            System.out.println(listaGrados);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
