package tacos.web;

import javax.validation.Valid;
import com.google.inject.internal.Errors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("tacoOrder") TacoOrder tacoOrder, Errors errors, Model model) {
        
        if (errors.hasErrors()) {
            return "orderForm";
        }
        
        log.info("Order submitted: " + tacoOrder);
        return "redirect:/";
    }
}
