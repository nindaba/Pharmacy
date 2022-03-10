package pl.edu.vistula.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.vistula.data.OrderData;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.services.OrderService;

import static pl.edu.vistula.controllers.ControllerConstants.Checkout.Controller;
import static pl.edu.vistula.controllers.ControllerConstants.Checkout.Purchase;
@RestController
@AllArgsConstructor
public class CheckoutController {
    private OrderService orderService;
    @PostMapping(Controller+Purchase)
    public ResponseEntity<SuccessResponse> purchase(@RequestBody OrderData data){
        return ResponseEntity.ok(orderService.purchase(data));
    }
}
