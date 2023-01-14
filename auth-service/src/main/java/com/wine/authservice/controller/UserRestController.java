package com.wine.authservice.controller;

import com.wine.authservice.controller.util.ApiPageParams;
import com.wine.authservice.domain.dto.ListWrapper;
import com.wine.authservice.domain.dto.UserDto;
import com.wine.authservice.service.UserService;
import com.wine.authservice.api.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping
    @ApiPageParams
    public ListWrapper<UserDto> loadAll(@RequestParam Integer page, @RequestParam Integer size) {
        final PageRequest pageRequest = PageRequest.of(page, size);

        Page<UserDto> userPage = userService.loadAll(pageRequest);

        return new ListWrapper<UserDto>()
                .setContent(userPage.getContent())
                .setSize(userPage.getSize())
                .setPage(userPage.getPageable().getPageNumber())
                .setTotal(userPage.getTotalElements())
                .setTotalPages(userPage.getTotalPages());
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }


//    @GetMapping("/group/{id}")
//    public List<UserDto> loadByGroup(@PathVariable Long id, @RequestParam int start, @RequestParam Integer limit){
//        return userService.loadByGroup(id, start, limit);
//    }

    @PostMapping
    public UserDto add(@RequestBody UserRequest user)  {
        return userService.create(modelMapper.map(user, UserDto.class));
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserRequest user){
        return userService.update(modelMapper.map(user, UserDto.class));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
