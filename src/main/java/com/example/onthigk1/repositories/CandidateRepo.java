/*
 * @ (#) CandidateRepo.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthigk1.repositories;

import com.example.onthigk1.entities.Candidate;

import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 24/10/2024
 * @version: 1.0
 */
public interface CandidateRepo {
    Candidate create(Candidate c);
    List<Candidate> findAll();
    Candidate findById(int id);

    List<Candidate> findByCompanyName(String company);
    List<Candidate> findByExperGearterThan5();
    List<Candidate> deleteById(int id);


}
