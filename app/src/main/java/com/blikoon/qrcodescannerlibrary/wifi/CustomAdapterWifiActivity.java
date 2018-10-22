package com.blikoon.qrcodescannerlibrary.wifi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blikoon.qrcodescannerlibrary.R;
import com.blikoon.qrcodescannerlibrary.main.DataModelMainActivity;

import java.util.List;

/**
 * Created by yihan on 10/19/18.
 */

public class CustomAdapterWifiActivity extends ArrayAdapter<DataModelMainActivity> implements View.OnClickListener {

    private List<DataModelMainActivity> mDataSet;
    private Context mContext;
    private int mLastPosition;

    private static class ViewHolder {
        ImageView mImageViewLogo;
        TextView mTextViewTitle;
        TextView mTextViewContent;
    }

    public CustomAdapterWifiActivity(List<DataModelMainActivity> dataSet, Context context) {
        super(context, R.layout.activity_main_row, dataSet);
        this.mDataSet = dataSet;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
// Get the data item for this position
        DataModelMainActivity dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_main_row, parent, false);
            viewHolder.mImageViewLogo = convertView.findViewById(R.id.iv_activity_main_row_logo);
            viewHolder.mTextViewTitle = convertView.findViewById(R.id.tv_activity_main_row_title);
            viewHolder.mTextViewContent = convertView.findViewById(R.id.tv_activity_main_row_content);
            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > mLastPosition) ? R.anim.wifi_up_from_bottom : R.anim.wifi_down_from_top);
        result.startAnimation(animation);
        mLastPosition = position;

        viewHolder.mImageViewLogo.setImageResource(dataModel.getImageViewResourceId());
        viewHolder.mTextViewTitle.setText(dataModel.getTextViewTitle());
        viewHolder.mTextViewContent.setText(dataModel.getTextViewContent());
        // Return the completed view to render on screen
        return convertView;    }

    public void setLastPosition(int lastPosition) {
        mLastPosition = lastPosition;
    }
}
