$(function() {


  f_indexWriteAnchorBtn();
  f_index_tdBgwhite();


  function f_indexWriteAnchorBtn() {
    var toggleAbtn = $('#writeAnchorBtn');   
    toggleAbtn.hide();
    $(window).scroll(function() {
        if ($(this).scrollTop() > 50) {
            toggleAbtn.fadeIn();
        } else {
            toggleAbtn.fadeOut();
        }
    });
  }
  
  
  function f_index_tdBgwhite() {
    if(location.pathname == "/jamyto2/index.jsp") {
      $(".bgwhiteNo1").each(function() {
        if ($(this).text() == "") {
          $(this).removeClass("bg-white");
        }
      });
      $(".bgwhiteNo2").each(function() {
        if ($(this).text() == "") {
          $(this).removeClass("bg-white");
        }
      });
    }    
  }


});