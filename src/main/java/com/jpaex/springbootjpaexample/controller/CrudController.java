package com.jpaex.springbootjpaexample.controller;


import com.jpaex.springbootjpaexample.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final CrudService service;

    @GetMapping("/search")
    public String searchParam(@RequestParam(value = "age") Long age) {
        return service.searchParamMember(age);
    }

    @GetMapping("/searchRepo")
    public String searchRepo(@RequestParam(value = "name") String name) {
        return service.searchParamRepoMember(name);
    }

    @PostMapping("/insert")
    public String insertMember(@RequestParam(value = "name") String name,
                               @RequestParam(value = "age") Long age) {
        return service.insertMember(name, age);
    }

    // patch가 아닌 post인 이유를 찾아봤는데 레거시한 서버나 복잡한 경우는 사용한다더라 ..
    @PostMapping("/update")
    public String updateMember(@RequestParam(value = "name") String name,
                               @RequestParam(value = "age") Long age) {
        return service.updateMember(name, age);
    }


    @DeleteMapping("/delete")
    public String deleteMember(@RequestParam(value = "name") String name) {
        return service.deleteMember(name);
    }

}
