package com.carbonWeightwatchers.cww.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.carbonWeightwatchers.cww.presenter.viewModel.CarbonWeightWatcherViewModel

@BindingAdapter("imagePaths", "pathError", "imageOption")
fun loadImage(imageView: ImageView, @Nullable path:String?, errorDrawable: Drawable, option:String) {
    var myOptions = RequestOptions()
        .placeholder(errorDrawable)
        .error(errorDrawable)


    when(option) {
        "fit" -> myOptions = myOptions.fitCenter()
        "inside" -> myOptions = myOptions.centerInside()
        "crop" -> myOptions = myOptions.centerCrop()
    }

    Glide.with(imageView.context)
        .load(path ?: "")
        .apply(myOptions)
        .into(imageView)
}


@BindingAdapter("addTextChangeListener")
fun addTextChangeListener(view: SearchView, @Nullable modelItemCarbon: CarbonWeightWatcherViewModel?) {

    view?.setOnQueryTextListener(
        object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0?.isNotEmpty() == true)
                    modelItemCarbon?. carbonWeightWatcherModelItem?.filter { it.title.toLowerCase().contains(p0.toLowerCase())
                    }.let { tt ->
                        modelItemCarbon?.  adapter?.differ?.submitList(tt)
                        // showEmptyView(tt.isEmpty())
                    }
                else
                    modelItemCarbon?.getWeightWatcher()
                return false
            }
        }
    )
    view?.setOnCloseListener {
        modelItemCarbon?.onCreate()
        false
    }

}




@BindingAdapter("date")
fun TextView.convertDate(rawDate:String?) {
    text = rawDate?.let {
        rawDate.substring(0,4) + "/" + rawDate.substring(4,6) + "/" + rawDate.substring(6)
    } ?: ""
}

@BindingConversion
fun convertBooleanToVisibility(visible:Boolean) :Int {
    return if(visible) View.VISIBLE else View.GONE
}
