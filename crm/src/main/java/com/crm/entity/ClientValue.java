package com.crm.entity;


public class ClientValue {
  private Long cv_Id;
  private Long cv_NameId;
  private Long cv_Sex;
  private Long cv_ClientType;
  private Long cv_ConsumeNum;
  private Float cv_ConsumeSum;
  private Long cv_ServerRepresent;
  private DataDictionary dataDictionary;
  private EmployeeInfo employeeInfo;
  private ClientResource clientResource;
  private String cr_Name;

  public String getCr_Name() {
    return cr_Name;
  }

  public void setCr_Name(String cr_Name) {
    this.cr_Name = cr_Name;
  }

  public Long getCv_Id() {
    return cv_Id;
  }

  public void setCv_Id(Long cv_Id) {
    this.cv_Id = cv_Id;
  }

  public Long getCv_NameId() {
    return cv_NameId;
  }

  public void setCv_NameId(Long cv_NameId) {
    this.cv_NameId = cv_NameId;
  }

  public Long getCv_Sex() {
    return cv_Sex;
  }

  public void setCv_Sex(Long cv_Sex) {
    this.cv_Sex = cv_Sex;
  }

  public Long getCv_ClientType() {
    return cv_ClientType;
  }

  public void setCv_ClientType(Long cv_ClientType) {
    this.cv_ClientType = cv_ClientType;
  }

  public Long getCv_ConsumeNum() {
    return cv_ConsumeNum;
  }

  public void setCv_ConsumeNum(Long cv_ConsumeNum) {
    this.cv_ConsumeNum = cv_ConsumeNum;
  }

  public Float getCv_ConsumeSum() {
    return cv_ConsumeSum;
  }

  public void setCv_ConsumeSum(Float cv_ConsumeSum) {
    this.cv_ConsumeSum = cv_ConsumeSum;
  }


  public Long getCv_ServerRepresent() {
    return cv_ServerRepresent;
  }

  public void setCv_ServerRepresent(Long cv_ServerRepresent) {
    this.cv_ServerRepresent = cv_ServerRepresent;
  }

  public DataDictionary getDataDictionary() {
    return dataDictionary;
  }

  public void setDataDictionary(DataDictionary dataDictionary) {
    this.dataDictionary = dataDictionary;
  }

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
}
