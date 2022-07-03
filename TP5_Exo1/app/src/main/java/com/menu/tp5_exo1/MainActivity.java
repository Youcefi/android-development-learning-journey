package com.menu.tp5_exo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Youcefi Nour Elhouda & Daoudi Nadia
 * Groupe 2
 */


public class MainActivity extends Activity {
    private ImageSwitcher imageSwitcher;
    private Button Precedent;
    private Button Suivant;

    private final String[] images = {"image1", "image2"};
    private int Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Precedent = (Button) findViewById(R.id.buttonPrecedent);
        Suivant = (Button) findViewById(R.id.buttonSuivant);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        // Creation d'une animation
        // Lorsqu'une image est sélectionnéé, elle apparait en <fondu>.
        // Losque l'image suivante est sélectionnée, l'image actuelle s'estompe

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        this.Index = 0;
        this.showImage(this.Index);

        //Gestion du clic sur les boutons
        Precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePrecedente();
            }
        });

        Suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageSuivante();
            }
        });
    }

    private void ImagePrecedente(){
        if (Index > 0){
            Index --;
        }else {
            Toast.makeText(getApplicationContext(),"No Previous Image", Toast.LENGTH_SHORT).show();
            return;
        }
        this.showImage(Index);
    }

    private void ImageSuivante(){
        if (Index < this.images.length-1){
            Index ++;
        }else {
            Toast.makeText(getApplicationContext(),"No Next Image", Toast.LENGTH_SHORT).show();
            return;
        }
        this.showImage(Index);
    }

    private void showImage(int imgIndex){
        String NomImage = this.images[imgIndex];
        String NomPackage = this.getPackageName();
        int resId = this.getResources().getIdentifier(NomImage,"drawable",NomPackage);
        if (resId != 0){
            this.imageSwitcher.setImageResource(resId);
        }
    }
}

