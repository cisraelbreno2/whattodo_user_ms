package br.com.user_ms.infra.controller;

import br.com.user_ms.domain.port.UserModifyPort;
import br.com.user_ms.domain.port.UserRegisterPort;
import br.com.user_ms.domain.port.model.UserModifyRequest;
import br.com.user_ms.domain.port.model.UserModifyResponse;
import br.com.user_ms.domain.port.model.UserRegisterRequest;
import br.com.user_ms.domain.port.model.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserModifyPort userModifyPort;
    private final UserRegisterPort userRegisterPort;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest userRegisterRequest){
        return new ResponseEntity<>(userRegisterPort.register(userRegisterRequest), HttpStatus.OK);
    }

    @PostMapping("/modify")
    public ResponseEntity<UserModifyResponse> register(@RequestBody UserModifyRequest userModifyRequest){
        return new ResponseEntity<>(userModifyPort.modify(userModifyRequest), HttpStatus.OK);
    }
}
