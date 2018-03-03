package gank.yl.com.gank.ext

import android.content.Context
import android.widget.Toast

/**
 * Created by YangLang on 2018/3/2.
 */
fun Context.showToast(content: String) = Toast.makeText(this, content, Toast.LENGTH_SHORT).show()