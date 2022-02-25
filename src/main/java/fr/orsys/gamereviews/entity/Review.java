package fr.orsys.gamereviews.entity;

import fr.orsys.gamereviews.entity.user.Moderator;
import fr.orsys.gamereviews.entity.user.Player;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Getter
@Setter

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime publicationDateTime;

    private LocalDateTime moderationDateTime;

    @Column(nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Player player;

    @ManyToOne
    private Moderator moderator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
                Objects.equals(description, review.description) &&
                Objects.equals(publicationDateTime, review.publicationDateTime) &&
                Objects.equals(moderationDateTime, review.moderationDateTime) &&
                Objects.equals(score, review.score) &&
                Objects.equals(game, review.game) &&
                Objects.equals(player, review.player) &&
                Objects.equals(moderator, review.moderator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, publicationDateTime, moderationDateTime, score, game, player, moderator);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Review.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("description='" + description + "'")
                .add("publicationDateTime=" + publicationDateTime)
                .add("moderationDateTime=" + moderationDateTime)
                .add("score=" + score)
                .add("game=" + game.getName())
                .add("player=" + player.getPseudonym())
                .add("moderator=" + moderator.getPseudonym())
                .toString();
    }

}
