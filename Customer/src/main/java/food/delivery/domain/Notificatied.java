package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Notificatied extends AbstractEvent {

    private Long id;
    private String menuInfo;
    private String storeId;
    private Integer qty;
    private String riderId;
    private String orderId;
    private String customerId;
    private String deliveryStatus;

    public Notificatied(Notification aggregate){
        super(aggregate);
    }
    public Notificatied(){
        super();
    }
}
