package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static String usernameKey = "username";

    public void clickFunction (View view){
        //Log.i("Info", "Button pressed");

        EditText myTextField = (EditText) findViewById(R.id.editText);

        String str = myTextField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("username", str).apply();

        goToActivity2(str);
    }

    public void goToActivity2(String s){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("message", s);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")){
            String userName = sharedPreferences.getString(usernameKey, "");
            goToActivity2(userName);
        } else {
            setContentView(R.layout.activity_main);
        }

    }
}