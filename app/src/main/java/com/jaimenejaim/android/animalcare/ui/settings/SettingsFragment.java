package com.jaimenejaim.android.animalcare.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseFragment;
import com.jaimenejaim.android.animalcare.ui.my_animals.others.DividerItemDecotation;
import com.jaimenejaim.android.animalcare.ui.settings.adapters.SettingsAdapter;
import com.jaimenejaim.android.animalcare.ui.signin.SignInActivity;


public class SettingsFragment extends BaseFragment implements SettingsViewImpl {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView mRecyclerView;
    private SettingsAdapter mAdapter;
    private Button buttonLogOut;
    private SettingsPresenter presenter;
    private TextView textViewProfileName;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        initComponents(view);
        intiPresenter();
        configRecyclerView();
        setListeners();

        return view;
    }


    @Override
    public void initComponents(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
        buttonLogOut = view.findViewById(R.id.buttonLogOut);
        textViewProfileName = view.findViewById(R.id.textViewProfileName);
    }

    @Override
    public void setListeners() {
        buttonLogOut.setOnClickListener(view -> {
            presenter.logOut();
        });

        mAdapter.setOnItemClickListener(item -> {
            presenter.onItemClick(item);
        });
    }


    @Override
    public void intiPresenter() {
        presenter = new SettingsPresenter(this);

    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void finish(){
        Intent intent = new Intent(getActivity(), SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        getActivity().finish();
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }


    public void configRecyclerView(){

        mAdapter = new SettingsAdapter(presenter.loadSettings());
        mRecyclerView.addItemDecoration(new DividerItemDecotation(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void openActivity(Object activity) {
        Intent intent = new Intent(getActivity(), activity.getClass());
        startActivity(intent);
    }

    @Override
    public TextView getTextViewProfileName() {
        return this.textViewProfileName;
    }
}
