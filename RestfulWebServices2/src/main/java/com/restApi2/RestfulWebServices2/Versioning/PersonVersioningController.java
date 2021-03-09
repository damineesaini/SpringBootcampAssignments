package com.restApi2.RestfulWebServices2.Versioning;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    @ApiModelProperty(notes = "URI based versioning v1")
    public Person1 person1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping("/v2/person")
    @ApiModelProperty(notes = "URI based versioning v2")
    public Person2 person2() {
        return new Person2(new Name("Daminee", "Saini"));
    }

    @GetMapping(value = "/person/param", params = "version=1")
    @ApiModelProperty(notes = "param based versioning v1")
    public Person1 param1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    @ApiModelProperty(notes = "param based versioning v2")
    public Person2 param2() {
        return new Person2(new Name("Daminee", "Saini"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    @ApiModelProperty(notes = "header based versioning v1")
    public Person1 header1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    @ApiModelProperty(notes = "header based versioning v2")
    public Person2 header2() {
        return new Person2(new Name("Daminee", "Saini"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    @ApiModelProperty(notes = "MimeType based versioning v1")
    public Person1 produces1() {
        return new Person1("Daminee Saini");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    @ApiModelProperty(notes = "MimeType based versioning v2")
    public Person2 produces2() {
        return new Person2(new Name("Daminee", "Saini"));
    }
}
