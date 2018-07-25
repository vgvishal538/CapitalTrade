package com.capitaltrade.app.network.responseModel.loginResponse.submittedCaseDealerResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubmittedCaseDealerResponse {
    @SerializedName("success")
    @Expose
    private long success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("List_data")
    @Expose
    private List<SubmittedList> listData = null;

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



    public List<SubmittedList> getListData() {
        return listData;
    }

    public void setListData(List<SubmittedList> listData) {
        this.listData = listData;
    }



}
