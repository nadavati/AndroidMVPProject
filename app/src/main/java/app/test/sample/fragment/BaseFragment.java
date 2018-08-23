package app.test.sample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;


import app.test.sample.R;
import app.test.sample.adapter.AdapterExample;
import app.test.sample.adapter.AdapterExampleTypes;
import app.test.sample.model.Data;
import app.test.sample.presenter.PicturePresenter;
import app.test.sample.presenter.RecyclerItemClickListener;
import app.test.sample.view.PictureMvpView;
import app.test.sample.widget.ItemOffsetDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment implements PictureMvpView, RecyclerItemClickListener {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private PicturePresenter picturePresenter;
    RecyclerView.Adapter adapter;

    @Nullable
    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, rootView);
        picturePresenter = new PicturePresenter();
        picturePresenter.attachedView(this);
        setupRecyclerView();
        return rootView;
    }

    @Override public void onResume() {
        super.onResume();
        picturePresenter.onResume();
    }

    @Override public void setItems(ArrayList<Data> pictureList) {
        adapter = getAdapter(pictureList);
        recyclerView.setAdapter(adapter);

        if(adapter instanceof AdapterExample)
            ((AdapterExample) adapter).setRecyclerItemClickListener(this);
        else if(adapter instanceof AdapterExampleTypes)
            ((AdapterExampleTypes) adapter).setRecyclerItemClickListener(this);

    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override public void onDestroy() {
        picturePresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onItemClickListener(int position) {
        picturePresenter.onItemSelected(position);
    }

    private void setupRecyclerView() {

        if(getLayoutManager() != null)
            recyclerView.setLayoutManager(getLayoutManager());

        recyclerView.addItemDecoration(new ItemOffsetDecoration(recyclerView.getContext(), R.dimen.item_decoration));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    protected abstract int getLayout();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.Adapter getAdapter(ArrayList<Data> pictureList);




    //protected abstract RecyclerView.ItemDecoration getItemDecoration();
}
