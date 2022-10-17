package com.jsfc.store.store.routes.productroutes;

import com.jsfc.store.store.dto.ProductDto;
import com.jsfc.store.store.usecases.productusecases.PutProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutProductRoute {

    @Bean
    public RouterFunction<ServerResponse> updateProductFromApi(PutProductUseCase putProductUseCase) {
        return route(PUT("api/user/update-user").and(accept(MediaType.APPLICATION_JSON)), request ->
                request.bodyToMono(ProductDto.class)
                        .flatMap(productDto -> putProductUseCase.updateProduct(productDto))
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(error.getMessage())));
    }
}
