package ipeters.resttemplate_demo.persistence;

import ipeters.resttemplate_demo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Bean;

@Mapper (componentModel = "spring")//(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EmployeeJpaDaoMapper {
    EmployeeJpaEntity modelToJpaEntity(Employee employee);

    Employee jpaEntityToModel(EmployeeJpaEntity employeeJpaEntity);
}
