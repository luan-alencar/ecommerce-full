package com.luan.ecommerce.ecommerce.servico;

import com.luan.ecommerce.ecommerce.servico.dto.EmailDTO;
import com.luan.ecommerce.ecommerce.servico.rabbit.ConsumidorTarget;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableBinding(ConsumidorTarget.class)
public class ConsumidorServico {

    private final EmailServico emailServico;

    @StreamListener(target = ConsumidorTarget.BINDING_MAILER)
    public void sendMail(@Payload EmailDTO emailDTO) {
        log.info("Email recebido {}", emailDTO);
        emailServico.sendEmail(emailDTO);
    }

}