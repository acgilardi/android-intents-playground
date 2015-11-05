package com.appmite.androidintents;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class IntentItemAdapter extends RecyclerView.Adapter<IntentItemAdapter.ViewHolder> {
    private List<IntentItem> itemsData;

    public IntentItemAdapter(List<IntentItem> itemsData) {
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public IntentItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final String action = itemsData.get(position).getAction();
        final IntentItem intentItem = itemsData.get(position);

        viewHolder.buttonIntentItem.setText(action);
        //viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());

        viewHolder.buttonIntentItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), action, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(intentItem.getAction()).putExtras(intentItem.getExtrasBundle());

                if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button buttonIntentItem;
        //public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            buttonIntentItem = (Button) itemLayoutView.findViewById(R.id.button_intent_item);
            //imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.size();
    }
}
