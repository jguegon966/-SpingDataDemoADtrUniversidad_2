package es.iesjandula.SpringDataDemo;

import es.iesjandula.SpringDataDemo.models.consultas.ConsultasAlumno;
import es.iesjandula.SpringDataDemo.models.consultas.ConsultasAsignatura;
import es.iesjandula.SpringDataDemo.models.consultas.ConsultasProfesor;
import es.iesjandula.SpringDataDemo.parseadores.*;
import es.iesjandula.SpringDataDemo.repository.IAlumnoRepository;
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

	@Autowired
	private ConsultasAlumno consultasAlumno;

	@Autowired
	private ConsultasProfesor consultasProfesor;

	@Autowired
	private ConsultasAsignatura consultasAsignatura;

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

		//parseaAlumno.parsearAlumno();
		//parseaCurso.parsearCurso();
		//parseaDepartamento.parsearDepartamento();
		//parseaGrado.parsearGrado();
		//parseaProfesor.parseaProfesores();
		//parseaAsignatura.parseaAsignaturas();
		//parseaMatricula.parseaMatriculas();

		consultasAlumno.buscarAlumnoPorId(5L);

		consultasAlumno.buscarAlumnoPorNombre("Juan");

		consultasProfesor.buscarProfesorPorId(2L);

		consultasProfesor.buscarProfesorPorNombre("Zoe");

		consultasAsignatura.buscar10primerasAsignaturas();

	}

}
