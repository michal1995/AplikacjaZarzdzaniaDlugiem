package com.example.aplikacjazarzdzaniadlugiem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;

public class WyswietlUzytkownikaAdapter extends ArrayAdapter<Uzytkownicy>{


    private final Context mContext;
    private final int mLayoutResourceId;

    public WyswietlUzytkownikaAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);
        mContext = context;
        mLayoutResourceId = layoutResourceId;



    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        final Uzytkownicy currentItem = getItem(position);
        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        //dekolaracja TextView uzywanych w wierszu
        final CheckedTextView checkedTextView = row.findViewById(R.id.checkedTextView);
        final ImageView imageView = row.findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);
        checkedTextView.setChecked(false);
        checkedTextView.setText(currentItem.getmLogin());

        checkedTextView.setOnClickListener(new View.OnClickListener() {
                                               @SuppressLint("ResourceAsColor")
                                               @Override

                                               public void onClick(View v) {
                                                   if (mContext instanceof WyswietlUzytkownikowActivity) {
                                                       WyswietlUzytkownikowActivity activity = (WyswietlUzytkownikowActivity) mContext;
                                                       if (!checkedTextView.isChecked()) {
                                                           checkedTextView.setChecked(true);
                                                           activity.dodajDoListyWybranych(currentItem);
                                                           imageView.setVisibility(View.VISIBLE);

                                                       }
                                                       else if(checkedTextView.isChecked()) {
                                                           activity.usunDoListyWybranych(currentItem);
                                                           checkedTextView.setChecked(false);
                                                           imageView.setVisibility(View.INVISIBLE);
                                                       }
                                                   }
                                               }
                                           }

        );

        return row;

    }

    @Override
    public boolean isEnabled(int position) {
        return super.isEnabled(position);
    }
}
