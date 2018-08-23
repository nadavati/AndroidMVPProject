package app.test.sample.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import app.test.sample.R;
import app.test.sample.adapter.AdapterExample;
import app.test.sample.model.Data;

public class LinearVerticalFragment extends BaseFragment {


    public static LinearVerticalFragment newInstance() {
        return new LinearVerticalFragment();
    }


    @Override protected int getLayout() {
        return R.layout.fragment_base;
    }

    @Override protected RecyclerView.LayoutManager getLayoutManager() {
        return getLinearLayoutManager();
    }


    @Override protected RecyclerView.Adapter getAdapter(ArrayList<Data> pictureList) {
        return new AdapterExample(pictureList, R.layout.item_type_five);
    }

    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false);
    }
}

