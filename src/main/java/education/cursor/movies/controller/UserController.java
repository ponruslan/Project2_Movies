package education.cursor.movies.controller;

import com.fasterxml.jackson.annotation.JsonView;
import education.cursor.movies.model.Movie;
import education.cursor.movies.model.Views;
import education.cursor.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movie")
@Secured("ROLE_USER")
public class UserController {

    private final MovieService movieService;

    @GetMapping("all")
    @JsonView(Views.ShortMovie.class)
    public List<Movie> list() {
        return movieService.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMovie.class)
    public Movie getOne(@PathVariable("id") Movie movie) {
        return movie;
    }

}
