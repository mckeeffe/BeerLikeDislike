package com.eugene.beerlikedislike;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends Activity {

	final Context context = this;
	private ImageButton button_view;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button_view = (ImageButton) findViewById(R.id.View_Liked_Button);
        
        /** Start of Animation Code **/
        ImageView myImage = (ImageView) findViewById(R.id.image_header);
        Animation anim = new AlphaAnimation(0.0f, 2.0f);
        anim.setDuration(400); // You can manage the blinking time with this parameter
        anim.setStartOffset(50);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myImage.startAnimation(anim);
        /** End of Animation Code **/
         
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        
        
		// add button listener
		button_view.setOnClickListener(new OnClickListener() {
 
		  @Override
		  public void onClick(View arg0) {
 
			// custom dialog
			final Dialog dialog = new Dialog(context);
			dialog.setContentView(R.layout.custom_dialog_list_images);
			dialog.setTitle(Html.fromHtml("<font color='#9933ff'><b>List of BEERS you liked.</b></font>"));
			dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background_color);
 
			// set the custom dialog components for - image 
			ImageView image_1 = (ImageView) dialog.findViewById(R.id.image_1);
			image_1.setImageResource(R.drawable.ace);
			ImageView image_2 = (ImageView) dialog.findViewById(R.id.image_2);
			image_2.setImageResource(R.drawable.bulmers);
			ImageView image_3 = (ImageView) dialog.findViewById(R.id.image_3);
			image_3.setImageResource(R.drawable.carlsberg);
			ImageView image_4 = (ImageView) dialog.findViewById(R.id.image_4);
			image_4.setImageResource(R.drawable.chatoe_rogue);
			ImageView image_5 = (ImageView) dialog.findViewById(R.id.image_5);
			image_5.setImageResource(R.drawable.cider);
			ImageView image_6 = (ImageView) dialog.findViewById(R.id.image_6);
			image_6.setImageResource(R.drawable.dungarvan);
			ImageView image_7 = (ImageView) dialog.findViewById(R.id.image_7);
			image_7.setImageResource(R.drawable.guinness);
			ImageView image_8 = (ImageView) dialog.findViewById(R.id.image_8);
			image_8.setImageResource(R.drawable.hilden);
			ImageView image_9 = (ImageView) dialog.findViewById(R.id.image_9);
			image_9.setImageResource(R.drawable.rekorderlig);
			ImageView image_10 = (ImageView) dialog.findViewById(R.id.image_10);
			image_10.setImageResource(R.drawable.tin_man);
			// set the custom dialog components for - button
			Button dialogButton = (Button) dialog.findViewById(R.id.dialog_button_ok);
			
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.cancel();
				}
			});
 
			dialog.show();
		  }
		});
    }
		
	  private class ImagePagerAdapter extends PagerAdapter {
		    private int[] mImages = new int[] {
		        R.drawable.ace,
		        R.drawable.bulmers,
		        R.drawable.carlsberg,
		        R.drawable.chatoe_rogue,
		        R.drawable.cider,
		        R.drawable.dungarvan,
		        R.drawable.guinness,
		        R.drawable.hilden,
		        R.drawable.rekorderlig,
		        R.drawable.tin_man
		    };
		    
		    @Override
		    public int getCount() {
		      return mImages.length;
		    }

		    @Override
		    public boolean isViewFromObject(View view, Object object) {
		      return view == ((ImageView) object);
		    }
		    
		    @Override
		    public Object instantiateItem(ViewGroup container, int position) {
		      Context context = MainActivity.this;
		      ImageView imageView = new ImageView(context);
		      int padding = context.getResources().getDimensionPixelSize(
		          R.dimen.padding_small);
		      imageView.setPadding(padding, padding, padding, padding);
		      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		      imageView.setImageResource(mImages[position]);
		      ((ViewPager) container).addView(imageView, 0);
		      return imageView;
		    }
		    
		    
		    @Override
		    public void destroyItem(ViewGroup container, int position, Object object) {
		      ((ViewPager) container).removeView((ImageView) object);
		    }
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

