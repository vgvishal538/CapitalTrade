package com.capitaltrade.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.capitaltrade.app.R;
import com.capitaltrade.app.network.responseModel.loginResponse.submittedCasesResponse.ListDatum;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewCaseStatusAdapter extends RecyclerView.Adapter<ViewCaseStatusAdapter.ViewHolder> {

    public List<ListDatum> listDatumList;
    public Context context;

    public ViewCaseStatusAdapter(Context context, List<ListDatum> listDatumList) {
        this.context = context;
        this.listDatumList = listDatumList;

    }

    @NonNull
    @Override
    public ViewCaseStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.case_status_lay, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewCaseStatusAdapter.ViewHolder viewHolder, int i) {
        final  ListDatum listDatum = getItem(i);
        assert  listDatum !=null;
        viewHolder.statusId.setText("ID "+listDatum.getId());
        viewHolder.statusName.setText(listDatum.getApplName());
        if (listDatum.getStatus().equals("Reject")){
            viewHolder.status.setText(listDatum.getStatus());
            viewHolder.status.setTextColor(Color.RED);
        }else if (listDatum.getStatus().equals("Approved")){
            viewHolder.status.setText(listDatum.getStatus());
            viewHolder.status.setTextColor(Color.GREEN);
        }


    }

    @Override
    public int getItemCount() {
        return listDatumList.size();
    }
    private ListDatum getItem(int position) {
        return position < listDatumList.size() ? listDatumList.get(position) : null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.statusId)
        TextView statusId;
        @BindView(R.id.statusName)
        TextView statusName;
        @BindView(R.id.status)
        TextView status;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
