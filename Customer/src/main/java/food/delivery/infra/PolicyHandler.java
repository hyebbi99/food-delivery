package food.delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.delivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationRepository notificationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='KakaoNotified'")
    public void wheneverKakaoNotified_OrderInfoTransfer(@Payload KakaoNotified kakaoNotified){

        KakaoNotified event = kakaoNotified;
        System.out.println("\n\n##### listener OrderInfoTransfer : " + kakaoNotified + "\n\n");


        

        // Sample Logic //
        Notification.orderInfoTransfer(event);
        

        

    }

}


