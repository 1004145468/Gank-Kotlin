package gank.yl.com.gank.common

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import gank.yl.com.gank.utils.dp2px

/**
 * Created by YangLang on 2018/3/2.
 */
class SpaceItemDecoration(private val bottomSpace: Float) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect.set(0, 0, 0, dp2px(view.context, bottomSpace))
    }
}