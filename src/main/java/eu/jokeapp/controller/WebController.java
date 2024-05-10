package eu.jokeapp.controller;

import eu.jokeapp.model.Joke;
import eu.jokeapp.model.JokeBook;
import eu.jokeapp.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web-joke")
@RequiredArgsConstructor
public class WebController {

    private final JokeService jokeService;


    @GetMapping
    public String index() {
        return "index";
    }


    @GetMapping("/get-joke-book/{nrOfJokes}")
    public String getJokeBook(@PathVariable("nrOfJokes") Long nrOfJokes, Model model) {
        JokeBook jokeBook = jokeService.getJokeBook(nrOfJokes);
        List<Joke> jokes = jokeBook.getJokes();
        model.addAttribute("jokes", jokes);
        return "joke-book";
    }

}
