package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
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
}
