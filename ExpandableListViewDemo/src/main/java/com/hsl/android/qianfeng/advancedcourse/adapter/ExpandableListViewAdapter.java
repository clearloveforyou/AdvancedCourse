package com.hsl.android.qianfeng.advancedcourse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hsl.android.qianfeng.advancedcourse.R;

import java.util.List;

/**
 * Created by clearlove on 2016/3/15.
 */
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private List<String> groupData;//组显示
    private List<String> childData;//子列表
    private LayoutInflater inflater;

    public ExpandableListViewAdapter(List<String> groupData, List<String> childData, Context context) {
        this.groupData = groupData;
        this.childData = childData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupData != null ? groupData.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData != null ? childData.size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //行是否具有唯一id
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ExpandableGroupHolder expandableGroupHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.group,null);
            expandableGroupHolder = new ExpandableGroupHolder(convertView);
            convertView.setTag(expandableGroupHolder);
        } else {
            expandableGroupHolder = (ExpandableGroupHolder) convertView.getTag();
        }

        expandableGroupHolder.txtGroup.setText(groupData.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ExpandableListHolder expandableListHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.child,null);
            expandableListHolder = new ExpandableListHolder(convertView);
            convertView.setTag(expandableListHolder);
        } else {
            expandableListHolder = (ExpandableListHolder) convertView.getTag();
        }

        expandableListHolder.txtChild.setText(childData.get(childPosition));
        return convertView;
    }

    //行是否可选
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    //单元类
    class ExpandableListHolder {

        public TextView txtChild;
        public ExpandableListHolder(View view){
            txtChild = (TextView) view.findViewById(R.id.child_txt);
        }

    }

    //父单元
    class ExpandableGroupHolder {

        public TextView txtGroup;
        public ExpandableGroupHolder(View view){
            txtGroup = (TextView) view.findViewById(R.id.group_txt);
        }
    }
}
