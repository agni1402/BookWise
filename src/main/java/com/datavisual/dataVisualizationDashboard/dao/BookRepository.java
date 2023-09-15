package com.datavisual.dataVisualizationDashboard.dao;

import com.datavisual.dataVisualizationDashboard.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
