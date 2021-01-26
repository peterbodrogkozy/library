package com.epam.training.imagine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements BusinessEntity<Long>, Serializable {

	private static final long serialVersionUID = 6726189393642295288L;

	@Id
    @GeneratedValue
    @Column(unique = true, name = "ID")
    private Long id;

    @Column(unique = true, nullable = false, name = "TITLE")
    private String title;

    @Column(unique = true, nullable = false, name = "AMOUNT")
    private Integer amount;

    public Book() { }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
