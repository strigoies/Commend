package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.*;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**

 *
 * @author testjava
 * @since 2020-02-24
 */
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

    Integer countRegisterDay(String day);

    Integer CountProvince(Integer province);

    Integer CountShandongProvince(Integer sd);

    Integer CountEveryProvince(@Param("injury") Integer injury, @Param("province") String province);

    CountProvince EveryProvinceInjuryTotal();

    List<CountProvince> EveryProvinceInjury();
    List<CountAvatar> EveryAvatarInjury();
    List<CountGender> EveryGenderInjury();

    List<CountLevel> EveryLevelInjury();
    List<CountCareer> EveryCareerInjury();
    List<CountInjury> EveryInjury();
    List<CountBeInjury> EveryBeInjury();
    List<CountAgeInjury> EveryAgeInjury();
    List<CountInsurance> EveryInsurance();
    List<CountAvatarBuyInsurance> EveryAvatarBuyInsurance();
    List<CountMonth>EveryMonthInjury();

    List<CountMonth>EveryMonthBuyInsurance();

    List<CountInsurance>EveryInjuryInsurance();

    List<CountAvatar>EveryAvatarInjuryAll();

    List<CountInsurancePlan>EveryInsurancePlan();

    List<CountInsurancePlan>EveryInsuranceBeInjury();

    List<CountAvatar>EveryUserAge(String insurance);
    List<CountAvatar>EveryUserGender(String insurance);
    List<CountAvatar>EveryUserAvatar(String insurance);

    List<CountAvatar>EveryUserInjury(String insurance);
    List<CountAvatar>UserCommend(String gender,String avatar,String province,String sta);
    List<CountAvatar> MadeChart(String level,String gender,String avatar,String be_injured,String injury,String province,String injured_scene,String insurance,String category);

}
