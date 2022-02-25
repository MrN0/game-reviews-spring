package fr.orsys.gamereviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.orsys.gamereviews.entity.user.Moderator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    private String picture;

    @ManyToOne
    private Classification classification;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private BusinessModel businessModel;

    @ManyToOne
    private Moderator moderator;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "games_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private List<Platform> platforms;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(name, game.name) &&
                Objects.equals(description, game.description) &&
                Objects.equals(releaseDate, game.releaseDate) &&
                Objects.equals(picture, game.picture) &&
                Objects.equals(classification, game.classification) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(publisher, game.publisher) &&
                Objects.equals(businessModel, game.businessModel) &&
                Objects.equals(moderator, game.moderator) &&
                Objects.equals(platforms, game.platforms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, releaseDate, picture, classification,
                genre, publisher, businessModel, moderator, platforms);
    }

}
