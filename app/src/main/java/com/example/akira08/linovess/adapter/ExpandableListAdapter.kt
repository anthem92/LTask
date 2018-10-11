package com.example.akira08.linovess.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.akira08.linovess.R
import com.example.akira08.linovess.model.MenuModel


class ExpandableListAdapter(var context: Context, var expandableListView : ExpandableListView, var menuObject:MutableList<MenuModel>) : BaseExpandableListAdapter(){

    override fun getGroup(groupPosition: Int): MenuModel {
        return menuObject.get(groupPosition)
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_group,null)
        }

        val title = convertView?.findViewById<TextView>(R.id.main_title_navbar)
        title?.text = menuObject.get(groupPosition).headerText

        val icon = convertView?.findViewById<ImageView>(R.id.main_icon_navbar)

        if(!menuObject.get(groupPosition).drawableName.equals("")){
            val resID = context.getResources().getIdentifier(menuObject.get(groupPosition).drawableName, "drawable", context.getPackageName())
            icon?.setImageResource(resID)
        }
        else{
            icon?.setImageResource(android.R.color.transparent)
        }

        title?.setOnClickListener {
            if(expandableListView.isGroupExpanded(groupPosition))
                expandableListView.collapseGroup(groupPosition)
            else
                expandableListView.expandGroup(groupPosition)
        }
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return menuObject.get(groupPosition).bodyText.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): MutableList<Any> {
        return menuObject.get(groupPosition).bodyText.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_item,null)
        }

        val title = convertView?.findViewById<TextView>(R.id.sub_title)
        title?.text = getChild(groupPosition,childPosition).get(0).toString()



        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return menuObject.size
    }

}
