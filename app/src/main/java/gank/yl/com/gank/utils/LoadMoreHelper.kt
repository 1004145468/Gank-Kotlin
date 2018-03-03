package gank.yl.com.gank.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by YangLang on 2018/3/3.
 */
class LoadMoreHelper {

    companion object {

        fun init(recyclerview: RecyclerView, loadMoreConfigLoader: LoadMoreConfigLoader) {
            loadMoreConfigLoader.attachRecyclerView(recyclerview)
            recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 && loadMoreConfigLoader.canLoadMore()) {
                        loadMoreConfigLoader.LoadMoreData()
                    }
                }
            })
        }
    }

    abstract class LoadMoreConfigLoader {

        private lateinit var recyclerview: RecyclerView

        fun attachRecyclerView(recyclerview: RecyclerView) {
            this.recyclerview = recyclerview
        }

        open fun needLoadMore(): Boolean {
            val linearLayoutManager = recyclerview.layoutManager as LinearLayoutManager
            val itemCount = recyclerview.adapter.itemCount
            return linearLayoutManager.findLastVisibleItemPosition() == itemCount - 1
        }

        abstract fun isFinishLoadMore(): Boolean

        fun canLoadMore(): Boolean {
            return isFinishLoadMore() && needLoadMore()
        }

        abstract fun LoadMoreData()

    }

}