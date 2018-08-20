package com.crm.entity;


import java.security.Timestamp;

public class RoleManagement {

  private Long r_mId;
  private String r_mCode;
  private String r_mName;
  private Long r_mDepartId;
  private Timestamp r_mLastTime;
  private Long r_mOperator;
  private String r_mDescription;

  public Long getR_mId() {
    return r_mId;
  }

  public void setR_mId(Long r_mId) {
    this.r_mId = r_mId;
  }

  public String getR_mCode() {
    return r_mCode;
  }

  public void setR_mCode(String r_mCode) {
    this.r_mCode = r_mCode;
  }

  public String getR_mName() {
    return r_mName;
  }

  public void setR_mName(String r_mName) {
    this.r_mName = r_mName;
  }

  public Long getR_mDepartId() {
    return r_mDepartId;
  }

  public void setR_mDepartId(Long r_mDepartId) {
    this.r_mDepartId = r_mDepartId;
  }

  public Timestamp getR_mLastTime() {
    return r_mLastTime;
  }

  public void setR_mLastTime(Timestamp r_mLastTime) {
    this.r_mLastTime = r_mLastTime;
  }

  public Long getR_mOperator() {
    return r_mOperator;
  }

  public void setR_mOperator(Long r_mOperator) {
    this.r_mOperator = r_mOperator;
  }

  public String getR_mDescription() {
    return r_mDescription;
  }

  public void setR_mDescription(String r_mDescription) {
    this.r_mDescription = r_mDescription;
  }
}
