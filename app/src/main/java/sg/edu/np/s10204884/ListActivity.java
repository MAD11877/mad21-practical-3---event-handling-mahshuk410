package sg.edu.np.s10204884;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView icon = findViewById(R.id.androidIcon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //Intent in = new Intent(ListActivity.this,MainActivity.class);
               // startActivity(in);
                // Intent openDialog = getIntent();
               createDialog();
            }
        });

    }
    public void createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
        builder.setTitle("Profile");
        builder.setMessage("MADNess");
        builder.setCancelable(true);
        builder.setPositiveButton("View",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){
                Random rand = new Random();
                int num = 1000000001 + rand.nextInt(1000000000);

                Intent viewButton = new Intent(ListActivity.this,MainActivity.class);
                viewButton.putExtra("num",num);
                startActivity(viewButton);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}