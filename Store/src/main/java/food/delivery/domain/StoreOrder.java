package food.delivery.domain;

import food.delivery.domain.OrderAccepted;
import food.delivery.domain.OrderRejected;
import food.delivery.domain.CookStarted;
import food.delivery.domain.CookFinished;
import food.delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String menuInfo;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String deliveryStatus;
    
    
    
    
    
    private String storeId;

    @PostPersist
    public void onPostPersist(){


        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();



        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }




    public static void orderInfoTransfer(Ordered ordered){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }


}
