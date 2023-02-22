package cl.myhotel.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.myhotel.prueba.entities.Employee;
import cl.myhotel.prueba.entities.projection.AntiguedadEmpleadoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoDepartamentoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoView;
import cl.myhotel.prueba.entities.projection.InformacionPaisView;
import cl.myhotel.prueba.entities.projection.SalarioDepartamentoView;
import cl.myhotel.prueba.entities.projection.SueldoEmpleadoDepartmentoView;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT COUNT(e) as cantidad,  \n"
			+ "CASE WHEN e.salary < 3500 THEN 'SEGMENTO A' \n"
			+ "WHEN e.salary >= 8000 THEN 'SEGMENTO C' \n"
			+ "ELSE 'SEGMENTO B' \n"
			+ "END AS segmento FROM Employee e \n"
			+ "GROUP BY segmento \n"
			+ "ORDER BY segmento")
	List<EmpleadoSegmentoView> countEmployeeBySegment();
	
	@Query("SELECT COUNT(e) AS cantidad,  \n"
			+ "CASE WHEN e.salary < 3500 THEN 'SEGMENTO A'\n"
			+ "WHEN e.salary >= 8000 THEN 'SEGMENTO C'\n"
			+ "ELSE 'SEGMENTO B'\n"
			+ "END AS segmento, d.departmentName as departamento FROM Employee e\n"
			+ "LEFT JOIN Department d\n"
			+ "ON d.departmentId  = e.departmentId  \n"
			+ "GROUP BY segmento, d.departmentName\n"
			+ "ORDER BY departamento,segmento")
	List<EmpleadoSegmentoDepartamentoView> countEmployeeBySegmentAndDepartment();
	
	@Query("SELECT MAX(e.salary) AS sueldoMaximo,  \n"
			+ "d.departmentName as departamento FROM Employee e\n"
			+ "LEFT JOIN Department d\n"
			+ "ON d.departmentId  = e.departmentId  \n"
			+ "GROUP BY d.departmentName\n"
			+ "ORDER BY departamento,sueldoMaximo")
	List<SueldoEmpleadoDepartmentoView> maxSalaryByDepartment();
	
	@Query(value = "SELECT YEAR(FROM_DAYS(DATEDIFF(NOW(),e.HIRE_DATE))) AS antiguedad,j.JOB_TITLE as cargo,e.FIRST_NAME as nombre, e.LAST_NAME as apellido, e.EMAIL as email FROM employees e  \n"
			+ "LEFT JOIN jobs j\n"
			+ "ON e.JOB_ID  = j.JOB_ID \n"
			+ "WHERE j.JOB_TITLE like '%MANAGER%'\n"
			+ "HAVING ANTIGUEDAD > ?1",
			nativeQuery = true)
	List<AntiguedadEmpleadoView> findManagerBySeniority(int antiguedad);
	
	@Query(value = "SELECT AVG(e.SALARY) as salarioPromedio, d.DEPARTMENT_NAME as departamento FROM employees e\n"
			+ "left JOIN departments d\n"
			+ "ON d.DEPARTMENT_ID  = e.DEPARTMENT_ID\n"
			+ "GROUP BY d.DEPARTMENT_ID\n"
			+ "HAVING COUNT(*) > ?1",
			nativeQuery = true)
	List<SalarioDepartamentoView> findAvgSalary(int cantidad);
	
	@Query(value = "SELECT DISTINCT  c.COUNTRY_NAME as pais, \n"
			+ "	COUNT(e.EMPLOYEE_ID) over w as cantidad,\n"
			+ "	AVG(e.SALARY) over w as salarioPromedio,\n"
			+ "	MAX(e.SALARY) over w as salarioMaximo,\n"
			+ "	MIN(e.SALARY) over w as salarioMinimo,\n"
			+ "	AVG(YEAR(FROM_DAYS(DATEDIFF(NOW(),e.HIRE_DATE)))) over w as antiguedadPromedio\n"
			+ "from employees e\n"
			+ "left JOIN departments d\n"
			+ "ON d.DEPARTMENT_ID  = e.DEPARTMENT_ID\n"
			+ "left JOIN locations l \n"
			+ "ON l.LOCATION_ID  = d.LOCATION_ID \n"
			+ "left JOIN countries c \n"
			+ "ON c.COUNTRY_ID  = l.COUNTRY_ID\n"
			+ "WINDOW w AS (PARTITION BY c.COUNTRY_NAME)",
			nativeQuery = true)
	List<InformacionPaisView> findCountryInfo();
	
	
}