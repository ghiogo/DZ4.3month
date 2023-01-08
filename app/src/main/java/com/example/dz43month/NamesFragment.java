package com.example.dz43month;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NamesFragment extends Fragment implements OnClickItemCat{
    private final CatsRepository catsRepository = new CatsRepository();
    private final NamesAdapter namesAdapter= new NamesAdapter();
    private RecyclerView recyclerView;

    public NamesFragment () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_names, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_names);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL,false));

        recyclerView.setAdapter(namesAdapter);
        namesAdapter.setListCat(catsRepository.getListOfCatHTTP());

        namesAdapter.setOnClickItemCat(this);
    }

    @Override
    public void listenerClickItemCat(CatModel catModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("cat",catModel);
        getParentFragmentManager().beginTransaction()
                .add(R.id.fragment_container_view, DetailFragment.class, bundle)
                .addToBackStack("NameFragment")
                .commit();
    }
}