package cl.myhotel.prueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.myhotel.prueba.entities.projection.AntiguedadEmpleadoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoDepartamentoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoView;
import cl.myhotel.prueba.entities.projection.InformacionPaisView;
import cl.myhotel.prueba.entities.projection.SalarioDepartamentoView;
import cl.myhotel.prueba.entities.projection.SueldoEmpleadoDepartmentoView;
import cl.myhotel.prueba.repositories.EmployeeRepository;
import cl.myhotel.prueba.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmpleadoSegmentoView> listarEmpleadoSegmento() {
		return employeeRepository.countEmployeeBySegment();
	}

	@Override
	public List<EmpleadoSegmentoDepartamentoView> listarEmpleadoSegmentoDepartamento() {
		return employeeRepository.countEmployeeBySegmentAndDepartment();
	}

	@Override
	public List<SueldoEmpleadoDepartmentoView> listarSueldoEmpleado() {
		return employeeRepository.maxSalaryByDepartment();
	}

	@Override
	public List<AntiguedadEmpleadoView> listarEmpleadoPorAntiguedad(int antiguedad) {
		return employeeRepository.findManagerBySeniority(antiguedad);
	}

	@Override
	public List<SalarioDepartamentoView> listarSalarioPorDepartamento(int cantidad) {
		return employeeRepository.findAvgSalary(cantidad);
	}

	@Override
	public List<InformacionPaisView> listarInfoPorPais() {
		return employeeRepository.findCountryInfo();
	}

	
}
