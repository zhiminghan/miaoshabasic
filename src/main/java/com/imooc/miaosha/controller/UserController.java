package com.imooc.miaosha.controller;

import com.imooc.miaosha.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	MiaoshaUserService userService;
	
	@Autowired
	RedisService redisService;
	
    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoshaUser> info(MiaoshaUser user) {

        redisService.set(UserKey.getById,String.valueOf(user.getId()),user);
        return Result.success(user);
    }

    @RequestMapping("/index")
    @ResponseBody
    public String info() {

        return "hello world";
    }
    
}
