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
import android.widget.TextView;


public class WyswietlDlugAdapter extends ArrayAdapter<Dlugi> {

    private final Context mContext;
    private final int mLayoutResourceId;

    public WyswietlDlugAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);
        mContext = context;
        mLayoutResourceId = layoutResourceId;



    }

    @SuppressLint("ResourceAsColor")
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        final Dlugi currentItem = getItem(position);
        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);

        TextView komuTextView = row.findViewById(R.id.textViewKomuP);
        TextView zaCoTextView = row.findViewById(R.id.textViewZaCoP);
        TextView kwotaTextView = row.findViewById(R.id.textViewKwota);

        if(currentItem.getmKomu().equals(ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId())) {
            komuTextView.setText(currentItem.getmKtoLogin());
            kwotaTextView.setTextColor(R.color.kolorNaPlus);
            kwotaTextView.setText(String.valueOf(currentItem.getmIle()));

        }
        else
        {
            komuTextView.setText(currentItem.getmKomuLogin());
            kwotaTextView.setTextColor(R.color.kolorNaMinus);
            kwotaTextView.setText("-"+String.valueOf(currentItem.getmIle()));
        }
        zaCoTextView.setText(currentItem.getmZaCo());


        return row;
    }






}
