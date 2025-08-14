package com.ist412.gameflixauth.controller;

import com.ist412.gameflixauth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    // POST /register
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody Map<String,String> body) {
        String message = userService.register(body.get("username"), body.get("password"));
        Map<String,String> resp = new HashMap<>();
        resp.put("message", message);

        if ("User registered successfully".equals(message)) {
            return ResponseEntity.ok(resp);
        } else { // duplicate or invalid input
            return ResponseEntity.badRequest().body(resp);
        }
    }

    // POST /login
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> body) {
        String message = userService.login(body.get("username"), body.get("password"));
        Map<String,String> resp = new HashMap<>();
        resp.put("message", message);

        if ("Login successful".equals(message)) {
            return ResponseEntity.ok(resp);
        } else {
            return ResponseEntity.status(401).body(resp);
        }
    }
}