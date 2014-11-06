package com.kupferwerk.sample.recyclerview.gridlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kupferwerk.sample.recyclerview.R;
import com.kupferwerk.sample.recyclerview.model.Item;
import com.kupferwerk.sample.recyclerview.adapter.StaggeredAdapter;

public class GridLayoutActivity extends Activity {
   private RecyclerView recyclerView;
   private RecyclerView.Adapter adapter;
   private RecyclerView.LayoutManager layoutManager;

   private int orientation;
   private boolean reverseLayout;

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.activity_gridlayout, menu);
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if (item.getItemId() == R.id.menu_orientation) {
         if (orientation == GridLayoutManager.VERTICAL) {
            orientation = GridLayoutManager.HORIZONTAL;
         } else {
            orientation = GridLayoutManager.VERTICAL;
         }
         initializeRecyclerView();
      } else if (item.getItemId() == R.id.menu_revert) {
         reverseLayout = !reverseLayout;
         initializeRecyclerView();
      }
      return super.onOptionsItemSelected(item);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_recyclerview);
      orientation = GridLayoutManager.VERTICAL;
      reverseLayout = false;
      initializeRecyclerView();
   }

   private void initializeRecyclerView() {
      recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      recyclerView.setHasFixedSize(true);

      layoutManager = new GridLayoutManager(this, 2, orientation, reverseLayout);
      recyclerView.setLayoutManager(layoutManager);

      // specify an adapter (see also next example)
      adapter = new StaggeredAdapter(this, Item.buildDemoModel(30));
      recyclerView.setAdapter(adapter);
   }
}
