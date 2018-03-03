package gank.yl.com.gank.main.gank.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.view.ViewGroup
import gank.yl.com.gank.ImageActivity
import gank.yl.com.gank.R
import gank.yl.com.gank.common.BaseRecyclerAdapter
import gank.yl.com.gank.common.BaseRecyclerViewHolder
import gank.yl.com.gank.main.gank.entity.GankEntity
import gank.yl.com.gank.utils.displayImage
import kotlinx.android.synthetic.main.item_gank.view.*

/**
 * Created by YangLang on 2018/3/2.
 *
 */
class GankAdapter(val context: Context) : BaseRecyclerAdapter<GankEntity.ResultEntity>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
        val rootView = mLayoutInflater.inflate(R.layout.item_gank, parent, false)
        return GankViewHolder(rootView)
    }


    inner class GankViewHolder(itemView: View) : BaseRecyclerViewHolder(itemView) {

        private var url: String? = null

        init {
            itemView.mItemImage.setOnClickListener {
                val intent = Intent(context, ImageActivity::class.java)
                intent.putExtra("image", url)
                val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, itemView.mItemImage, "shareview")
                        .toBundle()
                ActivityCompat.startActivity(context, intent, bundle)
            }
        }

        override fun getData(data: Any) {
            if (data != null && data is GankEntity.ResultEntity) {
                url = data.url
                displayImage(context, itemView.mItemImage, url)
            }
        }
    }
}