package com.dzr.javabean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: dingzr
 * @Date: 2018/12/6 14:02
 * @Description: 时间段对象
 */

@Data
@ApiModel(value = "WorkHours", description = "时间段对象")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkHours implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("开始时间")
    private Integer startTime;

    @ApiModelProperty("结束时间")
    private Integer endTime;

    private String desc;

}
