package edu.pernat.racVpred;

import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyFirstAnimObject implements ApplicationListener, InputProcessor {
	 PerspectiveCamera camera;
	
     private static final int        FRAME_COLS = 6;         // #1
     private static final int        FRAME_ROWS = 5;         // #2
     
     Animation                       walkAnimation;          // #3
     Texture                         walkSheet;              // #4
     TextureRegion[]                 walkFrames;             // #5
     SpriteBatch                     spriteBatch;            // #6
     TextureRegion                   currentFrame;           // #7
     
     float stateTime;                                        // #8
    
    // @Override
     public void create() {
             walkSheet = new Texture(Gdx.files.internal("animation_sheet.png"));     // #9
             TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);                                // #10
             walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
             int index = 0;
             for (int i = 0; i < FRAME_ROWS; i++) {
                     for (int j = 0; j < FRAME_COLS; j++) {
                             walkFrames[index++] = tmp[i][j];
                     }
             }
             walkAnimation = new Animation(0.025f, walkFrames);              // #11
             spriteBatch = new SpriteBatch();                                // #12
             stateTime = 0f;                                                 // #13
     }

    // @Override
     public void render() {
             Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);                                            // #14
             stateTime += Gdx.graphics.getDeltaTime();                       // #15
             currentFrame = walkAnimation.getKeyFrame(stateTime, true);      // #16
             spriteBatch.begin();
             spriteBatch.draw(currentFrame, 50, 50);                         // #17
             spriteBatch.end();
     }

	
		  
		  
		  
		  public boolean keyDown(int keycode) {
		        if(keycode == Keys.BACK){

					
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
				    ;
//				    for (Mesh face : faces) {
//				      face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//				      
//				    }
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

		public void pause() {
			// TODO Auto-generated method stub
			
		}

		public void resize(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		public void resume() {
			// TODO Auto-generated method stub
			
		}







}
