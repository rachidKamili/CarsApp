package mel.kamili.rachid.carsapp.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mel.kamili.rachid.carsapp.R;
import mel.kamili.rachid.carsapp.model.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCarFragment extends Fragment implements View.OnClickListener {

    OnCarAddedListener mCallback;

    private EditText etModel;
    private EditText etType;
    private EditText etYear;
    private Button addBtn;

    public interface OnCarAddedListener {
        public void onCarAdded(Car car);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnCarAddedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnCarAddedListener");
        }
    }

    public AddCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_car, container, false);
        bindViews(v);
        return v;
    }

    private void bindViews(View v) {
        etModel = v.findViewById(R.id.etModel);
        etType = v.findViewById(R.id.etType);
        etYear = v.findViewById(R.id.etYear);
        addBtn = v.findViewById(R.id.addCarBtn);
        addBtn.setOnClickListener(this);
    }

    private void initiateEts(){
        etModel.setText("");
        etType.setText("");
        etYear.setText("");
    }

    @Override
    public void onClick(View v) {
        Car car = new Car(etModel.getText().toString(),
                etType.getText().toString(),
                etYear.getText().toString());
        mCallback.onCarAdded(car);
        initiateEts();
    }
}
