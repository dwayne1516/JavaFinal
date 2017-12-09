package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tweet {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Size(max = 140)
    private String content;

    @NotNull
    @Size(min = 1)
    private String sentby;

    @DateTimeFormat(pattern = "")
    private String posteddate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentby() {
        return sentby;
    }

    public void setSentby(String sentby) {
        this.sentby = sentby;
    }

    public String getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(String posteddate) {
        this.posteddate = posteddate;
    }
}

