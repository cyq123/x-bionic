package com.imcore.xbionic.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class VirtivalProgres extends ProgressBar{
	

		public VirtivalProgres(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
		}

		public VirtivalProgres(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}

		public VirtivalProgres(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		//
		@Override
		protected synchronized void onDraw(Canvas canvas) {
			canvas.rotate(-90);// 反转90度
			canvas.translate(-getHeight()+10, 70);// 移动到正确位置
			super.onDraw(canvas);
		}

		@Override
		protected synchronized void onMeasure(int widthMeasureSpec,
				int heightMeasureSpec) {
			// 互换宽高值
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}

		@Override
		protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			// 互换宽高值
			super.onSizeChanged(w, h, oldw, oldh);
		}

	
}
