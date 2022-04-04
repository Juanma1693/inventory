package com.app.inventory.infrastucture.provider.externalservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeingClient(value = "user-api", url = "${user-api}")
public interface UserApiAdapter /*extends UserApiPort*/{

    /*@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    UserDto getAllUsers();*/
}
