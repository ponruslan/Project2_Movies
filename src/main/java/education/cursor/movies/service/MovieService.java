package education.cursor.movies.service;

import education.cursor.movies.model.Movie;
import education.cursor.movies.model.MovieCategory;
import education.cursor.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public Movie update(Movie movieFromDb, Movie movie) {
        String name = movie.getName();
        MovieCategory category = movie.getCategory();
        String director = movie.getDirector();
        String description = movie.getDescription();

        if (name != null) {
            movieFromDb.setName(name);
        }
        if (category != null) {
            movieFromDb.setCategory(category);
        }
        if (director != null) {
            movieFromDb.setDirector(director);
        }
        if (description != null) {
            movieFromDb.setDescription(description);
        }

        return movieRepository.save(movieFromDb);
    }
}
