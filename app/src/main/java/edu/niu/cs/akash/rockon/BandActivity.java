/********************************************************************
 * Project Name: Rock On!
 * Author : Akash Rangojoo
 * Z ID : Z1717009
 * Description: This is the second activity that gets called from main activity. The string
 *              with the band name is passed to this activity and details about that band is shown.
 */

package edu.niu.cs.akash.rockon;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band);

        // the value retrieved from the previous activity is stored in this string object.
        String band = getIntent().getExtras().getString("bandName");
        TextView headingTV,descTV;
        headingTV = (TextView)findViewById(R.id.resultTextView);
        descTV = (TextView)findViewById(R.id.descTextView);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
        headingTV.setTypeface(type);
        descTV.setTypeface(type);

        if(band.equals("Led Zeppelin")){
            headingTV.setText(R.string.ledZeppelinString);
            descTV.setText(R.string.lzDesc);
        }
        else if(band.equals("The Beatles")){
            headingTV.setText(R.string.beatlesString);
            descTV.setText(R.string.tbDesc);
        }
        else if(band.equals("Pink Floyd")){
            headingTV.setText(R.string.pinkFloydString);
            descTV.setText(R.string.pfDesc);
        }
        else if(band.equals("Queen")){
            headingTV.setText(R.string.queenString);
            descTV.setText(R.string.queenDesc);
        }
        else if(band.equals("Metallica")){
            headingTV.setText(R.string.metallicaString);
            descTV.setText(R.string.metDesc);
        }

        //setContentView(textView);
    }

    public void goBack(View view) {
        finish();
    }
}
