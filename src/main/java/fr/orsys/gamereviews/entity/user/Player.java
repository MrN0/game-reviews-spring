package fr.orsys.gamereviews.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.orsys.gamereviews.entity.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString(callSuper = true)

@Entity
public class Player extends User {

    private LocalDate birthDate;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "player")
    private List<Review> reviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(birthDate, player.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthDate);
    }

}
