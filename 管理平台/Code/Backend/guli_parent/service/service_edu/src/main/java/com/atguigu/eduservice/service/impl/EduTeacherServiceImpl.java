package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.*;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public Integer countRegisterDay(String day) {
        return baseMapper.countRegisterDay(day);
    }

    @Override
    public Integer CountProvince(Integer province) {
        return baseMapper.CountProvince(province);
    }

    @Override
    public Integer CountShandongProvince(Integer sd) {
        return baseMapper.CountShandongProvince(sd);
    }

    @Override
    public Integer CountEveryProvince(Integer injury, String province) {
        return baseMapper.CountEveryProvince(injury,province);
    }

    @Override
    public CountProvince EveryProvinceInjuryTotal() {
        return baseMapper.EveryProvinceInjuryTotal();
    }

    @Override
    public List<CountProvince> EveryProvinceInjury() { return baseMapper.EveryProvinceInjury(); }
    @Override
    public List<CountAvatar> EveryAvatarInjury() { return baseMapper.EveryAvatarInjury(); }
    @Override
    public List<CountGender> EveryGenderInjury() { return baseMapper.EveryGenderInjury(); }
    @Override
    public List<CountLevel> EveryLevelInjury() { return baseMapper.EveryLevelInjury(); }
    @Override
    public List<CountCareer> EveryCareerInjury() { return baseMapper.EveryCareerInjury(); }
    @Override
    public List<CountInjury> EveryInjury() { return baseMapper.EveryInjury(); }
    @Override
    public List<CountBeInjury> EveryBeInjury() { return baseMapper.EveryBeInjury(); }
    @Override
    public List<CountAgeInjury> EveryAgeInjury() { return baseMapper.EveryAgeInjury(); }
    @Override
    public List<CountInsurance> EveryInsurance() { return baseMapper.EveryInsurance(); }
    @Override
    public List<CountAvatarBuyInsurance> EveryAvatarBuyInsurance() { return baseMapper.EveryAvatarBuyInsurance(); }

    @Override
    public List<CountMonth>EveryMonthInjury() { return baseMapper.EveryMonthInjury(); }

    @Override
    public List<CountMonth>EveryMonthBuyInsurance() { return baseMapper.EveryMonthBuyInsurance(); }

    @Override
    public List<CountInsurance>EveryInjuryInsurance() { return baseMapper.EveryInjuryInsurance(); }
    
    @Override
    public List<CountAvatar>EveryAvatarInjuryAll() { return baseMapper.EveryAvatarInjuryAll(); }

    @Override
    public List<CountInsurancePlan>EveryInsurancePlan() { return baseMapper.EveryInsurancePlan(); }

    @Override
    public List<CountInsurancePlan>EveryInsuranceBeInjury() { return baseMapper.EveryInsuranceBeInjury(); }

    @Override
    public List<CountAvatar>EveryUserAge(String insurance) { return baseMapper.EveryUserAge(insurance); }
    @Override
    public List<CountAvatar>EveryUserGender(String insurance) { return baseMapper.EveryUserGender(insurance); }
    @Override
    public List<CountAvatar>EveryUserAvatar(String insurance) { return baseMapper.EveryUserAvatar(insurance); }

    @Override
    public List<CountAvatar>EveryUserInjury(String insurance) { return baseMapper.EveryUserInjury(insurance); }

    @Override
    public List<CountAvatar>UserCommend(String gender,String avatar,String province,String sta) { return baseMapper.UserCommend(gender,avatar,province,sta); }
    @Override
    public List<CountAvatar>MadeChart(String level,String gender,String avatar,String be_injured,String injury,String province,String injured_scene,String insurance,String category) { return baseMapper.MadeChart(level,gender,avatar,be_injured,injury,province,injured_scene,insurance,category); }
}
