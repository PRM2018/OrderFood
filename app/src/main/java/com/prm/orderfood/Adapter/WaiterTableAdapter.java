package com.prm.orderfood.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prm.orderfood.R;

import java.util.List;

import com.prm.orderfood.Entity.Table;

/**
 * Created by Tung Pham on 7/23/2018.
 */

public class WaiterTableAdapter extends ArrayAdapter<Table>{
    private Context context;
    private int resource;
    private List<Table> arrTable;

    public WaiterTableAdapter(@NonNull Context context, int resource, @NonNull List<Table> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrTable = arrTable;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_table,parent,false);
            viewHolder.tableNo = (TextView) convertView.findViewById(R.id.tv_table_no);
            viewHolder.tableName = (TextView) convertView.findViewById(R.id.tv_table_name);
            viewHolder.tableStatus = (ImageView) convertView.findViewById(R.id.iv_table_check);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Table table = (Table) getItem(position);
        viewHolder.tableNo.setText(String.valueOf(table.getTableID()));
        viewHolder.tableName.setText(table.getTableName().toString());
        if(table.getTableStatus() == 1){
            viewHolder.tableStatus.setImageResource(R.drawable.checked_checkbox);
        }else{
            viewHolder.tableStatus.setImageResource(R.drawable.unchecked_checkbox);
        }
        return convertView;
    }
    public class ViewHolder {
        TextView tableNo, tableName;
        ImageView tableStatus;
    }

}
