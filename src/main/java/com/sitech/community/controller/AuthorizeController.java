package com.sitech.community.controller;

import com.sitech.community.dto.AccessTokenDTO;
import com.sitech.community.dto.GithubUser;
import com.sitech.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id("c2c04316c1273aafe0d7");
        accessTokenDTO.setClient_secret("645f2209d18a25c40ca774de64a4917468de3144");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user=githubProvider.githubUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }

}
