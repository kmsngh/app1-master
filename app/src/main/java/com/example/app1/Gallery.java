package com.example.app1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gallery extends Fragment {

    private StaggeredGridLayoutManager manager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList mData = new ArrayList<row>();
        mData.add(new row(R.drawable.gala));
        mData.add(new row(R.drawable.galb));
        mData.add(new row(R.drawable.galc));
        mData.add(new row(R.drawable.gald));
        mData.add(new row(R.drawable.gale));
        mData.add(new row(R.drawable.galf));
        mData.add(new row(R.drawable.galg));
        mData.add(new row(R.drawable.galh));
        mData.add(new row(R.drawable.gali));
        mData.add(new row(R.drawable.galj));
        mData.add(new row(R.drawable.gala));
        mData.add(new row(R.drawable.galb));
        mData.add(new row(R.drawable.galc));
        mData.add(new row(R.drawable.gald));
        mData.add(new row(R.drawable.gale));
        mData.add(new row(R.drawable.galf));
        mData.add(new row(R.drawable.galg));
        mData.add(new row(R.drawable.galh));
        mData.add(new row(R.drawable.gali));
        mData.add(new row(R.drawable.galj));

        RecyclerView staggeredRv  = new RecyclerView(getContext());
        staggeredRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        StaggeredRecyclerAdapter adapter = new StaggeredRecyclerAdapter(getContext(), mData);
        staggeredRv.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnGalleryItemClickListener() {
            @Override
            public void onItemClick(StaggeredRecyclerAdapter.ImageViewHolder holder, View view, int position) {

        });

        return staggeredRv;
    }
    }


}
