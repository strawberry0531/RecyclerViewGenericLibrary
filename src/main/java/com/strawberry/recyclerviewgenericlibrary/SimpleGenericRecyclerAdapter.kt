package com.strawberry.recyclerviewgenericlibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class SimpleGenericRecyclerAdapter<T :Any>(
    private val dataSet: List<T>, @LayoutRes val layoutID: Int,
    private val bindingInterface: GenericSimpleRecyclerBindingInterface<T>
) :
    RecyclerView.Adapter<SimpleGenericRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun <T : Any> bind(
            item: T,
            bindingInterface: GenericSimpleRecyclerBindingInterface<T>
        ) = bindingInterface.bindData(item,view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutID, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item,bindingInterface)
    }

    override fun getItemCount(): Int = dataSet.size
}

interface GenericSimpleRecyclerBindingInterface<T:Any> {
    fun bindData(item: T,view:View)
}
