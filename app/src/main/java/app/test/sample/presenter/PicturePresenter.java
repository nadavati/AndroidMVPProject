package app.test.sample.presenter;

import java.util.ArrayList;
import app.test.sample.model.LoaderListener;
import app.test.sample.model.Data;
import app.test.sample.model.DataInteractor;
import app.test.sample.view.PictureMvpView;


public class PicturePresenter implements Presenter<PictureMvpView>, LoaderListener {

    private PictureMvpView pictureMvpView;
    private final DataInteractor pictureInteractor;

    public PicturePresenter() {
        pictureInteractor = new DataInteractor();
    }

    @Override
    public void attachedView(PictureMvpView view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        pictureMvpView = view;
    }

    @Override public void detachView() {
        pictureMvpView = null;
    }

    @Override public void onResume() {
        pictureMvpView.showProgress();
        pictureInteractor.loadItems(this);
    }

    @Override public void onItemSelected(int position) {
        pictureMvpView.showMessage(Integer.toString(position));

    }

    @Override public void onFinished(ArrayList<Data> pictureList) {
        pictureMvpView.setItems(pictureList);
        pictureMvpView.hideProgress();
    }
}
