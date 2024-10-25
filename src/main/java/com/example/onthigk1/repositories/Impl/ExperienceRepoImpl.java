/*
 * @ (#) ExperienceRepoImpl.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthigk1.repositories.Impl;

import com.example.onthigk1.entities.Candidate;
import com.example.onthigk1.entities.Experience;
import com.example.onthigk1.repositories.ExperienceRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 24/10/2024
 * @version: 1.0
 */
public class ExperienceRepoImpl implements ExperienceRepo {
    private static EntityManager em;

    public ExperienceRepoImpl(){
        em = Persistence.createEntityManagerFactory("onThiGK").createEntityManager();
    }

    @Override
    public Experience create(Experience ex) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(ex);
            et.commit();
            return ex;

        }catch (Exception e){
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
