package com.atguigu.eduservice.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherQuery {

    @ApiModelProperty(value = "查询投保开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询投保结束时间", example = "2019-12-01 10:10:10")
    private String end;


    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "工种名称")
    private String career;

    @ApiModelProperty(value = "职业类别")
    private String level;

    @ApiModelProperty(value = "所属行业")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;


    @ApiModelProperty(value = "查询出险开始时间", example = "2019-01-01 10:10:10")
    private String begininjury;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询出险结束时间", example = "2019-12-01 10:10:10")
    private String endinjury;

    @ApiModelProperty(value = "伤情")
    private String injury;
    @ApiModelProperty(value = "年龄")
    private String age;
    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "所属省份")
    private String province;

    @ApiModelProperty(value = "所属地市")
    private String city;

    @ApiModelProperty(value = "所属区县")
    private String country;

    @ApiModelProperty(value = "是否出险  1（true）已出险， 0（false）未出险")
    private Integer beInjured;
    @ApiModelProperty(value = "出险场景")
    private String injuredScene;
    @ApiModelProperty(value = "保险种类")
    private String insurance;
    @ApiModelProperty(value = "保险方案")
    private String insurancePlan;
}
