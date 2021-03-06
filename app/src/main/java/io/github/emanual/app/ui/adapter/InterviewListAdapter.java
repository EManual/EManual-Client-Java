package io.github.emanual.app.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.emanual.app.R;
import io.github.emanual.app.entity.InterviewJSONEntity;
import io.github.emanual.app.ui.QuestionListActivity;

/**
 * Author: jayin
 * Date: 2/25/16
 */
public class InterviewListAdapter extends  RecyclerView.Adapter<InterviewListAdapter.ViewHolder>{
    Context context;
    List<InterviewJSONEntity> data;

    public InterviewListAdapter(Context context, List<InterviewJSONEntity> data){
        this.context = context;
        this.data = data;
    }

    public Context getContext() {
        return context;
    }

    public List<InterviewJSONEntity> getData() {
        return data;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_interviewlist, parent, false));
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        final InterviewJSONEntity item = data.get(position);
        holder.tv_name.setText(item.getInfo().getName_cn());
        holder.iv_icon.setImageURI(Uri.parse(item.getInfo().getIcon_url()));
        holder.layout_container.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuestionListActivity.class);
                intent.putExtra(QuestionListActivity.EXTRA_INTERVIEW, item);
                getContext().startActivity(intent);
            }
        });
    }

    @Override public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.layout_container) View layout_container;
        @Bind(R.id.tv_name) TextView tv_name;
        @Bind(R.id.iv_icon) SimpleDraweeView iv_icon;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
