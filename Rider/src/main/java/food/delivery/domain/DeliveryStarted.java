package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String menuId;
    private String customerId;
    private String address;
    private String menuInfo;
    private Integer qty;
    private String deliveryStatus;
    private String storeId;
    private String riderId;
    private String orderId;

    public DeliveryStarted(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
