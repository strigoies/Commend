package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.*;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */
@Api(description="讲师管理")
@RestController
@EnableDiscoveryClient //nacos注册
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    //访问地址： http://localhost:8001/eduservice/teacher/findAll
    //把service注入
    @Autowired
    private EduTeacherService teacherService;



    //2 逻辑删除讲师的方法
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    //4 条件查询带分页的方法
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                                  @RequestBody(required = false)  TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
       // 多条件组合查询
        // mybatis学过 动态sql
        String name = teacherQuery.getName();
        String level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        String avatar = teacherQuery.getAvatar();
        String gender = teacherQuery.getGender();
        String career = teacherQuery.getCareer();
        String province = teacherQuery.getProvince();
        String city = teacherQuery.getCity();
        String country = teacherQuery.getCountry();
        String age = teacherQuery.getAge();
        Integer beInjured = teacherQuery.getBeInjured();
        String beginInjury = teacherQuery.getBegininjury();
        String endInjury = teacherQuery.getEndinjury();
        String injuredScene = teacherQuery.getInjuredScene();
        String insurance = teacherQuery.getInsurance();
        String insurancePlan = teacherQuery.getInsurancePlan();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(beInjured)) {
            wrapper.eq("be_injured",beInjured);
        }
        if(!StringUtils.isEmpty(endInjury)) {
            wrapper.le("gmt_modified",endInjury);
        }
        if(!StringUtils.isEmpty(beginInjury)) {
            wrapper.ge("gmt_modified",beginInjury);
        }
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(gender)) {
            wrapper.eq("gender",gender);
        }
        if(!StringUtils.isEmpty(age)) {
            wrapper.eq("age",age);
        }
        if(!StringUtils.isEmpty(career)) {
            wrapper.eq("career",career);
        }
        if(!StringUtils.isEmpty(city)) {
            wrapper.eq("city",city);
        }
        if(!StringUtils.isEmpty(province)) {
            wrapper.eq("province",province);
        }
        if(!StringUtils.isEmpty(country)) {
            wrapper.eq("country",country);
        }

        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }
        if(!StringUtils.isEmpty(avatar)) {
            //构建条件
            wrapper.like("avatar",avatar);
        }
        if(!StringUtils.isEmpty(injuredScene)) {
            //构建条件
            wrapper.like("injured_scene",injuredScene);
        }
        if(!StringUtils.isEmpty(insurance)) {
            //构建条件
            wrapper.like("insurance",insurance);
        }
        if(!StringUtils.isEmpty(insurancePlan)) {
            //构建条件
            wrapper.like("insurance_plan",insurancePlan);
        }

        //排序
        wrapper.orderByDesc("gmt_create");

        //调用方法实现条件查询分页
        teacherService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();//总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return R.ok().data("total",total).data("rows",records);
    }

    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = teacherService.save(eduTeacher);
        if(save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

    //讲师修改功能
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = teacherService.updateById(eduTeacher);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //查询某一天注册人数
    @GetMapping("countRegister/{day}")
    public R countRegister(@PathVariable String day) {
        Integer count = teacherService.countRegisterDay(day);
        return R.ok().data("countRegister",count);
    }

    @GetMapping("CountProvince/{province}")
    public R CountProvince(@PathVariable Integer province) {
        Integer count = teacherService.CountProvince(province);
        return R.ok().data("CountProvince",count);
    }

    @GetMapping("CountShandongProvince/{sd}")
    public R CountShandongProvince(@PathVariable Integer sd) {
        Integer count = teacherService.CountShandongProvince(sd);
        return R.ok().data("CountShandongProvince",count);
    }

    @GetMapping("CountEveryProvince/{injury}/{province}")
    public R CountEveryProvince(@PathVariable Integer injury,@PathVariable String province) {
        Integer count = teacherService.CountEveryProvince(injury,province);
        return R.ok().data("CountShandongProvince",count);
    }

    @GetMapping("EveryProvinceInjuryTotal")
    private R EveryProvinceInjuryTotal() {
        //QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //wrapper.groupBy("province", "beInjured");

        CountProvince countProvince = teacherService.EveryProvinceInjuryTotal();
        return R.ok();
    }
    //每个省份出险
    @GetMapping("EveryProvinceInjury")
    private R EveryProvinceInjury(){
        List<CountProvince> count = teacherService.EveryProvinceInjury();
        return R.ok().data("EveryProvinceInjury",count);
    }
    //保险种类销售
    @GetMapping("EveryInsurance")
    private R EveryInsurance(){
        List<CountInsurance> count = teacherService.EveryInsurance();
        return R.ok().data("EveryInsurance",count);
    }
    //每个行业保险销售
    @GetMapping("EveryAvatarBuyInsurance")
    private R EveryAvatarBuyInsurance(){
        List<CountAvatarBuyInsurance> count = teacherService.EveryAvatarBuyInsurance();
        return R.ok().data("EveryAvatarBuyInsurance",count);
    }
    //每个行业出险  前六
    @GetMapping("EveryAvatarInjury")
    private R EveryAvatarInjury(){
        List<CountAvatar> count = teacherService.EveryAvatarInjury();
        return R.ok().data("EveryAvatarInjury",count);
    }
    //性别出险
    @GetMapping("EveryGenderInjury")
    private R EveryGenderInjury(){
        List<CountGender> count = teacherService.EveryGenderInjury();
        return R.ok().data("EveryGenderInjury",count);
    }
    //职业类别出险
    @GetMapping("EveryLevelInjury")
    private R EverylevelInjury(){
        List<CountLevel> count = teacherService.EveryLevelInjury();
        return R.ok().data("EveryLevelInjury",count);
    }
    //工种名称出险
    @GetMapping("EveryCareerInjury")
    private R EverycareerInjury(){
        List<CountCareer> count = teacherService.EveryCareerInjury();
        return R.ok().data("EveryCareerInjury",count);
    }
    //伤情出险
    @GetMapping("EveryInjury")
    private R EveryInjury(){
        List<CountInjury> count = teacherService.EveryInjury();
        return R.ok().data("EveryInjury",count);
    }
    //出险和不出险统计
    @GetMapping("EveryBeInjury")
    private R EveryBeInjury(){
        List<CountBeInjury> count = teacherService.EveryBeInjury();
        return R.ok().data("EveryBeInjury",count);
    }
    //年龄出险
    @GetMapping("EveryAgeInjury")
    private R EveryAgeInjury(){
        List<CountAgeInjury> count = teacherService.EveryAgeInjury();
        return R.ok().data("EveryAgeInjury",count);
    }
    //月份平均出险
    @GetMapping("EveryMonthInjury")
    private R EveryMonthInjury(){
        List<CountMonth> count = teacherService.EveryMonthInjury();
        return R.ok().data("EveryMonthInjury",count);
    }
    //月份平均购买保险
    @GetMapping("EveryMonthBuyInsurance")
    private R EveryMonthBuyInsurance(){
        List<CountMonth> count = teacherService.EveryMonthBuyInsurance();
        return R.ok().data("EveryMonthBuyInsurance",count);
    }
    //保险种类理赔
    @GetMapping("EveryInjuryInsurance")
    private R EveryInjuryInsurance(){
        List<CountInsurance> count = teacherService.EveryInjuryInsurance();
        return R.ok().data("EveryInjuryInsurance",count);
    }
    //每个行业出险 全部行业
    @GetMapping("EveryAvatarInjuryAll")
    private R EveryAvatarInjuryAll(){
        List<CountAvatar> count = teacherService.EveryAvatarInjuryAll();
        return R.ok().data("EveryAvatarInjuryAll",count);
    }
    //每个保险种类方案占比
    @GetMapping("EveryInsurancePlan")
    private R EveryInsurancePlan(){
        List<CountInsurancePlan> count = teacherService.EveryInsurancePlan();
        //之后总条数加1
        Object[][] countPlan1 = new Object[19][3];
        countPlan1[0][0] = "plan";
        countPlan1[0][1] = "value";
        countPlan1[0][2] = "insurance";
        for(int i = 1;i<count.size();i++)
        {
            String plan = count.get(i).getPlan();
            Integer value = count.get(i).getValue();
            String insurance = count.get(i).getInsurance();
            countPlan1[i][0] = plan;
            countPlan1[i][1] = value;
            countPlan1[i][2] = insurance;
        }
        return R.ok().data("EveryInsurancePlan",countPlan1);
    }
    //每个保险种类出险不出险
    @GetMapping("EveryInsuranceBeInjury")
    private R EveryInsuranceBeInjury(){
        List<CountInsurancePlan> count = teacherService.EveryInsuranceBeInjury();
        //之后总条数加1
        Object[][] countPlan1 = new Object[18][3];
        countPlan1[0][0] = "beinjury";
        countPlan1[0][1] = "value";
        countPlan1[0][2] = "insurance";
        for(int i = 1;i<count.size();i++)
        {
            String plan = count.get(i).getPlan();
            Integer value = count.get(i).getValue();
            String insurance = count.get(i).getInsurance();
            countPlan1[i][0] = plan;
            countPlan1[i][1] = value;
            countPlan1[i][2] = insurance;
        }
        return R.ok().data("EveryInsuranceBeInjury",countPlan1);
    }
    @GetMapping("EveryUserAge/{insurance}")
    public R EveryUserAge(@PathVariable String insurance) {
        List<CountAvatar> count = teacherService.EveryUserAge(insurance);
        return R.ok().data("EveryUserAge",count);
    }
    @GetMapping("EveryUserGender/{insurance}")
    public R EveryUserGender(@PathVariable String insurance) {
        List<CountAvatar> count = teacherService.EveryUserGender(insurance);
        return R.ok().data("EveryUserGender",count);
    }
    @GetMapping("EveryUserAvatar/{insurance}")
    public R EveryUserAvatar(@PathVariable String insurance) {
        List<CountAvatar> count = teacherService.EveryUserAvatar(insurance);
        return R.ok().data("EveryUserAvatar",count);
    }
    @GetMapping("EveryUserInjury/{insurance}")
    public R EveryUserInjury(@PathVariable String insurance) {
        List<CountAvatar> count = teacherService.EveryUserInjury(insurance);
        return R.ok().data("EveryUserInjury",count);
    }
    @GetMapping("UserCommend/{gender}/{avatar}/{province}/{sta}")
    public R UserCommend(@PathVariable(required = false) String gender,@PathVariable(required = false) String avatar,@PathVariable(required = false) String province,@PathVariable(required = false) String sta) {
        List<CountAvatar> count = teacherService.UserCommend(gender,avatar,province,sta);
        return R.ok().data("UserCommend",count);
    }
    @GetMapping("MadeChart/{level}/{gender}/{avatar}/{be_injured}/{injury}/{province}/{injured_scene}/{insurance}/{category}")
    public R MadeChart(@PathVariable String level,@PathVariable String gender,@PathVariable String avatar,@PathVariable String be_injured,@PathVariable String injury,@PathVariable String province,@PathVariable String injured_scene,@PathVariable String insurance,@PathVariable String category) {
        List<CountAvatar> count = teacherService.MadeChart(level,gender,avatar,be_injured,injury,province,injured_scene,insurance,category);
        return R.ok().data("MadeChart",count);
    }

}

