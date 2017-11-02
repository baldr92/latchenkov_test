package com.lpn.latchenkov_test;

import android.support.annotation.Nullable;

/**
 * Created by Paul on 01.11.17.
 */

public class DataState {
    @Nullable
    private Post post;
    // comment
    // photo
    // todo

    public void setPost(@Nullable Post post) {
        this.post = post;
    }

    @Nullable
    public Post getPost() {
        return post;
    }
}
//1