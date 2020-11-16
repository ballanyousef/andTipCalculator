package com.it.yb.andtipcalculator;

import android.app.Activity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends Activity {

private double currentBillTotal;// x // סכום החיוב
private int currentCustomPercent;// y // ?אחוז הטיפ שנקבע בעזרת פקד הגרירה

// define referances to all view
private EditText billEditText; // קליטת סכום חיוב
private EditText tip10EditText; // הצגת טיפ 10%
private EditText total10EditText; // סכום חיוב עם טיפ 10%
private EditText tip15EditText; // הצגת טיפ 15%
private EditText total15EditText; // סכום חיוב עם טיפ 15%
private EditText tip20EditText; // הצגת טיפ 20%
private EditText total20EditText; // סכום חיוב עם טיפ 20%

private TextView customTipTextView; // תווית הצגת מידע
private EditText tipCustomEditText; // custom tip
private EditText totalCustomEditText; // total custom tip
private SeekBar customSeekBar;



@Override
public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // יצירת רפרנסים
        tip10EditText = (EditText) findViewById(R.id.tip10EditText);
        total10EditText = (EditText) findViewById(R.id.total10EditText);
        tip15EditText = (EditText) findViewById(R.id.tip15EditText);
        total15EditText = (EditText) findViewById(R.id.total15EditText);
        tip20EditText = (EditText) findViewById(R.id.tip20EditText);
        total20EditText = (EditText) findViewById(R.id.total20EditText);

        // יצירת רפרנס לטיפ מותאם אישי
        customTipTextView = (TextView) findViewById(R.id.customTipTextView);

        // יצירת רפרנס
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditText);
        totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditText);

        // יצירת רפרנס וקביעת מטפל אירוע לשינוי תיבת טקסט
        billEditText = (EditText) findViewById(R.id.billEditText);
        billEditText.addTextChangedListener(billEditTextWatcher);

        // SeekBar יצירת רפרנס וקביעת מטפל אירוע של פקד
        customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);

        } // end onCreate

// עדכון טיפים
private void updateStandard() {
        // calculate 10% percent tip
        double tenPercentTip = currentBillTotal * 0.1;
        double tenPercentTotal = currentBillTotal + tenPercentTip;

        // display values
        tip10EditText.setText(String.format(".%02f", tenPercentTip));//4.56745645
        total10EditText.setText(String.format("%.02f", tenPercentTotal));

        // calculate with a 15% percent tip
        double fifteenPercentTip = currentBillTotal * 0.15;
        double fifteenPercentTotal = currentBillTotal + fifteenPercentTip;

        // display values
        tip15EditText.setText(String.format("%.02f", fifteenPercentTip));
        total15EditText.setText(String.format("%.02f", fifteenPercentTotal));

        // calculate . with a 20% percent tip
        double twentyPercentTip = currentBillTotal * 0.20;
        double twentyPercentTotal = currentBillTotal + twentyPercentTip;

        // display values
        tip20EditText.setText(String.format("%.02f", twentyPercentTip));
        total20EditText.setText(String.format("%.02f", twentyPercentTotal));
        } // end updateStandard

// updates the custom tip and total EditTexts
private void updateCustom() {

        // position of the SeekBar
        customTipTextView.setText(currentCustomPercent + "%");

        // calculate the custom tip amount
        double customTipAmount = currentBillTotal * currentCustomPercent * 0.01;

        // calculate total bill+ custom tip
        double customTotalAmount = currentBillTotal + customTipAmount;

        // display : tip + total bill amounts
        tipCustomEditText.setText(String.format("%.02f", customTipAmount));
        totalCustomEditText.setText(String.format("%.02f", customTotalAmount));
        } //

// TextWatcher listener
private TextWatcher billEditTextWatcher = new TextWatcher() {

public void onTextChanged(CharSequence s, int start, int before,
        int count) {


         try {
        currentBillTotal = Double.parseDouble(s.toString());
        } // end try
        catch (NumberFormatException e) {
        currentBillTotal = 0.0; // default if an exception occurs
        }

        // עדכון טיפ רגיל ומותאם אישי
        updateStandard(); // update the 10, 15 and 20% EditTexts
        updateCustom(); // update the custom tip EditTexts

        }

public void beforeTextChanged(CharSequence s, int start, int count,
        int after) {

        }

public void afterTextChanged(Editable s) {

        }
        };

// ----SeekBar Listener
// when the user changes the position of SeekBar
private OnSeekBarChangeListener customSeekBarListener = new OnSeekBarChangeListener() {

public void onStopTrackingTouch(SeekBar seekBar) {
        }

public void onStartTrackingTouch(SeekBar seekBar) {

        }

public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
        // sets currentCustomPercent to the SeekBar position
        currentCustomPercent = seekBar.getProgress();// 18, 20,33
        // currentCustomPercent =
        // MyCalculatorActivity.this.customSeekBar.getProgress();

        // update EditTexts for custom tip and total
        updateCustom();

        }
        };

        }