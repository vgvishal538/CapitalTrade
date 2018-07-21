package com.capitaltrade.app.network.responseModel.loginResponse.fiResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FiResponse {
    @SerializedName("FI_data")
    @Expose
    private List<FIDatum> fIData = null;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<FIDatum> getFIData() {
        return fIData;
    }

    public void setFIData(List<FIDatum> fIData) {
        this.fIData = fIData;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

