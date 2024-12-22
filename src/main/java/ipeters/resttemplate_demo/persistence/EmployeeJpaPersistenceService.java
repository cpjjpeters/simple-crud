package ipeters.resttemplate_demo.persistence;

import ipeters.resttemplate_demo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeJpaPersistenceService implements EmployeePersistenceFacade {
    @Autowired
    EmployeeJpaDaoMapper employeeJpaDaoMapper;
    @Autowired
      EmployeeJpaRepository employeeJpaRepository;



    @Override
    public Employee save(Employee employee) {
        final EmployeeJpaEntity employeeJpaEntity = this.employeeJpaRepository.save(employeeJpaDaoMapper.modelToJpaEntity(employee));
        log.debug("Employee JPA = {}", employeeJpaEntity.getName());
        return this.employeeJpaDaoMapper.jpaEntityToModel(employeeJpaEntity);
    }

    @Override
    public List<Employee> findAll() {

        return this.employeeJpaRepository.findAll()
                .stream()
                .map(employeeJpaEntity -> this.employeeJpaDaoMapper.jpaEntityToModel(employeeJpaEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findById(Long id) {

        return this.employeeJpaRepository.findById(id)
                .flatMap(employeeJpaEntity -> Optional.of(this.employeeJpaDaoMapper.jpaEntityToModel(employeeJpaEntity)));
    }

    public void deleteAll() {
        this.employeeJpaRepository.deleteAll();
    }

    @Override
    public void delete(Employee employee) {
        this.employeeJpaRepository.delete(this.employeeJpaDaoMapper.modelToJpaEntity(employee));
    }

    @Override
    public void deleteById(Long id) {
        this.employeeJpaRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {

        return this.employeeJpaDaoMapper.jpaEntityToModel(this.employeeJpaRepository.save(this.employeeJpaDaoMapper.modelToJpaEntity(employee)));
    }

    @Override
    public Employee findByEmployeeId(long theId) {
        return this.employeeJpaDaoMapper.jpaEntityToModel(this.employeeJpaRepository.findByEmployeeId(theId));
    }
}
