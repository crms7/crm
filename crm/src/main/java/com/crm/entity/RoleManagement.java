package com.crm.entity;


import java.util.Date;

public class RoleManagement {

  private Long rm_Id;
  private String rm_Code;
  private String rm_Name;
  private Long rm_DepartId;
  private Date rm_LastTime;
  private Long rm_Operator;
  private String rm_Description;
  private Dept dept;
  private EmployeeInfo employeeInfo;

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public EmployeeInfo getEmployeeInfo() {
    return employeeInfo;
  }

  public void setEmployeeInfo(EmployeeInfo employeeInfo) {
    this.employeeInfo = employeeInfo;
  }

  public Long getRm_Id() {
    return rm_Id;
  }

  public void setRm_Id(Long rm_Id) {
    this.rm_Id = rm_Id;
  }

  public String getRm_Code() {
    return rm_Code;
  }

  public void setRm_Code(String rm_Code) {
    this.rm_Code = rm_Code;
  }

  public String getRm_Name() {
    return rm_Name;
  }

  public void setRm_Name(String rm_Name) {
    this.rm_Name = rm_Name;
  }

  public Long getRm_DepartId() {
    return rm_DepartId;
  }

  public void setRm_DepartId(Long rm_DepartId) {
    this.rm_DepartId = rm_DepartId;
  }

  public Date getRm_LastTime() {
    return rm_LastTime;
  }

  public void setRm_LastTime(Date rm_LastTime) {
    this.rm_LastTime = rm_LastTime;
  }

  public Long getRm_Operator() {
    return rm_Operator;
  }

  public void setRm_Operator(Long rm_Operator) {
    this.rm_Operator = rm_Operator;
  }

  public String getRm_Description() {
    return rm_Description;
  }

  public void setRm_Description(String rm_Description) {
    this.rm_Description = rm_Description;
  }
}
