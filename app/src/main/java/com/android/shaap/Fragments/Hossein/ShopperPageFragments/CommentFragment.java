package com.android.shaap.Fragments.Hossein.ShopperPageFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.shaap.Adapters.ShopperPageAddapters.CommentRecAdapter;
import com.android.shaap.R;

import java.util.ArrayList;

// Created By Hossein
public class CommentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> myDataset ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataset = new ArrayList<>();
        myDataset.add("ناشناس");
        myDataset.add("علی");
        myDataset.add("احمد");
        myDataset.add("حسین");
        myDataset.add("سعید");
        myDataset.add("ناشناس");
        myDataset.add("سعید");
        myDataset.add("ناشناس");
        myDataset.add("سعید");
        myDataset.add("ناشناس");
        myDataset.add("سعید");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment,
                container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CommentRecAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}

