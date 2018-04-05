package mel.kamili.rachid.carsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mel.kamili.rachid.carsapp.R;
import mel.kamili.rachid.carsapp.adapter.CarAdapter;
import mel.kamili.rachid.carsapp.model.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarsFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected RecyclerView.Adapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Car> mCarList = new ArrayList<>();

    public CarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cars, container, false);

        bindRecyclerView(rootView);
        prepareMovieData();

        return rootView;
    }

    private void bindRecyclerView(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rvCars);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CarAdapter(mCarList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void addCar(Car car){
        mCarList.add(car);
        mAdapter.notifyDataSetChanged();
    }

    private void prepareMovieData() {
        mCarList.add(new Car("model 1", "type 1", "year 1"));
        mCarList.add(new Car("model 2", "type 2", "year 2"));
        mCarList.add(new Car("model 3", "type 3", "year 3"));
        mAdapter.notifyDataSetChanged();
    }

}
