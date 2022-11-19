package com.example.lab2.controller;

import com.example.lab2.entity.Session;
import com.example.lab2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SessionController {
    private SessionService sessionService;

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sessions")
    String editSessions(Model model) {
        model.addAttribute("sessionList", sessionService.getAllSessions());
        return "sessions";
    }

    @GetMapping("/sessions/show")
    public String addBuyerForm(Model model) {
        model.addAttribute("sess", new Session());
        model.addAttribute("sessionId", new Session().getId());
        return "sessions";
    }

    @RequestMapping("/sessions/add")
    public String showBuyerPager(Model model) {
        List<Session> sessions = sessionService.getAllSessions();
        model.addAttribute("sessions", sessions);
        model.addAttribute("sess", new Session());
        return "sessions";
    }

    @PostMapping("/sessions/add")
    public String postBuyerForm(@ModelAttribute("sess") Session session, Model model) {
        sessionService.saveSession(session);
        model.addAttribute("sess", new Session());
        return "redirect:/sessions";
    }

    @PostMapping("/sessions/delete/{id}")
    public String deleteSession(@PathVariable int id) {
        sessionService.deleteSession(id);
        return "redirect:/sessions";
    }
}
