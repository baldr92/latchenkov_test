package com.lpn.latchenkov_test;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Paul on 30.10.2017.
 */

public class ObjectsAdapter extends RecyclerView.Adapter<ObjectsAdapter.ViewHolder> {


    @Override
    public ObjectsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //загружаем разметку в зависимости от типа
        //и получаем нужный холдер
        ObjectsAdapter.ViewHolder viewHolder = null;   //возможно из-за этого нулла может быть ошибка !!!!
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
                EditText editText = (EditText) cardView.findViewById(R.id.edit_post);
                TextView textView = (TextView) cardView.findViewById(R.id.text_posts);
                String idText = editText.getText().toString();
                int id = Integer.parseInt(idText);
                textView.setText(id);

        }

    }

    @Override
    public int getItemCount() {
        //возвращаем кол-во вариантов в наборе данных

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        if (position == 2) {
            return 2;
        }
        if (position == 3) {
            return 3;
        } else {
            return 4;
        }
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        //определяем класс ViewHolder
        private CardView cardview;
        public ViewHolder(CardView v) {
            super(v);
            cardview = v;
        }
    }

}
