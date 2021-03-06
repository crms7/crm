package com.crm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClientResource {

  private Long cr_Id;
  private String cr_ClientName;
  private Long cr_ClientCode;
  private Long cr_Sex;
  private Long cr_Type;
  private Long cr_Status;
  private Long cr_AllotStatus;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date cr_EnterTime;
  private Long cr_EntryPerson;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date cr_Birthday;
  private String cr_Phone;
  private String cr_WorkTelephone;
  private String cr_HomeTelephone;
  private String cr_Email;
  private String cr_Address;
  private String cr_Remark;

  private String  clientType; //客户类型
  private String clientStatus; //客户状态
  private String clientAllotStatus; //客户分配
  private EmployeeInfo employeeInfo;

  public EmployeeInfo getEmployeeInfo() {
    return employeeInfo;
  }

  public void setEmployeeInfo(EmployeeInfo employeeInfo) {
    this.employeeInfo = employeeInfo;
  }

  public Long getCr_Id() {
    return cr_Id;
  }

  public void setCr_Id(Long cr_Id) {
    this.cr_Id = cr_Id;
  }

  public String getCr_ClientName() {
    return cr_ClientName;
  }

  public void setCr_ClientName(String cr_ClientName) {
    this.cr_ClientName = cr_ClientName;
  }

  public Long getCr_ClientCode() {
    return cr_ClientCode;
  }

  public void setCr_ClientCode(Long cr_ClientCode) {
    this.cr_ClientCode = cr_ClientCode;
  }

  public Long getCr_Sex() {
    return cr_Sex;
  }

  public void setCr_Sex(Long cr_Sex) {
    this.cr_Sex = cr_Sex;
  }

  public Long getCr_Type() {
    return cr_Type;
  }

  public void setCr_Type(Long cr_Type) {
    this.cr_Type = cr_Type;
  }

  public Long getCr_Status() {
    return cr_Status;
  }

  public void setCr_Status(Long cr_Status) {
    this.cr_Status = cr_Status;
  }

  public Long getCr_AllotStatus() {
    return cr_AllotStatus;
  }

  public void setCr_AllotStatus(Long cr_AllotStatus) {
    this.cr_AllotStatus = cr_AllotStatus;
  }

  public Date getCr_EnterTime() {
    return cr_EnterTime;
  }

  public void setCr_EnterTime(Date cr_EnterTime) {
    this.cr_EnterTime = cr_EnterTime;
  }

  public Long getCr_EntryPerson() {
    return cr_EntryPerson;
  }

  public void setCr_EntryPerson(Long cr_EntryPerson) {
    this.cr_EntryPerson = cr_EntryPerson;
  }

  public Date getCr_Birthday() {
    return cr_Birthday;
  }

  public void setCr_Birthday(Date cr_Birthday) {
    this.cr_Birthday = cr_Birthday;
  }

  public String getCr_Phone() {
    return cr_Phone;
  }

  public void setCr_Phone(String cr_Phone) {
    this.cr_Phone = cr_Phone;
  }

  public String getCr_WorkTelephone() {
    return cr_WorkTelephone;
  }

  public void setCr_WorkTelephone(String cr_WorkTelephone) {
    this.cr_WorkTelephone = cr_WorkTelephone;
  }

  public String getCr_HomeTelephone() {
    return cr_HomeTelephone;
  }

  public void setCr_HomeTelephone(String cr_HomeTelephone) {
    this.cr_HomeTelephone = cr_HomeTelephone;
  }

  public String getCr_Email() {
    return cr_Email;
  }

  public void setCr_Email(String cr_Email) {
    this.cr_Email = cr_Email;
  }

  public String getCr_Address() {
    return cr_Address;
  }

  public void setCr_Address(String cr_Address) {
    this.cr_Address = cr_Address;
  }

  public String getCr_Remark() {
    return cr_Remark;
  }

  public void setCr_Remark(String cr_Remark) {
    this.cr_Remark = cr_Remark;
  }

  public String getClientType() {
    return clientType;
  }

  public void setClientType(String clientType) {
    this.clientType = clientType;
  }

  public String getClientStatus() {
    return clientStatus;
  }

  public void setClientStatus(String clientStatus) {
    this.clientStatus = clientStatus;
  }

  public String getClientAllotStatus() {
    return clientAllotStatus;
  }

  public void setClientAllotStatus(String clientAllotStatus) {
    this.clientAllotStatus = clientAllotStatus;
  }
}
