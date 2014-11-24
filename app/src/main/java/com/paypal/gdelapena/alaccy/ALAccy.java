package com.paypal.gdelapena.alaccy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class ALAccy extends Activity implements ActionBar.TabListener {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    public static final String logTag = "ALAccy : ";

    public LocationListener _networkListener;
    LocationListener _gpsListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaccy);




        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Set up the icons
        final int[] TabIcons = new int[]{
                R.drawable.ic_action_map,
                R.drawable.ic_empty,
                R.drawable.ic_empty
        };

        mSectionsPagerAdapter = new SectionsPagerAdapter(this, getFragmentManager());


        //CoordinatesFragment articleFrag = (CoordinatesFragment) getFragmentManager().findFragmentById(R.id.fragment_coordinates);


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setIcon(getResources().getDrawable(TabIcons[i]))
                            .setTabListener(this));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alaccy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }

        if (id == R.id.action_startListening){
            onStartListening(item);
        }

        if (id == R.id.action_stopListening){
            onStopListening(item);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onStartListening(MenuItem item){
        Log.d(logTag, "Started listening");

        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        _networkListener = new MyLocationListener();
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,0, _networkListener);

        _gpsListener = new MyLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, _gpsListener);
    }

    public void onStopListening(MenuItem item){
        Log.d(logTag, "Stopped listening");
        DoStopListening();
    }

    void DoStopListening(){
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        if(_networkListener != null){
            lm.removeUpdates(_networkListener);
            _networkListener = null;
        }

        if(_gpsListener != null){
            lm.removeUpdates(_gpsListener);
            _gpsListener = null;
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
}
