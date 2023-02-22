package cl.myhotel.prueba.service;

import java.util.List;

import cl.myhotel.prueba.entities.projection.AntiguedadEmpleadoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoDepartamentoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoView;
import cl.myhotel.prueba.entities.projection.InformacionPaisView;
import cl.myhotel.prueba.entities.projection.SalarioDepartamentoView;
import cl.myhotel.prueba.entities.projection.SueldoEmpleadoDepartmentoView;

public interface EmployeeService {
	List<EmpleadoSegmentoView> listarEmpleadoSegmento();
	List<EmpleadoSegmentoDepartamentoView> listarEmpleadoSegmentoDepartamento();
	List<SueldoEmpleadoDepartmentoView> listarSueldoEmpleado();
	List<AntiguedadEmpleadoView> listarEmpleadoPorAntiguedad(int antiguedad);
	List<SalarioDepartamentoView> listarSalarioPorDepartamento(int cantidad);
	List<InformacionPaisView> listarInfoPorPais();
	
}