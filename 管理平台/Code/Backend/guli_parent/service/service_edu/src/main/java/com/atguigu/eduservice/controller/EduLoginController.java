package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
//import com.atguigu.eduservice.client.UCenterClient;
//import com.atguigu.eduservice.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.member;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin  //解决跨域
public class EduLoginController {
    //@Autowired
    //private UCenterClient ucenterClient;
    //login

    @PostMapping("login/{username}/{password}")
    public R login(@PathVariable String username,@PathVariable String password) {


        String n1="admin";
        String k1="admin";
        String n2="manager";
        String k2 = "manager";
        String n3 = "super";
        String k3 = "super";
        String u1="user";
        String ku1="user";
        String u2="client";
        String ku2 = "client";
        System.out.println(username+ "  "+ password);
        if(n1.equals(username)&&k1.equals(password))
        {
            return R.ok().data("token","admin");
        }
        if(n2.equals(username)&&k2.equals(password))
        {
            return R.ok().data("token","admin");
        }
        if(n3.equals(username)&&k3.equals(password))
        {
            return R.ok().data("token","admin");
        }

        return R.error();
    }

    //
    @PostMapping("loginuser/{username}/{password}")
    public R loginuser(@PathVariable String username,@PathVariable String password) {
        String n1="admin";
        String k1="admin";
        String n2="manager";
        String k2 = "manager";
        String n3 = "super";
        String k3 = "super";
        String u1="users";
        String ku1="users";
        String u2="client";
        String ku2 = "client";
        System.out.println(username+ "  "+ password);
        if(n1.equals(username)&&k1.equals(password))
        {
            return R.ok().data("token","admin");
        }
        if(n2.equals(username)&&k2.equals(password))
        {
            return R.ok().data("token","admin");
        }
        if(n3.equals(username)&&k3.equals(password))
        {
            return R.ok().data("token","admin");
        }
        if(u1.equals(username)&&ku1.equals(password))
        {
            return R.ok().data("token","user");
        }
        if(u2.equals(username)&&ku2.equals(password))
        {
            return R.ok().data("token","user");
        }
        return R.error();
    }



    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://tse1-mm.cn.bing.net/th/id/R-C.8c17ead5ae1f06f1b49bf5a54509dedc?rik=RLUpATeUH%2b%2b0wA&riu=http%3a%2f%2fuxren.cn%2fwp-content%2fuploads%2f2016%2f06%2fbaozhu-uxren-wenda-touxiang-00.jpg&ehk=pTZft3veQ4P%2bI663iQlFycT1fjXHrriFY59c8WhsxZM%3d&risl=&pid=ImgRaw&r=0");
    }
   // @Autowired
   // private UcenterMemberService memberService;
//    @GetMapping("info1")
//    public R info1() {
//        String token = memberService.login(member);
//       ucenterClient.loginUser();
//       return R.ok();

    }


