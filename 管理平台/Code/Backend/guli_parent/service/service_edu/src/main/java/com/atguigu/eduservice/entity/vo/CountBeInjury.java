package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountBeInjury {
    @ApiModelProperty(value = "是否出险")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}