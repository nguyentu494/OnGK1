/*
 * @ (#) ControllerServlet.java   1.0     25/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthigk1.controller;

import com.example.onthigk1.entities.Candidate;
import com.example.onthigk1.entities.Experience;
import com.example.onthigk1.enums.Roles;
import com.example.onthigk1.repositories.CandidateRepo;
import com.example.onthigk1.repositories.ExperienceRepo;
import com.example.onthigk1.repositories.Impl.CandidateRepoImpl;
import com.example.onthigk1.repositories.Impl.ExperienceRepoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 25/10/2024
 * @version: 1.0
 */
@WebServlet(name = "controllServlet", value = {"/controller"})
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CandidateRepo candidateRepo = new CandidateRepoImpl();
        switch (action){
            case "candidate":{
                if(req.getParameter("id") == null){
                    req.setAttribute("listNV", candidateRepo.findAll());
                    req.getRequestDispatcher("candidates.jsp").forward(req,resp);
                }else{
                    String id = req.getParameter("id");
                    Candidate c = candidateRepo.findById(Integer.parseInt(id));
                    req.setAttribute("candidate", c);
                    req.getRequestDispatcher("candidate-detail.jsp").forward(req, resp);
                }

            }
            case "report1":{
                req.getRequestDispatcher("report1.jsp").forward(req, resp);
            }
            case "report2":{
                List<Candidate> listCan = candidateRepo.findByExperGearterThan5();
                req.setAttribute("listNV", listCan);
                req.getRequestDispatcher("candidates.jsp").forward(req,resp);
            }
            case "add":{
                    Map<Integer, Roles> listRole = new HashMap<>();
                    for (Roles r : Roles.values()){
                        listRole.put(r.getId(), r.getRole(r.getId()));
                    }
                    req.setAttribute("roles", listRole);
                    req.getRequestDispatcher("add-candidate.jsp").forward(req,resp);
            }
            case "delete":{
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("listNV", candidateRepo.deleteById(id));
                req.getRequestDispatcher("candidates.jsp").include(req,resp);
            }
            default:{
                PrintWriter pw = new PrintWriter("trang-loi.jsp");
                pw.println("Trang nay la trang loi");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1111");
        String action = req.getParameter("action");
        CandidateRepo candidateRepo = new CandidateRepoImpl();
        ExperienceRepo experienceRepo = new ExperienceRepoImpl();
        switch (action){
            case "search":{
                String comName = req.getParameter("txtNV").toString();
                System.out.println(comName);
                List<Candidate> listCan = candidateRepo.findByCompanyName(comName);
                req.setAttribute("listCan", listCan);
                req.getRequestDispatcher("report1.jsp").forward(req, resp);
            }
            case "add":{
                String email = req.getParameter("txtEmail");
                String phone = req.getParameter("txtPhone");
                String name = req.getParameter("txtName");
                LocalDate from = LocalDate.parse(req.getParameter("txtFrom"));
                LocalDate to = LocalDate.parse(req.getParameter("txtTo"));
                String wd = req.getParameter("txtDes");
                String comName = req.getParameter("txtCompany");
                Roles r = null;
                switch (req.getParameter("inputRole")){
                    case "STAFF":{
                        r = Roles.STAFF;
                    }
                }
                Candidate c = new Candidate();
                c.setEmail(email);
                c.setPhone(phone);
                c.setFullName(name);
                Experience experience = new Experience();
                experience.setCandidate(candidateRepo.create(c));
                experience.setWorkDescription(wd);
                experience.setToDate(to);
                experience.setFromDate(from);
                experience.setCompanyName(comName);
                experience.setRoles(r);
                experienceRepo.create(experience);
                resp.sendRedirect("controller?action=candidate");
            }
        }
    }
}
