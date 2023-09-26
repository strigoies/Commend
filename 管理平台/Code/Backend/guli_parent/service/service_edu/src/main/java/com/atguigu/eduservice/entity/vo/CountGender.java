package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountGender {
    @ApiModelProperty(value = "性别")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}
