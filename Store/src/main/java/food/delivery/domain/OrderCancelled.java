package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String menuInfo;
    private String address;
    private Integer qty;
    private String deliveryStatus;
    private String storeId;

    public OrderCancelled(StoreOrder aggregate){
        super(aggregate);
    }
    public OrderCancelled(){
        super();
    }
}
