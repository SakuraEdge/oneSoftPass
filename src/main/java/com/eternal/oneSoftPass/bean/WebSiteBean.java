package com.eternal.oneSoftPass.bean;

import java.io.Serializable;

public class WebSiteBean implements Serializable {

    private String W_ID;
    private String NAME;
    private String WEBSITE;
    private String COMMENT;

    public String getW_ID() {
        return W_ID;
    }

    public void setW_ID(String w_ID) {
        W_ID = w_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public void setCOMMENT(String COMMENT) {
        this.COMMENT = COMMENT;
    }

}
