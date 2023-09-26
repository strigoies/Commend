

package com.atguigu.eduservice.entity.vo;

        import io.swagger.annotations.ApiModelProperty;
        import lombok.Data;

@Data
public class CountInsurance {
    @ApiModelProperty(value = "保险种类")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}