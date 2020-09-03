package education.cursor.movies.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MovieCategory {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    HISTORY("History"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    WESTERN("Western"),
    CRIME_THRILLER("Crime Thriller"),
    DISASTER_THRILLER("Disaster Thriller"),
    PSYCHOLOGICAL_THRILLER("Psychological Thriller"),
    CRIME("Crime"),
    TECHNO_THRILLER("Techno Thriller");

    private final String name;

    MovieCategory(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

}
