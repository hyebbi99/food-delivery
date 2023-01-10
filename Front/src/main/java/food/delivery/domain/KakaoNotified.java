package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class KakaoNotified extends AbstractEvent {

    private Long id;

    public KakaoNotified(Order aggregate){
        super(aggregate);
    }
    public KakaoNotified(){
        super();
    }
}
