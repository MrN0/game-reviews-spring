package fr.orsys.gamereviews.form;

import fr.orsys.gamereviews.entity.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public record GameForm(

        @NotBlank(message = "{game.name.null}")
        @Size(max = 255, message = "{game.name.size}")
        String name,

        @NotBlank(message = "{game.description.null}")
        String description,

        @NotNull(message = "game.releaseDate.null")
        @Past(message = "game.releaseDate.past")
        LocalDate releaseDate,

        @NotBlank(message = "{game.picture.null}")
        @Size(max = 255, message = "{game.picture.size}")
        String picture,

        @NotNull(message = "{game.genre.null}")
        Genre genre,

        @NotNull(message = "{game.classification.null}")
        Classification classification,

        @NotNull(message = "{game.publisher.null}")
        Publisher publisher,

        @NotNull(message = "{game.businessModel.null}")
        BusinessModel businessModel,

        @NotEmpty(message = "{game.platforms.empty}")
        List<Platform> platforms

) {}
