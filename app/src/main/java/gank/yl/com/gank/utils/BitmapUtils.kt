package gank.yl.com.gank.utils

import android.content.Context
import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder


/**
 * Created by YangLang on 2018/3/3.
 */
fun displayImage(context: Context, draweeView: SimpleDraweeView, url: String?) {
    if (url.isNullOrEmpty() || (draweeView.tag != null && (draweeView.tag as String) == url)) {
        return
    }
    draweeView.tag = url
    val uri = Uri.parse(url)
    val request = ImageRequestBuilder.newBuilderWithSource(uri)
            .setResizeOptions(ResizeOptions(getScreenWidth(context), dp2px(context, 150f)))
            .build()

    val controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(request)
            .setOldController(draweeView.controller)
            .build()
    draweeView.controller = controller
}