package com.example.app1;
import android.view.View;

public interface OnPlaylistItemClickListener {

    public void onItemClick(Playlist.PlaylistViewHolder holder, View view, int position);
}
