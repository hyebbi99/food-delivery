package food.delivery.infra;

import food.delivery.domain.*;
import food.delivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderInfoViewHandler {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            OrderInfo orderInfo = new OrderInfo();
            // view 객체에 이벤트의 Value 를 set 함
            orderInfo.setOrderId(ordered.getOrderId());
            orderInfo.setDeliveryStatus("주문되었습니다");
            // view 레파지 토리에 save
            orderInfoRepository.save(orderInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_1(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(orderAccepted.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setDeliveryStatus("주문이 접수되었습니다");
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_2(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(orderRejected.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setDeliveryStatus("주문이 거절되었습니다");
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_3(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(cookStarted.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setDeliveryStatus("음식조리가 시작되었습니다");
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_4(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(cookFinished.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setDeliveryStatus("조리가 완료되었습니다");
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_5(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(deliveryStarted.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setDeliveryStatus("배달이 시작되었습니다");
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryFinished_then_UPDATE_6(@Payload DeliveryFinished deliveryFinished) {
        try {
            if (!deliveryFinished.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(deliveryFinished.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setDeliveryStatus("배달이 완료되었습니다");
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

