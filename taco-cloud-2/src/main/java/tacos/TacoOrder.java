package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placedAt;

    @NotBlank
    private String deliveryName;

    @NotBlank
    private String deliveryStreet;

    @NotBlank
    private String deliveryCity;

    @NotBlank
    private String deliveryState;

    @NotBlank
    private String deliveryZip;

    @Digits(integer = 16, fraction = 0)
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @NotNull
    @Digits(integer = 3, fraction = 0)
    private String ccVV;
    
    private List<Taco> tacos = new ArrayList<>();

    private void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}