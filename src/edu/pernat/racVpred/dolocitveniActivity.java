package edu.pernat.racVpred;


import com.badlogic.gdx.backends.android.AndroidApplication;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dolocitveniActivity extends Activity  {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.glavni_layout);
	        
	        
	        final Button button = (Button) findViewById(R.id.button1);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                switch (v.getId())        
	                {
	                    case R.id.button1:
	                    {
	                    	// Toast.makeText(dolocitveniActivity.this,"Je internet",Toast.LENGTH_LONG).show();
//	                    	Intent moj=new Intent(this, MainActivity.class);
//	            			this.startActivity(moj);
	                        break;
	                    }
	                }
	            }
	        });


	        
	    }

	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
		if(which==R.id.button1)
		{
			Intent moj=new Intent(this, MainActivity.class);
			this.startActivity(moj);
		}
		else if(which==R.id.button2)
		{
			
		}
		
	}
	
	

}
