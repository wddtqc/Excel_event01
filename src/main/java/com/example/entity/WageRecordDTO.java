package com.example.entity;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
//1111122222
public class WageRecordDTO implements Serializable {
    private String projectStreet;
    private String projectName;
    @Pattern(regexp = "^$|\\d{4}-\\d{2}-\\d{2}", message = "日期格式错误")
    private String projectStartTime;
    @Pattern(regexp = "^$|\\d{4}-\\d{2}-\\d{2}", message = "日期格式错误")
    private String projectEndTime;
    private String name;
    private String idCard;
    private String phone;
    private String company;
    private String jobType;
    private String workArea;
    @Pattern(regexp = "^$|\\d{4}-\\d{2}-\\d{2}", message = "日期格式错误")
    private String entryDate;
    private String baseSalary;
    private String payStatus;
    private String socialSecurity;
    private String remark;
    @Pattern(regexp = "^$|\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "日期时间格式错误")
    private String month;
    private Long id;

    // getter/setter
    public String getProjectStreet() { return projectStreet; }
    public void setProjectStreet(String projectStreet) { this.projectStreet = projectStreet; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public String getProjectStartTime() { return projectStartTime; }
    public void setProjectStartTime(String projectStartTime) { this.projectStartTime = projectStartTime; }
    public String getProjectEndTime() { return projectEndTime; }
    public void setProjectEndTime(String projectEndTime) { this.projectEndTime = projectEndTime; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }
    public String getWorkArea() { return workArea; }
    public void setWorkArea(String workArea) { this.workArea = workArea; }
    public String getEntryDate() { return entryDate; }
    public void setEntryDate(String entryDate) { this.entryDate = entryDate; }
    public String getBaseSalary() { return baseSalary; }
    public void setBaseSalary(String baseSalary) { this.baseSalary = baseSalary; }
    public String getPayStatus() { return payStatus; }
    public void setPayStatus(String payStatus) { this.payStatus = payStatus; }
    public String getSocialSecurity() { return socialSecurity; }
    public void setSocialSecurity(String socialSecurity) { this.socialSecurity = socialSecurity; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
} 
