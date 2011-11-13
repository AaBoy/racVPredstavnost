package edu.pernat.racVpred;
import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Vector3;
/*
 * pomagal iz strani: http://code.google.com/p/libgdx/wiki/OrthographicCamera
 * http://code.google.com/p/libgdx/wiki/ProjectionViewportCamera
 * http://code.google.com/p/libgdx/wiki/OrthographicCamera
 * 
 * 
 * */

public class LikOrtigonalno implements ApplicationListener {
	

	
	 private Mesh[] faces;
	  private OrthographicCamera camera;
	 
	  
	  public void create() {
		  //camera = new PerspectiveCamera(60, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		  
		  if (faces == null) {
	      faces = new Mesh[6];
	 
	      for (int i = 0; i < 6; i++) {
	        faces[i] = new Mesh(true, 4, 4,
	            new VertexAttribute(Usage.Position, 3, "a_position"),
	            new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
	 
	        faces[i].setIndices(new short[] { 0, 1, 2, 3 });
	      }
	 
	      faces[0].setVertices(new float[] {
	              0.2f, 0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255),//zgoraj desno
	              -0.2f, 0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255),//zgoraj levo
	              0.2f, -0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255),//spodaj desno
	              -0.2f, -0.2f, 0.2f, Color.toFloatBits(96, 0, 0, 255) });//temno rdeča // spodaj levo
	     
	          faces[1].setVertices(new float[] {
	              0.2f, 0.2f, -0.2f, Color.toFloatBits(255, 0, 0, 255),
	              -0.2f, 0.2f, -0.2f, Color.toFloatBits(255, 0, 0, 255),
	              0.2f, -0.2f, -0.2f,  Color.toFloatBits(255, 0, 0, 255),
	              -0.2f, -0.2f, -0.2f, Color.toFloatBits(255, 0, 0, 255) });//svetlo rdeča
	     
	          faces[2].setVertices(new float[] {
	              0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 255, 0, 255),
	              -0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 255, 0, 255),
	              0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 255, 0, 255),
	              -0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 255, 0, 255) });// svetlo zelena
	     
	          
	          faces[3].setVertices(new float[] {
	              0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 96, 0, 255),
	              -0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 96, 0, 255),
	              0.2f, -0.2f, 0.2f, Color.toFloatBits(0, 96, 0, 255),
	              -0.2f, -0.2f, 0.2f,  Color.toFloatBits(0, 96, 0, 255) });//temno zelena
	     
	          faces[4].setVertices(new float[] {
	              0.2f, 0.2f, 0.2f, Color.toFloatBits(0, 0, 255, 255),
	              0.2f, -0.2f, 0.2f, Color.toFloatBits(0, 0, 255, 255),//spodaj levo
	              0.2f, 0.2f, -0.2f, Color.toFloatBits(0, 0, 255, 255),
	              0.2f, -0.2f, -0.2f, Color.toFloatBits(0, 0, 255, 255) });//svetlo modra - spodaj desno
	     
	          faces[5].setVertices(new float[] {
	              -0.2f, 0.2f, 0.2f, Color.toFloatBits(110,67,148, 255),
	              -0.2f, -0.2f, 0.2f, Color.toFloatBits(0, 0, 96, 255),//spodaj levo
	              -0.2f, 0.2f, -0.2f, Color.toFloatBits(110,67,148, 255),
	              -0.2f, -0.2f, -0.2f, Color.toFloatBits(110,67,148, 255) }); // temno modra - spodaj desno
	        }
	 
	    Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
	    camera = new OrthographicCamera(3f, 4.2f);
	    camera.position.set(-0.4f, -0.4f, 1);
	    camera.zoom+=0.1f;
	  }
	 
	  
	  public void resume() { }
	 
	   int lastTouchX;
	   int lastTouchY;


	   private void handleInput() {
          
                   camera.zoom += 0.02;
           }
	   
	   
	  public void render() {
		  

		  if (Gdx.input.justTouched()) {
		      lastTouchX = Gdx.input.getX();
		      lastTouchY = Gdx.input.getY();
		    } else if (Gdx.input.isTouched()) {
		    	
		      camera.rotate(0.2f * (lastTouchX - Gdx.input.getX()), 0, 1.0f, 0);
		      camera.rotate(0.2f * (lastTouchY - Gdx.input.getY()), 1.0f, 0, 0);
		      lastTouchX = Gdx.input.getX();
		      lastTouchY = Gdx.input.getY();
		      
		    }

		    
		 
		    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		    camera.update();
		    camera.apply(Gdx.gl10);
		 
		    for (Mesh face : faces) {
		      face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
		    }
		 
		    try {
		      Thread.sleep(16); // ~60FPS
		    } catch (InterruptedException e) {
		    }
	  }
	   
	  public void resize(int width, int height) {
	    /*float aspectRatio = (float) width / (float) height;
	    camera = new OrthographicCamera(5, 2f * aspectRatio, 2f);
	    camera.near=0.01f;
	    camera.far=10f;
	    camera.lookAt(0, 0, 0);*/
	  }
	 
	   
	  public void pause() { }
	 
	   
	  public void dispose() { }
	}
	