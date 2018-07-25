package com.capitaltrade.app.network.responseModel.loginResponse.submittedCaseDealerResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmittedList {
    @SerializedName("appl_name")
    @Expose
    private String applName;
    @SerializedName("appl_father_name")
    @Expose
    private String applFatherName;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("contact_no")
    @Expose
    private String contactNo;
    @SerializedName("alter_contact_no")
    @Expose
    private String alterContactNo;
    @SerializedName("elligible_age_group")
    @Expose
    private String elligibleAgeGroup;
    @SerializedName("appl_litracy_status")
    @Expose
    private String applLitracyStatus;
    @SerializedName("appl_house")
    @Expose
    private String applHouse;
    @SerializedName("bill_no")
    @Expose
    private String billNo;
    @SerializedName("adhaar_no")
    @Expose
    private String adhaarNo;
    @SerializedName("pan_no")
    @Expose
    private String panNo;
    @SerializedName("kyc_no")
    @Expose
    private String kycNo;
    @SerializedName("appl_relation")
    @Expose
    private String applRelation;
    @SerializedName("co_appl_name")
    @Expose
    private String coApplName;
    @SerializedName("co_appl_father_name")
    @Expose
    private String coApplFatherName;
    @SerializedName("co_appl_address")
    @Expose
    private String coApplAddress;
    @SerializedName("co_appl_con_no")
    @Expose
    private String coApplConNo;
    @SerializedName("co_appl_acc_detail")
    @Expose
    private String coApplAccDetail;
    @SerializedName("co_appl_bill_no")
    @Expose
    private String coApplBillNo;
    @SerializedName("co_appl_adhaar_no")
    @Expose
    private String coApplAdhaarNo;
    @SerializedName("co_appl_pan_no")
    @Expose
    private String coApplPanNo;
    @SerializedName("co_appl_kyc_no")
    @Expose
    private String coApplKycNo;
    @SerializedName("garantor_name")
    @Expose
    private String garantorName;
    @SerializedName("garantor_con_no")
    @Expose
    private String garantorConNo;
    @SerializedName("garantor_father_name")
    @Expose
    private String garantorFatherName;
    @SerializedName("garantor_address")
    @Expose
    private String garantorAddress;
    @SerializedName("garantor_bill_no")
    @Expose
    private String garantorBillNo;
    @SerializedName("dealer_name")
    @Expose
    private String dealerName;
    @SerializedName("e_riq_manuf")
    @Expose
    private String eRiqManuf;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("dealer_sigh")
    @Expose
    private String dealerSigh;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private String id;

    public String getApplName() {
        return applName;
    }

    public void setApplName(String applName) {
        this.applName = applName;
    }

    public String getApplFatherName() {
        return applFatherName;
    }

    public void setApplFatherName(String applFatherName) {
        this.applFatherName = applFatherName;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAlterContactNo() {
        return alterContactNo;
    }

    public void setAlterContactNo(String alterContactNo) {
        this.alterContactNo = alterContactNo;
    }

    public String getElligibleAgeGroup() {
        return elligibleAgeGroup;
    }

    public void setElligibleAgeGroup(String elligibleAgeGroup) {
        this.elligibleAgeGroup = elligibleAgeGroup;
    }

    public String getApplLitracyStatus() {
        return applLitracyStatus;
    }

    public void setApplLitracyStatus(String applLitracyStatus) {
        this.applLitracyStatus = applLitracyStatus;
    }

    public String getApplHouse() {
        return applHouse;
    }

    public void setApplHouse(String applHouse) {
        this.applHouse = applHouse;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(String adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getKycNo() {
        return kycNo;
    }

    public void setKycNo(String kycNo) {
        this.kycNo = kycNo;
    }

    public String getApplRelation() {
        return applRelation;
    }

    public void setApplRelation(String applRelation) {
        this.applRelation = applRelation;
    }

    public String getCoApplName() {
        return coApplName;
    }

    public void setCoApplName(String coApplName) {
        this.coApplName = coApplName;
    }

    public String getCoApplFatherName() {
        return coApplFatherName;
    }

    public void setCoApplFatherName(String coApplFatherName) {
        this.coApplFatherName = coApplFatherName;
    }

    public String getCoApplAddress() {
        return coApplAddress;
    }

    public void setCoApplAddress(String coApplAddress) {
        this.coApplAddress = coApplAddress;
    }

    public String getCoApplConNo() {
        return coApplConNo;
    }

    public void setCoApplConNo(String coApplConNo) {
        this.coApplConNo = coApplConNo;
    }

    public String getCoApplAccDetail() {
        return coApplAccDetail;
    }

    public void setCoApplAccDetail(String coApplAccDetail) {
        this.coApplAccDetail = coApplAccDetail;
    }

    public String getCoApplBillNo() {
        return coApplBillNo;
    }

    public void setCoApplBillNo(String coApplBillNo) {
        this.coApplBillNo = coApplBillNo;
    }

    public String getCoApplAdhaarNo() {
        return coApplAdhaarNo;
    }

    public void setCoApplAdhaarNo(String coApplAdhaarNo) {
        this.coApplAdhaarNo = coApplAdhaarNo;
    }

    public String getCoApplPanNo() {
        return coApplPanNo;
    }

    public void setCoApplPanNo(String coApplPanNo) {
        this.coApplPanNo = coApplPanNo;
    }

    public String getCoApplKycNo() {
        return coApplKycNo;
    }

    public void setCoApplKycNo(String coApplKycNo) {
        this.coApplKycNo = coApplKycNo;
    }

    public String getGarantorName() {
        return garantorName;
    }

    public void setGarantorName(String garantorName) {
        this.garantorName = garantorName;
    }

    public String getGarantorConNo() {
        return garantorConNo;
    }

    public void setGarantorConNo(String garantorConNo) {
        this.garantorConNo = garantorConNo;
    }

    public String getGarantorFatherName() {
        return garantorFatherName;
    }

    public void setGarantorFatherName(String garantorFatherName) {
        this.garantorFatherName = garantorFatherName;
    }

    public String getGarantorAddress() {
        return garantorAddress;
    }

    public void setGarantorAddress(String garantorAddress) {
        this.garantorAddress = garantorAddress;
    }

    public String getGarantorBillNo() {
        return garantorBillNo;
    }

    public void setGarantorBillNo(String garantorBillNo) {
        this.garantorBillNo = garantorBillNo;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getERiqManuf() {
        return eRiqManuf;
    }

    public void setERiqManuf(String eRiqManuf) {
        this.eRiqManuf = eRiqManuf;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDealerSigh() {
        return dealerSigh;
    }

    public void setDealerSigh(String dealerSigh) {
        this.dealerSigh = dealerSigh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
