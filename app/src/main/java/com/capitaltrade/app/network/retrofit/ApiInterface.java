package com.capitaltrade.app.network.retrofit;

import com.capitaltrade.app.network.responseModel.loginResponse.dealerResponse.DealerResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.fiResponse.FiResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.preFormUploadResponse.AddCaseResponse;

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
}
