package com.nguyenlv.avoidticket;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity 
{
	private RadioGroup rgPermitTypeGroup;
	private RadioButton rbPermitTypeButton;
	private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListenerOnButton();
    }


    private void addListenerOnButton() 
    {
		//logic for button Next
		rgPermitTypeGroup = (RadioGroup) findViewById(R.id.rgPermitType);
		btnNext = (Button) findViewById(R.id.btnNext);
		
		btnNext.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				//get radio button id
				int selectedId = rgPermitTypeGroup.getCheckedRadioButtonId();
				rbPermitTypeButton = (RadioButton) findViewById(selectedId);
				
				if(selectedId == -1)
				{
					Toast.makeText(MainActivity.this, "Please select a permit type", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(MainActivity.this,
							"Your permit type is " + rbPermitTypeButton.getText(), Toast.LENGTH_SHORT).show();	
					
					Intent myIntent = new Intent(MainActivity.this, MapActivity.class);
					startActivityForResult(myIntent, 0);
				}
			}
		});
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
