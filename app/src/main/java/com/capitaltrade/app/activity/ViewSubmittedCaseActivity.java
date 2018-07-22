package com.capitaltrade.app.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.capitaltrade.app.R;
import com.capitaltrade.app.Utils.SharedPrefUtils;
import com.capitaltrade.app.adapter.SubmittedCaseAdapter;
import com.capitaltrade.app.network.responseModel.loginResponse.fiResponse.FiResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCasesResponse.ListDatum;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCasesResponse.submittedCaseResponse;
import com.capitaltrade.app.network.retrofit.ApiInterface;
import com.capitaltrade.app.network.retrofit.RetrofitUtil;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewSubmittedCaseActivity extends AppCompatActivity {

    @BindView(R.id.submittedCaseRV)
    RecyclerView submittedCaseRV;
    ApiInterface apiService;
    private SubmittedCaseAdapter submittedCaseAdapter;
    private ProgressDialog progress;
    private List<ListDatum> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_submitted_case);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        progress=new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(ViewSubmittedCaseActivity.this);
        submittedCaseRV.setLayoutManager(mLayoutManager);
        // retrofit api init.
        apiService = RetrofitUtil.getClient().create(ApiInterface.class);
     //   getSubmittedCases();
    }

//    private void getSubmittedCases() {
//        progress.show();
//        Call<submittedCaseResponse> call = apiService.getSubmittedCases(SharedPrefUtils.getId(ViewSubmittedCaseActivity.this));
//        call.enqueue(new Callback<submittedCaseResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<submittedCaseResponse>call, @NonNull Response<submittedCaseResponse> response) {
//                progress.dismiss();
//                if (response.body().getSuccess() == 1){
//                    try {
//
//
//                    }catch (Throwable throwable){
//                        throwable.printStackTrace();
//                    }
//                    submittedCaseAdapter = new SubmittedCaseAdapter(getApplicationContext(),listData);
//                    submittedCaseRV.setAdapter(submittedCaseAdapter);
//                    submittedCaseAdapter.notifyDataSetChanged();
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<submittedCaseResponse>call, @NonNull Throwable t) {
//                // Log error here since request failed
//               Log.e("error",""+t);
//                progress.dismiss();
//            }
//        });
//
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
