package com.crm.entity;


import java.util.Date;

public class ServiceCreate {

  private Long sc_Id;
  private String sc_Name;
  private Long sc_Client;
  private String sc_Phone;
  private Long sc_Type;
  private Long sc_State;
  private Date sc_OperaTime;
  private Long sc_OperaPerson;
  private Long sc_DealPeople;
  private String sc_Content;
  private String sc_Postsc_ript;
  private Date sc_TurnoverTime;
  //服务类型
  private String serviceType;
  //服务类型
  private String serviceState;

  //操作人
  private String  operaPerson;
  //待处理人
  private String  dealPeople;

  public Long getSc_Id() {
    return sc_Id;
  }

  public void setSc_Id(Long sc_Id) {
    this.sc_Id = sc_Id;
  }

  public String getSc_Name() {
    return sc_Name;
  }

  public void setSc_Name(String sc_Name) {
    this.sc_Name = sc_Name;
  }

  public Long getSc_Client() {
    return sc_Client;
  }

  public void setSc_Client(Long sc_Client) {
    this.sc_Client = sc_Client;
  }

  public String getSc_Phone() {
    return sc_Phone;
  }

  public void setSc_Phone(String sc_Phone) {
    this.sc_Phone = sc_Phone;
  }

  public Long getSc_Type() {
    return sc_Type;
  }

  public void setSc_Type(Long sc_Type) {
    this.sc_Type = sc_Type;
  }

  public Long getSc_State() {
    return sc_State;
  }

  public void setSc_State(Long sc_State) {
    this.sc_State = sc_State;
  }

  public Date getSc_OperaTime() {
    return sc_OperaTime;
  }

  public void setSc_OperaTime(Date sc_OperaTime) {
    this.sc_OperaTime = sc_OperaTime;
  }

  public Long getSc_OperaPerson() {
    return sc_OperaPerson;
  }

  public void setSc_OperaPerson(Long sc_OperaPerson) {
    this.sc_OperaPerson = sc_OperaPerson;
  }

  public Long getSc_DealPeople() {
    return sc_DealPeople;
  }

  public void setSc_DealPeople(Long sc_DealPeople) {
    this.sc_DealPeople = sc_DealPeople;
  }

  public String getSc_Content() {
    return sc_Content;
  }

  public void setSc_Content(String sc_Content) {
    this.sc_Content = sc_Content;
  }

  public String getSc_Postsc_ript() {
    return sc_Postsc_ript;
  }

  public void setSc_Postsc_ript(String sc_Postsc_ript) {
    this.sc_Postsc_ript = sc_Postsc_ript;
  }

  public Date getSc_TurnoverTime() {
    return sc_TurnoverTime;
  }

  public void setSc_TurnoverTime(Date sc_TurnoverTime) {
    this.sc_TurnoverTime = sc_TurnoverTime;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public String getServiceState() {
    return serviceState;
  }

  public void setServiceState(String serviceState) {
    this.serviceState = serviceState;
  }

  public String getOperaPerson() {
    return operaPerson;
  }

  public void setOperaPerson(String operaPerson) {
    this.operaPerson = operaPerson;
  }

  public String getDealPeople() {
    return dealPeople;
  }

  public void setDealPeople(String dealPeople) {
    this.dealPeople = dealPeople;
  }
}
