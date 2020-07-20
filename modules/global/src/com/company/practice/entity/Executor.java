package com.company.practice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamePattern("%s %s %s|fio,department,post")
@Table(name = "PRACTICE_EXECUTOR")
@Entity(name = "practice_Executor")
public class Executor extends StandardEntity {
    private static final long serialVersionUID = -3461906043062711855L;

    @NotBlank(message = "You must enter the name of the executor")
    @NotNull
    @Column(name = "FIO", nullable = false, length = 63)
    protected String fio;

    @NotBlank
    @NotNull
    @Column(name = "POST", nullable = false, length = 63)
    protected String post;

    @NotBlank
    @NotNull
    @Column(name = "DEPARTMENT", nullable = false, length = 63)
    protected String department;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}