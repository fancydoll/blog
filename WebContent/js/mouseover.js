$(document).ready(function(){
	$('.top-nav li').mouseover(function(){
		$(this).find('.sub-nav').slideDown('fast').show();
		$(this).hover(function(){
		},function(){
			$(this).find('.sub-nav').slideUp('slow');
		});
	});
});

