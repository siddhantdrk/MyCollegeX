package com.example.mycollegex.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mycollegex.Fragments.InstituteSignUpFragment;
import com.example.mycollegex.Fragments.StudentSignUpFragment;

public class SignUpFragmentStateAdapter extends FragmentStateAdapter {

    public SignUpFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new InstituteSignUpFragment();
        } else {
            return new StudentSignUpFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
