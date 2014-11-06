package com.kupferwerk.sample.recyclerview.linearlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kupferwerk.sample.recyclerview.R;
import com.kupferwerk.sample.recyclerview.adapter.SimpleAdapter;
import com.kupferwerk.sample.recyclerview.model.Item;

import java.util.List;

public class LinearLayoutActivity extends Activity {
   private RecyclerView recyclerView;
   private RecyclerView.Adapter adapter;
   private RecyclerView.LayoutManager layoutManager;
   private List<Item> items;

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.activity_linearlayout, menu);
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if (R.id.menu_add == item.getItemId()) {
         int position = 1;
         items.add(position, new Item().setTitle("I am new.").setSubTitle("Huhu!"));
         adapter.notifyItemInserted(position);
      }
      if (R.id.menu_edit == item.getItemId()) {
         int position = 2;
         items.get(position).setTitle("I changed my title.");
         adapter.notifyItemChanged(position);
      }
      if (R.id.menu_delete == item.getItemId()) {
         int position = 1;
         if (items.size() > position) {
            items.remove(position);
            adapter.notifyItemRemoved(position);
         }
      }

      return super.onOptionsItemSelected(item);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_recyclerview);
      items = Item.buildDemoModel(30);
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
      adapter = new SimpleAdapter(this, items);
      recyclerView.setAdapter(adapter);
   }
}
