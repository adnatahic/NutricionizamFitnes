package com.korisnici.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.korisnici.module.Parametritreninga;
import com.korisnici.module.Rejting;
import com.sun.xml.bind.v2.model.core.ID;

@RepositoryRestResource(path="parametri",collectionResourceRel="parametri")
public interface ParametritreningaRepository extends PagingAndSortingRepository<Parametritreninga, Long>{

}
