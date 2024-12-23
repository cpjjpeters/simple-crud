package ipeters.resttemplate_demo.service;

import ipeters.resttemplate_demo.model.Employee;
import ipeters.resttemplate_demo.persistence.EmployeePersistenceFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 22/12/2024 inside the package - ipeters.resttemplate_demo.service */
@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeePersistenceFacade employeePersistenceFacade;


    public List<Employee> findAllEmployees() {
        return this.employeePersistenceFacade.findAll();
    }

    public Employee save(Employee employee) {
        log.debug("save employee {}", employee);
        return this.employeePersistenceFacade.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        log.debug("findById");
        return this.employeePersistenceFacade.findById(id);
    }
}
