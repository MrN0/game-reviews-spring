package fr.orsys.gamereviews.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record SignUpForm(

        @NotBlank(message = "{login.pseudonym.null}")
        @Size(min = 3, max = 64, message = "{login.pseudonym.size}")
        String pseudonym,

        @NotBlank(message = "{login.email.null}")
        @Size(min = 3, max = 255, message = "{login.email.size}")
        String email,

        @NotBlank(message = "{login.password.null}")
        @Size(min = 8, max = 128, message = "{login.password.size}")
        String password,

        @NotBlank(message = "{login.birthDate.null}")
        LocalDate birthDate

) {}
