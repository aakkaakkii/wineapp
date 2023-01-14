package com.wine.userservice.controller;

import com.wine.userservice.controller.util.ApiPageParams;
import com.wine.userservice.api.model.UserResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/users")
public class UserInternalController {

    @GetMapping
    @ApiOperation(value = "Get all users batch")
    @ApiPageParams
    public Page<UserResponse> findUsers(@RequestParam Integer size, @RequestParam Integer page){
        final PageRequest pageRequest = PageRequest.of(page, size);

//        final Page<UserResponse> userResponsePage =;
//        return userResponsePage;
        return null;
    }
}
