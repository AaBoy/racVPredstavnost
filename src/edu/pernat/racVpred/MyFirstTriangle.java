package edu.pernat.racVpred;




import android.util.Log;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

/*
 * pomagal iz strani: http://code.google.com/p/libgdx/wiki/OrthographicCamera
 * http://code.google.com/p/libgdx/wiki/ProjectionViewportCamera
 * http://code.google.com/p/libgdx/wiki/OrthographicCamera
 * 
 * 
 * */
public class MyFirstTriangle  implements ApplicationListener {
	 private Mesh[] faces;
	  private PerspectiveCamera camera;
	 
	  Music music;
	  public void create() {
			music = Gdx.audio.newMusic(Gdx.files.internal("a_je_to1.mp3"));
			music.setLooping(true);
			music.setVolume(0.0001f);
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
		  }
		 
		  
		  public void resume() { }
		 
		  protected int lastTouchX;
		  protected int lastTouchY;

		  private boolean noter=false;
		  private float n=0.01f;
		  
		  public void render() {
  
			  
			  
		    if (Gdx.input.justTouched()) {
		    	
		      lastTouchX = Gdx.input.getX();
		      lastTouchY = Gdx.input.getY();
		    } else if (Gdx.input.isTouched()) {

		      
		    if((lastTouchX > 120 && lastTouchX<360) && lastTouchY<200)
		    {
		    	
//		    	camera.rotate(10, 0, -0.01f, 0);
		    	camera.translate(0, -0.01f, 0);
		    	camera.lookAt(0, 0, 0);
		    	   Log.e("Smer", "gor");
		    	//gor
		    }
		    else if((lastTouchX > 120 && lastTouchX<360) && (lastTouchY>600 && lastTouchY<800))
		    {
		    	
//		    	camera.rotate(10, 0, +0.01f, 0);
		    	camera.translate(0, +0.01f, 0);
		    	camera.lookAt(0, 0, 0);
		    	Log.e("Smer", "dol");
		    	//dol
		    }
		    else if((lastTouchX < 120) && (lastTouchY>200 && lastTouchY<600))
		    {
		    	
		    	//camera.rotate(10, -0.01f,0,  0);
		    	camera.translate(-0.01f, 0, 0);
		    	camera.lookAt(0, 0, 0);
		    	Log.e("Smer", "levo");
		    	//levo
		    }
		    else if((lastTouchX > 360 && lastTouchX<4800) && (lastTouchY>200 && lastTouchY<600))
		    {
		    	
		    	//camera.rotate(10, 0.01f,0,  0);
		    	camera.translate(0.01f, 0, 0);
		    	camera.lookAt(0, 0, 0);
		    	Log.e("Smer", "desno");
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
		    	camera.translate(0, 0, -0.01f);
		    	camera.lookAt(0f, 0f, 0.4f);
		    	if(camera.position.z<-0.4 && noter !=true)
		    	{
		    		noter=true;
		    		camera.lookAt(0f, 0f, 0.4f);
		    	}
		    	Log.e("Smer", "noter");
		    	//noter
		    } 
		      
		      lastTouchX = Gdx.input.getX();
		      
		      lastTouchY = Gdx.input.getY(); 
		    }
		 
		   
		    camera.update();
		    camera.apply(Gdx.gl10);
		 
		    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT| GL10.GL_DEPTH_BUFFER_BIT);
		 
		    for (Mesh face : faces) {
		      face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
		      
		    }
		    try {
		      Thread.sleep(6); // ~60FPS
		    } catch (InterruptedException e) {
		    }
		  }
		 
		  
		  public void resize(int width, int height) {
		    float aspectRatio = (float) width / (float) height;
		    camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
		    
		    camera.near = 0.1f;
		    camera.far=10f;
		    camera.position.x=0f;
			camera.position.y=0f;
			camera.position.z=2f;
		    camera.translate(0, 0, 0);
		    camera.update();
		  }
		 
		  
		  public void pause() { }
		 
		  
		  public void dispose() { }
	}
	
	