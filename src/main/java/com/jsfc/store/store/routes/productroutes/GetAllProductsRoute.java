package com.jsfc.store.store.routes.productroutes;

import com.jsfc.store.store.dto.ProductDto;
import com.jsfc.store.store.usecases.productusecases.GetAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllProductsFromApi(GetAllProductsUseCase getAllProductsUseCase) {
        return route(GET("/api/products/get-all"), request -> ServerResponse.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllProductsUseCase.getAllProducts(), ProductDto.class)
                .onErrorResume(error -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue("Something went wrong while getting the users")));

    }
}
