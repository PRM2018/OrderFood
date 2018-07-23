package com.prm.orderfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.prm.orderfood.Entity.Table;
import com.prm.orderfood.R;
import com.prm.orderfood.UI.TableDetailActivity;
import java.util.List;

/**
 * Created by Tung Pham on 7/23/2018.
 */

public class WaiterTableAdapter extends ArrayAdapter<Table> {
    private Context context;
    private int resource;
    private List<Table> arrTable;

    public WaiterTableAdapter(@NonNull Context context, int resource,
            @NonNull List<Table> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrTable = arrTable;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_table, parent, false);
            viewHolder.tableNo = (TextView) convertView.findViewById(R.id.tv_table_no);
            viewHolder.tableName = (TextView) convertView.findViewById(R.id.tv_table_name);
            viewHolder.tableStatus = (ImageView) convertView.findViewById(R.id.iv_table_check);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Table table = (Table) getItem(position);
        viewHolder.tableNo.setText(String.valueOf(table.getTableID()));
        viewHolder.tableName.setText(table.getTableName());
        if (table.getTableStatus() == 1) {
            Log.d("Adapter", "Get status");
            viewHolder.tableStatus.setImageResource(R.drawable.checked_checkbox);
            Log.d("Adapter", "Get status 1");
        } else {
            viewHolder.tableStatus.setImageResource(R.drawable.unchecked_checkbox);
            Log.d("Adapter", "Get status 2");
        }

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TableDetailActivity.class);
            intent.putExtra("TableID", table.getTableID());
            intent.putExtra("TableName", table.getTableName());
            context.startActivity(intent);
        });

        return convertView;
    }

    public class ViewHolder {
        TextView tableNo, tableName;
        ImageView tableStatus;
    }
}
