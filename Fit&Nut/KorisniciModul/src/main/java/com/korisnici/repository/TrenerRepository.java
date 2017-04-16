package com.korisnici.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.korisnici.module.Osoba;
import com.korisnici.module.Trener;

@RepositoryRestResource(path="treneri",collectionResourceRel="treneri")
public interface TrenerRepository extends PagingAndSortingRepository<Trener, Integer>{

}
