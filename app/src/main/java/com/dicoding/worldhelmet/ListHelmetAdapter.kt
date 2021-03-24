package com.dicoding.worldhelmet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class ListHelmetAdapter(private val listHelmet: ArrayList<Helmet>): RecyclerView.Adapter<ListHelmetAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_helmet, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHelmet.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val helmet = listHelmet[position]
        Glide.with(holder.itemView.context)
                .load(helmet.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)
        holder.tvName.text = helmet.name
        holder.tvDetail.text = helmet.detail

        holder.itemView.setOnClickListener {
            val context= holder.itemView.context
            val helmetDetailActivity = Intent(context, Detail::class.java)
            helmetDetailActivity.putExtra(Detail.EXTRA_NAME, helmet.name)
            helmetDetailActivity.putExtra(Detail.EXTRA_IMAGE, helmet.photo)
            helmetDetailActivity.putExtra(Detail.EXTRA_DESC, helmet.detail)
            helmetDetailActivity.putExtra(Detail.EXTRA_YEAR, helmet.year)
            helmetDetailActivity.putExtra(Detail.EXTRA_FEATURES, helmet.features)
            helmetDetailActivity.putExtra(Detail.EXTRA_MATERIAL, helmet.material)
            helmetDetailActivity.putExtra(Detail.EXTRA_HOMOLOGATION, helmet.homologation)
            helmetDetailActivity.putExtra(Detail.EXTRA_GALLERY1, helmet.gallery1)
            helmetDetailActivity.putExtra(Detail.EXTRA_GALLERY2, helmet.gallery2)
            helmetDetailActivity.putExtra(Detail.EXTRA_GALLERY3, helmet.gallery3)
            helmetDetailActivity.putExtra(Detail.EXTRA_SIZE, helmet.size)
            context.startActivity(helmetDetailActivity)
        }

    }
}