package com.kupferwerk.sample.recyclerview.linearlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kupferwerk.sample.recyclerview.R;
import com.kupferwerk.sample.recyclerview.RecyclerViewAdapter;
import com.kupferwerk.sample.recyclerview.model.Item;

public class LinearLayoutActivity extends Activity {
   private RecyclerView recyclerView;
   private RecyclerView.Adapter adapter;
   private RecyclerView.LayoutManager layoutManager;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_recyclerview);

      initializeRecyclerView();
   }

   private void initializeRecyclerView() {
      recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      // use this setting to improve performance if you know that changes
      // in content do not change the layout size of the RecyclerView
      recyclerView.setHasFixedSize(true);

      // use a linear layout manager
      layoutManager = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(layoutManager);

      // specify an adapter (see also next example)
      adapter = new RecyclerViewAdapter(this, Item.buildDemoModel(30));
      recyclerView.setAdapter(adapter);
   }
}
