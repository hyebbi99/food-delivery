package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryFinished extends AbstractEvent {

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
}


