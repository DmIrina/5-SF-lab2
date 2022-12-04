package com.example.lab2.controller;

import com.example.lab2.entity.Session;
import com.example.lab2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class SessionController {
    private SessionService sessionService;

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sessions")
    String showSessionList(Model model) {
        model.addAttribute("sessionList", sessionService.getAllSessions());
        return "sessions";
    }

    @GetMapping("/sessions/add")
    public String addSession(Model model) {
        Session newSession = new Session();
        model.addAttribute("newSession", newSession);
        return "add";
    }

    @PostMapping("/sessions/add")
    public String saveSession(@ModelAttribute("newSession") Session newSession) {
        sessionService.saveSession(newSession);
        return "redirect:/sessions";
    }

    @RequestMapping("/sessions")
    public String deleteSession(@ModelAttribute(value="deletedSession") Session delSess) {
        sessionService.deleteSession(delSess.getId());
        return "redirect:sessions";
    }
}
