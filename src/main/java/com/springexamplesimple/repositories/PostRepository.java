package com.springexamplesimple.repositories;
import com.springexamplesimple.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Article, Long> {
}
