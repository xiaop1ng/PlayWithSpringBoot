package com.xiaoping.dao;

import com.xiaoping.entity.ContractTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;


@Repository
@Table(name = "contract_template")
public interface ContractTemplateDao extends CrudRepository<ContractTemplate, Long> {

}
