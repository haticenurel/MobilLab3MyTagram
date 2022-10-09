package com.example.hatice.mytagram;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PostActivity extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK)
                        {
                            Bundle bundle = result.getData().getExtras();
                            Bitmap bitmap = (Bitmap) bundle.get("data");
                            img.setImageBitmap(img);


            }
        }
    });

    img = (ImageView) findViewById(R.id.imageView);
    img.setOnClickListener (new OnClickListener()); {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            launcher.launch(intent);
            }

        });

    txtMsg = (EditText)findViewById(R.id.txtMessage);
    btnOk = (ImageButton) findViewById(R.id.btnOk);
    btnOk.setOnCLickListener (new View.OnClickListener())

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("msg", txtMsg.getText());
        bundle.putParcelable("bitmap", ((BitmapDrawable) img.getDrawable()).getBitmap());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    });
    btnCancel = (ImageButton) findViewById(R.id.btnCancel);
    btnCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
    });

}
}