package app.test.sample.drawer;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import app.test.sample.R;
import app.test.sample.fragment.LinearVerticalFragment;


public class DrawerInteractorImpl implements DrawerInteractor {

    @Override
    public void navigateTo(MenuItem item, DrawerLayout drawerLayout, DrawerListener listener) {

        switch (item.getItemId()) {
            case R.id.nav_linear_v:
                listener.replaceFragment(LinearVerticalFragment.newInstance());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
