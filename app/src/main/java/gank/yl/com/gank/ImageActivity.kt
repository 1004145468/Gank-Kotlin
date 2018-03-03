package gank.yl.com.gank

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.view.DraweeTransition
import gank.yl.com.gank.utils.displayImage
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //如果采用Fresco 进行专场动画 需要申明这两句话
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.sharedElementEnterTransition = DraweeTransition.createTransitionSet(ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP)
             window.sharedElementReturnTransition = DraweeTransition.createTransitionSet(ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP)
        }
        setContentView(R.layout.activity_image)
        val bitmapUrl = intent.getStringExtra("image")
        displayImage(this, mPicView, bitmapUrl)
        mPicView.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition()
            }
        }
    }
}
