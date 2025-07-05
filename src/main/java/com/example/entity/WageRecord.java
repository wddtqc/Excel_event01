package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName wage_record
 */
@TableName(value ="wage_record")
@Data
public class WageRecord {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 项目所属街道
     */
    private String projectStreet;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目开始时间
     */
    private String projectStartTime;

    /**
     * 项目结束时间
     */
    private String projectEndTime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 所属环卫公司
     */
    private String company;

    /**
     * 所属工种
     */
    private String jobType;

    /**
     * 工作区域
     */
    private String workArea;

    /**
     * 入职时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date entryDate;

    /**
     * 基本工资[元/月]
     */
    private BigDecimal baseSalary;

    /**
     * 工资支付情况[例如：已支付2021.7-20226]
     */
    private String payStatus;

    /**
     * 是否缴纳社保
     */
    private String socialSecurity;

    /**
     * 备注
     */
    private String remark;

    /**
     * 工资发放月份
     */
    private String month;

    /**
     * 创建时间
     */
    private Date createTime;
}