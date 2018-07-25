package com.capitaltrade.app.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.capitaltrade.app.R;
import com.capitaltrade.app.Utils.SharedPrefUtils;
import com.capitaltrade.app.adapter.SubmittedCaseDealerAdpater;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCaseDealerResponse.SubmittedCaseDealerResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCaseDealerResponse.SubmittedList;
import com.capitaltrade.app.network.retrofit.ApiInterface;
import com.capitaltrade.app.network.retrofit.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewSubmittedCaseActivity extends AppCompatActivity {

    public RequestBody getID;
    @BindView(R.id.submittedCaseRV)
    RecyclerView submittedCaseRV;
    ApiInterface apiService;
    private SubmittedCaseDealerAdpater submittedCaseAdapter;
    private ProgressDialog progress;
    private List<SubmittedList> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_submitted_case);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(ViewSubmittedCaseActivity.this);
        submittedCaseRV.setLayoutManager(mLayoutManager);
        // retrofit api init.
        apiService = RetrofitUtil.getClient().create(ApiInterface.class);
        Log.e("submitedId", SharedPrefUtils.getId(ViewSubmittedCaseActivity.this));
        getID = RequestBody.create(MediaType.parse("text/plain"), SharedPrefUtils.getId(ViewSubmittedCaseActivity.this));
        getSubmittedCases();
    }

    private void getSubmittedCases() {
        progress.show();
        Call<SubmittedCaseDealerResponse> call = apiService.getSubmittedCasesDealer(getID);
        call.enqueue(new Callback<SubmittedCaseDealerResponse>() {
            @Override
            public void onResponse(@NonNull Call<SubmittedCaseDealerResponse> call, @NonNull Response<SubmittedCaseDealerResponse> response) {
                progress.dismiss();
                Log.e("ressss", "" + response);
                if (response.body().getSuccess() == 1) {
                    try {

                        listData.addAll(response.body().getListData());
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();

                    }
                    submittedCaseAdapter = new SubmittedCaseDealerAdpater(getApplicationContext(), listData);
                    submittedCaseRV.setAdapter(submittedCaseAdapter);
                    submittedCaseAdapter.notifyDataSetChanged();
                } else {

                }


            }

            @Override
            public void onFailure(@NonNull Call<SubmittedCaseDealerResponse> call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e("error", "" + t);
                progress.dismiss();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
