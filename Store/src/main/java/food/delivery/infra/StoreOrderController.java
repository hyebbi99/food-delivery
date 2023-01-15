package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/storeOrders")
@Transactional
public class StoreOrderController {
    @Autowired
    StoreOrderRepository storeOrderRepository;



    @RequestMapping(value = "storeOrders/{id}/orderconfirm",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public StoreOrder orderConfirm(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /storeOrder/orderConfirm  called #####");
            Optional<StoreOrder> optionalStoreOrder = storeOrderRepository.findById(id);
            
            optionalStoreOrder.orElseThrow(()-> new Exception("No Entity Found"));
            StoreOrder storeOrder = optionalStoreOrder.get();
            storeOrder.orderConfirm();
            
            storeOrderRepository.save(storeOrder);
            return storeOrder;
            
    }
    






}
