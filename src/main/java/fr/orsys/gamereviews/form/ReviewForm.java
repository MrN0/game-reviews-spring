package fr.orsys.gamereviews.form;

import fr.orsys.gamereviews.entity.Game;
import fr.orsys.gamereviews.entity.user.Player;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

public record ReviewForm(

        @NotNull(message = "{review.score.null}")
        @Range(max = 20, message = "{review.score.range}")
        Integer score,

        @NotBlank(message = "{review.description.null}")
        String description,

        @NotNull(message = "{review.game.null}")
        Game game,

        @NotNull(message = "{review.player.null}")
        Player player,

        @NotNull(message = "{review.publicationDateTime.null}")
        @Past(message = "{review.publicationDateTime.past}")
        LocalDateTime publicationDateTime

) {}
