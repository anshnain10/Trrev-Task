package com.example.trrevtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Pojo2> localDataSet;
    private  Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView9,textView10,textView11,textView8;
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView9 = (TextView) view.findViewById(R.id.textView9);
            textView10 = (TextView) view.findViewById(R.id.textView10);
            textView11 = (TextView) view.findViewById(R.id.textView11);
            textView8 = (TextView) view.findViewById(R.id.textView8);
            imageView=(ImageView) view.findViewById(R.id.imageView);
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(List<Pojo2> dataSet,Context context) {
        localDataSet = dataSet;
        this.context=context;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView8.setText("Department Id :"+localDataSet.get(position).getId());
        viewHolder.textView9.setText("Created At :"+localDataSet.get(position).getCreated_at());
        viewHolder.textView10.setText("Updated At :"+localDataSet.get(position).getUpdated_at());
        viewHolder.textView11.setText("Name :"+localDataSet.get(position).getName());
        Glide.with(context).load(localDataSet.get(position).getUrl()).into(viewHolder.imageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
