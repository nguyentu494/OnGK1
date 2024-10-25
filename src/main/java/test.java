/*
 * @ (#) test.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

import com.example.onthigk1.entities.Candidate;
import com.example.onthigk1.entities.Experience;
import com.example.onthigk1.enums.Roles;
import com.example.onthigk1.repositories.CandidateRepo;
import com.example.onthigk1.repositories.ExperienceRepo;
import com.example.onthigk1.repositories.Impl.CandidateRepoImpl;
import com.example.onthigk1.repositories.Impl.ExperienceRepoImpl;
import net.datafaker.Faker;

import java.time.LocalDate;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 24/10/2024
 * @version: 1.0
 */
public class test {
//    public static void main(String[] args) {
//        CandidateRepo c = new CandidateRepoImpl();
//        ExperienceRepo e = new ExperienceRepoImpl();
//        Faker f = new Faker();
//        for(int i  = 0; i < 3; i++){
//            Candidate ca = new Candidate();
//            Experience exp = new Experience();
//
//            exp.setCompanyName(f.company().name());
//            LocalDate from = f.date().birthdayLocalDate();
//            exp.setFromDate(from);
//            exp.setToDate(from.plusDays(i));
//            exp.setWorkDescription(f.job().title());
//
//            ca.setEmail(f.internet().emailAddress());
//            ca.setFullName(f.name().fullName());
//            ca.setPhone(f.phoneNumber().phoneNumberInternational());
//            exp.setRoles(Roles.STAFF);
//
//            exp.setCandidate(c.create(ca));
//            e.create(exp);
//        }
//    }
}
