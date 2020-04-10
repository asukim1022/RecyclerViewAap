package com.asukim.recyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 *@RecyclerAdapter
 *@brief MainActivity에있는 RecyclerView을 관리, listView에 ListData에서 저장한 데이터 출력하기
 *@date 2016.02.18
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<RecyclerItem> items;
    int item_layout;


    //생성자에서 데이터 리스트 객체를 전달받음.
    public RecyclerAdapter(Context context, List<RecyclerItem> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    //onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);
        return new ViewHolder(v);
    }

    //onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final RecyclerItem item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getImage());
        holder.image.setImageResource(R.mipmap.ic_launcher);
        holder.image.setScaleType(ImageView.ScaleType.CENTER);
        holder.title.setText(item.getTitle());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return this.items.size();
    }

    //아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);

            //뷰 객체에 대한 참조. (hold strong reference)
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
