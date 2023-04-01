package com.example.testdetectionobject14pomme;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface InterfaceServeurAliment  //ATTENTION LE TYPE
        // Call<Utilisateur>  OU Call<List<Utilisateur>>   OU  Call<Boolean>
        //veut dire que le tableau json sera retourner dans ce format
        //le probleme c que sa peut causer des erreur si c le mauvais type qui est retoutner c qui peut arriver
        //Call<ResponseBody>  veut dire qu'on retourne le json brute et qui va falloir le traiter mais cela evite les erreur de type qui pourait arriver avec les autre type

{
    @GET("/android/aliment.php")  //faudrait genre que sa soit http://localhost/android/test.php
        //bref la sa va faire 10.0.2.2/utilisateur.php
    Call<Aliment> getUtilisateur();  //renvoie 1 utilisateur

    @GET("/android/aliment.php")
    Call<List<Aliment>> getUtilisateursBis();  //renvoie une liste dutilisateur

    @POST("/utilisateur.php")
    @FormUrlEncoded
    Call<Aliment> getUtilisateurById(@Field("id") int i);

    @POST("/utilisateur.php")
    @FormUrlEncoded
    Call<Boolean> ajoutUtilisateur(@Field("requete") String requete,
                                   @Field("nom") String nom,
                                   @Field("prenom") String prenom);


    @GET("/android/aliment.php")  //faudrait genre que sa soit http://localhost/android/test.php
        //bref la sa va faire 10.0.2.2/utilisateur.php
    Call<ResponseBody> getAliments();  //renvoie 1 utilisateur

    @GET("/android/aliment.php")
    Call<List<Aliment>> getAlimentBis();  //renvoie une liste dutilisateur

}//InterfaceServeur

