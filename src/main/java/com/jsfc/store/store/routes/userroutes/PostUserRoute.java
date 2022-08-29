package com.jsfc.store.store.routes.userroutes;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.usecases.userusecases.PostUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostUserRoute {

    //This functions uses the route and accept a json media type. Then the request is convert to a dto, and with that dto we create the user.
    //after that with the dto we return a created statud and returning the object
    @Bean
    public RouterFunction<ServerResponse> createAnUser(PostUserUseCase postUserUseCase) {
       String myError = """
                Some of the fields that you are sending could be matching with the ones of another user.
                                                                
                Please check the fields that you are sending us following the next steps:
                                                                
                For the name, at least a name with two letters, it can be a full name or just two letters
                For the cellphone number, You can put the country's code like '+57' or not (max length after the +, 3 numbers), and then the phone number (max length 18 numbers after the country code)
                For the passport id, it can have numbers are letters, minimum 8 characters and maximum 20
                For the email, the structure could be 'example123@example.com'
                For the password, needs to have at least:
                    - one lowercase letter
                    - one uppercase letter
                    - one number
                    - one special character
                    - At least 8 characters
                """;

        return route(POST("/api/user/create-user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(postUserUseCase::createUser)
                        .flatMap(userDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(userDto))

                        .onErrorResume(
                                error -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(error.getMessage())));
    }
}
