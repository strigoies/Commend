package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountAvatar {
    @ApiModelProperty(value = "所属行业")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}
