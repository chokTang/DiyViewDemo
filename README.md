# DiyViewDemo
test demo 1.1

 
第一步 添加
整个项目的gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  第二步 在modle中gradle中添加依赖
  dependencies {
	        compile 'com.github.chokTang:DiyViewDemo:V1.0.1'
	}
	
	 
 第三步 在xml文件中BezierLine调用 画贝塞尔曲线
 app:b_start_x  起始点横坐标
 app:b_start_y  起始点纵坐标
 app:control_x  控制点横坐标
 app:control_y  控制点纵坐标
 app:end_x  结束点横坐标
 app:end_y  结束点纵坐标
