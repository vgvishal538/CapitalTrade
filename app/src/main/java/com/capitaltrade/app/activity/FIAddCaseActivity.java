package com.capitaltrade.app.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.capitaltrade.app.R;
import com.capitaltrade.app.network.responseModel.loginResponse.preFormUploadResponse.AddCaseResponse;
import com.capitaltrade.app.network.retrofit.ApiInterface;
import com.capitaltrade.app.network.retrofit.RetrofitUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FIAddCaseActivity extends AppCompatActivity {
    public RequestBody dealer_id, e_rik_manfu, customer_name, borrower_name, co_borrower_name,
            guran_name, c_addr, borr_addr, co_borr_address, gurr_addr, c_contact_no, contact_borro,
            contact_co_borrow, contact_gurr, eli_age_group_cust, eli_age_group_borro, eli_age_group_co_borr,
            eli_age_group_gurran, literacy_rate, borro_literacy, co_borro_literacy, gurran_literacy,
            borro_house, co_borro_house, gurranter_house, borr_kyc, gurr_kyc, co_borr_kyc, bank_passbook,
            co_borr_bank_passbook, gurr_bank_passbook, pdc_cheque, co_borr_pdc_cheque, gurr_pdc_cheque,
            check_status, co_borro_check_status, gurr_check_status, c_sign_version, borr_sign_version,
            co_c_sign_version, gurr_c_sign_version, cust_id;
    @BindView(R.id.submitFiAddCaseBtn)
    Button submitFiAddCaseBtn;
    @BindView(R.id.dealer_idBox)
    TextInputEditText dealer_idBox;
    @BindView(R.id.e_rik_manfuBox)
    TextInputEditText e_rik_manfuBox;
    @BindView(R.id.customer_nameBox)
    TextInputEditText customer_nameBox;
    @BindView(R.id.borrower_nameBox)
    TextInputEditText borrower_nameBox;
    @BindView(R.id.co_borrower_nameBox)
    TextInputEditText co_borrower_nameBox;
    @BindView(R.id.guran_nameBox)
    TextInputEditText guran_nameBox;
    @BindView(R.id.c_addrBox)
    TextInputEditText c_addrBox;
    @BindView(R.id.borr_addrBox)
    TextInputEditText borr_addrBox;
    @BindView(R.id.co_borr_addressBox)
    TextInputEditText co_borr_addressBox;
    @BindView(R.id.gurr_addrBox)
    TextInputEditText gurr_addrBox;
    @BindView(R.id.c_contact_noBox)
    TextInputEditText c_contact_noBox;
    @BindView(R.id.contact_borronoBox)
    TextInputEditText contact_borronoBox;
    @BindView(R.id.contact_co_borrowBox)
    TextInputEditText contact_co_borrowBox;
    @BindView(R.id.contact_gurrBox)
    TextInputEditText contact_gurrBox;
    @BindView(R.id.eli_age_group_custBox)
    TextInputEditText eli_age_group_custBox;
    @BindView(R.id.eli_age_group_borroBox)
    TextInputEditText eli_age_group_borroBox;
    @BindView(R.id.eli_age_group_co_borrBox)
    TextInputEditText eli_age_group_co_borrBox;
    @BindView(R.id.eli_age_group_gurranBox)
    TextInputEditText eli_age_group_gurranBox;
    @BindView(R.id.literacy_rateBox)
    TextInputEditText literacy_rateBox;
    @BindView(R.id.borro_literacyBox)
    TextInputEditText borro_literacyBox;
    @BindView(R.id.co_borro_literacyBox)
    TextInputEditText co_borro_literacyBox;
    @BindView(R.id.gurran_literacyBox)
    TextInputEditText gurran_literacyBox;
    @BindView(R.id.borro_houseBox)
    TextInputEditText borro_houseBox;
    @BindView(R.id.co_borro_houseBox)
    TextInputEditText co_borro_houseBox;
    @BindView(R.id.gurranter_houseBox)
    TextInputEditText gurranter_houseBox;
    @BindView(R.id.borr_kycBox)
    TextInputEditText borr_kycBox;
    @BindView(R.id.gurr_kycBox)
    TextInputEditText gurr_kycBox;
    @BindView(R.id.co_borr_kycBox)
    TextInputEditText co_borr_kycBox;
    @BindView(R.id.bank_passbookBox)
    TextInputEditText bank_passbookBox;
    @BindView(R.id.co_borr_bank_passbookBox)
    TextInputEditText co_borr_bank_passbookBox;
    @BindView(R.id.gurr_bank_passbookBox)
    TextInputEditText gurr_bank_passbookBox;
    @BindView(R.id.pdc_chequeBox)
    TextInputEditText pdc_chequeBox;
    @BindView(R.id.co_borr_pdc_chequeBox)
    TextInputEditText co_borr_pdc_chequeBox;
    @BindView(R.id.gurr_pdc_chequeBox)
    TextInputEditText gurr_pdc_chequeBox;
    @BindView(R.id.check_statusBox)
    TextInputEditText check_statusBox;
    @BindView(R.id.co_borro_check_statusBox)
    TextInputEditText co_borro_check_statusBox;
    @BindView(R.id.gurr_check_statusBox)
    TextInputEditText gurr_check_statusBox;
    @BindView(R.id.c_sign_versionBox)
    TextInputEditText c_sign_versionBox;
    @BindView(R.id.borr_sign_versionBox)
    TextInputEditText borr_sign_versionBox;
    @BindView(R.id.co_c_sign_versionBox)
    TextInputEditText co_c_sign_versionBox;
    @BindView(R.id.gurr_c_sign_versionBox)
    TextInputEditText gurr_c_sign_versionBox;
    @BindView(R.id.cust_idBox)
    TextInputEditText cust_idBox;
    ApiInterface apiService;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiadd_case);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);
        // retrofit api init.
        apiService = RetrofitUtil.getClient().create(ApiInterface.class);
    }

    @OnClick(R.id.submitFiAddCaseBtn)
    public void SubmitFiData() {
        if (dealer_idBox.getText().toString().isEmpty()) {
            dealer_idBox.setError("This Can't Be Empty");
        } else if (customer_nameBox.getText().toString().isEmpty()) {
            customer_nameBox.setError("This Can't Be Empty");
        } else if (borrower_nameBox.getText().toString().isEmpty()) {
            borrower_nameBox.setError("This Can't Be Empty");
        } else if (c_contact_noBox.getText().toString().isEmpty()) {
            c_contact_noBox.setError("This Can't Be Empty");
        } else {
            submitData();
        }

    }

    private void submitData() {

        dealer_id = RequestBody.create(MediaType.parse("text/plain"), dealer_idBox.getText().toString());
        e_rik_manfu = RequestBody.create(MediaType.parse("text/plain"), e_rik_manfuBox.getText().toString());
        customer_name = RequestBody.create(MediaType.parse("text/plain"), customer_nameBox.getText().toString());
        borrower_name = RequestBody.create(MediaType.parse("text/plain"), borrower_nameBox.getText().toString());
        co_borrower_name = RequestBody.create(MediaType.parse("text/plain"), co_borrower_nameBox.getText().toString());
        guran_name = RequestBody.create(MediaType.parse("text/plain"), guran_nameBox.getText().toString());
        c_addr = RequestBody.create(MediaType.parse("text/plain"), c_addrBox.getText().toString());
        borr_addr = RequestBody.create(MediaType.parse("text/plain"), borr_addrBox.getText().toString());
        co_borr_address = RequestBody.create(MediaType.parse("text/plain"), co_borr_addressBox.getText().toString());
        gurr_addr = RequestBody.create(MediaType.parse("text/plain"), gurr_addrBox.getText().toString());
        contact_borro = RequestBody.create(MediaType.parse("text/plain"), contact_borronoBox.getText().toString());
        c_contact_no = RequestBody.create(MediaType.parse("text/plain"), c_contact_noBox.getText().toString());
        contact_co_borrow = RequestBody.create(MediaType.parse("text/plain"), contact_co_borrowBox.getText().toString());
        contact_gurr = RequestBody.create(MediaType.parse("text/plain"), contact_gurrBox.getText().toString());
        eli_age_group_cust = RequestBody.create(MediaType.parse("text/plain"), eli_age_group_custBox.getText().toString());
        eli_age_group_borro = RequestBody.create(MediaType.parse("text/plain"), eli_age_group_borroBox.getText().toString());
        eli_age_group_co_borr = RequestBody.create(MediaType.parse("text/plain"), eli_age_group_co_borrBox.getText().toString());
        eli_age_group_gurran = RequestBody.create(MediaType.parse("text/plain"), eli_age_group_gurranBox.getText().toString());
        literacy_rate = RequestBody.create(MediaType.parse("text/plain"), literacy_rateBox.getText().toString());
        borro_literacy = RequestBody.create(MediaType.parse("text/plain"), borro_literacyBox.getText().toString());
        co_borro_literacy = RequestBody.create(MediaType.parse("text/plain"), co_borro_literacyBox.getText().toString());
        gurran_literacy = RequestBody.create(MediaType.parse("text/plain"), gurran_literacyBox.getText().toString());
        borro_house = RequestBody.create(MediaType.parse("text/plain"), borro_houseBox.getText().toString());
        co_borro_house = RequestBody.create(MediaType.parse("text/plain"), co_borro_houseBox.getText().toString());
        gurranter_house = RequestBody.create(MediaType.parse("text/plain"), gurranter_houseBox.getText().toString());
        borr_kyc = RequestBody.create(MediaType.parse("text/plain"), borr_kycBox.getText().toString());
        gurr_kyc = RequestBody.create(MediaType.parse("text/plain"), gurr_kycBox.getText().toString());
        co_borr_kyc = RequestBody.create(MediaType.parse("text/plain"), co_borr_kycBox.getText().toString());
        bank_passbook = RequestBody.create(MediaType.parse("text/plain"), bank_passbookBox.getText().toString());
        co_borr_bank_passbook = RequestBody.create(MediaType.parse("text/plain"), co_borr_bank_passbookBox.getText().toString());
        gurr_bank_passbook = RequestBody.create(MediaType.parse("text/plain"), gurr_bank_passbookBox.getText().toString());
        pdc_cheque = RequestBody.create(MediaType.parse("text/plain"), pdc_chequeBox.getText().toString());
        co_borr_pdc_cheque = RequestBody.create(MediaType.parse("text/plain"), co_borr_pdc_chequeBox.getText().toString());
        gurr_pdc_cheque = RequestBody.create(MediaType.parse("text/plain"), gurr_pdc_chequeBox.getText().toString());
        check_status = RequestBody.create(MediaType.parse("text/plain"), check_statusBox.getText().toString());
        co_borro_check_status = RequestBody.create(MediaType.parse("text/plain"), co_borro_check_statusBox.getText().toString());
        gurr_check_status = RequestBody.create(MediaType.parse("text/plain"), gurr_check_statusBox.getText().toString());
        c_sign_version = RequestBody.create(MediaType.parse("text/plain"), c_sign_versionBox.getText().toString());
        borr_sign_version = RequestBody.create(MediaType.parse("text/plain"), borr_sign_versionBox.getText().toString());
        co_c_sign_version = RequestBody.create(MediaType.parse("text/plain"), co_c_sign_versionBox.getText().toString());
        gurr_c_sign_version = RequestBody.create(MediaType.parse("text/plain"), gurr_c_sign_versionBox.getText().toString());
        cust_id = RequestBody.create(MediaType.parse("text/plain"), cust_idBox.getText().toString());
        progress.show();

        Call<AddCaseResponse> call = apiService.submitFiAddCaseApi( dealer_id, e_rik_manfu, customer_name, borrower_name, co_borrower_name,
                guran_name, c_addr, borr_addr, co_borr_address, gurr_addr, c_contact_no, contact_borro,
                contact_co_borrow, contact_gurr, eli_age_group_cust, eli_age_group_borro, eli_age_group_co_borr,
                eli_age_group_gurran, literacy_rate, borro_literacy, co_borro_literacy, gurran_literacy,
                borro_house, co_borro_house, gurranter_house, borr_kyc, gurr_kyc, co_borr_kyc, bank_passbook,
                co_borr_bank_passbook, gurr_bank_passbook, pdc_cheque, co_borr_pdc_cheque, gurr_pdc_cheque,
                check_status, co_borro_check_status, gurr_check_status, c_sign_version, borr_sign_version,
                co_c_sign_version, gurr_c_sign_version, cust_id);
        call.enqueue(new Callback<AddCaseResponse>() {
            @Override
            public void onResponse( Call<AddCaseResponse> call,  Response<AddCaseResponse> response) {
                progress.dismiss();
                if (response.body().getSuccess() == 1){
                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
                Log.e("AddCaseRes",response.body().getMessage());

            }

            @Override
            public void onFailure(@NonNull Call<AddCaseResponse>call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e("AddCaseReserror", t.toString());
                progress.dismiss();
            }
        });


    }

}
