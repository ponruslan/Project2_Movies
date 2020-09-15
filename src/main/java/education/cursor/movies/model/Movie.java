package education.cursor.movies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class)
@JsonView(Views.ShortMovie.class)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieCategory category;

    private String director;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    @JsonView(Views.FullMovie.class)
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private List<Rate> rates;

    public double getRate() {
        if (rates.isEmpty()) return 0d;
        else {
            double rate = rates.stream().mapToDouble(Rate::getRate).sum() / rates.size();
            return Double.parseDouble(String.format("%.1f", rate));
        }
    }
}
