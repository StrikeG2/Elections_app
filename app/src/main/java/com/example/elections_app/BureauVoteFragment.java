package com.example.elections_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.elections_app.databinding.FragmentBureauVoteBinding;

public class BureauVoteFragment extends Fragment {
    private FragmentBureauVoteBinding binding; // Utilisation du ViewBinding

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBureauVoteBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_bureau_vote, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Utilisez le binding pour accéder aux vues
        binding.btnCreerBureau.setOnClickListener(v -> {
            // Logique de création
            Navigation.findNavController(v).navigate(R.id.action_bureauVote_to_gestionObjets);
        });

        TextView title = requireActivity().findViewById(R.id.tv_header_title);
        if (title != null) {
            title.setText("Bureau de Vote"); // Ex: "Bureau de Vote"
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}