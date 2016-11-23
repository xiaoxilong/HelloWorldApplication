package com.example.administrator.helloworldapplication.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.helloworldapplication.R;
import com.example.administrator.helloworldapplication.base.BaseActivity;
import com.example.administrator.helloworldapplication.ui.fragment.CollectionFragment;
import com.example.administrator.helloworldapplication.ui.fragment.ContactsFragment;
import com.example.administrator.helloworldapplication.ui.fragment.DailFragment;
import com.example.administrator.helloworldapplication.ui.fragment.YelloPageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class CallViewActivity extends BaseActivity  implements ViewPager.OnPageChangeListener{

    @InjectView(R.id.dial)
    TextView dial;
    @InjectView(R.id.contacts)
    TextView contacts;
    @InjectView(R.id.collection)
    TextView collection;
    @InjectView(R.id.yellowPage)
    TextView yellowPage;
    @InjectView(R.id.viewpage)
    ViewPager viewpage;

    private List<Fragment> fragmentList = new ArrayList<>();
    private DailFragment dailFragment;
    private ContactsFragment contactsFragment;
    private CollectionFragment collectionFragment;
    private YelloPageFragment yelloPageFragment;

    private FragmentPagerAdapter pagerAdapter;
    private int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_view);
        ButterKnife.inject(this);

        initFragment();
        viewpage.setAdapter(pagerAdapter);
        viewpage.setCurrentItem(0);
        dial.setTextColor(Color.RED);
        viewpage.setOnPageChangeListener(this);
    }

    private void initFragment() {
        dailFragment = new DailFragment();
        contactsFragment = new ContactsFragment();
        collectionFragment = new CollectionFragment();
        yelloPageFragment = new YelloPageFragment();

        fragmentList.add(dailFragment);
        fragmentList.add(contactsFragment);
        fragmentList.add(collectionFragment);
        fragmentList.add(yelloPageFragment);

        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };


    }

    @OnClick({R.id.dial, R.id.contacts, R.id.collection, R.id.yellowPage})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dial:
                dial.setTextColor(Color.RED);
                viewpage.setCurrentItem(0);
                contacts.setTextColor(Color.BLUE);
                collection.setTextColor(Color.BLUE);
                yellowPage.setTextColor(Color.BLUE);
                break;
            case R.id.contacts:
                contacts.setTextColor(Color.RED);
                viewpage.setCurrentItem(1);
                dial.setTextColor(Color.BLUE);
                collection.setTextColor(Color.BLUE);
                yellowPage.setTextColor(Color.BLUE);
                break;
            case R.id.collection:
                collection.setTextColor(Color.RED);
                viewpage.setCurrentItem(2);
                dial.setTextColor(Color.BLUE);
                contacts.setTextColor(Color.BLUE);
                yellowPage.setTextColor(Color.BLUE);
                break;
            case R.id.yellowPage:
                yellowPage.setTextColor(Color.RED);
                viewpage.setCurrentItem(3);
                dial.setTextColor(Color.BLUE);
                collection.setTextColor(Color.BLUE);
                contacts.setTextColor(Color.BLUE);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (position){
            case 0:
                dial.setTextColor(Color.RED);
                yellowPage.setTextColor(Color.BLUE);
                collection.setTextColor(Color.BLUE);
                contacts.setTextColor(Color.BLUE);
                break;
            case 1:
                contacts.setTextColor(Color.RED);
                yellowPage.setTextColor(Color.BLUE);
                collection.setTextColor(Color.BLUE);
                dial.setTextColor(Color.BLUE);
                break;
            case 2:
                collection.setTextColor(Color.RED);
                dial.setTextColor(Color.BLUE);
                yellowPage.setTextColor(Color.BLUE);
                contacts.setTextColor(Color.BLUE);
                break;
            case 3:
                yellowPage.setTextColor(Color.RED);
                dial.setTextColor(Color.BLUE);
                collection.setTextColor(Color.BLUE);
                contacts.setTextColor(Color.BLUE);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {



    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
