package com.crm.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClientProgress {
  private Long cp_Id;
  private Long cp_NameId;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date cp_CreationTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date cp_OperationTime;
  private Long cp_OperationPerson;
  private String cp_PlanCode;
  private String cp_PlanName;
  @DateTimeFormat(pattern = "yyyy-MM")
  private Date cp_PlanMonth;
  private Long cp_PlanStatus;
  private String cp_PlanContent;
  private ClientResource clientResource;
  private EmployeeInfo employeeInfo;

  public EmployeeInfo getEmployeeInfo() {
    return employeeInfo;
  }

  public void setEmployeeInfo(EmployeeInfo employeeInfo) {
    this.employeeInfo = employeeInfo;
  }

  public ClientResource getClientResource() {
    return clientResource;
  }

  public void setClientResource(ClientResource clientResource) {
    this.clientResource = clientResource;
  }

  public Long getCp_Id() {
    return cp_Id;
  }

  public void setCp_Id(Long cp_Id) {
    this.cp_Id = cp_Id;
  }

  public Long getCp_NameId() {
    return cp_NameId;
  }

  public void setCp_NameId(Long cp_NameId) {
    this.cp_NameId = cp_NameId;
  }

  public Date getCp_CreationTime() {
    return cp_CreationTime;
  }

  public void setCp_CreationTime(Date cp_CreationTime) {
    this.cp_CreationTime = cp_CreationTime;
  }

  public Date getCp_OperationTime() {
    return cp_OperationTime;
  }

  public void setCp_OperationTime(Date cp_OperationTime) {
    this.cp_OperationTime = cp_OperationTime;
  }


  public Long getCp_OperationPerson() {
    return cp_OperationPerson;
  }

  public void setCp_OperationPerson(Long cp_OperationPerson) {
    this.cp_OperationPerson = cp_OperationPerson;
  }

  public String getCp_PlanCode() {
    return cp_PlanCode;
  }

  public void setCp_PlanCode(String cp_PlanCode) {
    this.cp_PlanCode = cp_PlanCode;
  }

  public String getCp_PlanName() {
    return cp_PlanName;
  }

  public void setCp_PlanName(String cp_PlanName) {
    this.cp_PlanName = cp_PlanName;
  }

  public Date getCp_PlanMonth() {
    return cp_PlanMonth;
  }

  public void setCp_PlanMonth(Date cp_PlanMonth) {
    this.cp_PlanMonth = cp_PlanMonth;
  }

  public Long getCp_PlanStatus() {
    return cp_PlanStatus;
  }

  public void setCp_PlanStatus(Long cp_PlanStatus) {
    this.cp_PlanStatus = cp_PlanStatus;
  }

  public String getCp_PlanContent() {
    return cp_PlanContent;
  }

  public void setCp_PlanContent(String cp_PlanContent) {
    this.cp_PlanContent = cp_PlanContent;
  }
}
