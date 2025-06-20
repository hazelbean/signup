package com.task.signup.controller;

import com.task.signup.dto.UserDTO;
import com.task.signup.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new UserDTO());

        return "signup";
    }

    @PostMapping("/signup")
    public void processSignup(@ModelAttribute UserDTO user, HttpServletResponse response) throws IOException {
        String result = userService.registerUser(user);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script>alert('" + result + "'); location.href='/signup';</script>");
    }
}
