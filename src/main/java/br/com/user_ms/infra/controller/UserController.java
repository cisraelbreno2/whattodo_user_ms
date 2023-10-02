package br.com.user_ms.infra.controller;

import br.com.user_ms.domain.port.FindUserPort;
import br.com.user_ms.domain.port.UserModifyPort;
import br.com.user_ms.domain.port.UserRegisterPort;
import br.com.user_ms.domain.port.model.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserModifyPort userModifyPort;
    private final UserRegisterPort userRegisterPort;
    private final FindUserPort findUserPort;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") String id){
        return new ResponseEntity<>(findUserPort.findById(id), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest userRegisterRequest){
        return new ResponseEntity<>(userRegisterPort.register(userRegisterRequest), HttpStatus.OK);
    }

    @PostMapping("/modify")
    public ResponseEntity<UserModifyResponse> register(@RequestBody UserModifyRequest userModifyRequest){
        return new ResponseEntity<>(userModifyPort.modify(userModifyRequest), HttpStatus.OK);
    }
}
