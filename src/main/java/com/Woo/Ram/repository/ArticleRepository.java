package com.Woo.Ram.repository;

import com.Woo.Ram.entity.Article;
import com.Woo.Ram.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    @Query("SELECT p from Article p order by p.id desc ")
    ArrayList<Article> findAll();

    @Transactional
    @Modifying
    @Query("update Article p set p.view = p.view + 1 where p.id = :id")
    int updateView(Long id);

}
