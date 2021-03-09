package com.restApi2.RestfulWebServices2.Versioning;

import org.springframework.web.bind.annotation.GetMapping;

public class PersonVersioningController {

    @GetMapping("/person1")
    public Person1 person1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping("/person2")
    public Person2 person2() {
        return new Person2(new Name("Daminee", "Saini"));
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public Person1 param1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public Person2 param2() {
        return new Person2(new Name("Daminee", "Saini"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public Person1 header1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public Person2 header2() {
        return new Person2(new Name("Daminee", "Saini"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public Person1 produces1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public Person2 produces2() {
        return new Person2(new Name("Daminee", "Saini"));
    }
}
