android-recyclerview-sample
===========================

This repository provides sample implementation for the android recyclerview.

- A simple sample using LinearLayoutManager and some actions to demonstrate the default animations.

- A simple sample using GridLayoutManager and some actions to demonstrate orientation change and reverse mode.

- A simple sample using StaggeredGridLayoutManager.


How to use RecyclerView
=======================

1. Update build.gradle with the following dependency:

        compile 'com.android.support:recyclerview-v7:21.0.0'

2. Include RecyclerView in Layout:

         <android.support.v7.widget.RecyclerView
                android:id="@+id/recycler_view"
                android:scrollbars="vertical"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>

3. Initialize in Code:

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

4. Write Adapter:

        public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

           public static class ViewHolder extends RecyclerView.ViewHolder {
              public TextView txtTitle;

              public ViewHolder(final View container) {
                 super(container);
                 txtTitle = (TextView) container.findViewById(R.id.txtTitle);
              }
           }

           private List<Item> items;
           private Picasso picasso;

           public SimpleAdapter(final Activity activity, List<Item> items) {
              this.items = items;
           }

           @Override
           public int getItemCount() {
              return items.size();
           }

           @Override
           public void onBindViewHolder(SimpleAdapter.ViewHolder holder, int position) {
              Item item = items.get(position);
              holder.txtTitle.setText(item.getTitle());
           }

           @Override
           public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
              // create a new view
              View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);
              return new ViewHolder(v);
           }
        }

