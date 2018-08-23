package app.test.sample.view;

import java.util.ArrayList;
import app.test.sample.model.Data;

public interface PictureMvpView {

    void setItems(ArrayList<Data> pictureList);

    void showProgress();

    void hideProgress();

    void showMessage(String message);

}
