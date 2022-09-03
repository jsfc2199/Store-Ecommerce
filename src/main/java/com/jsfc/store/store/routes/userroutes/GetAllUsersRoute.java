package com.jsfc.store.store.routes.userroutes;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.usecases.userusecases.GetAllUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllUsersRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllUserFromApi(GetAllUserUseCase getAllUserUseCase) {
        return route(GET("/api/user/get-all"), request -> ServerResponse.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllUserUseCase.getAllUser(), UserDto.class)
                .onErrorResume(error -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue("Something went wrong while getting the users")));
    }
}
