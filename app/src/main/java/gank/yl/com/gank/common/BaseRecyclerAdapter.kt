package gank.yl.com.gank.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

/**
 * Created by YangLang on 2018/3/2.
 */
abstract class BaseRecyclerAdapter<T : Any> : RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected val mLayoutInflater: LayoutInflater

    constructor(context: Context) : super() {
        mLayoutInflater = LayoutInflater.from(context)
    }

    private lateinit var mData: ArrayList<T>

    fun setData(datasource: ArrayList<T>) {
        this.mData = datasource
    }

    fun addData(data: T) {
        this.mData.add(data)
        notifyItemInserted(mData.size)
    }

    fun addDatas(datas: ArrayList<T>) {
        val originSize = this.mData.size
        this.mData.addAll(datas)
        notifyItemRangeInserted(originSize, datas.size)
    }

    fun clearDatas() {
        this.mData.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder?, position: Int) {
        holder?.getData(mData[position])
    }
}