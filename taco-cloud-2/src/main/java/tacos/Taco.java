package tacos;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {

    private Long id;
    private Date createdAt;
    
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters")
    private String name;

    @NotNull
    @Size(min = 1, message = "There must be at least 1 ingredient in your Taco")
    private List<Ingredient> ingredients;


}
