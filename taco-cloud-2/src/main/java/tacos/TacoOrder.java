package tacos;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccVV;
    
    private List<Taco> tacos = new ArrayList<>();

    private void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}