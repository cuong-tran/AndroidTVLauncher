package vn.vnpttech.androidtv.video;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import vn.vnpttech.androidtv.R;
import vn.vnpttech.androidtv.detail.MediaModel;

public class NativeVideoActivity extends Activity {

    public static final String VIDEO = "Video";
    private VideoView mVideoView;
    private MediaModel mMediaModel;
    private MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // turn off the window's title bar, must be called before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Obsolete flag used for GB/HC to work correctly, but it's causing memory leaking in 7425B1 ICS
        //set fullscreen flag to window
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Avoid little bar on top of screen, visible while over-scan resize enabled.
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SCALED,
        //WindowManager.LayoutParams.FLAG_SCALED);

        //Avoid screen locked during video playback
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_nativevideo);

        mMediaModel = getIntent().getParcelableExtra(NativeVideoActivity.VIDEO);
    }

    @Override
    public void onStart() {
        super.onStart();

        //Start a playback from an URI
        mVideoView = findViewById(R.id.video_player);
        mMediaController = new MediaController(this);
        mMediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mMediaController);
        if (mVideoView != null) {
            mVideoView.setVideoURI(Uri.parse(mMediaModel.getVideoUrl()));
            mVideoView.requestFocus();
            // mVideoView.setLooping(true);//Set looping all the time which is convenient for demo
            mVideoView.start();
            String channel_name = mMediaModel.getTitle();
            Toast.makeText(getApplicationContext(),
                    channel_name, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mVideoView.pause();
        mVideoView.suspend();
        // mMediaController.hide();
        finish();
        //System.exit(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {

//        Log.d(TAG, "KEYCODE: " + keyCode);
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mVideoView.pause();
            mVideoView.suspend();
            // mMediaController.hide();
            // mMediaController.setEnabled(false);

            //Go back to cover flow activity
            //Intent myIntent = new Intent(this, MytvActivity.class);
            //startActivity(myIntent);

            finish();
            System.exit(0);
            return true;
        } else {
            return false;
        }
    }
}
