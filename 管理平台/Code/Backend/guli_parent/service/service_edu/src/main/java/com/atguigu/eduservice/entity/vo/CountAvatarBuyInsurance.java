
package com.atguigu.eduservice.entity.vo;

        import io.swagger.annotations.ApiModelProperty;
        import lombok.Data;

@Data
public class CountAvatarBuyInsurance {
    @ApiModelProperty(value = "不同行业购买保险数量")
    private String name;

    @ApiModelProperty(value = "总计")
    private Integer value;
}