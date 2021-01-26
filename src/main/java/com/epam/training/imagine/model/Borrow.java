package com.epam.training.imagine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Borrow implements BusinessEntity<Long>, Serializable {

	private static final long serialVersionUID = 3259407635309423200L;

	@Id
    @GeneratedValue
    @Column(unique = true, name = "ID")
    private Long id;

    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    
    @OneToOne
    private Book book;

    public Borrow() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Book getBook() {
        return book;
    }
    
    public User getUser() {
        return user;
    }
}
