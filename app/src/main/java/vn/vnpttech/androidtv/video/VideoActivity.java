package vn.vnpttech.androidtv.video;

import android.app.Activity;
import android.os.Bundle;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import vn.vnpttech.androidtv.R;
import vn.vnpttech.androidtv.detail.MediaModel;

public class VideoActivity extends Activity {

    public static final String VIDEO = "Video";
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private MediaModel mMediaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mMediaModel = getIntent().getParcelableExtra(VideoActivity.VIDEO);

        JCVideoPlayer.TOOL_BAR_EXIST = false;
        JCVideoPlayer.ACTION_BAR_EXIST = false;

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.video_player);

        jcVideoPlayerStandard.setUp(mMediaModel.getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, mMediaModel.getTitle());
        jcVideoPlayerStandard.startPlayLocic();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
