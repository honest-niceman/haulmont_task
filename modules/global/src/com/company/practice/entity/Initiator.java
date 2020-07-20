package com.company.practice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamePattern("%s|fio")
@Table(name = "PRACTICE_INITIATOR")
@Entity(name = "practice_Initiator")
public class Initiator extends StandardEntity {
    private static final long serialVersionUID = 5440667433379520797L;

    @NotBlank(message = "You must enter the name of the initiator")
    @NotNull
    @Column(name = "FIO", nullable = false, length = 63)
    protected String fio;

    @Column(name = "DEPARTMENT", length = 63)
    protected String department;

    @Email(message = "Email address is not valid ")
    @Column(name = "EMAIL", length = 127)
    protected String email;

    @Column(name = "IS_EMPLOYEE")
    protected Boolean isEmployee;

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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