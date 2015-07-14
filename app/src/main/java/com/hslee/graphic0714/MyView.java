/*
	사용자가 화면을 터치하면, MyView상의 터치한 좌표값을 구해서, 그 포인트에 원을 그려보자!
 */

package com.hslee.graphic0714;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyeshinlee on 15. 7. 14..
 */
public class MyView extends View {

	ArrayList<RectF> rectFs = new ArrayList<RectF>();
	List<Point> list = new ArrayList<Point>();
	float posX, posY, w=10, h=10;
	Paint paint, paint2;

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);

		paint = new Paint();
		paint.setColor(Color.MAGENTA);

	}

	public void setPos(float x, float y) {
		int width = (int)Math.random()*5 + 6;
		RectF rectF = new RectF(x, y, x+width, y+width);
		rectFs.add(rectF);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		//원을 그리자.
		//canvas.drawOval(posX,posY, posX+w,posY+h, null);  //API21부터 지원됨.
		//canvas.drawOval(new RectF(posX,posY, posX+w,posY+h), paint);

		for ( int i = 0; i < rectFs.size(); i++ ) {
			//canvas.drawOval(rectFs.get(i), paint);

			Point point = list.get(i);
			canvas.drawOval(new RectF(point.x,point.y, point.x+w,point.y+h), paint);
		}
	}
}
