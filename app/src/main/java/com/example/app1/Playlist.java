        package com.example.app1;


        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

        public class Playlist extends Fragment {
            MediaPlayer mediaplayer;
            ArrayList<PlaylistItem> mData;
            PlaylistAdapter adapter;
            public Playlist(){
                // Required empty public constructor
            }
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                mData = new ArrayList<PlaylistItem>();
                final PlaylistAdapter adapter = new PlaylistAdapter(mData);
                mData.add(new PlaylistItem("bad guy","Billie Eilish", R.drawable.a,"https://www.youtube.com/watch?v=DyDfgMOUjCI" ));
                mData.add(new PlaylistItem("Psycho", "Post Malone",R.drawable.b,"https://www.youtube.com/watch?v=au2n7VVGv_c"));
                mData.add(new PlaylistItem("Senorita","Shawn Mendes, Camila Cabello", R.drawable.c,"https://www.youtube.com/watch?v=Pkh8UtuejGw"));
                mData.add(new PlaylistItem("Sucker","Jonas Brother",R.drawable.d,"https://www.youtube.com/watch?v=CnAmeh0-E-U"));
                mData.add(new PlaylistItem("Jealous(feat. Chris Brown, Lil Wayne & Big Sean)","DJ Khaled",R.drawable.e,"https://www.youtube.com/watch?v=Dl37B3zlJ30"));
                mData.add(new PlaylistItem("Never Really Over","Katy Perry", R.drawable.f,"https://www.youtube.com/watch?v=aEb5gNsmGJ8"));

                RecyclerView rv = new RecyclerView(getContext());

                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                rv.setAdapter(adapter);

                adapter.setOnItemClickListener(new OnPlaylistItemClickListener() {
                    @Override
                    public void onItemClick(PlaylistViewHolder holder, View view, int position) {
                        PlaylistItem item= adapter.getItem(position);
                        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                        startActivity(browse);
                    }
                });

                return rv;
            }

            public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {
                ArrayList<PlaylistItem> mData;
                OnPlaylistItemClickListener listener;

                public PlaylistAdapter( ArrayList<PlaylistItem> mData) {
                    this.mData = mData;
                }

                @NonNull
                @Override
                public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                    View layout = layoutInflater.inflate(R.layout.playlist_item, parent, false);
                    return new PlaylistViewHolder(layout, listener);
                }

                @Override
                public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
                    holder.tv_name.setText(mData.get(position).getTitle());
                    holder.tv_number.setText(mData.get(position).getSinger());
                    holder.img_user.setImageResource(mData.get(position).getAlbumImg());
                }

                @Override
                public int getItemCount() {
                    return mData.size();
                }

                public PlaylistItem getItem(int position){return mData.get(position); }


                public void setOnItemClickListener(OnPlaylistItemClickListener listener){
                    this.listener = listener;
                }
                public void onItemClick(PlaylistViewHolder holder, View view, int position){
                    if(listener != null){
                        listener.onItemClick(holder, view, position);
                    }
                }

            }

            public class PlaylistViewHolder extends RecyclerView.ViewHolder {

                TextView tv_name, tv_number;
                ImageView img_user;

                public PlaylistViewHolder(@NonNull View itemView, final OnPlaylistItemClickListener listener){
                    super(itemView);
                    tv_name = itemView.findViewById(R.id.tv_title);
                    tv_number = itemView.findViewById(R.id.tv_singer);
                    img_user = itemView.findViewById(R.id.album_art);

                    itemView.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View view) {
                            int position = getAdapterPosition();
                            if(listener != null){
                                listener.onItemClick(PlaylistViewHolder.this, view, position );
                            }

                        }
                    });

                }
            }
        }

