/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/

 package com.example.android.justjava;



         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.view.View;
         import android.widget.TextView;

         import java.text.NumberFormat;
         import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Defining the variable to assign to the number of coffees **/
    int quantity = 0;
    /**
     * This method is called when the increment button is clicked
     */
    public void increment(View view) {
         quantity ++;
        display(quantity);
    }

    /**
     * This method is called when the decrement button is clicked
     */
    public void decrement(View view) {
         quantity --;
         if(quantity < 0){quantity = 0;} //to avoid displaying negative numbers
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       // display(quantity);
      // displayPrice(quantity*5);

        // gives different values to a string depending on the  number of cups
        String numTazze;
        if (quantity == 1) {
            numTazze = " tazzina";
        } else {
            numTazze = " tazzine";
        }

        //
        String price_message = ("Sono "+(quantity * 5)+"€ per "+ quantity + numTazze +" prego!");
       // displayMessage(R.string.price_message);
        displayMessage(price_message);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance( Locale.ITALY).format(number));
    }

    private void displayMessage(String message){
        TextView messageTextView = (TextView) findViewById(R.id.price_text_view);
        messageTextView.setText(message);
    }

    /**
    This method erases the quantity and the text message */
    public void reset(View view) {
        quantity = 0;
        display(quantity);
        displayMessage("");

    }
}