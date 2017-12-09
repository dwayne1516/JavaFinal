package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    @Autowired
    TweetRepository tweetRepository;

    @RequestMapping("/")
    public String listTweets(Model model){
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("tweets", tweetRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String tweetForm(Model model){
        model.addAttribute("tweet", new Tweet());
        return "tweetform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Tweet tweet, BindingResult result){
        if (result.hasErrors()){
            return "tweetform";
        }
        tweetRepository.save(tweet);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("tweet", tweetRepository.findOne(id));
        return "show";
    }
    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        tweetRepository.delete(id);
        return "redirect:/";
    }
}