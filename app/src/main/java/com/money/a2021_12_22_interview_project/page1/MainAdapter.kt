package com.money.a2021_12_22_interview_project.page1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.money.a2021_12_22_interview_project.R
import com.money.a2021_12_22_interview_project.api.UserData
import com.money.a2021_12_22_interview_project.tool.ImageLoaderManager

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataArray = ArrayList<UserData>()

    private lateinit var onUserItemClickListener: OnUserItemClickListener

    fun setOnUserItemClickListener(onUserItemClickListener: OnUserItemClickListener){
        this.onUserItemClickListener = onUserItemClickListener
    }

    fun setDataArray(dataArray : ArrayList<UserData>){
        this.dataArray = dataArray
    }

    companion object{
        private const val TITLE = 0

        private const val LIST = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TITLE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout,parent,false)
            return TitleViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_list_layout,parent,false)
        return UserListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is TitleViewHolder){
            holder.showView()
            return
        }
        if (holder is UserListViewHolder){
            holder.showView(dataArray[position - 1])
            holder.setOnUserItemClickListener(onUserItemClickListener)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TITLE else LIST
    }

    override fun getItemCount(): Int = dataArray.size + 1

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun showView() {

        }

    }

    class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val ivPhoto : ImageView = itemView.findViewById(R.id.item_photo)

        private val tvName : TextView = itemView.findViewById(R.id.item_name)

        private val tvStatus : TextView = itemView.findViewById(R.id.item_status)

        private val root : ConstraintLayout = itemView.findViewById(R.id.item_root)

        private lateinit var onUserItemClickListener: OnUserItemClickListener

        fun setOnUserItemClickListener(onUserItemClickListener: OnUserItemClickListener){
            this.onUserItemClickListener = onUserItemClickListener
        }

        fun showView(userData: UserData) {

            ImageLoaderManager.setPhotoUrl(userData.avatarUrl,ivPhoto)

            tvName.text = userData.login

            tvStatus.visibility = if (userData.siteAdmin) View.VISIBLE else View.GONE

            root.setOnClickListener {
                onUserItemClickListener.onUserClick(userData)
            }

        }

    }

    fun interface OnUserItemClickListener{
        fun onUserClick(data:UserData)
    }

}