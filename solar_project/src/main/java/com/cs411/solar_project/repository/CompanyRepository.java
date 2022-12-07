package com.cs411.solar_project.repository;

import com.cs411.solar_project.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByCompanyID(int companyID);
}
