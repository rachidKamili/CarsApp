package mel.kamili.rachid.carsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mel.kamili.rachid.carsapp.fragments.CarsFragment;

public class MainActivity extends AppCompatActivity {

    private static final String CARS_FRAG_TAG = "CARS_FRAG_TAG";
    private CarsFragment carsFragment;

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

    }
}
