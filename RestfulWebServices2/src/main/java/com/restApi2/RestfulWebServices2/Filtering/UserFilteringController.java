package com.restApi2.RestfulWebServices2.Filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restApi2.RestfulWebServices2.ContentNegotiation.UserNotFoundException;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserFilteringController {

    @Autowired
    private UserStaticFilterService userStaticFilterService;

    @Autowired
    private UserDynamicFilterService userDynamicFilterService;


    @PostMapping("/static")
    @ApiModelProperty(notes = "static filtering of password field , in request body pass name and password")
    public UserStaticFilterBean createUserStaticFilter(@Valid @RequestBody UserStaticFilterBean userStaticFilterBean) throws UserNotFoundException {
        UserStaticFilterBean newUser = userStaticFilterService.createUserStaticFilter(userStaticFilterBean);
        if (newUser == null)
            throw new UserNotFoundException("please do not provide id");
        return newUser;
    }

    @PostMapping("/dynamic")
    @ApiModelProperty(notes = "dynamic filtering of password field , in request body pass name and password")
    public UserDynamicFilterBean createUserDynamicFilter(@Valid @RequestBody UserDynamicFilterBean userDynamicFilterBean) throws UserNotFoundException {
        UserDynamicFilterBean newUser = userDynamicFilterService.createUserDynamicFilter(userDynamicFilterBean);
        if (newUser == null)
            throw new UserNotFoundException("please do not provide id");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userDynamicFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(newUser);
        mappingJacksonValue.setFilters(filters);
        return newUser;
    }
}
