package edu.pernat.racVpred;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class glasba implements ApplicationListener {

	Music music;
	
	public void create() {
		music = Gdx.audio.newMusic(Gdx.files.internal("data/a_je_to.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		music.play();
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void pause() {
		// TODO Auto-generated method stub
		
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}

	
}
