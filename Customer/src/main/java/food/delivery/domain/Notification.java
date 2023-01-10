package food.delivery.domain;

import food.delivery.domain.Notificatied;
import food.delivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Notification_table")
@Data

public class Notification  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String menuInfo;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String menuInfo;
    
    
    
    
    
    private String deliveryStatus;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String riderId;
    
    
    
    
    
    private String orderId;

    @PostPersist
    public void onPostPersist(){


        Notificatied notificatied = new Notificatied(this);
        notificatied.publishAfterCommit();

    }

    public static NotificationRepository repository(){
        NotificationRepository notificationRepository = CustomerApplication.applicationContext.getBean(NotificationRepository.class);
        return notificationRepository;
    }




    public static void orderInfoTransfer(KakaoNotified kakaoNotified){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(kakaoNotified.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }


}
