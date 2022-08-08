package com.example.asteroidradar

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.asteroidradar.data.model.PictureOfDay
import com.squareup.picasso.Picasso


@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
        imageView.contentDescription = String.format(R.string.potentially_hazardous_asteroid_image.toString())
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
        imageView.contentDescription = String.format(R.string.not_hazardous_asteroid_image.toString())
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
        imageView.contentDescription = String.format(R.string.potentially_hazardous_asteroid_image.toString())

    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
        imageView.contentDescription = String.format(R.string.not_hazardous_asteroid_image.toString())
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}

@BindingAdapter("pictureOfDay")
fun bindImagePictureOfDay(imageView: ImageView, data: PictureOfDay?) {

    data?.let {

        if (it.mediaType == "image") {

            Picasso.with(imageView.context)
                .load(it.url)
                .into(imageView)

            // Reference: use Glide works as well
            /*
            Glide.with(imageView.context)
                .load(it.url)
                .into(imageView)*/

            val strFormat = imageView.resources.getString(
                R.string.nasa_picture_of_day_content_description_format)
            imageView.contentDescription = String.format(strFormat, it.title)

        }
    }
}
