package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personV1() {
        return new PersonV1("Gokul Prathin");
    }

    @GetMapping(value = "v2/person", params = "version=2")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Gokul", "Prathin"));
    }
}
