package com.projectjava.project.controller;

import com.projectjava.project.model.Blog;
import com.projectjava.project.model.Job;
import com.projectjava.project.model.User;
import com.projectjava.project.repository.BlogRepository;
import com.projectjava.project.repository.JobRepository;
import com.projectjava.project.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private BlogRepository blogRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "home";
    }

    @GetMapping("/jobs")
    public String listJobs(Model model) {
        List<Job> listJobs = jobRepo.findAll();
        model.addAttribute("listJobs", listJobs);
        return "jobs";
    }

    @GetMapping("/blogs")
    public String listBlogs(Model model) {
        List<Blog> listBlogs = blogRepo.findAll();
        model.addAttribute("blogs", new Blog());
        model.addAttribute("listBlogs", listBlogs);
        return "blogs";
    }

    @GetMapping("/myjobs")
    public String mylistJobs(Model model) {
        List<Job> mylistJobs = jobRepo.findAll();
        model.addAttribute("listJobs", mylistJobs);
        return "myjobs";
    }

    @PostMapping("/blogs")
    public String blogsSubmit(@ModelAttribute Blog blogs, Model model) {
        model.addAttribute("blogs", blogs);
        return "blogs_succes";
    }



//    @DeleteMapping("/myjobs/{id}")
//    public void deleteEmployee(@PathVariable(value = "id") Long userId)
//            throws ResourceNotFoundException {
//        Job job = job
//
//    }

}
