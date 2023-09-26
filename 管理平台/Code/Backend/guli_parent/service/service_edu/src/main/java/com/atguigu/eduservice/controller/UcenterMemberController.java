package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.UcenterMember;
import com.atguigu.eduservice.entity.vo.RegisterVo;
import com.atguigu.eduservice.service.UcenterMemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-05-21
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/ucenter-member")
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;



    //登录
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
        //member对象封装手机号和密码
        //调用service方法实现登录
        //返回token值，使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token",token);
    }

    //注册
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

    //根据token获取用户信息
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取用户信息
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo",member);
    }
    @PostMapping("updateUser")
    public R updateTeacher(@RequestBody UcenterMember ucenterMember) {
        boolean flag =memberService.updateById(ucenterMember);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                                  @RequestBody(required = false) RegisterVo registerVo) {
        //创建page对象
        Page<UcenterMember> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String mobile = registerVo.getMobile();
        //String password=registerVo.getPassword();
        Integer sex = registerVo.getSex();
        String avatar = registerVo.getAvatar();
        String sign = registerVo.getSign();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(mobile)) {
            wrapper.eq("mobile",mobile);
        }
        if(!StringUtils.isEmpty(sex)) {
            wrapper.le("sex",sex);
        }
        if(!StringUtils.isEmpty(avatar)) {
            wrapper.ge("avatar",avatar);
        }
        if(!StringUtils.isEmpty(sign)) {
            //构建条件
            wrapper.like("sign",sign );
        }
        //排序
       // wrapper.orderByDesc("gmt_create");

        //调用方法实现条件查询分页
        memberService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();//总记录数
        List<UcenterMember> records = pageTeacher.getRecords(); //数据list集合
        return R.ok().data("total",total).data("rows",records);
    }
    @GetMapping("getUser/{id}")
    public R getTeacher(@PathVariable String id) {
        UcenterMember eduTeacher = memberService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }



}

