package com.capitaltrade.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.capitaltrade.app.R;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCaseDealerResponse.SubmittedList;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCasesResponse.ListDatum;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubmittedCaseDealerAdpater extends RecyclerView.Adapter<SubmittedCaseDealerAdpater.ViewHolder> {
    public List<SubmittedList> listDatumList;
    public Context context;

    public SubmittedCaseDealerAdpater(Context context, List<SubmittedList> listDatumList) {
        this.context = context;
        this.listDatumList = listDatumList;

    }

    @NonNull
    @Override
    public SubmittedCaseDealerAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.submmited_case_lay, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubmittedCaseDealerAdpater.ViewHolder viewHolder, int i) {
        final  SubmittedList listDatum = getItem(i);
        assert  listDatum !=null;
        viewHolder.idText.setText("ID "+listDatum.getId());
        viewHolder.personNameTxt.setText(listDatum.getApplName());

    }
    @Override
    public int getItemCount() {
        return listDatumList.size();
    }
    private SubmittedList getItem(int position) {
        return position < listDatumList.size() ? listDatumList.get(position) : null;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.idText)
        TextView idText;
        @BindView(R.id.personNameTxt)
        TextView personNameTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
