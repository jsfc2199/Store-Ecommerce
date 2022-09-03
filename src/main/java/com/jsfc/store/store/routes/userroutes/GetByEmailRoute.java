package com.jsfc.store.store.routes.userroutes;

import com.jsfc.store.store.usecases.userusecases.GetByEmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetByEmailRoute {

    @Bean
    public RouterFunction<ServerResponse> getUserByEmail(GetByEmailUseCase getByEmailUseCase){
        return route(GET("/api/user/get-by-email/{email}"),
                request -> getByEmailUseCase.getByEmail(request.pathVariable("email"))
                        .flatMap(userDto -> ServerResponse.status(HttpStatus.FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(userDto))
                        .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue("User not found")));
    }
}
