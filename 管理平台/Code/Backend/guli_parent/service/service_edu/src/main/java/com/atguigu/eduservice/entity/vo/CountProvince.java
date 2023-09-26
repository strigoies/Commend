package com.atguigu.eduservice.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class CountProvince {
    @ApiModelProperty(value = "所属省份")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}