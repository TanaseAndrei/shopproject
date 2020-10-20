$(window).scroll(function(){
    var scrollValue = $(this).scrollTop();
    console.log(scrollValue);
    $("#iphone").css("transform",'translate('+scrollValue/10+'%)','0px');
});