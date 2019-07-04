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
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class PotwierdzDlugAdapter extends ArrayAdapter<Dlugi>{

    private final Context mContext;
    private final int mLayoutResourceId;

    public PotwierdzDlugAdapter (Context context, int layoutResourceId) {


        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        final Dlugi currentItem = getItem(position);
        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);

        //dekolaracja TextView uzywanych w wierszu
        TextView komu = row.findViewById(R.id.textViewKomuP);
        TextView zaCo = row.findViewById(R.id.textViewZaCoP);
        TextView ile = row.findViewById(R.id.textViewIleP);
        CheckBox potwierdzenie = row.findViewById(R.id.checkBoxPotwierdzP);

        //logika potwierdzenia

        //if(currentItem.getmKto()== ZalogowanyUzytkownik.getInstance().getZalogowanyUzytkownik().getmId())
        //{
        if (mContext instanceof PotwierdzDlugActivity) {
            PotwierdzDlugActivity activity = (PotwierdzDlugActivity) mContext;
            Switch switchSP = activity.findViewById(R.id.switchSP);
            if (switchSP.isChecked())
                komu.setText(currentItem.getmKomuLogin());
            else
                komu.setText(currentItem.getmKtoLogin());

            zaCo.setText(currentItem.getmZaCo());
            ile.setText(String.valueOf(currentItem.getmIle()));
        }

            //}

            potwierdzenie.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    if (mContext instanceof PotwierdzDlugActivity) {
                        PotwierdzDlugActivity activity = (PotwierdzDlugActivity) mContext;
                        Switch switchSP = activity.findViewById(R.id.switchSP);

                        if(switchSP.isChecked())
                    currentItem.setmPotwierdzone(true);
                    else
                    currentItem.setmSplacone(true);


                        activity.aktualizujListe(currentItem);
                    }

                }
            })

            ;


            return row;

        }


    }
