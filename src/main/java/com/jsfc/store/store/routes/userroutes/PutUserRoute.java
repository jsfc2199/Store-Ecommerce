package com.jsfc.store.store.routes.userroutes;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.usecases.userusecases.PutUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutUserRoute {

    @Bean
    public RouterFunction<ServerResponse> updateAnUser(PutUserUseCase putUserUseCase){
        return route(PUT("api/user/update-user").and(accept(MediaType.APPLICATION_JSON)), request ->
                request.bodyToMono(UserDto.class)
                        .flatMap(userDto -> putUserUseCase.updateUser(userDto))
                        .flatMap(userDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(userDto))
                        .onErrorResume(error->ServerResponse.status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(error.getMessage())));
    }
}
