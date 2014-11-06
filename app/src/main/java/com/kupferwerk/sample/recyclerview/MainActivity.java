package com.kupferwerk.sample.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kupferwerk.sample.recyclerview.gridlayout.GridLayoutActivity;
import com.kupferwerk.sample.recyclerview.linearlayout.LinearLayoutActivity;
import com.kupferwerk.sample.recyclerview.staggeredgridlayout.StaggeredGridLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
   public static class ViewHolder extends RecyclerView.ViewHolder {
      public TextView txtTitle;

      public ViewHolder(final View container) {
         super(container);
         txtTitle = (TextView) container.findViewById(android.R.id.text1);
      }
   }

   private static class RecyclerViewAdapter extends RecyclerView.Adapter<MainActivity.ViewHolder> {

      private List<Pair<String, Intent>> items;
      private Activity activity;

      public RecyclerViewAdapter(final Activity activity, final List<Pair<String, Intent>> items) {
         this.items = items;
         this.activity = activity;
      }

      @Override
      public int getItemCount() {
         return items.size();
      }

      @Override
      public void onBindViewHolder(MainActivity.ViewHolder holder, int position) {
         final Pair<String, Intent> item = items.get(position);
         holder.txtTitle.setText(item.first);
         holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               activity.startActivity(item.second);
            }
         });
      }

      @Override
      public MainActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         // create a new view
         View v = LayoutInflater.from(parent.getContext())
               .inflate(android.R.layout.simple_list_item_1, parent, false);
         // set the view's size, margins, paddings and layout parameters
         return new ViewHolder(v);
      }
   }

   private List<Pair<String, Intent>> items;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      buildItems();
      initializeRecyclerView();
   }

   private void buildItems() {
      items = new ArrayList<Pair<String, Intent>>();

      Intent linearLayout = new Intent(this, LinearLayoutActivity.class);
      items.add(new Pair<String, Intent>("Simple Example with LinearLayout and Default-Animations",
            linearLayout));

      Intent gridLayout = new Intent(this, GridLayoutActivity.class);
      items.add(new Pair<String, Intent>("Simple Example with GridLayout", gridLayout));

      Intent staggeredGridLayout = new Intent(this, StaggeredGridLayoutActivity.class);
      items.add(new Pair<String, Intent>("Simple Example with StaggeredGridLayout",
            staggeredGridLayout));
   }

   private void initializeRecyclerView() {
      RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      recyclerView.setHasFixedSize(true);
      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(layoutManager);
      RecyclerView.Adapter adapter = new RecyclerViewAdapter(this, items);
      recyclerView.setAdapter(adapter);
   }
}
