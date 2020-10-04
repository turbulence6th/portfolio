package com.turbulence6th.portfolio.controller;

import com.turbulence6th.portfolio.manager.RequestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class IndexController {

    private RequestManager requestManager;

    @Autowired
    public IndexController(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        String ip = Optional.ofNullable(request.getHeader("X-Forwarded-For"))
                .orElse(request.getRemoteHost());
        requestManager.save(ip);
        return "index.html";
    }
}
