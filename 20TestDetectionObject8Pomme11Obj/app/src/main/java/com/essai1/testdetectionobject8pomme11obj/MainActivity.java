package com.essai1.testdetectionobject8pomme11obj;

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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.essai1.testdetectionobject8pomme11obj.ml.ModelPomme11Objet1;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MainActivity extends AppCompatActivity {
//va detecter si c une pomme ,une cerise ou une orange


    Button camera, gallery;
    ImageView imageView;
    TextView result;
    int imageSize = 32; //à partir des information eu sur l'information donner après limportation du model tensorflowLite.Bref sa dit pt la taille de la redimension de limage
    //dans mon exemple c cette ligne  TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 32, 32, 3}, DataType.FLOAT32);
    //et sa vien du fichier model.tflite qui ses ouvert après limportation du model

    float confidenceThreshold = 0.5f; //variable pour stocker le seuil de confiance souhaité (par exemple 0,5)
    //sa veut dire que si yer en bas de 0.5 il va dire aucun objet detecte

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = findViewById(R.id.button);
        gallery = findViewById(R.id.button2);

        result = findViewById(R.id.result);
        imageView = findViewById(R.id.imageView);

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
    }//methode onCreate

    public void classifyImage(Bitmap image){   //dans cette methode il faut copié coller le code qui saffiche après limportation du model tflite

        try {

            ModelPomme11Objet1 model = ModelPomme11Objet1.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 32, 32, 3}, DataType.FLOAT32);
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
            ModelPomme11Objet1.Outputs outputs = model.process(inputFeature0);
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
            String[] classes = {"7up", "Nesquik Au Fraise", "cerise","chocolat Skor","coffee Crisp","deodorant Axe","moutarde","orange","pomme","sauce Hot Chicken","thon Rio Mare"};

            if (maxConfidence >= confidenceThreshold) {
                // si la confiance de la classe maximale est supérieure ou égale au seuil de confiance,
                // afficher la classe correspondante
                result.setText(classes[maxPos]);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){

            if(requestCode == 3){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight()); //redimenssion de la Bitmap et en fait un carré
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }else {
                Uri dat = data.getData();
                Bitmap image = null;
                try {
                    image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }

        }//if(resultCode == RESULT_OK)
        super.onActivityResult(requestCode, resultCode, data);
    }
}//class MainActivity