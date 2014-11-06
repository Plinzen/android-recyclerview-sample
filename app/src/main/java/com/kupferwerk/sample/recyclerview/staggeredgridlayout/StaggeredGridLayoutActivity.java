package com.kupferwerk.sample.recyclerview.staggeredgridlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.kupferwerk.sample.recyclerview.R;
import com.kupferwerk.sample.recyclerview.StaggeredAdapter;
import com.kupferwerk.sample.recyclerview.model.Item;

public class StaggeredGridLayoutActivity extends Activity {
   private RecyclerView recyclerView;
   private RecyclerView.Adapter adapter;
   private StaggeredGridLayoutManager layoutManager;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_recyclerview);
      initializeRecyclerView();
   }

   private void initializeRecyclerView() {
      recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      recyclerView.setHasFixedSize(true);

      layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
      recyclerView.setLayoutManager(layoutManager);

      adapter = new StaggeredAdapter(this, Item.buildDemoModel(30));
      recyclerView.setAdapter(adapter);
   }
}
