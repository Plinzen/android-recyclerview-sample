package com.kupferwerk.sample.recyclerview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.sample.recyclerview.R;
import com.kupferwerk.sample.recyclerview.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

   public static class ViewHolder extends RecyclerView.ViewHolder {
      public TextView txtTitle;
      public TextView txtSubTitle;
      public ImageView imgIcon;

      public ViewHolder(final View container) {
         super(container);
         txtTitle = (TextView) container.findViewById(R.id.txtTitle);
         txtSubTitle = (TextView) container.findViewById(R.id.txtSubtitle);
         imgIcon = (ImageView) container.findViewById(R.id.imgIcon);
      }
   }

   private List<Item> items;
   private Picasso picasso;

   public SimpleAdapter(final Activity activity, List<Item> items) {
      this.items = items;
      picasso = Picasso.with(activity.getApplicationContext());
      picasso.setLoggingEnabled(true);
   }

   @Override
   public int getItemCount() {
      return items.size();
   }

   @Override
   public void onBindViewHolder(SimpleAdapter.ViewHolder holder, int position) {
      Item item = items.get(position);
      holder.txtTitle.setText(item.getTitle());
      holder.txtSubTitle.setText(item.getSubTitle());
      picasso.load("http://lorempixel.com/400/200/").error(R.drawable.sample).into(holder.imgIcon);
   }

   @Override
   public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      // create a new view
      View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.recyclerview_item, parent, false);
      return new ViewHolder(v);
   }
}
