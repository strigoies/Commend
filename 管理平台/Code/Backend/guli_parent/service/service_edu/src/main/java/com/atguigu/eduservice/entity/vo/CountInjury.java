package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountInjury {
    @ApiModelProperty(value = "伤情")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}
