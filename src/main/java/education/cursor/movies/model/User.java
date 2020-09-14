package education.cursor.movies.model;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;


import javax.persistence.*;

import java.util.Set;


@Data
@Entity
public class User   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.ShortUser.class)
    private Long id;
    @JsonView(Views.ShortUser.class)
    private String username;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}