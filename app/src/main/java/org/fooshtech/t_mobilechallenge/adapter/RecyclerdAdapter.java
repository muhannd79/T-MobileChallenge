package org.fooshtech.t_mobilechallenge.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.fooshtech.t_mobilechallenge.R;
import org.fooshtech.t_mobilechallenge.model.Cards;

import java.util.List;

public class RecyclerdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Cards> cards;

    private static final int VIEW_CARD_TYPE_TEXT = 0;
    private static final int VIEW_CARD_TYPE_TITLE_DESC = 1;
    private static final int VIEW_CARD_TITLE_DESC_IMAGE = 2;

    public RecyclerdAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (cards != null && cards.get(position).getCardType().equals("text")) {
            return VIEW_CARD_TYPE_TEXT;

        } else if(cards != null && cards.get(position).getCardType().equals("title_description")){
            return VIEW_CARD_TYPE_TITLE_DESC;

        } else if(cards != null && cards.get(position).getCardType().equals("image_title_description")){
                return VIEW_CARD_TITLE_DESC_IMAGE;
        }
        return -1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_CARD_TYPE_TEXT) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.layout_card, parent, false);
            return new ItemViewHolderText(view);

        } else if(viewType == VIEW_CARD_TYPE_TITLE_DESC){ // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.layout_card_title_desc, parent, false);
            return new ItemViewHolderTextDESC(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.layout_card_title_desc_imag, parent, false);
            return new ItemViewHolderTextDESCImage(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == VIEW_CARD_TYPE_TEXT) {
            Cards item = cards.get(position);
            ((ItemViewHolderText) holder).txt_title.setText(item.getCard().getValue());
            ((ItemViewHolderText) holder).txt_title.setTextColor(Color.parseColor(item.getCard().getAttributes().getTextColor()));
            ((ItemViewHolderText) holder).txt_title.setTextSize(item.getCard().getAttributes().getFont().getSize());

        } else if (getItemViewType(position) == VIEW_CARD_TYPE_TITLE_DESC) {

            Cards item = cards.get(position);
            ((ItemViewHolderTextDESC) holder).txt_title.setText(item.getCard().getTitle().getValue());
            ((ItemViewHolderTextDESC) holder).txt_title.setTextColor(Color.parseColor(item.getCard().getTitle().getAttributes().getTextColor()));
            ((ItemViewHolderTextDESC) holder).txt_title.setTextSize(item.getCard().getTitle().getAttributes().getFont().getSize());

            ((ItemViewHolderTextDESC) holder).txt_desc.setText(item.getCard().getDescription().getValue());
            ((ItemViewHolderTextDESC) holder).txt_desc.setTextColor(Color.parseColor(item.getCard().getDescription().getAttributes().getTextColor()));
            ((ItemViewHolderTextDESC) holder).txt_desc.setTextSize(item.getCard().getDescription().getAttributes().getFont().getSize());
        }
        else if (getItemViewType(position) == VIEW_CARD_TITLE_DESC_IMAGE) {

            Cards item = cards.get(position);

            int newHeight = item.getCard().getImage().getSize().getHeight();
            int newWidth = item.getCard().getImage().getSize().getWidth();
            ((ItemViewHolderTextDESCImage) holder).imageView.requestLayout();
            ((ItemViewHolderTextDESCImage) holder).imageView.getLayoutParams().height = newHeight;
            ((ItemViewHolderTextDESCImage) holder).imageView.getLayoutParams().width = newWidth;
            ((ItemViewHolderTextDESCImage) holder).imageView.setScaleType(ImageView.ScaleType.FIT_XY);
           // ((ItemViewHolderTextDESCImage) holder).imageView.setImageResource(R.drawable.video_menu);

            Glide.with(((ItemViewHolderTextDESCImage) holder).imageView.getContext())
                    .load(item.getCard().getImage().getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .into(((ItemViewHolderTextDESCImage) holder).imageView);

            ((ItemViewHolderTextDESCImage) holder).txt_title.setText(item.getCard().getTitle().getValue());
            ((ItemViewHolderTextDESCImage) holder).txt_title.setTextColor(Color.parseColor(item.getCard().getTitle().getAttributes().getTextColor()));
            ((ItemViewHolderTextDESCImage) holder).txt_title.setTextSize(item.getCard().getTitle().getAttributes().getFont().getSize());

            ((ItemViewHolderTextDESCImage) holder).txt_desc.setText(item.getCard().getDescription().getValue());
            ((ItemViewHolderTextDESCImage) holder).txt_desc.setTextColor(Color.parseColor(item.getCard().getDescription().getAttributes().getTextColor()));
            ((ItemViewHolderTextDESCImage) holder).txt_desc.setTextSize(item.getCard().getDescription().getAttributes().getFont().getSize());
        }
    }


    @Override
    public int getItemCount() {
        if (cards != null) {
            return cards.size();
        }
        return 0;
    }

    public void setItemList(List<Cards> itemList) {
        this.cards = itemList;
        notifyDataSetChanged();
    }

    //ViewHolder class
    class ItemViewHolderText extends RecyclerView.ViewHolder {

        TextView txt_title;

        ItemViewHolderText(View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.title);

        }
    }

    class ItemViewHolderTextDESC extends RecyclerView.ViewHolder {

        TextView txt_title, txt_desc;

        ItemViewHolderTextDESC(View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.title);
            txt_desc = itemView.findViewById(R.id.desc);
        }
    }

    class ItemViewHolderTextDESCImage extends RecyclerView.ViewHolder {

        TextView txt_title, txt_desc;
        ImageView imageView;

        ItemViewHolderTextDESCImage(View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.title);
            txt_desc = itemView.findViewById(R.id.desc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
