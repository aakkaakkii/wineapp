package com.wine.authservice.controller;

import com.wine.authservice.domain.dto.GroupDto;
import com.wine.authservice.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/groups")
@RequiredArgsConstructor
public class GroupRestController {
    private final GroupService groupService;

    @GetMapping
    public List<GroupDto> loadAll() {
        return groupService.loadAll();
    }

    @GetMapping("/{id}")
    public GroupDto getById(@PathVariable Long id){
        return groupService.getById(id);
    }

    @PostMapping
    public GroupDto add(@RequestBody GroupDto group) {
        return groupService.create(group);
    }

    @PutMapping("/{id}")
    public GroupDto update(@RequestBody GroupDto group) {
        return groupService.update(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        groupService.deleteById(id);
    }
}
