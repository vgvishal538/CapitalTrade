package com.capitaltrade.app.network.responseModel.loginResponse.submittedCasesResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class submittedCaseResponse {

    @SerializedName("List_data")
    @Expose
    private List<ListDatum> listData = null;
    @SerializedName("success")
    @Expose
    private long success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<ListDatum> getListData() {
        return listData;
    }

    public void setListData(List<ListDatum> listData) {
        this.listData = listData;
    }

    public long getSuccess() {
        return success;
    }

    public void setSuccess(long success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
