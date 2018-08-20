package com.crm.entity;


import java.security.Timestamp;

public class Dept {

  private Long d_pId;
  private String d_pCode;
  private String d_pName;
  private Timestamp d_pLastTime;
  private Long d_pOperator;
  private String d_pDeptProfile;
  private String d_pDescription;

  public Long getD_pId() {
    return d_pId;
  }

  public void setD_pId(Long d_pId) {
    this.d_pId = d_pId;
  }

  public String getD_pCode() {
    return d_pCode;
  }

  public void setD_pCode(String d_pCode) {
    this.d_pCode = d_pCode;
  }

  public String getD_pName() {
    return d_pName;
  }

  public void setD_pName(String d_pName) {
    this.d_pName = d_pName;
  }

  public Timestamp getD_pLastTime() {
    return d_pLastTime;
  }

  public void setD_pLastTime(Timestamp d_pLastTime) {
    this.d_pLastTime = d_pLastTime;
  }

  public Long getD_pOperator() {
    return d_pOperator;
  }

  public void setD_pOperator(Long d_pOperator) {
    this.d_pOperator = d_pOperator;
  }

  public String getD_pDeptProfile() {
    return d_pDeptProfile;
  }

  public void setD_pDeptProfile(String d_pDeptProfile) {
    this.d_pDeptProfile = d_pDeptProfile;
  }

  public String getD_pDescription() {
    return d_pDescription;
  }

  public void setD_pDescription(String d_pDescription) {
    this.d_pDescription = d_pDescription;
  }
}
