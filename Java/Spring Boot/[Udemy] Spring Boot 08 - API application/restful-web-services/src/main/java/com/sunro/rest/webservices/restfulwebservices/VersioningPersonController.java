package com.sunro.rest.webservices.restfulwebservices;

import com.sunro.rest.webservices.restfulwebservices.model.Name;
import com.sunro.rest.webservices.restfulwebservices.model.PersonV1;
import com.sunro.rest.webservices.restfulwebservices.model.PersonV2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersinPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersinPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/v1/person", params = "version=1")
    public PersonV1 getFirstVersinPersonRequestParameter() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/v1/person", params = "version=2")
    public PersonV1 getSecondVersinPersonRequestParameter() {

        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 GetFirstVersinOfPersonRequestHeader() {

        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfAcceptHerader() {
        return new PersonV1("Bob Charlie");
    }
}
