package com.hslee.graphic0714;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

	String TAG;

	ArrayList<Point> list = new ArrayList<Point>();

	MyView myView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TAG = this.getClass().getName();

		setContentView(R.layout.activity_main);
		myView = (MyView)findViewById(R.id.myView);
	}

	public void printOval(float x, float y) {

		//myView.posX = x;
		//myView.posY = y;
		myView.setPos(x, y);

		myView.invalidate();
	}

	public void printOval(List l) {

		myView.list = l;

		myView.invalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "터치했어?");

		//printOval(event.getX(), event.getY());

		Point point = new Point((int)event.getX(), (int)event.getY());
		list.add(point);
		printOval(list);

		return false;
	}
}
