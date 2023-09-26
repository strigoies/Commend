
package com.atguigu.eduservice.entity.vo;

        import io.swagger.annotations.ApiModelProperty;
        import lombok.Data;

@Data
public class CountMonth {
    @ApiModelProperty(value = "月份")
    private Integer name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}