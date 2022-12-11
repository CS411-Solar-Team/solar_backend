package com.cs411.solar_project.repository;

import com.cs411.solar_project.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
//    Company findByCompanyID(int companyID);
}
