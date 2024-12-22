package ipeters.resttemplate_demo.persistence;

import ipeters.resttemplate_demo.model.Employee;
import ipeters.resttemplate_demo.persistence.EmployeeJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Bean;

@Mapper //(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EmployeeJpaDaoMapper {
    EmployeeJpaEntity modelToJpaEntity(Employee employee);

    Employee jpaEntityToModel(EmployeeJpaEntity employeeJpaEntity);
}
