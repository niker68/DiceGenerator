package com.example.dicegenerator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button31;
    Button button32;
    Button button33;
    Button button34;
    Button button35;
    Button buttonStart;
    Button buttonReset;
    TextView view0;
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;
    TextView view5;
    SharedPreferences mySettings;
    Handler handler;
    Button buttonminus;
    Button buttonplus;
    Dice dice0 = new Dice();
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    Dice dice3 = new Dice();
    Dice dice4 = new Dice();
    Dice dice5 = new Dice();

    Switch switch0;
    Boolean checkswitch0;
    Switch switch1;
    Boolean checkswitch1;
    Switch switch2;
    Boolean checkswitch2;
    Switch switch3;
    Boolean checkswitch3;
    Switch switch4;
    Boolean checkswitch4;
    Switch switch5;
    Boolean checkswitch5;
    Switch switch6;
    Boolean checkswitch6;
    int buttoncolor0;
    int buttoncolor1;
    int buttoncolor2;
    int buttoncolor3;
    int buttoncolor4;
    int buttoncolor5;



    //TextView textTimer;
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;

    int [] arr = new int[11];
    //int timer =60;
    int currentColor = 0;
    //boolean timerRun = false;
    TextView textTimer;
    Integer timer =120;
    Integer time = 120;
    boolean timerRun = false;
    Thread thread;

    //Звук
    MediaPlayer mPlayer;
    MediaPlayer mPlayerDice;
    MediaPlayer mPlayer10Sec;

    public String load (String str){
        return mySettings.getString(str,"Panic");
    }
    public void save (String key, String str){
        Editor editor = mySettings.edit();
        editor.putString(key,str);
        editor.commit();
    }

    public void PanicOnTheWallStreet(){
        save("packOfDices","Panic");
        dice0.setNumberOfSides(6);
        dice1.setNumberOfSides(6);
        dice2.setNumberOfSides(6);
        dice3.setNumberOfSides(6);
        String []listOfNumbers = new String[6];
        int []listOfColors = new int[6];
        //зеленый куб
        for(int i = 1;i<=6;i++){
            listOfColors[i-1]= arr[0];
        }
        listOfNumbers[0] = "0";
        listOfNumbers[1] = "0";
        listOfNumbers[2] = "-1";
        listOfNumbers[3] = "+1";
        listOfNumbers[4] = "-2";
        listOfNumbers[5] = "+2";
        dice1.setListOfNumbers(listOfNumbers);
        dice1.setListOfColors(listOfColors);

        //синий куб
        listOfNumbers = new String[6];
        listOfColors = new int[6];
        for(int i = 1;i<=6;i++){
            listOfColors[i-1]= arr[1];
        }
        listOfNumbers[0] = "0";
        listOfNumbers[1] = "-1";
        listOfNumbers[2] = "0";
        listOfNumbers[3] = "+1";
        listOfNumbers[4] = "-1";
        listOfNumbers[5] = "+1";
        dice0.setListOfNumbers(listOfNumbers);
        dice0.setListOfColors(listOfColors);

        //красный куб
        listOfNumbers = new String[6];
        listOfColors = new int[6];
        for(int i = 1;i<=6;i++){
            listOfColors[i-1]= arr[3];
        }
        listOfNumbers[0] = "+2";
        listOfNumbers[1] = "-2";
        listOfNumbers[2] = "+3";
        listOfNumbers[3] = "-3";
        listOfNumbers[4] = "+7";
        listOfNumbers[5] = "-7";
        dice3.setListOfNumbers(listOfNumbers);
        dice3.setListOfColors(listOfColors);

        //желтый куб
        listOfNumbers = new String[6];
        listOfColors = new int[6];
        for(int i = 1;i<=6;i++){
            listOfColors[i-1]= arr[2];
        }
        listOfNumbers[0] = "+1";
        listOfNumbers[1] = "-1";
        listOfNumbers[2] = "+2";
        listOfNumbers[3] = "-2";
        listOfNumbers[4] = "+3";
        listOfNumbers[5] = "-3";
        dice2.setListOfNumbers(listOfNumbers);
        dice2.setListOfColors(listOfColors);

        /*switch3.setChecked(false);
        switch4.setChecked(false);
        switch5.setChecked(false);*/
    }

    public void Catan(){
        save("packOfDices","Catan");
        String []listOfNumbers = new String[6];
        int []listOfColors = new int[6];
        for(int i = 1;i<=6;i++){
            listOfNumbers[i-1]=Integer.toString(i);
        }
        listOfColors[0]= arr[6];//белый
        listOfColors[1]= arr[6];//белый
        listOfColors[2]= arr[6];//белый
        listOfColors[3]= arr[6];//белый
        listOfColors[4]= arr[6];//белый
        listOfColors[5]= arr[6];//белый

        dice0.setNumberOfSides(6);
        dice1.setNumberOfSides(6);
        dice2.setNumberOfSides(6);
        dice0.setListOfNumbers(listOfNumbers);
        dice1.setListOfNumbers(listOfNumbers);
        dice0.setListOfColors(listOfColors);


        listOfColors = new int[6];
        listOfColors[0]= arr[3];//красный
        listOfColors[1]= arr[3];//красный
        listOfColors[2]= arr[3];//красный
        listOfColors[3]= arr[3];//красный
        listOfColors[4]= arr[3];//красный
        listOfColors[5]= arr[3];//красный

        dice1.setListOfColors(listOfColors);

        listOfNumbers = new String[6];
        listOfColors = new int[6];
        for(int i = 1;i<=6;i++){
            listOfNumbers[i-1]= "";
        }
        listOfColors[0]= arr[0];//зеленый
        listOfColors[1]= arr[1];//синий
        listOfColors[2]= arr[2];//желтый
        listOfColors[3]= arr[5];//черный
        listOfColors[4]= arr[5];//черный
        listOfColors[5]= arr[5];//черный
        dice2.setListOfNumbers(listOfNumbers);
        dice2.setListOfColors(listOfColors);
       /* switch3.setChecked(false);
        switch4.setChecked(false);
        switch5.setChecked(false);
*/
    }

    public void ThrowButton(){
        int resultOfThrow0 = dice0.ThrowDice();
        button0.setBackgroundColor(dice0.getColor(resultOfThrow0));
        buttoncolor0 = dice0.getColor(resultOfThrow0);
        button0.setText(dice0.getNumber(resultOfThrow0));
        int resultOfThrow1 = dice1.ThrowDice();
        button1.setBackgroundColor(dice1.getColor(resultOfThrow1));
        buttoncolor1 = dice1.getColor(resultOfThrow1);
        button1.setText(dice1.getNumber(resultOfThrow1));
        int resultOfThrow2 = dice2.ThrowDice();
        button2.setBackgroundColor(dice2.getColor(resultOfThrow2));
        buttoncolor2 = dice2.getColor(resultOfThrow2);
        button2.setText(dice2.getNumber(resultOfThrow2));
        int resultOfThrow3 = dice3.ThrowDice();
        button3.setBackgroundColor(dice3.getColor(resultOfThrow3));
        buttoncolor3 = dice3.getColor(resultOfThrow3);
        button3.setText(dice3.getNumber(resultOfThrow3));
        int resultOfThrow4 = dice4.ThrowDice();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySettings = PreferenceManager.getDefaultSharedPreferences(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //app ID

        /*
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3675146285571777~9686769595");
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {



            @Override
            public void onAdFailedToLoad(int error) {
                mAdView.setVisibility(View.GONE);
            }



            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }
        }); */
        /*try {
            getSupportActionBar().hide();
        }
        catch (Exception e){

        }*/
        //Звук
        mPlayer=MediaPlayer.create(this,R.raw.clock);
        mPlayerDice = MediaPlayer.create(this,R.raw.diceaudio);
        mPlayer10Sec= MediaPlayer.create(this,R.raw.sec10);

        textTimer=(TextView) findViewById(R.id.textTimer);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);



        button12 = (Button) findViewById(R.id.button12);



        button31 = (Button) findViewById(R.id.button31);
        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);
        button34 = (Button) findViewById(R.id.button34);
        button35 = (Button) findViewById(R.id.button35);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonplus = (Button) findViewById(R.id.buttonplus);
        buttonminus = (Button) findViewById(R.id.buttonminus);

        buttoncolor0=getResources().getColor(R.color.colorRED);
        buttoncolor1=getResources().getColor(R.color.colorBLUE);
        buttoncolor2=getResources().getColor(R.color.colorGREEN);
        buttoncolor3=getResources().getColor(R.color.colorYELLOW);
        buttoncolor4=getResources().getColor(R.color.colorPURPLE);
        buttoncolor5=getResources().getColor(R.color.colorBLACK);

        switch6 = (Switch) findViewById(R.id.switch6);
        checkswitch6 = switch6.isChecked();
        final Drawable color3= getResources().getDrawable(R.color.color3);
        final Drawable color1= getResources().getDrawable(R.color.color1);

        arr[0]=getResources().getColor(R.color.colorGREEN);
        arr[1]=getResources().getColor(R.color.colorBLUE);
        arr[2]=getResources().getColor(R.color.colorYELLOW);
        arr[3]=getResources().getColor(R.color.colorRED);
        arr[4]=getResources().getColor(R.color.colorPURPLE);
        arr[5]=getResources().getColor(R.color.colorBLACK);
        arr[6]=getResources().getColor(R.color.colorWHITE);
        arr[7]=getResources().getColor(R.color.colorBROWN);
        arr[8]=getResources().getColor(R.color.colorGRAY);
        arr[9]=getResources().getColor(R.color.colorPINK);
        arr[10]=getResources().getColor(R.color.colorORANGE);

        if (savedInstanceState==null){
            PanicOnTheWallStreet();
            button0.setBackgroundColor(dice0.getColor(0));
            button1.setBackgroundColor(dice1.getColor(0));
            button2.setBackgroundColor(dice2.getColor(0));
            button3.setBackgroundColor(dice3.getColor(0));


            buttoncolor0 = dice0.getColor(0);
            buttoncolor1 = dice1.getColor(0);
            buttoncolor2 = dice2.getColor(0);
            buttoncolor3 = dice3.getColor(0);

            button0.setText(dice0.getNumber(0));
            button1.setText(dice1.getNumber(0));
            button2.setText(dice2.getNumber(0));
            button3.setText(dice3.getNumber(0));


            button0.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);

        }else {
            if (load("packOfDices").equals("Catan")) {
                Catan();
                button0.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.INVISIBLE);


            } else {
                if (load("packOfDices").equals("Panic")) {
                    PanicOnTheWallStreet();
                    button0.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);

                }
            }
        }


        button31.setVisibility(View.INVISIBLE);
        button34.setVisibility(View.INVISIBLE);
        button35.setVisibility(View.INVISIBLE);
        System.out.println("Number = " + dice0.getNumberOfSides());

        switch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch6.isChecked()){
                    button32.setVisibility(View.VISIBLE);
                    buttonReset.setVisibility(View.VISIBLE);
                    buttonplus.setVisibility(View.VISIBLE);
                    buttonminus.setVisibility(View.VISIBLE);
                    button33.setVisibility(View.VISIBLE);
                }

                else {
                    button32.setVisibility(View.INVISIBLE);
                    buttonReset.setVisibility(View.INVISIBLE);
                    buttonplus.setVisibility(View.INVISIBLE);
                    buttonminus.setVisibility(View.INVISIBLE);
                    button33.setVisibility(View.INVISIBLE);
                }
            }

        });



        buttonplus.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                plus5sec(view);
                // the code to execute repeatedly
            }
        }));

        buttonminus.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                minus5sec(view);
                // the code to execute repeatedly
            }
        }));













        button12.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mPlayerDice.start();
                ThrowButton();
                button12.setEnabled(false);
                //спрятать ее
                buttonStart.setVisibility(View.GONE);
                buttonStart.setEnabled(false);
                //спрятать ее
                button12.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //чтоб она была снова доступна
                        button12.setEnabled(true);
                        //чтоб она отображалась
                        button12.setVisibility(View.VISIBLE);
                        buttonStart.setEnabled(true);
                        //чтоб она отображалась
                        buttonStart.setVisibility(View.VISIBLE);
                    }
                }, 3000);
            }
        }));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                textTimer.setText( text );
            }
        };




        button31.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter1--;

                view1.setText(String.valueOf(counter1));
                // the code to execute repeatedly
            }
        }));


        button32.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Catan();
                button0.setBackgroundColor(dice0.getColor(0));
                button1.setBackgroundColor(dice1.getColor(0));
                button2.setBackgroundColor(dice2.getColor(0));
                button3.setBackgroundColor(Color.TRANSPARENT);


                buttoncolor0 = dice0.getColor(0);
                buttoncolor1 = dice1.getColor(0);
                buttoncolor2 = dice2.getColor(0);


                button0.setText(dice0.getNumber(0));
                button1.setText(dice1.getNumber(0));
                button2.setText(dice2.getNumber(0));
                button3.setText("");

                button0.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.INVISIBLE);
                // the code to execute repeatedly
            }
        }));

        button33.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                PanicOnTheWallStreet();

                button0.setBackgroundColor(dice0.getColor(0));
                button1.setBackgroundColor(dice1.getColor(0));
                button2.setBackgroundColor(dice2.getColor(0));
                button3.setBackgroundColor(dice3.getColor(0));

                buttoncolor0 = dice0.getColor(0);
                buttoncolor1 = dice1.getColor(0);
                buttoncolor2 = dice2.getColor(0);
                buttoncolor3 = dice3.getColor(0);

                button0.setText(dice0.getNumber(0));
                button1.setText(dice1.getNumber(0));
                button2.setText(dice2.getNumber(0));
                button3.setText(dice3.getNumber(0));
                button0.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);

                // the code to execute repeatedly
            }
        }));


        button34.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter4--;

                view4.setText(String.valueOf(counter4));
                // the code to execute repeatedly
            }
        }));


        button35.setOnTouchListener(new RepeatListener(400, 100, new android.view.View.OnClickListener(){
            @Override
            public void onClick(View view) {
                counter5--;

                view5.setText(String.valueOf(counter5));
                // the code to execute repeatedly
            }
        }));


        //textTimer=(TextView)findViewById(R.id.textTimer);
        //textTimer.setText(timer);
        /*view0.setText(counter0);
        view1.setText(counter1);
        view2.setText(counter2);
        view3.setText(counter3);
        view4.setText(counter4);
        view5.setText(counter5);*/






    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.



        savedInstanceState.putInt("time", time);

        savedInstanceState.putInt("buttoncolor0", buttoncolor0);
        savedInstanceState.putInt("buttoncolor1", buttoncolor1);
        savedInstanceState.putInt("buttoncolor2", buttoncolor2);
        savedInstanceState.putInt("buttoncolor3", buttoncolor3);
        savedInstanceState.putInt("buttoncolor4", buttoncolor4);
        savedInstanceState.putInt("buttoncolor5", buttoncolor5);



        savedInstanceState.putString("buttontext0", button0.getText().toString());
        savedInstanceState.putString("buttontext1", button1.getText().toString());
        savedInstanceState.putString("buttontext2", button2.getText().toString());
        savedInstanceState.putString("buttontext3", button3.getText().toString());


        savedInstanceState.putInt("buttonvisible0", button0.getVisibility());
        savedInstanceState.putInt("buttonvisible1", button1.getVisibility());
        savedInstanceState.putInt("buttonvisible2", button2.getVisibility());
        savedInstanceState.putInt("buttonvisible3", button3.getVisibility());
        savedInstanceState.putInt("buttonstart", buttonStart.getVisibility());
        savedInstanceState.putBoolean("switch6",switch6.isChecked());

        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.



        time = savedInstanceState.getInt("time");

        buttoncolor0 = savedInstanceState.getInt("buttoncolor0");
        buttoncolor1 = savedInstanceState.getInt("buttoncolor1");
        buttoncolor2 = savedInstanceState.getInt("buttoncolor2");
        buttoncolor3 = savedInstanceState.getInt("buttoncolor3");
        buttoncolor4 = savedInstanceState.getInt("buttoncolor4");
        buttoncolor5 = savedInstanceState.getInt("buttoncolor5");


        switch6.setChecked(savedInstanceState.getBoolean("switch6"));


        textTimer.setText(String.valueOf(time));

        button0.setBackgroundColor(buttoncolor0);
        button1.setBackgroundColor(buttoncolor1);
        button2.setBackgroundColor(buttoncolor2);
        button3.setBackgroundColor(buttoncolor3);


        button0.setText(savedInstanceState.getString("buttontext0"));
        button1.setText(savedInstanceState.getString("buttontext1"));
        button2.setText(savedInstanceState.getString("buttontext2"));
        button3.setText(savedInstanceState.getString("buttontext3"));


        button0.setVisibility(savedInstanceState.getInt("buttonvisible0"));
        button1.setVisibility(savedInstanceState.getInt("buttonvisible1"));
        button2.setVisibility(savedInstanceState.getInt("buttonvisible2"));
        button3.setVisibility(savedInstanceState.getInt("buttonvisible3"));



        if (switch6.isChecked()){
            button32.setVisibility(View.VISIBLE);
            buttonReset.setVisibility(View.VISIBLE);
            buttonplus.setVisibility(View.VISIBLE);
            buttonminus.setVisibility(View.VISIBLE);
            button33.setVisibility(View.VISIBLE);
        }

        else {
            button32.setVisibility(View.INVISIBLE);
            buttonReset.setVisibility(View.INVISIBLE);
            buttonplus.setVisibility(View.INVISIBLE);
            buttonminus.setVisibility(View.INVISIBLE);
            button33.setVisibility(View.INVISIBLE);
        }
    }


    public void changeColor0minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button0.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button0.setBackgroundColor((arr[currentColor-1]));
            buttoncolor0=arr[currentColor-1];
        }
        else {
            button0.setBackgroundColor(arr[10]);
            buttoncolor0=arr[10];
            currentColor=10;

        }
    }

    public void changeColor1minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button1.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button1.setBackgroundColor((arr[currentColor-1]));
            buttoncolor1=arr[currentColor-1];
        }
        else {
            button1.setBackgroundColor(arr[10]);
            buttoncolor1=arr[10];
            currentColor=10;

        }
    }

    public void changeColor2minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button2.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button2.setBackgroundColor((arr[currentColor-1]));
            buttoncolor2=arr[currentColor-1];
        }
        else {
            button2.setBackgroundColor(arr[10]);
            buttoncolor2=arr[10];
            currentColor=10;

        }
    }

    public void changeColor3minus(){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button3.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=0) {
            button3.setBackgroundColor((arr[currentColor-1]));
            buttoncolor3=arr[currentColor-1];
        }
        else {
            button3.setBackgroundColor(arr[10]);
            buttoncolor3=arr[10];
            currentColor=10;

        }
    }

    public void changeColor0 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button0.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button0.setBackgroundColor((arr[currentColor+1]));
            buttoncolor0=arr[currentColor+1];
        }
        else {
            button0.setBackgroundColor(arr[0]);
            buttoncolor0=arr[0];
            currentColor=0;

        }
    }
    public void changeColor1 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button1.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            buttoncolor1=arr[currentColor+1];
            button1.setBackgroundColor((arr[currentColor+1]));

        }
        else {
            button1.setBackgroundColor(arr[0]);
            buttoncolor1=arr[0];
            currentColor=0;

        }
    }
    public void changeColor2 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button2.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button2.setBackgroundColor((arr[currentColor+1]));
            buttoncolor2=arr[currentColor+1];

        }
        else {
            button2.setBackgroundColor(arr[0]);
            currentColor=0;
            buttoncolor2=arr[0];

        }
    }
    public void changeColor3 (View view){
        for (int i = 0;i<11;i++) {
            if (((ColorDrawable)button3.getBackground()).getColor() == (arr[i])){
                currentColor=i;
                String str = " currentColor = "+currentColor;

            }
        }
        if (currentColor!=10) {
            button3.setBackgroundColor((arr[currentColor+1]));
            buttoncolor3=arr[currentColor+1];

        }
        else {
            button3.setBackgroundColor(arr[0]);
            buttoncolor3=arr[0];
            currentColor=0;

        }
    }

    public void plus0 (View view){
        counter0++;

        view0.setText(String.valueOf(counter0));
    }
    public void minus0 (View view){
        counter0--;

        view0.setText(String.valueOf(counter0));
    }
    public void plus1 (View view){
        counter1++;

        view1.setText(String.valueOf(counter1));
    }
    public void minus1 (View view){
        counter1--;

        view1.setText(String.valueOf(counter1));
    }
    public void plus2 (View view){
        counter2++;

        view2.setText(String.valueOf(counter2));
    }
    public void minus2 (View view){
        counter2--;

        view2.setText(String.valueOf(counter2));
    }
    public void plus3 (View view){
        counter3++;

        view3.setText(String.valueOf(counter3));
    }
    public void minus3 (View view){
        counter3--;

        view3.setText(String.valueOf(counter3));
    }
    public void plus4 (View view){
        counter4++;

        view4.setText(String.valueOf(counter4));
    }
    public void minus4 (View view){
        counter4--;

        view4.setText(String.valueOf(counter4));
    }
    public void plus5 (View view){
        counter5++;

        view5.setText(String.valueOf(counter5));
    }
    public void minus5 (View view){
        counter5--;

        view5.setText(String.valueOf(counter5));
    }
    public void startTimer (View view){
        if (!timerRun) {
            thread = new Thread(new timerForCounter());
            thread.start();
        }
    }
    public void resetTimer (View view){
        timerRun = false;
        timer = time;
        mPlayer.pause();
        mPlayerDice.pause();
        mPlayer10Sec.pause();
        //textTimer.setText(String.valueOf(timer));
        Message msg2 = new Message();
        msg2.obj = timer.toString();
        handler.sendMessage(msg2);
    }
    public void plus5sec (View view){
        time = time +5;
        Message msg4 = new Message();
        msg4.obj = time.toString();
        handler.sendMessage(msg4);
    }
    public void minus5sec (View view){
        time = time -5;
        Message msg5 = new Message();
        msg5.obj = time.toString();
        handler.sendMessage(msg5);
    }
    /*class BlockOfButton12 implements  Runnable{
        public void run(){
            button12.setEnabled(false);
            try {
                Thread.sleep(1000);  // пауза на 10 секунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            button12.setEnabled(true);
        }
    }*/
    class timerForCounter implements Runnable {

        public void run() {
                try {
                    Thread.sleep(100);
                    timer = time;
                    timerRun = true;
                    Message msg = new Message();
                    msg.obj = timer.toString();
                    handler.sendMessage(msg);

                    //textTimer.setText(timer);

                    while (timerRun) {
                        if(timer == 11){
                            mPlayer10Sec.start();
                        }
                        if (timer == 0) {
                            mPlayer10Sec.pause();
                            mPlayer.start();
                            Thread.sleep(2500);
                            mPlayer.start();

                            timerRun = false;
                            timer=time;
                            Message msg1 = new Message();
                            msg1.obj = timer.toString();
                            handler.sendMessage(msg1);
                            Thread.sleep(100);
                            break;
                        }
                        timer--;

                        Message msg1 = new Message();
                        msg1.obj = timer.toString();
                        handler.sendMessage(msg1);
                        //textTimer.setText(timer);

                        Thread.sleep(1000);
                        //TimeUnit.SECONDS.sleep(1);
                    }
                }

            catch(Exception e){
                textTimer.setText("Error");
            }

        }
    }
}

