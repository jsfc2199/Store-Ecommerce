package com.jsfc.store.store.routes.productroutes;

import com.jsfc.store.store.dto.ProductDto;
import com.jsfc.store.store.usecases.productusecases.PostProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostProductRoute {

    @Bean
    public RouterFunction<ServerResponse> createProductRoute(PostProductUseCase postProductUseCase){
        return route(POST("/api/product/create-product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(productDto -> postProductUseCase.postProduct(productDto))
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(error.getMessage())));
    }
}
