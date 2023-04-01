package com.example.testdetectionobject14pomme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AffichageNombreObjetActivity extends AppCompatActivity {


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


    double prixTotal7up = 0;
    double prixTotalAlexandreAbel = 0;
    double prixTotalNesquikAuChocolat = 0;
    double prixTotalNesquikAuFraise = 0;
    double prixTotalOignonEspagnol = 0;
    double prixTotalChocolatSkor = 0;
    double prixTotalCoffeeCrisp = 0;
    double prixTotalDeodorantAxe = 0;
    double prixTotalMoutarde = 0;
    double prixTotalOrange = 0;
    double prixTotalPomme = 0;
    double prixTotalSauceHotChicken = 0;
    double prixTotalThonRioMare = 0;

    double prixTotalTousArticle = 0;


    TextView tbNombre7up,tbPrix7up, tbNombreAlexandreAbel,tbPrixAlexandreAbel, tbNombreNesquikChocolat,tbPrixNesquikChocolat, tbNombreNesquikFraise,tbPrixNesquikFraise, tbNombreOignonEspagnol,tbPrixOignonEspagnol, tbNombreChocolatSkor,tbPrixChocolatSkor, tbNombreCoffeeCrisp,tbPrixCoffeeCrisp, tbNombreDeodorantAxe,tbPrixDeodorantAxe, tbNombreMoutarde,tbPrixMoutarde, tbNombreOrange,tbPrixOrange, tbNombrePomme,tbPrixPomme, tbNombreSauceHotChicken,tbPrixSauceHotChicken,tbNombreThonRioMare,tbPrixThonRioMare, tbPrixTotalDeToutLesArticles;
    ImageView btPlus7up, btMoin7up, btPlusAlexandreAbel, btMoinAlexandreAbel, btPlusNesquikChocolat, btMoinNesquikChocolat, btPlusNesquikFraise, btMoinNesquikFraise, btPlusOignonEspagnol, btMoinOignonEspagnol, btPlusChocolatSkor, btMoinChocolatSkor, btPlusCoffeeCrisp, btMoinCoffeeCrisp, btPlusDeodorantAxe, btMoinDeodorantAxe, btPlusMoutarde, btMoinMoutarde, btPlusOrange, btMoinOrange, btPlusPomme, btMoinPomme, btPlusSauceHotChicken, btMoinSauceHotChicken, btPlusThonRioMare, btMoinThonRioMare;
    LinearLayout linearLayout7up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_nombre_objet);

        /*TextView nombre delement*/
        tbNombre7up= findViewById(R.id.tbNombre7up);
        tbNombreAlexandreAbel= findViewById(R.id.tbNombreAlexandreAbel);
        tbNombreNesquikChocolat= findViewById(R.id.tbNombreNesquikChocolat);
        tbNombreNesquikFraise= findViewById(R.id.tbNombreNesquikFraise);
        tbNombreOignonEspagnol= findViewById(R.id.tbNombreOignonEspagnol);
        tbNombreChocolatSkor= findViewById(R.id.tbNombreChocolatSkor);
        tbNombreCoffeeCrisp = findViewById(R.id.tbNombreCoffeeCrisp);
        tbNombreDeodorantAxe= findViewById(R.id.tbNombreDeodorantAxe);
        tbNombreMoutarde= findViewById(R.id.tbNombreMoutarde);
        tbNombreOrange= findViewById(R.id.tbNombreOrange);
        tbNombrePomme= findViewById(R.id.tbNombrePomme);
        tbNombreSauceHotChicken= findViewById(R.id.tbNombreSauceHotChicken);
        tbNombreThonRioMare= findViewById(R.id.tbNombreThonRioMare);

        /*TextView prix delement*/
        tbPrix7up= findViewById(R.id.tbPrix7up);
        tbPrixAlexandreAbel= findViewById(R.id.tbPrixAlexandreAbel);
        tbPrixNesquikChocolat= findViewById(R.id.tbPrixNesquikChocolat);
        tbPrixNesquikFraise= findViewById(R.id.tbPrixNesquikFraise);
        tbPrixOignonEspagnol= findViewById(R.id.tbPrixOignonEspagnol);
        tbPrixChocolatSkor= findViewById(R.id.tbPrixChocolatSkor);
        tbPrixCoffeeCrisp = findViewById(R.id.tbPrixCoffeeCrisp);
        tbPrixDeodorantAxe= findViewById(R.id.tbPrixDeodorantAxe);
        tbPrixMoutarde= findViewById(R.id.tbPrixMoutarde);
        tbPrixOrange= findViewById(R.id.tbPrixOrange);
        tbPrixPomme= findViewById(R.id.tbPrixPomme);
        tbPrixSauceHotChicken= findViewById(R.id.tbPrixSauceHotChicken);
        tbPrixThonRioMare= findViewById(R.id.tbPrixThonRioMare);

        tbPrixTotalDeToutLesArticles = findViewById(R.id.prixTotalTousArticle);

        /*ImageView*/  //recupere id des boutton image view
        btPlus7up = findViewById(R.id.btPlus7up);
        btMoin7up = findViewById(R.id.btMoin7up);
        btPlusAlexandreAbel = findViewById(R.id.btPlusAlexandreAbel);
        btMoinAlexandreAbel = findViewById(R.id.btMoinAlexandreAbel);
        btPlusNesquikChocolat = findViewById(R.id.btPlusNesquikChocolat);
        btMoinNesquikChocolat = findViewById(R.id.btMoinNesquikChocolat);
        btPlusNesquikFraise = findViewById(R.id.btPlusNesquikFraise);
        btMoinNesquikFraise = findViewById(R.id.btMoinNesquikFraise);
        btPlusOignonEspagnol  =  findViewById(R.id.btPlusOignonEspagnol);
        btMoinOignonEspagnol = findViewById(R.id.btMoinOignonEspagnol);
        btPlusChocolatSkor = findViewById(R.id.btPlusChocolatSkor);
        btMoinChocolatSkor = findViewById(R.id.btMoinChocolatSkor);
        btPlusCoffeeCrisp = findViewById(R.id.btPlusCoffeeCrisp);
        btMoinCoffeeCrisp = findViewById(R.id.btMoinCoffeeCrisp);
        btPlusDeodorantAxe = findViewById(R.id.btPlusDeodorantAxe);
        btMoinDeodorantAxe = findViewById(R.id.btMoinDeodorantAxe);
        btPlusMoutarde = findViewById(R.id.btPlusMoutarde);
        btMoinMoutarde = findViewById(R.id.btMoinMoutarde);
        btPlusOrange = findViewById(R.id.btPlusOrange);
        btMoinOrange = findViewById(R.id.btMoinOrange);
        btPlusPomme = findViewById(R.id.btPlusPomme);
        btMoinPomme = findViewById(R.id.btMoinPomme);
        btPlusSauceHotChicken = findViewById(R.id.btPlusSauceHotChicken);
        btMoinSauceHotChicken = findViewById(R.id.btMoinSauceHotChicken);
        btPlusThonRioMare = findViewById(R.id.btPlusThonRioMare);
        btMoinThonRioMare = findViewById(R.id.btMoinThonRioMare);

        /*linearLayout7up*/
        linearLayout7up = findViewById(R.id.linearLayout7up);  //sert a cahché les linearLayout si la valeur est 0

        Intent intent = getIntent();

        tbNombre7up.setText(String.valueOf(intent.getIntExtra("nombre7up" ,0)));
        nombre7up = intent.getIntExtra("nombre7up" ,0);
        prix7up = intent.getDoubleExtra("prix7up" ,0);
       // miseAJoursPrixTotal7up();
       tbPrix7up.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotal7up))+" $");

        tbNombreAlexandreAbel.setText(String.valueOf(intent.getIntExtra("nombreAlexandreAbel" ,0)));
        nombreAlexandreAbel = intent.getIntExtra("nombreAlexandreAbel" ,0);
        prixAlexandreAbel = intent.getDoubleExtra("prixAlexandreAbel" ,0);
        tbPrixAlexandreAbel.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalAlexandreAbel))+" $");

        tbNombreNesquikChocolat.setText(String.valueOf(intent.getIntExtra("nombreNesquikAuChocolat" ,0)));
        nombreNesquikAuChocolat = intent.getIntExtra("nombreNesquikAuChocolat" ,0);
        prixNesquikAuChocolat = intent.getDoubleExtra("prixNesquikAuChocolat" ,0);
        tbPrixNesquikChocolat.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalNesquikAuChocolat))+" $");

        tbNombreNesquikFraise.setText(String.valueOf(intent.getIntExtra("nombreNesquikAuFraise" ,0)));
        nombreNesquikAuFraise = intent.getIntExtra("nombreNesquikAuFraise" ,0);
        prixNesquikAuFraise = intent.getDoubleExtra("prixNesquikAuFraise" ,0);
        tbPrixNesquikFraise.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalNesquikAuFraise))+" $");

        tbNombreOignonEspagnol.setText(String.valueOf(intent.getIntExtra("nombreOignonEspagnol" ,0)));
        nombreOignonEspagnol = intent.getIntExtra("nombreOignonEspagnol" ,0);
        prixOignonEspagnol = intent.getDoubleExtra("prixOignonEspagnol" ,0);
        tbPrixOignonEspagnol.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalOignonEspagnol))+" $");


        tbNombreChocolatSkor.setText(String.valueOf(intent.getIntExtra("nombreChocolatSkor" ,0)));
        nombreChocolatSkor = intent.getIntExtra("nombreChocolatSkor" ,0);
        prixChocolatSkor = intent.getDoubleExtra("prixChocolatSkor" ,0);
        tbPrixChocolatSkor.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalChocolatSkor))+" $");

        tbNombreCoffeeCrisp.setText(String.valueOf(intent.getIntExtra("nombreCoffeeCrisp" ,0)));
        nombreCoffeeCrisp = intent.getIntExtra("nombreCoffeeCrisp" ,0);
        prixCoffeeCrisp = intent.getDoubleExtra("prixCoffeeCrisp" ,0);
        tbPrixCoffeeCrisp.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalCoffeeCrisp))+" $");

        tbNombreDeodorantAxe.setText(String.valueOf(intent.getIntExtra("nombreDeodorantAxe" ,0)));
        nombreDeodorantAxe = intent.getIntExtra("nombreDeodorantAxe" ,0);
        prixDeodorantAxe = intent.getDoubleExtra("prixDeodorantAxe" ,0);
        tbPrixDeodorantAxe.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalDeodorantAxe))+" $");

        tbNombreMoutarde.setText(String.valueOf(intent.getIntExtra("nombreMoutarde" ,0)));
        nombreMoutarde = intent.getIntExtra("nombreMoutarde" ,0);
        prixMoutarde = intent.getDoubleExtra("prixMoutarde" ,0);
        tbPrixMoutarde.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalMoutarde))+" $");


        tbNombreOrange.setText(String.valueOf(intent.getIntExtra("nombreOrange" ,0)));
        nombreOrange = intent.getIntExtra("nombreOrange" ,0);
        prixOrange = intent.getDoubleExtra("prixOrange" ,0);
        tbPrixOrange.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalOrange))+" $");

        tbNombrePomme.setText(String.valueOf(intent.getIntExtra("nombrePomme" ,0)));
        nombrePomme = intent.getIntExtra("nombrePomme" ,0);
        prixPomme = intent.getDoubleExtra("prixPomme" ,0);
        tbPrixPomme.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalPomme))+" $");


        tbNombreSauceHotChicken.setText(String.valueOf(intent.getIntExtra("nombreSauceHotChicken" ,0)));
        nombreSauceHotChicken = intent.getIntExtra("nombreSauceHotChicken" ,0);
        prixSauceHotChicken = intent.getDoubleExtra("prixSauceHotChicken" ,0);
        tbPrixSauceHotChicken.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalSauceHotChicken))+" $");


        tbNombreThonRioMare.setText(String.valueOf(intent.getIntExtra("nombreThonRioMare" ,0)));
        nombreThonRioMare = intent.getIntExtra("nombreThonRioMare" ,0);
        prixThonRioMare = intent.getDoubleExtra("prixThonRioMare" ,0);
        tbPrixThonRioMare.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalThonRioMare))+" $");


/*
        /*partie cache les element si la valeur est 0*/  /*
        if(nombre7up <= 0){
            linearLayout7up.setVisibility(View.GONE);
        }*/  //desativer temporairement


        /*partie pour lincrementation ou decrementation des bouttom*/

        btPlus7up.setOnClickListener(new View.OnClickListener(){  //boutton plus 7up

            @Override
            public void onClick(View v) {
                nombre7up++;  //incremente la nombre de 7up
                tbNombre7up.setText(String.valueOf(nombre7up));//met a jours la textbox nombre de 7up
                miseAJoursPrixTotal7up(); //met a jours le prix total des 7up
                tbPrix7up.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotal7up))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles
            }//onClick
        });


        btMoin7up.setOnClickListener(new View.OnClickListener(){  //boutton moin 7up

            @Override
            public void onClick(View v) {
                if(nombre7up > 0){
                    nombre7up--; //decremente la nombre de 7up
                    tbNombre7up.setText(String.valueOf(nombre7up));//met a jours la textbox nombre de 7up
                    miseAJoursPrixTotal7up();//met a jours le prix total des 7up
                    tbPrix7up.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotal7up))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });



        btPlusAlexandreAbel.setOnClickListener(new View.OnClickListener(){  //boutton plus NesquikFraise

            @Override
            public void onClick(View v) {
                nombreAlexandreAbel++;
                tbNombreAlexandreAbel.setText(String.valueOf(nombreAlexandreAbel));
                miseAJoursPrixTotalAlexandreAbel(); //met a jours le prix total des 7up
                tbPrixAlexandreAbel.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalAlexandreAbel))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinAlexandreAbel.setOnClickListener(new View.OnClickListener(){  //boutton moin NesquikFraise

            @Override
            public void onClick(View v) {
                if(nombreAlexandreAbel > 0){
                    nombreAlexandreAbel--;
                    tbNombreAlexandreAbel.setText(String.valueOf(nombreAlexandreAbel));
                    miseAJoursPrixTotalAlexandreAbel(); //met a jours le prix total des 7up
                    tbPrixAlexandreAbel.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalAlexandreAbel))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });

        btPlusNesquikChocolat.setOnClickListener(new View.OnClickListener(){  //boutton plus NesquikFraise

            @Override
            public void onClick(View v) {
                nombreNesquikAuChocolat++;
                tbNombreNesquikChocolat.setText(String.valueOf(nombreNesquikAuChocolat));
                miseAJoursPrixTotalNesquikAuChocolat(); //met a jours le prix total des 7up
                tbPrixNesquikChocolat.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalNesquikAuChocolat))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinNesquikChocolat.setOnClickListener(new View.OnClickListener(){  //boutton moin NesquikFraise

            @Override
            public void onClick(View v) {
                if(nombreNesquikAuChocolat > 0){
                    nombreNesquikAuChocolat--;
                    tbNombreNesquikChocolat.setText(String.valueOf(nombreNesquikAuChocolat));
                    miseAJoursPrixTotalNesquikAuChocolat(); //met a jours le prix total des 7up
                    tbPrixNesquikChocolat.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalNesquikAuChocolat))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });

        btPlusNesquikFraise.setOnClickListener(new View.OnClickListener(){  //boutton plus NesquikFraise

            @Override
            public void onClick(View v) {
                nombreNesquikAuFraise++;
                tbNombreNesquikFraise.setText(String.valueOf(nombreNesquikAuFraise));
                miseAJoursPrixTotalNesquikAuFraise(); //met a jours le prix total des 7up
                tbPrixNesquikFraise.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalNesquikAuFraise))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinNesquikFraise.setOnClickListener(new View.OnClickListener(){  //boutton moin NesquikFraise

            @Override
            public void onClick(View v) {
                if(nombreNesquikAuFraise > 0){
                    nombreNesquikAuFraise--;
                    tbNombreNesquikFraise.setText(String.valueOf(nombreNesquikAuFraise));
                    miseAJoursPrixTotalNesquikAuFraise(); //met a jours le prix total des 7up
                    tbPrixNesquikFraise.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalNesquikAuFraise))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });



        btPlusOignonEspagnol.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreOignonEspagnol++;
                tbNombreOignonEspagnol.setText(String.valueOf(nombreOignonEspagnol));
                miseAJoursPrixTotalOignonEspagnol(); //met a jours le prix total des 7up
                tbPrixOignonEspagnol.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalOignonEspagnol))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinOignonEspagnol.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreOignonEspagnol > 0){
                    nombreOignonEspagnol--;
                    tbNombreOignonEspagnol.setText(String.valueOf(nombreOignonEspagnol));
                    miseAJoursPrixTotalOignonEspagnol(); //met a jours le prix total des 7up
                    tbPrixOignonEspagnol.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalOignonEspagnol))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });


        btPlusChocolatSkor.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreChocolatSkor++;
                tbNombreChocolatSkor.setText(String.valueOf(nombreChocolatSkor));
                miseAJoursPrixTotalChocolatSkor(); //met a jours le prix total des 7up
                tbPrixChocolatSkor.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalChocolatSkor))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinChocolatSkor.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreChocolatSkor > 0){
                    nombreChocolatSkor--;
                    tbNombreChocolatSkor.setText(String.valueOf(nombreChocolatSkor));
                    miseAJoursPrixTotalChocolatSkor(); //met a jours le prix total des 7up
                    tbPrixChocolatSkor.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalChocolatSkor))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });

        btPlusCoffeeCrisp.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreCoffeeCrisp++;
                tbNombreCoffeeCrisp.setText(String.valueOf(nombreCoffeeCrisp));
                miseAJoursPrixTotalCoffeeCrisp(); //met a jours le prix total des 7up
                tbPrixCoffeeCrisp.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalCoffeeCrisp))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinCoffeeCrisp.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreCoffeeCrisp > 0){
                    nombreCoffeeCrisp--;
                    tbNombreCoffeeCrisp.setText(String.valueOf(nombreCoffeeCrisp));
                    miseAJoursPrixTotalCoffeeCrisp(); //met a jours le prix total des 7up
                    tbPrixCoffeeCrisp.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalCoffeeCrisp))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });


        btPlusDeodorantAxe.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreDeodorantAxe++;
                tbNombreDeodorantAxe.setText(String.valueOf(nombreDeodorantAxe));
                miseAJoursPrixTotalDeodorantAxe(); //met a jours le prix total des 7up
                tbPrixDeodorantAxe.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalDeodorantAxe))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinDeodorantAxe.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreDeodorantAxe > 0){
                    nombreDeodorantAxe--;
                    tbNombreDeodorantAxe.setText(String.valueOf(nombreDeodorantAxe));
                    miseAJoursPrixTotalDeodorantAxe(); //met a jours le prix total des 7up
                    tbPrixDeodorantAxe.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalDeodorantAxe))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });


        btPlusMoutarde.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreMoutarde++;
                tbNombreMoutarde.setText(String.valueOf(nombreMoutarde));
                miseAJoursPrixTotalMoutarde(); //met a jours le prix total des 7up
                tbPrixMoutarde.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalMoutarde))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinMoutarde.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreMoutarde > 0){
                    nombreMoutarde--;
                    tbNombreMoutarde.setText(String.valueOf(nombreMoutarde));
                    miseAJoursPrixTotalMoutarde(); //met a jours le prix total des 7up
                    tbPrixMoutarde.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalMoutarde))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });


        btPlusOrange.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreOrange++;
                tbNombreOrange.setText(String.valueOf(nombreOrange));
                miseAJoursPrixTotalOrange(); //met a jours le prix total des 7up
                tbPrixOrange.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalOrange))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinOrange.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreOrange > 0){
                    nombreOrange--;
                    tbNombreOrange.setText(String.valueOf(nombreOrange));
                    miseAJoursPrixTotalOrange(); //met a jours le prix total des 7up
                    tbPrixOrange.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalOrange))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });


        btPlusPomme.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombrePomme++;
                tbNombrePomme.setText(String.valueOf(nombrePomme));
                miseAJoursPrixTotalPomme(); //met a jours le prix total des 7up
                tbPrixPomme.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalPomme))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinPomme.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombrePomme > 0){
                    nombrePomme--;
                    tbNombrePomme.setText(String.valueOf(nombrePomme));
                    miseAJoursPrixTotalPomme(); //met a jours le prix total des 7up
                    tbPrixPomme.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalPomme))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });


        btPlusSauceHotChicken.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreSauceHotChicken++;
                tbNombreSauceHotChicken.setText(String.valueOf(nombreSauceHotChicken));
                miseAJoursPrixTotalSauceHotChicken(); //met a jours le prix total des 7up
                tbPrixSauceHotChicken.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalSauceHotChicken))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

            }//onClick
        });


        btMoinSauceHotChicken.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreSauceHotChicken > 0){
                    nombreSauceHotChicken--;
                    tbNombreSauceHotChicken.setText(String.valueOf(nombreSauceHotChicken));
                    miseAJoursPrixTotalSauceHotChicken(); //met a jours le prix total des 7up
                    tbPrixSauceHotChicken.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalSauceHotChicken))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles

                }// if(nombre7up > 0)

            }//onClick
        });



        btPlusThonRioMare.setOnClickListener(new View.OnClickListener(){  //boutton plus Cerise

            @Override
            public void onClick(View v) {
                nombreThonRioMare++;
                tbNombreThonRioMare.setText(String.valueOf(nombreThonRioMare));
                miseAJoursPrixTotalThonRioMare(); //met a jours le prix total des 7up
                tbPrixThonRioMare.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalThonRioMare))+" $");  //met a jours la textbox prix total 7up
                miseAJoursPrixTotalDeToutLesElement();
                tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total 7up

            }//onClick
        });


        btMoinThonRioMare.setOnClickListener(new View.OnClickListener(){  //boutton moin Cerise

            @Override
            public void onClick(View v) {
                if(nombreThonRioMare > 0){
                    nombreThonRioMare--;
                    tbNombreThonRioMare.setText(String.valueOf(nombreThonRioMare));
                    miseAJoursPrixTotalThonRioMare(); //met a jours le prix total des 7up
                    tbPrixThonRioMare.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalThonRioMare))+" $");  //met a jours la textbox prix total 7up
                    miseAJoursPrixTotalDeToutLesElement();//met a jours la variable prixTotalTousArticle qui contient le total de tout les article
                    tbPrixTotalDeToutLesArticles.setText(String.valueOf(new DecimalFormat("#0.00").format(prixTotalTousArticle))+" $");  //met a jours la textbox prix total de tous les articles
                }// if(nombre7up > 0)

            }//onClick
        });


        // RetenirDonner();


    }//onCreate


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  //c'est les methode executer si on appuit sa fleche retour
        if(item.getItemId() == android.R.id.home)
        {
            RetenirDonner();   //pour que on retienne linformation on renvoie des donner avec cette methode
            //setResult(RESULT_CANCELED);
            finish();
        }
        return true;
    }

    public void miseAJoursPrixTotal7up(){
        prixTotal7up=prix7up*nombre7up;
    }

    public void miseAJoursPrixTotalAlexandreAbel(){
        prixTotalAlexandreAbel=prixAlexandreAbel*nombreAlexandreAbel;
    }

    public void miseAJoursPrixTotalNesquikAuChocolat(){
        prixTotalNesquikAuChocolat=prixNesquikAuChocolat*nombreNesquikAuChocolat;
    }

    public void miseAJoursPrixTotalNesquikAuFraise(){
        prixTotalNesquikAuFraise=prixNesquikAuFraise*nombreNesquikAuFraise;
    }

    public void miseAJoursPrixTotalOignonEspagnol(){
        prixTotalOignonEspagnol=prixOignonEspagnol*nombreOignonEspagnol;
    }

    public void miseAJoursPrixTotalChocolatSkor(){
        prixTotalChocolatSkor=prixChocolatSkor*nombreChocolatSkor;
    }

    public void miseAJoursPrixTotalCoffeeCrisp(){
        prixTotalCoffeeCrisp=prixCoffeeCrisp*nombreCoffeeCrisp;
    }

    public void miseAJoursPrixTotalDeodorantAxe(){
        prixTotalDeodorantAxe=prixDeodorantAxe*nombreDeodorantAxe;
    }

    public void miseAJoursPrixTotalMoutarde(){
        prixTotalMoutarde=prixMoutarde*nombreMoutarde;
    }

    public void miseAJoursPrixTotalOrange(){
        prixTotalOrange=prixOrange*nombreOrange;
    }

    public void miseAJoursPrixTotalPomme(){
        prixTotalPomme=prixPomme*nombrePomme;
    }

    public void miseAJoursPrixTotalSauceHotChicken(){
        prixTotalSauceHotChicken=prixSauceHotChicken*nombreSauceHotChicken;
    }

    public void miseAJoursPrixTotalThonRioMare(){
        prixTotalThonRioMare=prixThonRioMare*nombreThonRioMare;
    }

//il y a un bug bizarre avec cette methode lorsqu'on set le total final il arrivent qu'un valeur fantome s'ajoute.
    //cette valeur fantome est irrégulière par exemple avec les canne de thon a 4$ on peut arrivé a une valeur de 7.27$ sur le totalFinal
    //C'est pt du au fait de cliquer trop vite? Le bug semble arrivé de temps en temps
    //pt changer pour des float ou BigDecimal au lieux des double
    public void miseAJoursPrixTotalDeToutLesElement(){  //met a jours la textbox du total de tous les articles
        prixTotalTousArticle=prixTotal7up+prixTotalAlexandreAbel+prixTotalNesquikAuChocolat+prixTotalNesquikAuFraise+prixTotalOignonEspagnol+prixTotalChocolatSkor+prixTotalCoffeeCrisp+prixTotalDeodorantAxe+prixTotalMoutarde+prixTotalOrange+prixTotalPomme+prixTotalSauceHotChicken+prixTotalThonRioMare;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
        finish();
    }





    /*pas bonne facon de faire car sa recrer un activiter bref on a pas besoin des putExtra pour renvoyer a une partie*/
    public void RetenirDonner(){ //sert a renvoyer les donner a MainActivity
        Intent intent = new Intent(AffichageNombreObjetActivity.this, MainActivity.class);
        intent.putExtra("nombre7up",nombre7up);
        intent.putExtra("nombreAlexandreAbel",nombreAlexandreAbel);
        intent.putExtra("nombreNesquikAuChocolat",nombreNesquikAuChocolat);
        intent.putExtra("nombreNesquikAuFraise",nombreNesquikAuFraise);
        intent.putExtra("nombreOignonEspagnol",nombreOignonEspagnol);
        intent.putExtra("nombreChocolatSkor",nombreChocolatSkor);
        intent.putExtra("nombreCoffeeCrisp",nombreCoffeeCrisp);
        intent.putExtra("nombreDeodorantAxe",nombreDeodorantAxe);
        intent.putExtra("nombreMoutarde",nombreMoutarde);
        intent.putExtra("nombreOrange",nombreOrange);
        intent.putExtra("nombrePomme",nombrePomme);
        intent.putExtra("nombreSauceHotChicken",nombreSauceHotChicken);
        intent.putExtra("nombreThonRioMare",nombreThonRioMare);
        setResult(RESULT_OK, intent);  //chec lautre code pour comparer ya une modification importante ici
    }

}//classe AffichageNombreObjetActivity