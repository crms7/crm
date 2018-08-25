package com.crm.entity;


import java.util.Date;

public class EmployeeInfo {

  private Long e_Id;
  private String e_LoginId;
  private String e_Pwd;
  private String e_Number;
  private String e_Name;
  private Long e_Depart;
  private Long e_State;
  private Long e_Role;
  private Date e_CreationTime;
  private String e_Phone;
  private Long e_Sex;
  private String e_Operator;
  private String e_Description;
  private Dept dept;
  private RoleManagement role;

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public RoleManagement getRole() {
    return role;
  }

  public void setRole(RoleManagement role) {
    this.role = role;
  }

  public Long getE_Id() {
    return e_Id;
  }

  public void setE_Id(Long e_Id) {
    this.e_Id = e_Id;
  }

  public String getE_LoginId() {
    return e_LoginId;
  }

  public void setE_LoginId(String e_LoginId) {
    this.e_LoginId = e_LoginId;
  }

  public String getE_Pwd() {
    return e_Pwd;
  }

  public void setE_Pwd(String e_Pwd) {
    this.e_Pwd = e_Pwd;
  }

  public String getE_Number() {
    return e_Number;
  }

  public void setE_Number(String e_Number) {
    this.e_Number = e_Number;
  }

  public String getE_Name() {
    return e_Name;
  }

  public void setE_Name(String e_Name) {
    this.e_Name = e_Name;
  }

  public Long getE_Depart() {
    return e_Depart;
  }

  public void setE_Depart(Long e_Depart) {
    this.e_Depart = e_Depart;
  }

  public Long getE_State() {
    return e_State;
  }

  public void setE_State(Long e_State) {
    this.e_State = e_State;
  }

  public Long getE_Role() {
    return e_Role;
  }

  public void setE_Role(Long e_Role) {
    this.e_Role = e_Role;
  }

  public Date getE_CreationTime() {
    return e_CreationTime;
  }

  public void setE_CreationTime(Date e_CreationTime) {
    this.e_CreationTime = e_CreationTime;
  }

  public String getE_Phone() {
    return e_Phone;
  }

  public void setE_Phone(String e_Phone) {
    this.e_Phone = e_Phone;
  }

  public Long getE_Sex() {
    return e_Sex;
  }

  public void setE_Sex(Long e_Sex) {
    this.e_Sex = e_Sex;
  }

  public String getE_Operator() {
    return e_Operator;
  }

  public void setE_Operator(String e_Operator) {
    this.e_Operator = e_Operator;
  }

  public String getE_Description() {
    return e_Description;
  }

  public void setE_Description(String e_Description) {
    this.e_Description = e_Description;
  }
}
