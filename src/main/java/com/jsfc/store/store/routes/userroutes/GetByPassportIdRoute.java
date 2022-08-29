package com.jsfc.store.store.routes.userroutes;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.usecases.userusecases.GetByPassportIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetByPassportIdRoute {

    //this methos receives a passport number in the path, and then if the user exists the methods is going to return the object as a dto
    @Bean
    public RouterFunction<ServerResponse> getUserByPassport(GetByPassportIdUseCase getByPassportIdUseCase) {
        return route(GET("/api/user/get-by-passport/{passport}"),
                request -> getByPassportIdUseCase.getBypassportId(request.pathVariable("passport"))
                        .flatMap(userDto -> ServerResponse.status(HttpStatus.FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(userDto))

                        .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).bodyValue("User not found")));
    }
}
