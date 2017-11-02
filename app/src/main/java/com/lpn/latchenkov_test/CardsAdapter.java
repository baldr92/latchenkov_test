package com.lpn.latchenkov_test;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Paul on 30.10.2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder> {

    DataState state;
    Context context;
    PostGetListener postGetListener;

    public CardsAdapter(Context context) {
        this.context = context;
    }

    public void setPostGetListener(PostGetListener postGetListener) {
        this.postGetListener = postGetListener;
    }

    public void setData(DataState state) {
        this.state = state;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //загружаем разметку в зависимости от типа
        //и получаем нужный холдер
        CardsAdapter.ViewHolder viewHolder = null;   //возможно из-за этого нулла может быть ошибка !!!!
        CardView itemLayoutView;

        switch (viewType) {
            case 0:
                itemLayoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_card, parent,false);
                viewHolder = new ViewHolder (itemLayoutView);
                break;
            case 1:
                itemLayoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_card, parent, false);
                viewHolder = new ViewHolder(itemLayoutView);
                break;
            case 2:
                itemLayoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.users_card, parent, false);
                viewHolder = new ViewHolder(itemLayoutView);
                break;
            case 3:
                itemLayoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.photos_card, parent, false);
                viewHolder = new ViewHolder(itemLayoutView);
                break;
            case 4:
                itemLayoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.todos_card, parent, false);
                viewHolder = new ViewHolder(itemLayoutView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //заполняем заданные представления данными
        switch (this.getItemViewType(position)) {
            case 0:
                CardView cardView = holder.cardview;
                final EditText editText = (EditText) cardView.findViewById(R.id.edit_post);
                TextView textView = (TextView) cardView.findViewById(R.id.text_posts);
                Button action = new Button(context);
                // button
                action.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id = editText.getText().toString();
                        postGetListener.getPost(Integer.valueOf(id));
                    }
                });
                String idText = editText.getText().toString();
                int id = Integer.parseInt(idText);
                textView.setText(id);

        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        ItemType type = ItemType.getFromValue(position);
        return type.getValue();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //определяем класс ViewHolder
        private CardView cardview;
        public ViewHolder(CardView v) {
            super(v);
            cardview = v;
        }
    }

    public enum ItemType {
        POSTS(0),
        COMMENTS(1),
        USERS(2),
        PHOTOS(3),
        TODOS(4);

        int value;

        ItemType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        static ItemType getFromValue(int value) {
            for (ItemType type : ItemType.values()) {
                if (type.getValue() == value) {
                    return type;
                }
            }
            return POSTS;
        }
    }

    public interface PostGetListener {
        void getPost(int id);
    }
}
