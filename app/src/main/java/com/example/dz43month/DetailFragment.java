package com.example.dz43month;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class DetailFragment extends Fragment {
    ImageView imageView;
    TextView textCode, textName;
    CatModel catModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.image_detail);
        textCode = view.findViewById(R.id.txt_status_code_detail);
        textName = view.findViewById(R.id.txt_name_detail);

        getData();
    }

    private void getData() {
        Bundle bundle = getArguments();
        if (getArguments() != null) {
            catModel = (CatModel) bundle.getSerializable("cat");

            Glide.with(imageView.getContext()).load(catModel.getStatusCode()).into(imageView);
            textCode.setText(catModel.getStatusCode());
            textName.setText(catModel.getDescription());
        }
    }
}