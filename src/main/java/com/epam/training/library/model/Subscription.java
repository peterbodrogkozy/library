package com.epam.training.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription implements BusinessEntity<Long>, Serializable {
	
	private static final long serialVersionUID = -7277658061057518040L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    public Subscription() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }
    
    public User getUser() {
        return user;
    }
}
