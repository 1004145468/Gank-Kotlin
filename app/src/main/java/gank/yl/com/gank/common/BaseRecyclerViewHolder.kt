package gank.yl.com.gank.common

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by YangLang on 2018/3/2.
 */
abstract class BaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun getData(data: Any)
}