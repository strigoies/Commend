package com.atguigu.educenter.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterVo {
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "验证码")
    private String code;
    @ApiModelProperty(value = "性别 1 女，2 男")
    private Integer sex;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "行业")
    private String avatar;
}
