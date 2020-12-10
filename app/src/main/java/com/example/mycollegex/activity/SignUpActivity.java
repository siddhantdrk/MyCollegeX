package com.example.mycollegex.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mycollegex.Adapters.SignUpFragmentStateAdapter;
import com.example.mycollegex.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SignUpActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
        mViewPager2.setAdapter(new SignUpFragmentStateAdapter(SignUpActivity.this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Institute");
                } else {
                    tab.setText("Student");
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }

    private void initViews() {
        mViewPager2 = findViewById(R.id.sign_up_view_pager);
        mTabLayout = findViewById(R.id.sign_up_tab_layout);
    }
}