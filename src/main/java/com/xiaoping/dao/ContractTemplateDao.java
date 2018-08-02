package com.xiaoping.dao;

import com.xiaoping.entity.ContractTemplate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;


@Repository
@Table(name = "contract_template")
public interface ContractTemplateDao extends CrudRepository<ContractTemplate, Long> {

    @Query(value = "SELECT DISTINCT(template_type) from contract_template", nativeQuery = true)
    public List<String> types();
}
