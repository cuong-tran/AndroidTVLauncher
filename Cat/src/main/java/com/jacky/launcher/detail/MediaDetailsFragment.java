package com.jacky.launcher.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewLogoPresenter;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.support.v17.leanback.widget.SparseArrayObjectAdapter;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.jacky.launcher.R;
import com.jacky.launcher.video.NativeVideoActivity;
import com.jacky.launcher.video.VideoActivity;

/**
 * @author jacky
 * @version v1.0
 * @since 16/8/28
 */
public class MediaDetailsFragment extends DetailsFragment {

    public static final boolean USE_NATIVE_PLAYER = false;
    private static final int ACTION_VIDEO_PLAY = 1;
    private ArrayObjectAdapter mRowsAdapter;
    private MediaModel mMediaModel;
    private Context mContext;
    private BackgroundManager mBackgroundManager;
    private DisplayMetrics mMetrics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        mMediaModel = getActivity().getIntent().getParcelableExtra(MediaDetailsActivity.MEDIA);

        prepareBackgroundManager();
        buildDetails();
    }

    private void prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(getActivity());
        mBackgroundManager.attach(getActivity().getWindow());
        mMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
    }

    private void buildDetails() {
        ClassPresenterSelector selector = new ClassPresenterSelector();
        FullWidthDetailsOverviewRowPresenter rowPresenter = new FullWidthDetailsOverviewRowPresenter(
                new MediaDetailsDescriptionPresenter(),
                new DetailsOverviewLogoPresenter());

        rowPresenter.setOnActionClickedListener(new OnActionClickedListener() {

            @Override
            public void onActionClicked(Action action) {
                if (action.getId() == ACTION_VIDEO_PLAY) {
                    Intent intent;
                    if (USE_NATIVE_PLAYER) {
                        intent = new Intent(getActivity(), NativeVideoActivity.class);
                        intent.putExtra(NativeVideoActivity.VIDEO, mMediaModel);
                    } else {
                        intent = new Intent(getActivity(), VideoActivity.class);
                        intent.putExtra(VideoActivity.VIDEO, mMediaModel);
                    }
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), action.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        selector.addClassPresenter(DetailsOverviewRow.class, rowPresenter);
        selector.addClassPresenter(ListRow.class, new ListRowPresenter());
        mRowsAdapter = new ArrayObjectAdapter(selector);

        final DetailsOverviewRow detailsOverview = new DetailsOverviewRow(mMediaModel);

        Glide.with(mContext)
                .load(mMediaModel.getImageUrl())
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {

                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        detailsOverview.setImageBitmap(mContext, resource);
                        return true;
                    }
                })
                .into(-1, -1);

        updateBackground(mMediaModel.getImageUrl());

        SparseArrayObjectAdapter adapter = new SparseArrayObjectAdapter();
        // If current MediaModel has a Video URL then show the Play button
        if (!mMediaModel.getVideoUrl().isEmpty()) {
            adapter.set(ACTION_VIDEO_PLAY, new Action(ACTION_VIDEO_PLAY, getString(R.string.action_video_play)));
        }
        detailsOverview.setActionsAdapter(adapter);
        mRowsAdapter.add(detailsOverview);

        setAdapter(mRowsAdapter);
    }

    private void updateBackground(String uri) {
        Glide.with(this)
                .load(uri)
                .asBitmap()
                .centerCrop()
                .into(new SimpleTarget<Bitmap>(mMetrics.widthPixels, mMetrics.heightPixels) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        mBackgroundManager.setBitmap(resource);
                    }
                });
    }

    @Override
    public void onStop() {
        mBackgroundManager.release();
        super.onStop();
    }
}