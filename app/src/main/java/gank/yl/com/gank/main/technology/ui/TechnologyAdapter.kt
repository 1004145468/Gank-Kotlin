package gank.yl.com.gank.main.technology.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import gank.yl.com.gank.R
import gank.yl.com.gank.common.BaseRecyclerAdapter
import gank.yl.com.gank.common.BaseRecyclerViewHolder
import gank.yl.com.gank.ext.isEmpty
import gank.yl.com.gank.main.technology.entity.TechnologyEntity
import gank.yl.com.gank.utils.displayImage
import kotlinx.android.synthetic.main.item_techlogy.view.*

/**
 * Created by YangLang on 2018/3/3.
 */
class TechnologyAdapter(private val context: Context) : BaseRecyclerAdapter<TechnologyEntity.ResultEntity>(context) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerViewHolder {
        val rootView = mLayoutInflater.inflate(R.layout.item_techlogy, parent, false)
        return TechnologyViewHolder(rootView)
    }

    inner class TechnologyViewHolder(itemView: View) : BaseRecyclerViewHolder(itemView) {

        private var linkUrl: String? = null

        init {
            itemView.setOnClickListener {
                if (!linkUrl.isNullOrEmpty()) {
                    val intent = Intent()
                    intent.action = Intent.ACTION_VIEW
                    intent.data = Uri.parse(linkUrl)
                    context.startActivity(intent)
                }
            }
        }

        override fun getData(data: Any) {
            if (data != null && data is TechnologyEntity.ResultEntity) {
                linkUrl = data.url
                itemView.mTechnologyDes.text = data.desc
                if (!isEmpty(data.images)) {
                    val images = data.images!!
                    displayImage(context, itemView.mTechnologyCover1, images[0])
                    if (images.size > 1) {
                        itemView.mTechnologyCover2.visibility = View.VISIBLE
                        displayImage(context, itemView.mTechnologyCover2, images[1])
                    } else {
                        itemView.mTechnologyCover2.visibility = View.GONE
                    }
                }
            }
        }
    }
}