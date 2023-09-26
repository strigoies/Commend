package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="讲师")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

//    @ApiModelProperty(value = "姓名")
//    private String name;

    @ApiModelProperty(value = "简介/备注")
    private String intro;

    @ApiModelProperty(value = "工种名称")
    private String career;

    @ApiModelProperty(value = "职业类别")
    private String level;

    @ApiModelProperty(value = "所属行业")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "投保时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "出险时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty(value = "伤情")
    private String injury;

    @ApiModelProperty(value = "年龄")
    private Integer age;

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
