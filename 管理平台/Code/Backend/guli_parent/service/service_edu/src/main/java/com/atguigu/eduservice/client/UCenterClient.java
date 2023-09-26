package com.atguigu.eduservice.client;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.UcenterMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@Component
@FeignClient("service-ucenter")
public interface UCenterClient {
    @PostMapping("/educenter/member/login")
    public R loginUser(@RequestBody UcenterMember member);
}


