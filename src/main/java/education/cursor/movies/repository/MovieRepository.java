package education.cursor.movies.repository;

import education.cursor.movies.model.Movie;
import education.cursor.movies.model.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> getAllByCategory(MovieCategory category);
}
