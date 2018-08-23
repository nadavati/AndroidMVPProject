package app.test.sample.model;


import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import app.test.sample.R;
import app.test.sample.activity.MyApplication;


public class DataInteractor implements Interactor {

    private final static String[] pictureNames = {
            "Rocket in the universe",
            "A scene in London",
            "Moon over mountains",
            "A simple moon",
            "Sun and volcano",
            "A collection of mountains",
            "River between mountains",
            "Some pine trees",
            "On Small Town",
            "Volcanos reflection"
    };

    private final static int  pictureImages[] = {
            R.drawable.cohete_flat,
            R.drawable.london_flat,
            R.drawable.material_flat,
            R.drawable.moon_flat,
            R.drawable.mountain_flat,
            R.drawable.mountain_mo_flat,
            R.drawable.moutain_go_flat,
            R.drawable.pine_flat,
            R.drawable.towers_flat,
            R.drawable.vulcan_flat
    };


    @Override
    public void loadItems(final LoaderListener loaderListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaderListener.onFinished(createCollectionPictures());
            }
        }, 2000);
    }
    private ArrayList<Data> createCollectionPictures() {
        ArrayList<Data> pictures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Data picture = new Data(pictureNames[i], pictureImages[i]);
            pictures.add(picture);
        }
        return pictures;

    }
//    private void callTaskList(String mType) {
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                Config.get_dt + "/"+ Config.userID + "/"+ Config.internalProcessMainCompanyId+"/" + mType , null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        JSONObject jsonObject = null;
//                        if (!response.has("error")) {
//                            try {
//                                jsonObject = new JSONObject(String.valueOf(response));
//
//                            } catch (JSONException e) {
//                                //  progressDialog.dismiss();
//                                e.printStackTrace();
////                                Toast.makeText(TaskResultActivity.this, "Something went wrong, Please try again!",
////                                        Toast.LENGTH_LONG).show();
//                            }
//                        } else {
//                            // progressDialog.dismiss();
////                            Toast.makeText(TaskResultActivity.this, "Something went wrong, Please try again!",
////                                    Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // progressDialog.dismiss();
////                Toast.makeText(TaskResultActivity.this, "Something went wrong, Please try again!",
////                        Toast.LENGTH_LONG).show();
//            }
//        });
//        MyApplication.getInstance().addToRequestQueue(jsonObjReq);
//    }
}
