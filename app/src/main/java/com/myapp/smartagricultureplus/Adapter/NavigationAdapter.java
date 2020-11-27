package com.myapp.smartagricultureplus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.myapp.smartagricultureplus.Activity.MainActivity;
import com.myapp.smartagricultureplus.R;

public class NavigationAdapter extends RecyclerView.Adapter<com.myapp.smartagricultureplus.Adapter.NavigationAdapter.NavigationViewHolder> {
int[] icon = new int[]{R.mipmap.cat,R.mipmap.home,R.mipmap.black_people};
    Context context;
    public NavigationAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public NavigationViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view=null;
        NavigationViewHolder navigationViewHolder;
        if (view!=null){
            navigationViewHolder= (NavigationViewHolder) view.getTag();
        }else {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item,parent,false);
            navigationViewHolder=new NavigationViewHolder(view);
            view.setTag(navigationViewHolder);
        }
        navigationViewHolder.btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, MainActivity.class);
                context.startActivity(intent);
                Activity activity=(Activity)context;
                activity.finish();
            }
        });
        return navigationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationViewHolder holder, int position) {
        int iconSon=icon[position];
        holder.imageView.setBackgroundResource(iconSon);
        if (position==2){
            holder.btn_button.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return icon.length;
    }

    class NavigationViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        Button btn_button;
        public NavigationViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_navigationImage);
            btn_button=itemView.findViewById(R.id.btn_button);        }
    }
}
