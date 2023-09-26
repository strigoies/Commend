package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountCareer {
    @ApiModelProperty(value = "工种名称")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}
