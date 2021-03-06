package com.luan.ecommerce.ecommerce.servico;

import com.luan.ecommerce.ecommerce.servico.dto.EmailDTO;
import com.luan.ecommerce.ecommerce.servico.rabbit.ProdutorSource;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@EnableBinding(ProdutorSource.class)
@Service
@RequiredArgsConstructor
public class ProdutorServico {

    private final ProdutorSource produtorSource;

    public void enviarEmail(EmailDTO emailDTO) {
        Message<EmailDTO> message = MessageBuilder.withPayload(emailDTO).build();
        produtorSource.enviarEmail().send(message);
    }

}