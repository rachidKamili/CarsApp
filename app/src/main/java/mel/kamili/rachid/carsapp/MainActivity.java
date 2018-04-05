package mel.kamili.rachid.carsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mel.kamili.rachid.carsapp.fragments.AddCarFragment;
import mel.kamili.rachid.carsapp.fragments.CarsFragment;
import mel.kamili.rachid.carsapp.model.Car;

public class MainActivity extends AppCompatActivity implements AddCarFragment.OnCarAddedListener{

    private static final String CARS_FRAG_TAG = "CARS_FRAG_TAG";
    private static final String ADD_CAR_FRAG_TAG = "ADD_CAR_FRAG_TAG";
    private CarsFragment carsFragment;
    private AddCarFragment addCarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carsFragment = new CarsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flCarsHolder, carsFragment, CARS_FRAG_TAG)
                .addToBackStack(null)
                .commit();

        addCarFragment = new AddCarFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flAddingCarHolder, addCarFragment, ADD_CAR_FRAG_TAG)
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onCarAdded(Car car) {
        carsFragment.addCar(car);
        Toast.makeText(this, car.getModel(), Toast.LENGTH_SHORT).show();
    }
}
