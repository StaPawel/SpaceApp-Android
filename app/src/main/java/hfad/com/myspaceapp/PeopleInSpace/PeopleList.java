package hfad.com.myspaceapp.PeopleInSpace;

import com.google.gson.annotations.SerializedName;

public class PeopleList {
    @SerializedName("craft")
    private String craft;
    @SerializedName("name")
    private String name;

    public String getName(){
        return name;
    }
    public String getCraft(){
        return craft;
    }
}
