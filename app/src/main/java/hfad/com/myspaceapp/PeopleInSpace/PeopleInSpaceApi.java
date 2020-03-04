package hfad.com.myspaceapp.PeopleInSpace;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleInSpaceApi {

    @GET("/astros.json")
    Call<PeopleInSpace> getPeopleInSpace();
}

