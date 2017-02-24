package com.android.shaap.Activitys.Mehrdad;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import com.android.shaap.R;

// created by mehrdad
public class HesabdariActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesabdari);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),
                new String[]{
                        "اسفند95",
                        "فروردین96",
                        "اردیبهشت96",
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }



    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }


        DecoView decoView11;
        DecoView decoView21;
        DecoView decoView31;
        DecoView decoView12;
        DecoView decoView22;
        DecoView decoView32;
        DecoView decoView13;
        DecoView decoView23;
        DecoView decoView33;
        DecoView decoView14;
        DecoView decoView24;
        DecoView decoView34;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_hesabdari, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            decoView11 = (DecoView) rootView.findViewById(R.id.arc_progress11);
            decoView21 = (DecoView) rootView.findViewById(R.id.arc_progress21);
            decoView31 = (DecoView) rootView.findViewById(R.id.arc_progress31);
            decoView12 = (DecoView) rootView.findViewById(R.id.arc_progress12);
            decoView22 = (DecoView) rootView.findViewById(R.id.arc_progress22);
            decoView32 = (DecoView) rootView.findViewById(R.id.arc_progress32);
            decoView13 = (DecoView) rootView.findViewById(R.id.arc_progress13);
            decoView23 = (DecoView) rootView.findViewById(R.id.arc_progress23);
            decoView33 = (DecoView) rootView.findViewById(R.id.arc_progress33);
            decoView14 = (DecoView) rootView.findViewById(R.id.arc_progress14);
            decoView24 = (DecoView) rootView.findViewById(R.id.arc_progress24);
            decoView34 = (DecoView) rootView.findViewById(R.id.arc_progress34);

            final TextView textPercentage11 = (TextView) rootView.findViewById(R.id.textPercentage11);
            final TextView textPercentage21 = (TextView) rootView.findViewById(R.id.textPercentage21);
            final TextView textPercentage31 = (TextView) rootView.findViewById(R.id.textPercentage31);
            final TextView textPercentage12 = (TextView) rootView.findViewById(R.id.textPercentage12);
            final TextView textPercentage22 = (TextView) rootView.findViewById(R.id.textPercentage22);
            final TextView textPercentage32 = (TextView) rootView.findViewById(R.id.textPercentage32);
            final TextView textPercentage13 = (TextView) rootView.findViewById(R.id.textPercentage13);
            final TextView textPercentage23 = (TextView) rootView.findViewById(R.id.textPercentage23);
            final TextView textPercentage33 = (TextView) rootView.findViewById(R.id.textPercentage33);
            final TextView textPercentage14 = (TextView) rootView.findViewById(R.id.textPercentage14);
            final TextView textPercentage24 = (TextView) rootView.findViewById(R.id.textPercentage24);
            final TextView textPercentage34 = (TextView) rootView.findViewById(R.id.textPercentage34);


            setper(rootView, decoView11, textPercentage11, 80);
            setper(rootView, decoView21, textPercentage21, 45);
            setper(rootView, decoView31, textPercentage31, 23);

            setper(rootView, decoView12, textPercentage12, 9);
            setper(rootView, decoView22, textPercentage22, 14);
            setper(rootView, decoView32, textPercentage32, 1);

            setper(rootView, decoView13, textPercentage13, 63);
            setper(rootView, decoView23, textPercentage23, 52);
            setper(rootView, decoView33, textPercentage33, 89);

            setper(rootView, decoView14, textPercentage14, 33);
            setper(rootView, decoView24, textPercentage24, 66);
            setper(rootView, decoView34, textPercentage34, 44);


            return rootView;
        }

        void setper(View rootView, DecoView DV, final TextView tv, int per) {
            SeriesItem backItem = new SeriesItem.Builder(Color.parseColor("#FFD6D6D6"))
                    .setRange(0, 1, 1)
                    .build();

            DV.addSeries(backItem);

            final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FF540075"))
                    .setRange(0, 100, 0)
                    .build();

            int series1Index = DV.addSeries(seriesItem);


            seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
                @Override
                public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                    float percentFilled = ((currentPosition - seriesItem.getMinValue()) / (seriesItem.getMaxValue() - seriesItem.getMinValue()));
                    tv.setText(String.format("%.0f%%", percentFilled * 100f));
                }

                @Override
                public void onSeriesItemDisplayProgress(float percentComplete) {

                }
            });
            DV.addEvent(new DecoEvent.Builder(per)
                    .setIndex(series1Index)
                    .setDuration(5000)
                    .build());


        }


    }
}
