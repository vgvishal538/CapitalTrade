package com.capitaltrade.app.network.retrofit;

import com.capitaltrade.app.network.responseModel.loginResponse.dealerResponse.DealerResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.fiResponse.FiResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.preFormUploadResponse.AddCaseResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCasesResponse.submittedCaseResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("login")
    Call<DealerResponse> getDealerResponse(@Query("username") String username,
                                           @Query("password") String password,
                                           @Query("type") String type);

    @GET("login")
    Call<FiResponse> getFiResponse(@Query("username") String username,
                                       @Query("password") String password,
                                       @Query("type") String type);

     @POST("pre_customer_add")
     @Multipart
    Call<AddCaseResponse> uploadFormData(
             @Part MultipartBody.Part image,
             @Part("appl_name") RequestBody appl_name,
             @Part("joining_date" ) RequestBody joining_date,
             @Part("appl_father_name")RequestBody appl_father_name,
             @Part("contact_no") RequestBody contact_no,
             @Part("alter_contact_no") RequestBody alter_contact_no,
             @Part("elligible_age_group")RequestBody elligible_age_group,
             @Part("appl_litracy_status")RequestBody appl_litracy_status,
             @Part("appl_house") RequestBody appl_house,
             @Part("bill_no")RequestBody bill_no,
             @Part("adhaar_no") RequestBody adhaar_no,
             @Part("pan_no") RequestBody pan_no,
             @Part("kyc_no") RequestBody kyc_no,
             @Part("appl_relation") RequestBody appl_relation,
             @Part("co_appl_name") RequestBody co_appl_name,
             @Part("co_appl_father_name") RequestBody co_appl_father_name,
             @Part("co_appl_address") RequestBody co_appl_address,
             @Part("co_appl_con_no") RequestBody co_appl_con_no,
             @Part("co_appl_acc_detail") RequestBody co_appl_acc_detail,
             @Part("co_appl_bill_no") RequestBody co_appl_bill_no,
             @Part("co_appl_adhaar_no") RequestBody co_appl_adhaar_no,
             @Part("co_appl_pan_no")RequestBody co_appl_pan_no,
             @Part("co_appl_kyc_no") RequestBody co_appl_kyc_no,
             @Part("garantor_name") RequestBody garantor_name,
             @Part("garantor_con_no") RequestBody garantor_con_no,
             @Part("garantor_father_name") RequestBody garantor_father_name,
             @Part("garantor_address") RequestBody garantor_address,
             @Part("garantor_bill_no") RequestBody garantor_bill_no,
             @Part("dealer_id") RequestBody dealer_id,
             @Part("e_riq_manuf") RequestBody e_riq_manuf);

     @POST("pre_customer_list_for_fi")
     @Multipart
     Call<submittedCaseResponse> getSubmittedCases(@Part("phone") RequestBody phone);

     @POST("post_customer_add")
    @Multipart
    Call<AddCaseResponse> submitFiAddCaseApi(@Part("dealer_id") RequestBody dealer_id,
                                             @Part("e_rik_manfu")RequestBody e_rik_manfu,
                                             @Part("customer_name") RequestBody customer_name,
                                             @Part("borrower_name")RequestBody borrower_name,
                                           @Part("co_borrower_name")  RequestBody co_borrower_name,
                                           @Part("guran_name")  RequestBody guran_name,
                                           @Part("c_addr")  RequestBody c_addr,
                                           @Part("borr_addr")  RequestBody borr_addr,
                                            @Part("co_borr_address") RequestBody co_borr_address,
                                           @Part("gurr_addr") RequestBody gurr_addr,
                                            @Part("c_contact_no") RequestBody c_contact_no,
                                           @Part("contact_borro")  RequestBody contact_borro,
                                           @Part("contact_co_borrow")  RequestBody contact_co_borrow,
                                           @Part("contact_gurr")  RequestBody contact_gurr,
                                          @Part("eli_age_group_cust")   RequestBody eli_age_group_cust,
                                         @Part("eli_age_group_borro")    RequestBody eli_age_group_borro,
                                          @Part("eli_age_group_co_borr")   RequestBody eli_age_group_co_borr,
                                            @Part("eli_age_group_gurran") RequestBody eli_age_group_gurran,
                                            @Part("literacy_rate") RequestBody literacy_rate,
                                            @Part("borro_literacy") RequestBody borro_literacy,
                                            @Part("co_borro_literacy") RequestBody co_borro_literacy,
                                            @Part("gurran_literacy") RequestBody gurran_literacy,
                                            @Part("borro_house") RequestBody borro_house,
                                           @Part("co_borro_house")  RequestBody co_borro_house,
                                           @Part("gurranter_house") RequestBody gurranter_house,
                                           @Part("borr_kyc")  RequestBody borr_kyc,
                                           @Part("gurr_kyc")  RequestBody gurr_kyc,
                                           @Part("co_borr_kyc")  RequestBody co_borr_kyc,
                                           @Part("bank_passbook")  RequestBody bank_passbook,
                                           @Part("co_borr_bank_passbook")  RequestBody co_borr_bank_passbook,
                                            @Part("gurr_bank_passbook") RequestBody gurr_bank_passbook,
                                            @Part("pdc_cheque") RequestBody pdc_cheque,
                                            @Part("co_borr_pdc_cheque") RequestBody co_borr_pdc_cheque,
                                           @Part("gurr_pdc_cheque")  RequestBody gurr_pdc_cheque,
                                           @Part("check_status")  RequestBody check_status,
                                           @Part("co_borro_check_status") RequestBody co_borro_check_status,
                                           @Part("gurr_check_status")  RequestBody gurr_check_status,
                                            @Part("c_sign_version") RequestBody c_sign_version,
                                            @Part("borr_sign_version") RequestBody borr_sign_version,
                                            @Part("co_c_sign_version") RequestBody co_c_sign_version,
                                           @Part("gurr_c_sign_version")  RequestBody gurr_c_sign_version,
                                             @Part("cust_id") RequestBody cust_id);


}
