package mel.kamili.rachid.carsapp.fragments;


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

    private EditText etModel;
    private EditText etType;
    private EditText etYear;
    private Button addBtn;

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

    @Override
    public void onClick(View v) {
        Car car = new Car(etModel.getText().toString(),
                etType.getText().toString(),
                etYear.getText().toString());
        Toast.makeText(getContext(), car.getModel(), Toast.LENGTH_SHORT).show();
    }
}
