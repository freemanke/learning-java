package com.repository;

import com.entity.Book;
import com.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@Repository
@RepositoryRestResource(path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findByName(String name);
}
