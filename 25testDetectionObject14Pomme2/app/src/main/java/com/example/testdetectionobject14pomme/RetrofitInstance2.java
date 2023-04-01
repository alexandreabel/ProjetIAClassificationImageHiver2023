package com.example.testdetectionobject14pomme;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//pour la table aliment
public class RetrofitInstance2 {  //singleton
    //ATTENTION ERREUR  depuis https://stackoverflow.com/questions/45940861/android-8-cleartext-http-traffic-not-permitted
    //si ya http au lieux de https   sa va donner cette erreur Android 8: Cleartext HTTP traffic not permitted
    //bref depuis andoird 9 (API 28)  Cleartext HTTP est desactiver fac si tu met http sa block et sa marche po

    //NOTE:J'ai demander au prof et ya dautre solution
    //aller où xml et creer une XML ressource file nommé configuration_reseau.xml
    //copier collé de lcontenu dans les note fe cours configuration_reseau.docx fournit par fabrice dans les note de cours
    //aller dans le androidManifeste et ajouter cest 2 ligne
    //        android:networkSecurityConfig="@xml/configuration_reseau"
    //        android:usesCleartextTraffic="true"
    //https://proautomatisation.ca  ou  http://10.0.2.2
    public static final String BASE_URL = "http://proautomatisation.ca";  //sa remplace localhost si on est sur lemulateur android
    //bref si tu utilise lemulateur android et un BD en local faut que taillle la desse

    private static Retrofit retrofit;

    public static Retrofit getInstance(){

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
