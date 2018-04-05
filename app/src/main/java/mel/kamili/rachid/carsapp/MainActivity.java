package mel.kamili.rachid.carsapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mel.kamili.rachid.carsapp.fragments.AddCarFragment;
import mel.kamili.rachid.carsapp.fragments.CarsFragment;
import mel.kamili.rachid.carsapp.model.Car;

public class MainActivity extends AppCompatActivity implements AddCarFragment.OnCarAddedListener {

    private static final String CARS_FRAG_TAG = "CARS_FRAG_TAG";
    private static final String ADD_CAR_FRAG_TAG = "ADD_CAR_FRAG_TAG";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindFragments();

    }

    private void bindFragments() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.flCarsHolder, new CarsFragment(), CARS_FRAG_TAG)
                .addToBackStack(CARS_FRAG_TAG).commit();
        fragmentManager.beginTransaction()
                .add(R.id.flAddingCarHolder, new AddCarFragment(), ADD_CAR_FRAG_TAG)
                .addToBackStack(ADD_CAR_FRAG_TAG).commit();
    }

    @Override
    public void onCarAdded(Car car) {
        CarsFragment carsFragment = (CarsFragment) fragmentManager.findFragmentByTag(CARS_FRAG_TAG);
        carsFragment.addCar(car);
        Toast.makeText(this, car.getModel(), Toast.LENGTH_SHORT).show();
    }

    public void carListToggle(View view) {
        if (((Button) view).getText().toString().toLowerCase().contains("remove")) {
            CarsFragment carsFragment = (CarsFragment) fragmentManager.findFragmentByTag(CARS_FRAG_TAG);
            fragmentManager.beginTransaction().remove(carsFragment).commit();
            ((Button) view).setText("Show Car List");
        } else {
            fragmentManager.beginTransaction().add(R.id.flCarsHolder, new CarsFragment(), CARS_FRAG_TAG)
                    .addToBackStack(CARS_FRAG_TAG).commit();
            ((Button) view).setText("Remove Car List");
        }
    }

    public void addCarToggle(View view) {
        if (((Button) view).getText().toString().toLowerCase().contains("remove")) {
            AddCarFragment addCarFragment = (AddCarFragment) fragmentManager.findFragmentByTag(ADD_CAR_FRAG_TAG);
            fragmentManager.beginTransaction().remove(addCarFragment).commit();
            ((Button) view).setText("Show Adding Car");
        } else {
            fragmentManager.beginTransaction().add(R.id.flAddingCarHolder, new AddCarFragment(), ADD_CAR_FRAG_TAG)
                    .addToBackStack(ADD_CAR_FRAG_TAG).commit();
            ((Button) view).setText("Remove Adding Car");
        }
    }
}
