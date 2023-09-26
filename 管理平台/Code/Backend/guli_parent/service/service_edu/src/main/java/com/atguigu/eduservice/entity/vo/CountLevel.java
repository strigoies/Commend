package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

public class CountLevel {
    @ApiModelProperty(value = "职业类别")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}
