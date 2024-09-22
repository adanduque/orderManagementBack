package com.orderServices.micro_serv_oders.client;

import com.orderServices.micro_serv_oders.client.clientModel.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8087/products").build(); // URL del microservicio de productos
    }

    public Mono<Product> getProductById(Long productId) {
        return this.webClient
                .get()
                .uri("/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class);
 }
    public Mono<List<Product>> getProductsByIds(List<Long> ids) {
        String url = String.join(",", ids.stream().map(String::valueOf).toArray(String[]::new));

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/by-ids")
                        .queryParam("ids", url)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {});
    }
}