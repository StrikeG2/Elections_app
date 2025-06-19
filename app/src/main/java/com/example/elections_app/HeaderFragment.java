package com.example.elections_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class HeaderFragment extends Fragment {

    private OnTabSelectedListener listener;
    private LinearLayout[] tabs;
    private int currentSelectedTab = 0;

    public interface OnTabSelectedListener {
        void onTabSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTabSelectedListener) {
            listener = (OnTabSelectedListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, container, false);

        tabs = new LinearLayout[3];
        tabs[0] = view.findViewById(R.id.tab_circonscription);
        tabs[1] = view.findViewById(R.id.tab_centre_vote);
        tabs[2] = view.findViewById(R.id.tab_bureau_vote);

        setupTabs();

        return view;
    }

    private void setupTabs() {
        for (int i = 0; i < tabs.length; i++) {
            final int position = i;
            tabs[i].setOnClickListener(v -> {
                selectTab(position);
                if (listener != null) {
                    listener.onTabSelected(position);
                }
            });
        }

        // Sélectionner le premier onglet par défaut
        selectTab(0);
    }

    private void selectTab(int position) {
        // Réinitialiser tous les onglets
        for (int i = 0; i < tabs.length; i++) {
            if (i == position) {
                tabs[i].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.orange));
            } else {
                tabs[i].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green));
            }
        }
        currentSelectedTab = position;
    }
}