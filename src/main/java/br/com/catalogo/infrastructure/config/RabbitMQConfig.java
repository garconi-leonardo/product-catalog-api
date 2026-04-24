package br.com.catalogo.infrastructure.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PRODUTO_CRIADO = "produto.criado.v1";
    public static final String EXCHANGE_CATALOGO = "catalogo.exchange";

    @Bean
    public Queue filaProdutoCriado() {
        return new Queue(FILA_PRODUTO_CRIADO, true);
    }

    @Bean
    public TopicExchange exchangeCatalogo() {
        return new TopicExchange(EXCHANGE_CATALOGO);
    }

    @Bean
    public Binding bindingProdutoCriado(Queue fila, TopicExchange exchange) {
        return BindingBuilder.bind(fila).to(exchange).with("produto.evento.criado");
    }
}
