package edu.pernat.racVpred;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IzberiPogled extends Activity implements OnClickListener {

Button animacija, objekt;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	 setContentView(R.layout.glavni_layout);
	 animacija=(Button)findViewById(R.id.buttonAnimacija);
	 objekt=(Button)findViewById(R.id.buttonObjekt);
	 animacija.setOnClickListener(this);
	 objekt.setOnClickListener(this);
	}

public void onClick(View v) {
	// TODO Auto-generated method stub
	switch (v.getId()) {
	case R.id.buttonAnimacija:
		this.finish();
		Intent i = new Intent(this, MyFirstAnimObject.class);
		startActivity(i);
		break;

	case R.id.buttonObjekt:
		this.finish();
		Intent i1 = new Intent(this, MyFirstObject.class);
		startActivity(i1);
		break;
	default:
		break;
	}
}
}
