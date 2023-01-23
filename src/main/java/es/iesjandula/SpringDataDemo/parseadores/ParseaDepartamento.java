package es.iesjandula.SpringDataDemo.parseadores;

import es.iesjandula.SpringDataDemo.models.Departamento;
import es.iesjandula.SpringDataDemo.repository.IDepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase publica ParseaDepartamento que contiene la logica del parseador para la tabla departamento
 */
@Service
public class ParseaDepartamento
{

    @Autowired
    private IDepartamentoRepository iDepartamentoRepository;

    public void parsearDepartamento()
    {

        final String separadorCampo = ",";

        List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try
        {
            fileReader = new FileReader("src/main/resources/departamento.csv");
            bufferedReader = new BufferedReader(fileReader);

            String linea;

            //lee la cabecera y se la salta
            bufferedReader.readLine();

            while((linea = bufferedReader.readLine()) != null)
            {

                String[] departamentoArray = linea.split(separadorCampo);

                Departamento departamento = new Departamento();

                departamento.setId(Long.valueOf(departamentoArray[0]));
                departamento.setNombre(departamentoArray[1]);

                this.iDepartamentoRepository.saveAndFlush(departamento);

            }

            System.out.println(listaDepartamentos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
