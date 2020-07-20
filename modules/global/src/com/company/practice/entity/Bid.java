package com.company.practice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@NamePattern("%s %s %s|initiator,executor,id")
@Table(name = "PRACTICE_BID")
@Entity(name = "practice_Bid")
public class Bid extends StandardEntity {
    private static final long serialVersionUID = -3197547912111002231L;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INITIATOR_ID")
    protected Initiator initiator;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTOR_ID")
    protected Executor executor;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    protected String status;

    @NotBlank
    @Column(name = "DESCRIPTION")
    protected String description;

    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "OPENING_DATE")
    protected Date openingDate;

    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    @Column(name = "CLOSING_DATE")
    protected Date closingDate;

    @Column(name = "IS_APPROVED")
    protected Boolean isApproved;

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public void setStatus(Status status) {
        this.status = status == null ? null : status.getId();
    }

    public Status getStatus() {
        return status == null ? null : Status.fromId(status);
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public Initiator getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

}