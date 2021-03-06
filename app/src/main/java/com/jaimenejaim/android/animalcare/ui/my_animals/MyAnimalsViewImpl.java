package com.jaimenejaim.android.animalcare.ui.my_animals;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.ViewImpl;

import java.util.List;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface MyAnimalsViewImpl extends ViewImpl {
    int REQUEST_CODE_NEW_ANIMAL_ACTIVITY = 909;
    int REQUEST_CODE_DETAIL_ANIMAL_ACTIVITY = 910;


    void configRecyclerView(List<Animal> animals);
    void onFoundData();
    void onNotFoundData();
    void setRefreshingOnStartLoadingData();
    void setRefreshingOnFinishLoadingData();
    void loadMyAnimals(int page);
    void fetchDataOnRecyclerListView(List<Animal> animals);
    void setOnLoadNotFoundData();
    void setTextViewNotFoundDataVisibility(int visibility);
}
