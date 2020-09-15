package education.cursor.movies.controller;

import com.fasterxml.jackson.annotation.JsonView;
import education.cursor.movies.model.Movie;
import education.cursor.movies.model.Views;
import education.cursor.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movie")
public class UserController {

    private final MovieService movieService;
    private final Movie movie;

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

    @GetMapping("category/{id}")
    @JsonView(Views.ShortMovie.class)
    public List<Movie> movieList(@PathVariable("id") Movie movie) {
        return movieService.getAllMovieByCategory(movie);
    }
}