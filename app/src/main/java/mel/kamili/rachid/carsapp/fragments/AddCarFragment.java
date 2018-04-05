package mel.kamili.rachid.carsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import mel.kamili.rachid.carsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCarFragment extends Fragment {

    private EditText etModel;
    private EditText etType;
    private EditText etYear;

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
    }

}
