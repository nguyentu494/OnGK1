/*
 * @ (#) Candidate.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthigk1.entities;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 24/10/2024
 * @version: 1.0
 */

import com.example.onthigk1.enums.Roles;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "candidate")
@NamedQueries({
        @NamedQuery(name = "Candidate.findAll", query = "select c from Candidate c"),
        @NamedQuery(name = "Candidate.findById", query = "select c from Candidate c where c.id = :id"),
        @NamedQuery(name = "Candidate.findByExperiences_CompanyNameContainsAndExperiences_Roles", query = "select c from Candidate c inner join c.experiences experiences where experiences.companyName like concat('%', :companyName, '%') and experiences.roles = :roles"),
        @NamedQuery(name = "Candidate.findByExperiences_GreaterThan5Years", query = "select  c from Candidate  c inner join c.experiences exper where (exper.toDate-exper.fromDate)/(3600*365*24*1e9)>= 5")
})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String email;
    private String phone;
    @Column(name = "full_name")
    private String  fullName;


    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Experience> experiences;

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }


    public Candidate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
