package hfad.com.myspaceapp.PeopleInSpace;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleInSpace {
    @SerializedName("number")
    int number;
    @SerializedName("message")
    String message;
    @SerializedName("people")
    List<PeopleList> peopleList;

    public int getNumberOfPeople(){
        return number;
    }
    public String getMessage(){
        return message;
    }
    public List<PeopleList> getPeopleList(){
        return peopleList;
    }
}
