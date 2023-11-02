package com.eternal.oneSoftPass.bean;

public class DataSourceBean {

    private String ID;
    private String NAME;
    private String U_ID;
    private String DATA_TYPE;
    private String DATA_IP;
    private String DATA_PORT;
    private String DATA_TABLE;
    private String DATA_USERNAME;
    private String DATA_PASSWORD;
    private String STATE;
    private String CREATE_TIME;
    private String UPDATE_TIME;

    private String NOTE;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getU_ID() {
        return U_ID;
    }

    public void setU_ID(String u_ID) {
        U_ID = u_ID;
    }

    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    public void setDATA_TYPE(String DATA_TYPE) {
        this.DATA_TYPE = DATA_TYPE;
    }

    public String getDATA_IP() {
        return DATA_IP;
    }

    public void setDATA_IP(String DATA_IP) {
        this.DATA_IP = DATA_IP;
    }

    public String getDATA_PORT() {
        return DATA_PORT;
    }

    public void setDATA_PORT(String DATA_PORT) {
        this.DATA_PORT = DATA_PORT;
    }

    public String getDATA_TABLE() {
        return DATA_TABLE;
    }

    public void setDATA_TABLE(String DATA_TABLE) {
        this.DATA_TABLE = DATA_TABLE;
    }

    public String getDATA_USERNAME() {
        return DATA_USERNAME;
    }

    public void setDATA_USERNAME(String DATA_USERNAME) {
        this.DATA_USERNAME = DATA_USERNAME;
    }

    public String getDATA_PASSWORD() {
        return DATA_PASSWORD;
    }

    public void setDATA_PASSWORD(String DATA_PASSWORD) {
        this.DATA_PASSWORD = DATA_PASSWORD;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }
}
