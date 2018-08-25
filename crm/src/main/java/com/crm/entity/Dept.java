package com.crm.entity;


import java.util.Date;

public class Dept {

  private Long dp_Id;
  private String dp_Code;
  private String dp_Name;
  private Date dp_LastTime;
  private String dp_Operator;
  private String dp_DeptProfile;
  private String dp_Description;


  public Long getDp_Id() {
    return dp_Id;
  }

  public void setDp_Id(Long dp_Id) {
    this.dp_Id = dp_Id;
  }

  public String getDp_Code() {
    return dp_Code;
  }

  public void setDp_Code(String dp_Code) {
    this.dp_Code = dp_Code;
  }

  public String getDp_Name() {
    return dp_Name;
  }

  public void setDp_Name(String dp_Name) {
    this.dp_Name = dp_Name;
  }

  public Date getDp_LastTime() {
    return dp_LastTime;
  }

  public void setDp_LastTime(Date dp_LastTime) {
    this.dp_LastTime = dp_LastTime;
  }

  public String getDp_Operator() {
    return dp_Operator;
  }

  public void setDp_Operator(String dp_Operator) {
    this.dp_Operator = dp_Operator;
  }

  public String getDp_DeptProfile() {
    return dp_DeptProfile;
  }

  public void setDp_DeptProfile(String dp_DeptProfile) {
    this.dp_DeptProfile = dp_DeptProfile;
  }

  public String getDp_Description() {
    return dp_Description;
  }

  public void setDp_Description(String dp_Description) {
    this.dp_Description = dp_Description;
  }
}
