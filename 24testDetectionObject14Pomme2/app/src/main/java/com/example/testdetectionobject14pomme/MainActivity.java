package com.example.testdetectionobject14pomme;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdetectionobject14pomme.ml.ModelPommeCerise11Objet2;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//va detecter si c une pomme ,une cerise ou une orange


    Button camera, gallery, btAffichageElement;
    ImageView imageView;
    TextView result;
    AdapterAliment adapterAliment;
    int imageSize = 64; //à partir des information eu sur l'information donner après limportation du model tensorflowLite.Bref sa dit pt la taille de la redimension de limage
    //dans mon exemple c cette ligne  TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 32, 32, 3}, DataType.FLOAT32);
    //et sa vien du fichier model.tflite qui ses ouvert après limportation du model
    //avant etait a 32
    float confidenceThreshold = 0.5f; //variable pour stocker le seuil de confiance souhaité (par exemple 0,5)
    //sa veut dire que si yer en bas de 0.5 il va dire aucun objet detecte

    /*cest variable vont contenir le nombre d'objet détecter*/
    int nombre7up = 0;
    int nombreAlexandreAbel = 0;
    int nombreNesquikAuChocolat = 0;
    int nombreNesquikAuFraise = 0;
    int nombreOignonEspagnol = 0;
    int nombreChocolatSkor = 0;
    int nombreCoffeeCrisp = 0;
    int nombreDeodorantAxe = 0;
    int nombreMoutarde = 0;
    int nombreOrange = 0;
    int nombrePomme = 0;
    int nombreSauceHotChicken = 0;
    int nombreThonRioMare = 0;

    /*cest variable vont contenir le prix des objet recuperer dans la base de donner*/
    double prix7up = 0;
    double prixAlexandreAbel = 0;
    double prixNesquikAuChocolat = 0;
    double prixNesquikAuFraise = 0;
    double prixOignonEspagnol = 0;
    double prixChocolatSkor = 0;
    double prixCoffeeCrisp = 0;
    double prixDeodorantAxe = 0;
    double prixMoutarde = 0;
    double prixOrange = 0;
    double prixPomme = 0;
    double prixSauceHotChicken = 0;
    double prixThonRioMare = 0;



    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = findViewById(R.id.button);
        gallery = findViewById(R.id.button2);
        btAffichageElement = findViewById(R.id.btAffichageElement);

        result = findViewById(R.id.result);
        imageView = findViewById(R.id.imageView);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { ///c'est ici qu'on va recevoir les intent
            @Override
            public void onActivityResult(ActivityResult result) {
                nombre7up = result.getData().getIntExtra("nombre7up" ,0);
                nombreAlexandreAbel = result.getData().getIntExtra("nombreAlexandreAbel" ,0);
                nombreNesquikAuChocolat = result.getData().getIntExtra("nombreNesquikAuChocolat" ,0);
                nombreNesquikAuFraise = result.getData().getIntExtra("nombreNesquikAuFraise" ,0);
                nombreOignonEspagnol = result.getData().getIntExtra("nombreOignonEspagnol" ,0);
                nombreChocolatSkor = result.getData().getIntExtra("nombreChocolatSkor" ,0);
                nombreCoffeeCrisp = result.getData().getIntExtra("nombreCoffeeCrisp" ,0);
                nombreDeodorantAxe = result.getData().getIntExtra("nombreDeodorantAxe" ,0);
                nombreMoutarde = result.getData().getIntExtra("nombreMoutarde" ,0);
                nombreOrange = result.getData().getIntExtra("nombreOrange" ,0);
                nombrePomme = result.getData().getIntExtra("nombrePomme" ,0);
                nombreSauceHotChicken = result.getData().getIntExtra("nombreSauceHotChicken" ,0);
                nombreThonRioMare = result.getData().getIntExtra("nombreThonRioMare" ,0);

            }
        });


        bouttonPrixAliment();
        /*recuperer les donner de lactiviter  AffichageNombreObjetActivity*/
        // Intent intent = getIntent();
        // nombre7up = intent.getIntExtra("nombre7up" ,0);
        // nombreNesquikAuFraise = intent.getIntExtra("nombreNesquikAuFraise" ,0);
        // nombreCerise = intent.getIntExtra("nombreCerise" ,0);
        // nombreChocolatSkor = intent.getIntExtra("nombreChocolatSkor" ,0);
        // nombreCoffeeCrisp = intent.getIntExtra("nombreCoffeeCrisp" ,0);
        // nombreDeodorantAxe = intent.getIntExtra("nombreDeodorantAxe" ,0);
        // nombreMoutarde = intent.getIntExtra("nombreMoutarde" ,0);
        // nombreOrange = intent.getIntExtra("nombreOrange" ,0);
        // nombrePomme = intent.getIntExtra("nombrePomme" ,0);
        // nombreSauceHotChicken = intent.getIntExtra("nombreSauceHotChicken" ,0);
        // nombreThonRioMare = intent.getIntExtra("nombreThonRioMare" ,0);
        /*recuperer les donner de lactiviter  AffichageNombreObjetActivity*/



        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  //verification pour voir c quel version car la methode est juste accesible sur certaine version
                    if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){  //checkSelfPermission marche uniquement sur certaine version

                        Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraintent,3);

                    }// if(checkSelfPermission
                    else{
                        requestPermissions(new String[]{Manifest.permission.CAMERA},100);   //pour que  Manifest.permission.CAMERA soit detecter  il faut importer import android.Manifest;
                        //il faut aussi aller dans AndroidManifest.xml et ajouter  <uses-permission android:name="android.permission.CAMERA"></uses-permission>     en  haut des balise <application>
                    }
                }//if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            }

        }); ///variable methode  camera.setOnClickListener
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, 1);
            }
        });

        btAffichageElement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AffichageNombreObjetActivity.class);
                intent.putExtra("nombre7up",nombre7up);
                intent.putExtra("prix7up",prix7up);

                intent.putExtra("nombreAlexandreAbel",nombreAlexandreAbel);
                intent.putExtra("prixAlexandreAbel",prixAlexandreAbel);

                intent.putExtra("nombreNesquikAuChocolat",nombreNesquikAuChocolat);
                intent.putExtra("prixNesquikAuChocolat",prixNesquikAuChocolat);

                intent.putExtra("nombreNesquikAuFraise",nombreNesquikAuFraise);
                intent.putExtra("prixNesquikAuFraise",prixNesquikAuFraise);

                intent.putExtra("nombreOignonEspagnol",nombreOignonEspagnol);
                intent.putExtra("prixOignonEspagnol",prixOignonEspagnol);

                intent.putExtra("nombreChocolatSkor",nombreChocolatSkor);
                intent.putExtra("prixChocolatSkor",prixChocolatSkor);

                intent.putExtra("nombreCoffeeCrisp",nombreCoffeeCrisp);
                intent.putExtra("prixCoffeeCrisp",prixCoffeeCrisp);

                intent.putExtra("nombreDeodorantAxe",nombreDeodorantAxe);
                intent.putExtra("prixDeodorantAxe",prixDeodorantAxe);

                intent.putExtra("nombreMoutarde",nombreMoutarde);
                intent.putExtra("prixMoutarde",prixMoutarde);

                intent.putExtra("nombreOrange",nombreOrange);
                intent.putExtra("prixOrange",prixOrange);

                intent.putExtra("nombrePomme",nombrePomme);
                intent.putExtra("prixPomme",prixPomme);

                intent.putExtra("nombreSauceHotChicken",nombreSauceHotChicken);
                intent.putExtra("prixSauceHotChicken",prixSauceHotChicken);

                intent.putExtra("nombreThonRioMare",nombreThonRioMare);
                intent.putExtra("prixThonRioMare",prixThonRioMare);

                launcher.launch(intent);   //launcheur a remplacer startActivity car lactiviter doit pouvoir recevoir les donnée de lautre activiter
                // contrairement a startActivity qui ne recuperer rien donne les valeur ne pouront pas être mit a jours
            }
        });

    }//methode onCreate

    public void classifyImage(Bitmap image){   //dans cette methode il faut copié coller le code qui saffiche après limportation du model tflite

        try {

            ModelPommeCerise11Objet2 model = ModelPommeCerise11Objet2.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 64, 64, 3}, DataType.FLOAT32);  //doit être au meme format que le model soit 64 dans ce cas si
            //avant cetais 1, 32, 32, 3
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues,0,image.getWidth(),0,0,image.getWidth(), image.getHeight());

            int pixel = 0;
            // iteration over each pixel and extract R, G and B values. Add those values individually to the byte buffer
            for(int i = 0;i < imageSize; i++){
                for (int j = 0; j < imageSize; j++){
                    int val = intValues[pixel++];  //RBG

                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 1)); // (1.f / 255))   cest ligne devrait être diviser par 255 si dans le post traitement(code python) on l'aurais po faite
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 1)); // (1.f / 255))
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 1)); // (1.f / 255))
                }//for j
            }//for i

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            ModelPommeCerise11Objet2.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidence = outputFeature0.getFloatArray();

            /*ancien partie*/
            /*
            //trouver l'index de la classe avec le plus de confiance
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidence.length; i++){
                if(confidence[i] > maxConfidence){
                    maxConfidence = confidence[i];
                    maxPos = i;
                }
            }
            String[] classes = {"cerise", "orange", "pomme"};
            result.setText(classes[maxPos]);
            */
            /*ancien partie*/
            /*nouvelle partie*/
//trouver l'index de la classe avec le plus de confiance
            int maxPos = -1;
            float maxConfidence = -1f;
            for (int i = 0; i < confidence.length; i++){
                if(confidence[i] > maxConfidence){
                    maxConfidence = confidence[i];
                    maxPos = i;
                }
            }
            String[] classes = {"7up","Alexandre Abel","Nesquik au chocolat", "Nesquik Au Fraise", "chocolat Skor","coffee Crisp","deodorant Axe","moutarde","oignon espagnol","orange","pomme","sauce Hot Chicken","thon Rio Mare"};

            if (maxConfidence >= confidenceThreshold) {
                // si la confiance de la classe maximale est supérieure ou égale au seuil de confiance,
                // afficher la classe correspondante
                /*partie verification*/

                /*dans cette partie a va verifire quel element le modele de classification d'image va retourner
                 * et ajouter incrementre lelement trouver*/

                if(classes[maxPos] == "7up"){ //si c un chocolat skor il va l'incrémenter
                    nombre7up++;
                }

                if(classes[maxPos] == "Alexandre Abel"){ //si c un chocolat skor il va l'incrémenter
                    nombreAlexandreAbel++;
                }

                if(classes[maxPos] == "Nesquik au chocolat"){ //si c un chocolat skor il va l'incrémenter
                    nombreNesquikAuChocolat++;
                }

                if(classes[maxPos] == "Nesquik Au Fraise"){ //si c un chocolat skor il va l'incrémenter
                    nombreNesquikAuFraise++;
                }

                if(classes[maxPos] == "oignon espagnol"){ //si c un chocolat skor il va l'incrémenter
                    nombreOignonEspagnol++;
                }

                if(classes[maxPos] == "chocolat Skor"){ //si c un chocolat skor il va l'incrémenter
                    nombreChocolatSkor++;
                }

                if(classes[maxPos] == "coffee Crisp"){ //si c un chocolat skor il va l'incrémenter
                    nombreCoffeeCrisp++;
                }

                if(classes[maxPos] == "deodorant Axe"){ //si c un chocolat skor il va l'incrémenter
                    nombreDeodorantAxe++;
                }

                if(classes[maxPos] == "moutarde"){ //si c un chocolat skor il va l'incrémenter
                    nombreMoutarde++;
                }

                if(classes[maxPos] == "orange"){ //si c un chocolat skor il va l'incrémenter
                    nombreOrange++;
                }

                if(classes[maxPos] == "pomme"){ //si c un chocolat skor il va l'incrémenter
                    nombrePomme++;
                }

                if(classes[maxPos] == "sauce Hot Chicken"){ //si c un chocolat skor il va l'incrémenter
                    nombreSauceHotChicken++;
                }
                if(classes[maxPos] == "thon Rio Mare"){ //si c un chocolat skor il va l'incrémenter
                    nombreThonRioMare++;
                }
                /*partie verification*/


                result.setText(classes[maxPos] );
            } else {
                // sinon, afficher qu'aucun objet n'a été détecté
                result.setText("Aucun objet détecté");
            }

            /*nouvelle partie*/

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  //C'est la veille facon de faire le onActivityResult
        if(resultCode == RESULT_OK){

            if(requestCode == 3)
            {
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight()); //redimenssion de la Bitmap et en fait un carré
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);   //cest ici que la classifiaction d'image ce fait
            }

            if(requestCode == 1)   //faut verifier les reques code on les utilise
            {
                Uri dat = data.getData();
                Bitmap image = null;
                try {
                    image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);  //cest ici que la classifiaction d'image ce fait
            }

        }//if(resultCode == RESULT_OK)
        super.onActivityResult(requestCode, resultCode, data);
    }



    private void bouttonPrixAliment(){

        InterfaceServeurAliment interfaceServeurAliment = RetrofitInstance2.getInstance().create(InterfaceServeurAliment.class);
        Call<ResponseBody> call = interfaceServeurAliment.getAliments();
        call.enqueue(new Callback<ResponseBody>() {
                         @Override
                         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {  //action qu'on va faire si on a une reponse du serveur
                             ResponseBody body = response.body();
                             try {

                                 //  JSONObject jsonObject = new JSONObject(body.string());
                                 // String message = jsonObject.getString("Message");
                                 String s = body.string();
                                 JsonParser jsonParser = new JsonParser();
                                 Object o = jsonParser.parse(s);

                                 Log.d("TYPE OBJET",o.toString());
                                 Log.d("STRING", body.string());

                                 if(o instanceof JSONObject)  //si c un json object
                                 {
                                     JSONObject jsonObject = new JSONObject(body.string());    //convertie le json en objet json
                                     String message = jsonObject.getString("Message");
                                 }// if(o instanceof JSONObject)
                                 else{ //sinon
                                     JSONArray jsonArray = new JSONArray(s);  //sinon convertie le json en tableau json
                                     List<Aliment> l = new ArrayList<Aliment>();  //creer une liste avec le type utilisateur

                                     for (int i=0; i<jsonArray.length(); i++) //la boucle va parcourir les élément du json
                                     {
                                         JSONObject jsonObject = jsonArray.getJSONObject(i);  //methode pour recuperer le json. json par json. bref un par un
                                         //note c les atrtibut de la BD
                                         int id = jsonObject.getInt("no_aliment");  //va recupeer le id
                                         String nomA = jsonObject.getString("nom_aliment");  // va recuperer lattribut nom
                                         double prixA = jsonObject.getDouble("prix_aliment");// va recuperer lattribut prenom

                                         l.add(new Aliment(id, nomA, prixA));
                                         AssignationValeurPrixABaseDonner(nomA,prixA);
                                     }
                                     adapterAliment = new AdapterAliment(l);
                                     //rvliste.setAdapter(adapterAliment); //po besoin ont veut jsute les prix
                                     //  adapterUtilisateur = new AdapterUtilisateur(l);
                                     //  rvliste.setAdapter(adapterUtilisateur);
                                 }// else

                             }//try
                             catch (JSONException e){
                                 throw  new RuntimeException(e);
                             }//catch (JSONException e)
                             catch (IOException e){
                                 throw  new RuntimeException(e);
                             }//catch (IOException e)


                             //test/**/AUTRE FACON DE FAIRE //*************************//

                    /*
                    try {
                        JSONArray jsonArray = new JSONArray(body.string());

                        for (int i = 0;i < jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String nom = jsonObject.getString("nom");
                            String marque = jsonObject.getString("marque");
                            double prix = jsonObject.getDouble("prix");

                            Produit p = new Produit(id, nom, marque ,prix);
                            adapterListe.ajouterProduit(p);

                        }//for (int i = 0;i < jsonArray.length(); i++){


                        }//try
                    catch (JSONException e) {
                           throw  new RuntimeException(e);
                            // e.printStackTrace();
                        }//catch
                    catch (IOException e) {
                            throw  new RuntimeException(e);
                            // e.printStackTrace();
                        }//catch
*/
                             //test/**/AUTRE FACON DE FAIRE //*************************//


                         }//public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                         @Override
                         public void onFailure(Call<ResponseBody> call, Throwable t) { //action qu'on fait si la recuperation du json echou
//            public void onFailure(Call<ResponseBody> call, Throwable t) { //avant cetais
                             Call<List<Aliment>> call2 = interfaceServeurAliment.getAlimentBis();
                             call2.enqueue(new Callback<List<Aliment>>() {
                                               @Override
                                               public void onResponse(Call<List<Aliment>> call, Response<List<Aliment>> response) {
                                                   List l = response.body();
                                                  // prix7up=15;
                                               }

                                               @Override
                                               public void onFailure(Call<List<Aliment>> call, Throwable t) {
                                                   String message = t.getMessage();
                                                   System.out.println("TESTTTTT " +message);
                                                 //  prix7up= 15;     //cest ici qui va
                                                   //   Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                                               }
                                           }// call.enqueue(new Callback<List<Produit>>() {
                             );
                         }//public void onFailure(Call<ResponseBody> call,
                     }//call.enqueue(new Callback<ResponseBody>()
        );


    }//methode bouttonPrixAliment()


    public void AssignationValeurPrixABaseDonner(String nomAliment,double prixAliment){ //cette methode va verifier le nom de l'objet et assigner le prix qui vien de  la base de donner à la variable local prix correspondant a lobjet

        if(nomAliment.equals("7up")){ //si c un chocolat skor il va l'incrémenter
            prix7up=prixAliment;
        }

        if(nomAliment.equals("Alexandre Abel") ){ //si c un chocolat skor il va l'incrémenter
            prixAlexandreAbel=prixAliment;
        }

        if(nomAliment.equals("Nesquik au chocolat")){ //si c un chocolat skor il va l'incrémenter
            prixNesquikAuChocolat=prixAliment;
        }

        if(nomAliment.equals("Nesquik Au Fraise")){ //si c un chocolat skor il va l'incrémenter
            prixNesquikAuFraise=prixAliment;
        }

        if(nomAliment.equals("oignon espagnol")){ //si c un chocolat skor il va l'incrémenter
            prixOignonEspagnol=prixAliment;
        }

        if(nomAliment.equals("chocolat Skor") ){ //si c un chocolat skor il va l'incrémenter
            prixChocolatSkor=prixAliment;
        }

        if(nomAliment.equals("coffee Crisp")){ //si c un chocolat skor il va l'incrémenter
            prixCoffeeCrisp=prixAliment;
        }

        if(nomAliment.equals("deodorant Axe")){ //si c un chocolat skor il va l'incrémenter
            prixDeodorantAxe=prixAliment;
        }

        if(nomAliment.equals("moutarde") ){ //si c un chocolat skor il va l'incrémenter
            prixMoutarde=prixAliment;
        }

        if(nomAliment.equals("orange")){ //si c un chocolat skor il va l'incrémenter
            prixOrange=prixAliment;
        }

        if(nomAliment.equals("pomme")){ //si c un chocolat skor il va l'incrémenter
            prixPomme=prixAliment;
        }

        if(nomAliment.equals("sauce Hot Chicken")){ //si c un chocolat skor il va l'incrémenter
            prixSauceHotChicken=prixAliment;
        }
        if(nomAliment.equals("thon Rio Mare")){ //si c un chocolat skor il va l'incrémenter
            prixThonRioMare=prixAliment;
        }
        /*partie verification*/

    }

}//class MainActivity