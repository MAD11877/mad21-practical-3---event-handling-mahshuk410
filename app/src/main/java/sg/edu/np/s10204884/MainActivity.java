package sg.edu.np.s10204884;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Replace Heading with Intent int
        Intent recievedInfo = getIntent();
        int num = recievedInfo.getIntExtra("num",1000000000);
        TextView heading = findViewById(R.id.textView3);
        heading.setText("MAD"+num); //concatenation


        Button followButton = findViewById(R.id.FollowButton);


       followButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               User u = new User();
               String toastText = "";
               if (followButton.getText().toString().compareTo("FOLLOW") == 0) {

                   u.Followed = true;
                   followButton.setText("Unfollow");
                   System.out.println(u.Followed);
                   showToast("Followed");
               }
               else{
                   u.Followed = false;
                   followButton.setText("FOLLOW");
                   System.out.println(u.Followed);
                    showToast("Unfollowed");
               }

           }
       });
        /*TextView txt  = (TextView) findViewById(R.id.loremText);
        txt.setText("HELLO SIR");
        Log.d("debug","Create");*/
    }
    public void showToast(String toastText){
        //generate Toast notification first
        Toast toast = Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_SHORT);
        toast.show();

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug","Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug","Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug","Destroy");
    }

    @Override
    protected void onPause() {
        Log.d("debug","Pause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug","Resume");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug","restart"); //print command to android
    }


}