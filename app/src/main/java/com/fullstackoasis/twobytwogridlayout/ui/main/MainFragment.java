package com.fullstackoasis.twobytwogridlayout.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fullstackoasis.twobytwogridlayout.R;

import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getCanonicalName();
    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        doFadeIn();
                    }
                });

            }
        }, 5000);
        setImageDrawable(R.id.upperLeft, R.drawable.maryna_vasylieva_unsplash);
        setImageDrawable(R.id.upperRight, R.drawable.tyler_nix_unsplash);
        setImageDrawable(R.id.lowerLeft, R.drawable.taisiia_shestopal_unsplash);
        setImageDrawable(R.id.lowerRight, R.drawable.natali_navytka_unsplash);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private void setImageDrawable(int viewId, int drawableId) {
        ViewGroup vg = getActivity().findViewById(viewId);
        Drawable d = getResources().getDrawable(drawableId);
        ImageView iv = vg.findViewById(R.id.iv_latte);
        iv.setImageDrawable(d);
    }

    private void doFadeIn() {
        Log.d(TAG, "doFadeIn");
// Create the scene root for the scenes in this app
        ViewGroup sceneRoot = (ViewGroup) getActivity().findViewById(R.id.scene_root);
        Scene aScene = Scene.getSceneForLayout(sceneRoot, R.layout.main_fragment_empty, getContext());
        Scene anotherScene =
                Scene.getSceneForLayout(sceneRoot, R.layout.main_fragment_scene2, getContext());
        Transition fadeTransition =
                TransitionInflater.from(getContext()).
                        inflateTransition(R.transition.fade_transition);
        TransitionManager.go(anotherScene, fadeTransition);
    }

}