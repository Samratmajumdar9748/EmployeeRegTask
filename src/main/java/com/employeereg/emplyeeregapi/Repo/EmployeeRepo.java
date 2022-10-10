package com.employeereg.emplyeeregapi.Repo;

import com.employeereg.emplyeeregapi.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {

}
