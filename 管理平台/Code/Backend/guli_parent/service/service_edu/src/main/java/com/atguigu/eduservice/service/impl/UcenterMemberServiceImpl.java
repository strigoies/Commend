package com.atguigu.eduservice.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5;
import com.atguigu.eduservice.entity.UcenterMember;
import com.atguigu.eduservice.entity.vo.RegisterVo;
import com.atguigu.eduservice.mapper.UcenterMemberMapper;
import com.atguigu.eduservice.service.UcenterMemberService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-05-21
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

        @Autowired
        private RedisTemplate<String,String> redisTemplate;
        //登录的方法
        @Override
        public String login(UcenterMember member) {
            //获取登录手机号和密码
            String mobile = member.getMobile();
            String password = member.getPassword();

            //手机号和密码非空判断
            if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
                throw new GuliException(20001,"登录失败");
            }

            //判断手机号是否正确
            QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
            wrapper.eq("mobile",mobile);
            UcenterMember mobileMember = baseMapper.selectOne(wrapper);
            //判断查询对象是否为空
            if(mobileMember == null) {//没有这个手机号
                throw new GuliException(20001,"登录失败");
            }

            //判断密码
            //因为存储到数据库密码肯定加密的
            //把输入的密码进行加密，再和数据库密码进行比较
            //加密方式 MD5
            System.out.println(mobileMember.getPassword());
            if(!password.equals(mobileMember.getPassword())) {
                throw new GuliException(20001,"登录失败");
            }

            //判断用户是否禁用
            if(mobileMember.getIsDisabled()) {
                throw new GuliException(20001,"登录失败");
            }

            //登录成功
            //生成token字符串，使用jwt工具类
            String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());
            return jwtToken;
        }

        //注册的方法
        @Override
        public void register(RegisterVo registerVo) {
            //获取注册的数据
            //String code = registerVo.getCode(); //验证码
            String mobile = registerVo.getMobile(); //手机号
            String nickname = registerVo.getNickname(); //昵称
            String password = registerVo.getPassword(); //密码
            String avatar = registerVo.getAvatar();
            Integer age = registerVo.getAge();
            Integer sex = registerVo.getSex();
            //非空判断
            if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)
                    || StringUtils.isEmpty(nickname)) {
                throw new GuliException(20001,"注册失败");
            }
            //判断验证码
            //获取redis验证码
//        String redisCode = redisTemplate.opsForValue().get(mobile);
//        if(!code.equals(redisCode)) {
//            throw new GuliException(20001,"注册失败");
//        }

            //判断手机号是否重复，表里面存在相同手机号不进行添加
            QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
            wrapper.eq("mobile",mobile);
            Integer count = baseMapper.selectCount(wrapper);
            if(count > 0) {
                throw new GuliException(20001,"注册失败");
            }

            //数据添加数据库中
            UcenterMember member = new UcenterMember();
            member.setMobile(mobile);
            member.setNickname(nickname);
            member.setPassword(password);//密码需要加密的
            member.setIsDisabled(false);//用户不禁用
            member.setAvatar(avatar);
            member.setSex(sex);
            member.setAge(age);
            baseMapper.insert(member);
        }

}

