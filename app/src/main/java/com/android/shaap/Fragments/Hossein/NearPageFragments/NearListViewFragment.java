package com.android.shaap.Fragments.Hossein.NearPageFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.shaap.Adapters.NearAdapters.NearListViewAdapter;
import com.android.shaap.GetersAndSeters.Hossein.NearShoppersItems;
import com.android.shaap.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hossein on 11/02/2017.
 */
public class NearListViewFragment extends Fragment {
    ListView listView;
    List<NearShoppersItems> nearShoppersItemsList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nearShoppersItemsList = new ArrayList<>();

        NearShoppersItems nearShoppersItems = new NearShoppersItems("رستوران شیلا","خیابان انقلاب،نرسیده به پمب بنزین بعثت،جنب بانک مرکزی" ,3,R.drawable.shila_logo,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران هایداا","خیابان انقلاب،بعد از درب اصلی دانشگاه تهران،روبروی انتشارات دانشگاه تهران" ,4,R.drawable.resturan2,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران کی اف سی","بعد از پل چوبی،نبش کوچه یاسینی" ,2,R.drawable.resturan3,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
        nearShoppersItems = new NearShoppersItems("رستوران پدر خوب","قبل از متروی انقلای،پاساژ امیر،پلاک 8" ,1,R.drawable.resturan4,35.686450, 51.373527);//String name, String address, float stars, Bitmap imageOfShopper
        nearShoppersItemsList.add(nearShoppersItems);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_near_listview,
                container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new NearListViewAdapter(getActivity(), nearShoppersItemsList));
        return view;
    }
}
