$(function(){
	var slider = $('#scrollPics .slider');
	var imgCon = $('#scrollPics .slider li'); //获取图片
	imgCon.not(imgCon.eq(0)).hide(); //除第一张外其他隐藏
	var len = slider.find('li').length;
	var index = 0; 
	function showPic(index){
		imgCon.eq(index).show().siblings('li').hide();
	}
	$('#scrollPics').hover(function(){
		clearInterval(window.timer);
	},function(){
		window.timer = setInterval(function(){
			showPic(index);
			index ++;
			if(index === len){
				index = 0;
			}
		},1000);
	}).trigger('mouseover');   //触发被选元素的指定事件
	//trigger()方法触发被选元素的指定事件类型
})
