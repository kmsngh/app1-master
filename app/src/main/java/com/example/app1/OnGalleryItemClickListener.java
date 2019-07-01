package com.example.app1;

import android.view.View;

public interface OnGalleryItemClickListener {

    public void onItemClick(StaggeredRecyclerAdapter.ImageViewHolder holder, View view, int position);
}
