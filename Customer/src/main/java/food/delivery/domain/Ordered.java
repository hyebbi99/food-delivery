package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private Integer qty;
    private String address;
    private String deliveryStatus;
    private String storeId;
    private String menuInfo;
}
