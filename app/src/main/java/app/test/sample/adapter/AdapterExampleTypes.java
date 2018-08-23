package app.test.sample.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import app.test.sample.R;
import app.test.sample.model.Data;
import app.test.sample.presenter.RecyclerItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterExampleTypes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Data> pictureArrayList;
    private int itemLayout;

    private static final int TYPE_ITEM_1 = 0;
    private static final int TYPE_ITEM_2 = 1;
    private static final int TYPE_ITEM_3 = 2;
    private RecyclerItemClickListener recyclerItemClickListener;

    public void setRecyclerItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    public AdapterExampleTypes(ArrayList<Data> pictureArrayList, int itemLayout) {
        this.pictureArrayList = pictureArrayList;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolderType = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TYPE_ITEM_1:
                View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
                viewHolderType = new ExampleHolder(view);
                break;
            case TYPE_ITEM_2:
                viewHolderType = new ExampleHolderTypeTwo(inflater.inflate(R.layout.item_type_four, parent, false));
                break;
            case TYPE_ITEM_3:
                viewHolderType = new ExampleHolderTypeThree(inflater.inflate(R.layout.item_type_five, parent, false));
                break;
        }

        return viewHolderType;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Data picture = pictureArrayList.get(position);


        switch (holder.getItemViewType()) {
            case TYPE_ITEM_1:
                setTypeItem1(((ExampleHolder) holder), picture);
                break;

            case TYPE_ITEM_2:
                setTypeItem2(((ExampleHolderTypeTwo) holder), picture);
                break;

            case TYPE_ITEM_3:
                setTypeItem3(((ExampleHolderTypeThree) holder), picture);
                break;

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerItemClickListener != null)
                    recyclerItemClickListener.onItemClickListener(position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return pictureArrayList.size();
    }


    @Override
    public int getItemViewType(int position) {

        if (position % 3 == 0)
            return TYPE_ITEM_2;
        else if (position % 2 == 0)
            return TYPE_ITEM_3;


        return TYPE_ITEM_1;
    }


    public static class ExampleHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title)
        TextView title;
        @BindView(R.id.imageView)
        ImageView imageView;
        View view;

        public ExampleHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
        }

    }

    public static class ExampleHolderTypeTwo extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title)
        TextView title;
        @BindView(R.id.imageView)
        ImageView imageView;
        View view;

        public ExampleHolderTypeTwo(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
        }

    }

    public static class ExampleHolderTypeThree extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title)
        TextView title;
        @BindView(R.id.imageView)
        ImageView imageView;
        View view;

        public ExampleHolderTypeThree(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);

        }


    }

    private void setTypeItem1(ExampleHolder holder, Data picture) {
        holder.title.setText(picture.getName());
        holder.imageView.setImageResource(picture.getImage());
    }

    private void setTypeItem2(ExampleHolderTypeTwo holder, Data picture) {
        holder.title.setText(picture.getName());
        holder.imageView.setImageResource(picture.getImage());
    }

    private void setTypeItem3(ExampleHolderTypeThree holder, Data picture) {
        holder.title.setText(picture.getName());
        holder.imageView.setImageResource(picture.getImage());
    }

}
