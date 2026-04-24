package br.com.catalogo.infrastructure.messaging;

import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.infrastructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicarProdutoCriado(ProdutoResponse produto) {
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE_CATALOGO, 
            "produto.evento.criado", 
            produto
        );
    }
}
