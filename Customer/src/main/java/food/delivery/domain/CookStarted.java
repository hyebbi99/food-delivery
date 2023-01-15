package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String menuInfo;
    private String address;
    private Integer qty;
    private String deliveryStatus;
    private String storeId;
}
