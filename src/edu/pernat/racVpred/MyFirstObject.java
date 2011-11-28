package edu.pernat.racVpred;

import android.app.Application;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g3d.loaders.ModelLoaderOld;


/*
 * http://www.androidadb.com/source/libgdx-read-only/tests/gdx-tests/src/com/badlogic/gdx/tests/ObjTest.java.html
 * http://people.sc.fsu.edu/~jburkardt/data/obj/obj.html
 * */
public class MyFirstObject  extends GdxTest implements  InputProcessor {
    PerspectiveCamera cam;
   
    Mesh mesh;
    Texture texture;
    float angleY = 0;
    float angleX = 0;
    float[] lightColor = {1, 0, 0, 1};
    float[] lightPosition = {2, 0, 0, 0};
    float touchStartX = 0;
    float touchStartY = 0;
    
     
    public void create () {

//    	texture = new Texture(Gdx.files.internal("data/map.png"), true);
//        texture.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
    	
        mesh = ModelLoaderOld.loadObj(Gdx.files.internal("cube.obj").read());
        Gdx.app.log("ObjTest", "obj bounds: " + mesh.calculateBoundingBox());
        
        
        cam = new PerspectiveCamera(45, 4, 4);
       
        cam.position.set(50, 35, 50);
        cam.direction.set(-1, -1, -1);
        cam.far=100f;
        Gdx.input.setInputProcessor(this);

        
    }
 
     
    public void render () {
        GL10 gl = Gdx.graphics.getGL10();
        //gl.glColor4f(1, 1 ,1, 1);//barva
        gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_COLOR_MATERIAL);
        gl.glEnable(GL10.GL_TEXTURE_2D);
 
        cam.update();
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glLoadMatrixf(cam.projection.val, 0);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadMatrixf(cam.view.val, 0);
 
        //nastavljaš kje sveti
        gl.glEnable(GL10.GL_LIGHT0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, lightColor, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPosition, 0);
 
        gl.glRotatef(angleY, 0, 1, 0);
        gl.glRotatef(angleX, 1, 0, 0);
//        texture.bind();
        mesh.render(GL10.GL_LINE_LOOP);//kako se izriše
        
//        mesh.render(GL10.GL_TRIANGLE_STRIP);

    }
 
     
    public boolean keyDown (int keycode) {
        return false;
    }
 
     
    public boolean keyTyped (char character) {
        return false;
    }
 
     
    public boolean keyUp (int keycode) {
        return false;
    }
 
     
    public boolean touchDown (int x, int y, int pointer, int newParam) {
        touchStartX = x;
        touchStartY = y;
        return false;
    }
 
     
    public boolean touchDragged (int x, int y, int pointer) {
        angleY += (x - touchStartX);
        angleX += (y - touchStartY);
        touchStartX = x;
        touchStartY = y;
        return false;
    }
 
     
    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }
 
     
    public boolean needsGL20 () {
        return false;
    }
 
     
    public boolean touchMoved (int x, int y) {
        return false;
    }
 
     
    public boolean scrolled (int amount) {
        return false;
    }


	public void dispose() {
		// TODO Auto-generated method stub
		
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
