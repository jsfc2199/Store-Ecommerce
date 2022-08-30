package com.jsfc.store.store.routes.userroutes;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.usecases.userusecases.PostUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostUserRoute {

    //This functions uses the route and accept a json media type. Then the request is convert to a dto, and with that dto we create the user.
    //after that with the dto we return a created statud and returning the object
    @Bean
    public RouterFunction<ServerResponse> createAnUser(PostUserUseCase postUserUseCase) {

        return route(POST("/api/user/create-user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(postUserUseCase::createUser)
                        .flatMap(userDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(userDto))

                        .onErrorResume(
                                error -> {
                                    if (error.getClass().equals(DuplicateKeyException.class)) {
                                        return ServerResponse.status(HttpStatus.BAD_REQUEST)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue("Some values are the same from another user, please check the fields and fix them" + "\n\n" + error.getMessage());
                                    }
                                    return ServerResponse.status(HttpStatus.BAD_REQUEST)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue(error.getMessage());
                                }));
    }
}
