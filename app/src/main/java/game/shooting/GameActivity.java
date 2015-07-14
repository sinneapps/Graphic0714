package game.shooting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.hslee.graphic0714.R;

/**
 * Created by hyeshinlee on 15. 7. 14..
 */
public class GameActivity extends Activity {

	GameView gameView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game);
		gameView = (GameView)findViewById(R.id.gameView);
	}

	//우주선을 날리자! Bitmap의 x축을 변경후 invaliate()호출
	public void moveShip() {
		int x = gameView.getPosX();
		x+=20;
		gameView.setPosX(x);
		gameView.invalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		moveShip();

		return super.onTouchEvent(event);
	}
}
