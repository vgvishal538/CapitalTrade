package com.capitaltrade.app.network.responseModel.loginResponse.dealerResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DealerResponse {

    @SerializedName("Dealer_data")
    @Expose
    private List<DealerDatum> dealerData = null;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<DealerDatum> getDealerData() {
        return dealerData;
    }

    public void setDealerData(List<DealerDatum> dealerData) {
        this.dealerData = dealerData;
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
