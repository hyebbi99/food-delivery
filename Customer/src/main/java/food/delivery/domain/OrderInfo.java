package food.delivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderInfo_table")
@Data
public class OrderInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String menuInfo;
        private String deliveryStatus;
        private String storeId;
        private String qty;
        private String riderId;
        private String orderId;
        private String customerId;


}
