package education.cursor.movies.controller;

import com.fasterxml.jackson.annotation.JsonView;
import education.cursor.movies.model.Movie;
import education.cursor.movies.model.Views;
import education.cursor.movies.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
@Secured("ROLE_ADMIN")
public class AdminController {

    private final MovieService movieService;

    @PostMapping("movie")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @JsonView(Views.ShortMovie.class)
    public Movie create(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @DeleteMapping("movie/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public void delete(@PathVariable("id") Movie movie) {
        movieService.delete(movie);
    }

    @PostMapping("movie/{id}")
    @JsonView(Views.ShortMovie.class)
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public Movie update(@PathVariable("id") Movie movieFromDb, @RequestBody Movie movie) {
        return movieService.update(movieFromDb, movie);
    }
}
