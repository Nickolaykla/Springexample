package com.springexamplesimple.controllers;

import com.springexamplesimple.model.Article;
import com.springexamplesimple.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/article")
    public String blogMain(Model model) {
        Iterable<Article> articles = postRepository.findAll();
        model.addAttribute("articles", articles);
        return "article-main";
    }
    @GetMapping("/article/add")
    public String blogAdd(Model model) {
        return "article-add";
    }

    @PostMapping("/article/add")
    public String articlePostAdd(@RequestParam String title, @RequestParam String fullText, Model model) {
        Article article = new Article(title, fullText);
        postRepository.save(article);
        return "redirect:/article";
    }
    @GetMapping("/article/{id}")
    public String articleDetails(@PathVariable(value ="id") long id, Model model) {
        if(postRepository.existsById(id)) {
            return "redirect:/article";
        }
        Optional<Article> article = postRepository.findById(id);
        ArrayList<Article> list = new ArrayList<>();
        article.ifPresent(list::add);
        model.addAttribute("article", list);
        return "article-details";
    }
}
