/*****************************************************************
 * Project Name: Rock On!
 * Author : Akash Rangojoo
 * Z ID : Z1717009
 * Class Description : This is main class. It displays the heading image, and a spinner holding
 *                     band names.When a band is selected, it's image is displayed.
 *                     When the button below is clicked, control is taken to next activity where description is shown.
 */

package edu.niu.cs.akash.rockon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creating a new font. I have imported a font and placed it in the fonts folder so that it can be used
        // in this project.
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
        // Creating a TextView that holds instructions and an Image view that displays the title.
        TextView sampleTV = (TextView) findViewById(R.id.textView);
        ImageView titleIV= (ImageView) findViewById(R.id.titleImageView);
        String bandSelected; // This String will hold the selected band value
        Spinner listSpin;   // This spinner will hold the values of Bands.


        sampleTV.setTypeface(type); // setTypeface is used to set the font to this particular text view
        titleIV.setImageResource(R.drawable.rock_n_roll); // setting an image from drawableto this Image view

        // CCreating a Spinner and linking it to the spinner on the interface.
        listSpin = (Spinner) findViewById(R.id.listSpinner);
        // Creating an adapter with a layout for spinner.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_layout,SpinnerValues.stringArray);
        //setting the adapter to the spinner created
        listSpin.setAdapter(adapter);
        //set on item selected listener. This method will be called whenever an item is selected on spinner
        listSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // The selected value is saved into this string.
                final String selection = parent.getItemAtPosition(position).toString();
                // Image view which holds the image logo of the band is created
                ImageView bandIV = (ImageView) findViewById(R.id.bandImageView);
                // Based on the band selected, image is set using if conditions
                if(selection.equals("Led Zeppelin")){
                    bandIV.setImageResource(R.drawable.led_zep);//  setting image from drawable
                }
                else if(selection.equals("The Beatles")){
                    bandIV.setImageResource(R.drawable.the_beatles);
                }
                else if(selection.equals("Pink Floyd")){
                    bandIV.setImageResource(R.drawable.pink_floyd);
                }
                else if(selection.equals("Queen")){
                    bandIV.setImageResource(R.drawable.queen_band);
                }
                else if(selection.equals("Metallica")){
                    bandIV.setImageResource(R.drawable.metallica);
                }
                // Create button to go to next activity with details and link it to button on screen
                Button detailsBtn;
                detailsBtn = (Button) findViewById(R.id.detailsButton);
                // set on click listener t this button
                detailsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // create a new intent that take control to next activity from this context.
                        Intent newActivity1 = new Intent(MainActivity.this, BandActivity.class);
                        // send the selected band string to next activity using putExtra
                        newActivity1.putExtra("bandName",selection);
                        // start the activity by passing the intent created above
                        startActivity(newActivity1);
                    }
                });// ending on click listener
            }// ending onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); //  ending setOniteemselected
    }// ending onCreate
}// ending Main
