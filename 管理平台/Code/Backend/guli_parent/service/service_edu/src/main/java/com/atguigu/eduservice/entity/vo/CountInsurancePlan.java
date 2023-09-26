package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountInsurancePlan {
    @ApiModelProperty(value = "保险种类")
    private String plan;

    @ApiModelProperty(value = "总计")
    private Integer value;
    @ApiModelProperty(value = "保险种类")
    private String insurance;
}
