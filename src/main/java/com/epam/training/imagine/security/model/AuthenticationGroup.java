package com.epam.training.imagine.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AuthenticationGroup {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "AUTH_GROUP")
    private String authGroup;

    public AuthenticationGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationGroup that = (AuthenticationGroup) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(authGroup, that.authGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, authGroup);
    }

    @Override
    public String toString() {
        return "AuthenticationGroup{" +
                "id=" + id +
                ", personName='" + userName + '\'' +
                ", authGroup='" + authGroup + '\'' +
                '}';
    }
}
