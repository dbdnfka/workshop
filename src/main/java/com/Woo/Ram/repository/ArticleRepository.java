package com.Woo.Ram.repository;

import com.Woo.Ram.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    @Query("SELECT p from Article p order by p.id desc ")
    ArrayList<Article> findAll();
}
