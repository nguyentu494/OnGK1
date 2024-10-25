/*
 * @ (#) Experience.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthigk1.entities;

import com.example.onthigk1.enums.Roles;
import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 24/10/2024
 * @version: 1.0
 */
@Entity
@Table(name = "experience")
@NamedQueries({

})
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "work_description")
    private String workDescription;
    @Column(name = "company_name")
    private String companyName;
    @Enumerated
    @Column(name = "roles")
    private Roles roles;
    @ManyToOne
    private Candidate candidate;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Experience() {
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", workDescription='" + workDescription + '\'' +
                ", companyName='" + companyName + '\'' +
                ", roles='" + roles + '\'' +
                ", candidate=" + candidate +

                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
