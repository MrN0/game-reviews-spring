package fr.orsys.gamereviews.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record LoginForm(

        @NotBlank(message = "{login.pseudonym.null}")
        @Size(min = 3, max = 64, message = "{login.pseudonym.size}")
        String pseudonym,

        @NotBlank(message = "{login.password.null}")
        @Size(min = 8, max = 128, message = "{login.password.size}")
        String password

) {}
