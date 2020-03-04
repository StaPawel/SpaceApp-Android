package hfad.com.myspaceapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuildRetrofit {

        static Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.open-notify.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        static public Retrofit getRetrofitClient(){
            return retrofit;

        }

}
