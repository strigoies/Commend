package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.UcenterMember;
import com.atguigu.eduservice.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-05-21
 */
public interface UcenterMemberService extends IService<UcenterMember> {
    //登录的方法
    String login(UcenterMember member);

    //注册的方法
    void register(RegisterVo registerVo);
}
