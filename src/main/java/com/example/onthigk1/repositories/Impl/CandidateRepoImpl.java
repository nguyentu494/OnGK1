/*
 * @ (#) CandidateRepoImpl.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthigk1.repositories.Impl;

import com.example.onthigk1.entities.Candidate;
import com.example.onthigk1.enums.Roles;
import com.example.onthigk1.repositories.CandidateRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 24/10/2024
 * @version: 1.0
 */
public class CandidateRepoImpl implements CandidateRepo {

    private static EntityManager em;

    public CandidateRepoImpl(){
        em = Persistence.createEntityManagerFactory("onThiGK").createEntityManager();
    }

    @Override
    public Candidate create(Candidate c) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(c);
            et.commit();
            return c;
        }catch (Exception e){
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Candidate> findAll() {
        return em.createNamedQuery("Candidate.findAll", Candidate.class).getResultList();
    }

    @Override
    public Candidate findById(int id) {
        try{
            return em.createNamedQuery("Candidate.findById", Candidate.class).setParameter("id", id).getSingleResult();

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Candidate> findByCompanyName(String company) {
        return em.createNamedQuery("Candidate.findByExperiences_CompanyNameContainsAndExperiences_Roles", Candidate.class).setParameter("companyName", company).setParameter("roles", Roles.STAFF).getResultList();
    }

    @Override
    public List<Candidate> findByExperGearterThan5() {
        return em.createNamedQuery("Candidate.findByExperiences_GreaterThan5Years", Candidate.class).getResultList();
    }

    @Override
    public List<Candidate> deleteById(int id) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.remove(findById(id));
            et.commit();
            return findAll();
        }catch (Exception e){
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        CandidateRepoImpl candidateRepo = new CandidateRepoImpl();
       List<Candidate> c = candidateRepo.findByExperGearterThan5();
        System.out.println(c);
    }
}
