package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.hslee.graphic0714.R;

/**
 * Created by hyeshinlee on 15. 7. 14..
 */
public class GameView extends View {

	Bitmap ship;
	private int posX=100, posY=100;
	Paint paint;
	GameActivity activity;

	//조이스틱, 총알버튼의 크기
	RectF[] control = new RectF[5];
	int controlWidth=45, controlHeight=45, gap=5;

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);

		Matrix matrix = new Matrix();
		//matrix.setScale();

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
		//ship = Bitmap.createBitmap(bitmap, 0, 0, 128, 128);
		ship = Bitmap.createScaledBitmap(bitmap, 64, 64, false);

		paint = new Paint();
		paint.setColor(Color.BLUE);

		int startX=50, startY=250;
		control[0] = new RectF(startX,startY+controlHeight+gap, startX+controlWidth, startY+controlHeight+gap+controlHeight);    //left
		control[1] = new RectF(startX+controlWidth+gap,startY+controlHeight+gap, startX+controlWidth+gap+controlWidth, startY+controlHeight+gap+controlHeight);    //fire
		control[2] = new RectF(startX+(controlWidth+gap)*2,startY+controlHeight+gap, startX+(controlWidth+gap)*2+controlWidth, startY+controlHeight+gap+controlHeight);    //right
		control[3] = new RectF(startX+controlWidth+gap,startY, startX+controlWidth+gap+controlWidth, startY+controlHeight);    //up
		control[4] = new RectF(startX+controlWidth+gap,startY+(controlHeight+gap)*2, startX+controlWidth+gap+controlWidth, startY+(controlHeight+gap)*2+controlHeight);    //down

	}

	//조이스틱 그리기. layout으로 불가
	public void paintJoystick(Canvas canvas) {
		for (int i = 0; i < control.length; i++ ) {
			canvas.drawRect(control[i], paint);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawBitmap(ship, posX, posY, null);
		paintJoystick(canvas);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
