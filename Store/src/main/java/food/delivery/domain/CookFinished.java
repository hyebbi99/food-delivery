package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String menuInfo;
    private String address;
    private Integer qty;
    private String deliveryStatus;
    private String storeId;

    public CookFinished(StoreOrder aggregate){
        super(aggregate);
    }
    public CookFinished(){
        super();
    }
}
