package edu.pernat.racVpred;





import android.util.Log;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

/*
 * pomagal iz strani: http://code.google.com/p/libgdx/wiki/OrthographicCamera
 * http://code.google.com/p/libgdx/wiki/ProjectionViewportCamera
 * 
 * 
 * 
 * */
public class MyFirstTriangle  implements ApplicationListener, InputProcessor {
	 private Mesh[] faces;
	  private PerspectiveCamera camera;
	  private int stevec=0;
	  public final String NaslovGlasbe[]={"a_je_to.mp3","smb_overworld.mp3","family_guy_sound.mp3","craig_ferguson_short.mp3"};
	  Music music;
	  public void create() {
			music = Gdx.audio.newMusic(Gdx.files.internal(NaslovGlasbe[stevec]));
			music.setLooping(true);
			music.setVolume(0.05f);
			music.play();
			
		  
		  if (faces == null) {
		      faces = new Mesh[6];
		 
		      for (int i = 0; i < 6; i++) {
		        faces[i] = new Mesh(true, 4, 4,
		            new VertexAttribute(Usage.Position, 3, "a_position"),
		            new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
		 
		        faces[i].setIndices(new short[] { 0, 1, 2, 3 });
		      }
		 
		      faces[0].setVertices(new float[] {
		          0.2f, 0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255),
		          -0.2f, 0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255),
		          0.2f, -0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255),
		          -0.2f, -0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255) });
		 
		      faces[1].setVertices(new float[] {
		          0.2f, 0.2f, -0.2f, Color.toFloatBits(255, 0, 0, 255),
		          -0.2f, 0.2f, -0.2f, Color.toFloatBits(255, 0, 0, 255),
		          0.2f, -0.2f, -0.2f,  Color.toFloatBits(255, 0, 0, 255),
		          -0.2f, -0.2f, -0.2f, Color.toFloatBits(255, 0, 0, 255) });
		 
		      faces[2].setVertices(new float[] {
		          0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 255, 0, 255),
		          -0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 255, 0, 255),
		          0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 255, 0, 255),
		          -0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 255, 0, 255) });
		 
		      faces[3].setVertices(new float[] {
		          0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 96, 0, 255),
		          -0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 96, 0, 255),
		          0.2f, -0.2f, 0.2f, Color.toFloatBits(0, 96, 0, 255),
		          -0.2f, -0.2f, 0.2f,  Color.toFloatBits(0, 96, 0, 255) });
		 
		      faces[4].setVertices(new float[] {
		          0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 0, 255, 255),
		          0.2f, -0.2f, 0.2f, Color.toFloatBits(0, 0, 255, 255),
		          0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 0, 255, 255),
		          0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 0, 255, 255) });
		 
		      faces[5].setVertices(new float[] {
		          -0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 0, 96, 255),
		          -0.2f, -0.2f, 0.2f, Color.toFloatBits(0, 0, 96, 255),
		          -0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 0, 96, 255),
		          -0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 0, 96, 255) });
		    }
		 
		    Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
		    
		    
		    Gdx.input.setInputProcessor((InputProcessor) this);
	        Gdx.input.setCatchBackKey(true);
	        
	        

		  }
		 
		  
		  public void resume() { }
		 
		  protected int lastTouchX;
		  protected int lastTouchY;

		  private boolean noter=false;
		  private float n=0.01f;
		  
		  public void render() {
  
			  //camera.lookAt(0, 0, 0);
			  
		    if (Gdx.input.justTouched()) {
		    	
		      lastTouchX = Gdx.input.getX();
		      lastTouchY = Gdx.input.getY();
		    } else if (Gdx.input.isTouched()) {

		      
		    if((lastTouchX > 120 && lastTouchX<360) && lastTouchY<200)
		    {
		    	
		    	
		    	camera.translate(0, -0.1f, 0);
		    	//camera.rotate(10, 0, 0.01f, 0);
		    	camera.lookAt(0, 0, 0);   
		    	
		    	   Log.e("Smer", camera.position.toString());
		    	//gor
		    }
		    else if((lastTouchX > 120 && lastTouchX<360) && (lastTouchY>600 && lastTouchY<800))
		    {
//		    	camera.translate(0, +0.01f, 0);
//		    	camera.rotate(1, 0.1f, 0, 0);
		    	camera.translate(0, +0.1f, 0);
		    	camera.lookAt(0, 0, 0);
		    	Log.e("Smer", "dol");
		    	Log.e("Smer", camera.position.toString());
		    	//dol
		    }
		    else if((lastTouchX < 120) && (lastTouchY>200 && lastTouchY<600))
		    {
		    	
		    	//camera.rotate(5, -0.01f,0,  0);
//		    	camera.translate(-0.01f, 0, -0.01f);
		    	camera.translate(-0.1f, 0, 0f);
		    	camera.lookAt(0, 0, 0);
		    	
		         //camera.view.scale(0.5f, 0.5f, 0.5f);
		         //camera.rotate(0.025f, 0, 0, 1);

		         float x=0,y=0;
		         camera.rotate(0.25f,  1, y, x);
		         Log.e("Smer", camera.position.toString());
		        
		    	
		    	
		    	//levo
		    }
		    else if((lastTouchX > 360 && lastTouchX<4800) && (lastTouchY>200 && lastTouchY<600))
		    {
		    	
		    	//camera.rotate(10, 0.01f,0,  0);
		    	camera.translate(0.1f, 0, 0);
		    	camera.lookAt(0, 0, 0);
		    	Log.e("Smer", "desno");
		    	Log.e("Smer", camera.position.toString());
		    	//		    	n+=0.01f;
//		    	if(n>0.4f)
//		    	{
//		    		camera.lookAt(0f, 0f, 2f);
//		    		n=0;
//		    	}
		    	//deso
		    }
		    else if((lastTouchX > 120 && lastTouchX<360) && (lastTouchY>200 && lastTouchY<600))
		    {
		    	camera.translate(0, 0, -0.1f);
		    	camera.lookAt(0f, 0f, 0.0f);
		    	if(camera.position.z<-0.4 && noter !=true)
		    	{
		    		noter=true;
		    		camera.lookAt(0f, 0f, 0.4f);
		    	}
		    	Log.e("Smer", "noter");
		    	Log.e("Smer", camera.position.toString());
		    	//noter
		    }  
		    }
		 
		   
		    camera.update();
		    camera.apply(Gdx.gl10);
		 
		    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT| GL10.GL_DEPTH_BUFFER_BIT);
		    Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
		 
		    for (Mesh face : faces) {
		      face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
		      
		    }
		    try {
		      Thread.sleep(16); // ~60FPS
		    } catch (InterruptedException e) {
		    }
		  }
		 
		  
		  public void resize(int width, int height) {
		    float aspectRatio = (float) width / (float) height;
		    camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
		    
		    
		    camera.near = 1f;
		    camera.far=100f;
		    camera.position.x=0f;
			camera.position.y=0f;
			camera.position.z=1.5f;
		    //camera.translate(0, 0, 0);
		    camera.update();
		  }
		 
		  
		  public void pause() { }
		  
		  public boolean keyDown(int keycode) {
		        if(keycode == Keys.BACK){
		        	music.stop();
		        	music.dispose();
		        	if(stevec!=3)
		        	{
		        		stevec++;
		        	}else
		        		stevec=0;
		        	music = Gdx.audio.newMusic(Gdx.files.internal(NaslovGlasbe[stevec]));
					music.setLooping(true);
					music.setVolume(0.05f);
					music.play();
					
		        }
		        else if(keycode == Keys.SEARCH)
		        {
		        	
				    camera.position.x=0f;
					camera.position.y=0f;
					camera.position.z=1.5f;
//					camera.view.setToLookAt(new Vector3(new float[]{0,0,1.5F}),new Vector3( new float[]{0,0,0}),new Vector3(new float[]{0,1,0F}));
					camera.lookAt(0, 0, 0);
					camera.update();
				    camera.apply(Gdx.gl10);
				    Log.d("tukaj", "sem notri");
					 
				    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT| GL10.GL_DEPTH_BUFFER_BIT);
				    Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
				    noter=false;
				    for (Mesh face : faces) {
				      face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
				      
				    }
		        }
		        else if (keycode==Keys.MENU)
		        {
		        	camera.translate(0, 0, 0.1f);
			    	camera.lookAt(0f, 0f, 0.0f);
//			    	if(camera.position.z>0.4 && noter !=true)
//			    	{
//			    		noter=true;
//			    		camera.lookAt(0f, 0f,0f);
//			    		
//			    	}
			    	Log.e("Smer", "noter");
			    	Log.e("Smer", camera.position.toString());
			    	//noter
		        	
		        }
		        return false;
		   }

		  
		  public void dispose() { }


		public boolean keyTyped(char arg0) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean keyUp(int arg0) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean scrolled(int arg0) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean touchDragged(int arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean touchMoved(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			return false;
		}



	}
	
	