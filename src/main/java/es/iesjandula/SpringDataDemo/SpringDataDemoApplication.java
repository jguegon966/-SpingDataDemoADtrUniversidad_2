package es.iesjandula.SpringDataDemo;

import es.iesjandula.SpringDataDemo.parseadores.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase encargada de hacer llamadas a metodos con los repositorios
 */
@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner
{

	@Autowired
	private ParseaAlumno parseaAlumno;
	@Autowired
	private ParseaCurso parseaCurso;
	@Autowired
	private ParseaDepartamento parseaDepartamento;
	@Autowired
	private ParseaGrado parseaGrado;
	@Autowired
	private ParseaAsignatura parseaAsignatura;
	@Autowired
	private ParseaProfesor parseaProfesor;
	@Autowired
	private ParseaMatricula parseaMatricula;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	/**
	 * Hacemos instancias de los cada clase parseadora y llamamos a su metodo
	 * @param args incoming main method arguments
	 * @throws Exception excepciones generales
	 */
	@Transactional(readOnly = false)
	@Override
	public void run(String... args) throws Exception
	{


		parseaAlumno.parsearAlumno();
		parseaCurso.parsearCurso();
		parseaDepartamento.parsearDepartamento();
		parseaGrado.parsearGrado();
		parseaProfesor.parseaProfesores();
		parseaAsignatura.parseaAsignaturas();
		parseaMatricula.parseaMatriculas();

	}

}
