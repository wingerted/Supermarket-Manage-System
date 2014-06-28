
Do(function(){
  (function(b){var e=document;var a=[];var d=function(h,f,j,p,g){var q=g.createElement("form");var l,r,m,o;var n=function(i,s){var k=g.createElement("input");k.type="hidden";k.name=i;k.value=s;return k};q.target=p;q.action=h;q.method=f;for(l in j){if(j.hasOwnProperty(l)){r=j[l];if(typeof r==="object"&&Object.prototype.toString.call(r).search(/array/i)){m=r.length;while(m--){o=n(l,r[m]);q.appendChild(o)}}o=n(l,r);q.appendChild(o)}}return q};var c=function(){a.push(0);return"_xpost_iframe_"+a.length};b.xPost=function(h,j){var k=c();var i;var g;var f;if("ActiveXObject" in window){f=new ActiveXObject("htmlfile");f.open();f.write('<html><body><iframe id="xpost-proxy-iframe'+k+'"></iframe></body></html>');f.close();g=f.getElementById("xpost-proxy-iframe"+k);g.contentWindow.name=k;i=d(h,"post",j,k,f);f.body.appendChild(i);f=f.body}else{g=e.createElement("iframe");g.width=0;g.name=k;g.height=0;g.style.position="absolute";g.style.visibility="hidden";g.src="javascript:false;";f=e.body;f.appendChild(g);i=d(h,"post",j,k,e);f.appendChild(i)}g.onload=function(){};i.submit()}})(jQuery);var popup;var nav=$("#db-global-nav");var more=nav.find(".bn-more");nav.delegate(".bn-more, .top-nav-reminder .lnk-remind","click",function(f){f.preventDefault();var c=$(this);var d=c.parent();if(popup){popup.parent().removeClass("more-active");if($.contains(d[0],popup[0])){popup=null;return false}}d.addClass("more-active");popup=d.find(".more-items");if(c.hasClass("lnk-remind")&&noti_ids.num){var a=nav.find(".top-nav-reminder .num");var b=(a.find("span").text()|0)-noti_ids.num;b=b<=0?0:b;if(b===0){a.hide()}else{a.find("span").text(b)}noti_ids.num=0;$.xPost(noti_api,$.extend({ck:get_cookie("ck")},noti_ids))}return false});$(document).click(function(a){if($(a.target).closest(".more-items").length){return}if(popup){popup.parent().removeClass("more-active");popup=null}});
});

Do(function(){
  var nav = $('#db-nav-book');
  var inp=$("#inp-query"),label=inp.closest(".nav-search").find("label");if(inp.val()!==""){label.hide()}inp.parent().click(function(){inp.focus();label.hide()}).end().focusin(function(){label.hide()}).focusout(function(){if($.trim(this.value)===""){label.show()}else{label.hide()}}).keydown(function(){label.hide()});nav.find(".lnk-more, .lnk-account").click(function(b){b.preventDefault();var d,a=$(this),c=a.hasClass("lnk-more")?$("#db-productions"):$("#db-usr-setting");if(!c.data("init")){d=a.offset();c.css({"margin-left":(d.left-$(window).width()/2-c.width()+a.width()+parseInt(a.css("padding-right"),10))+"px",left:"50%",top:d.top+a.height()+"px"});c.data("init",1);c.hide();$("body").click(function(g){var f=$(g.target);if(f.hasClass("lnk-more")||f.hasClass("lnk-account")||f.closest("#db-usr-setting").length||f.closest("#db-productions").length){return}c.hide()})}if(c.css("display")==="none"){$(".dropdown").hide();c.show()}else{$(".dropdown").hide()}});
});

    var staticUrl = {
      'widget/suggest': 'http://img3.douban.com/js/book/widget/packed_suggest5156392335.js'
    , 'mod/template' :'http://img3.douban.com/js/book/mod/packed_template3692681558.js'
    }

    if(!Do.ready){
      (function(b){var a=function(c,d){b.getScript(c.shift(),function(){if(c.length){a(c,d)}else{d()}})};b.getScripts=a})(jQuery);

      $.getScripts([staticUrl['widget/suggest']
        , staticUrl['mod/template']], function(){
        var navSearchForm=$(".nav-srh form[name=ssform]");if(!navSearchForm.length){var navSearchForm=$(".nav-search form")}var navSearch=navSearchForm.find("input[name=search_text]");navSearch.searchSuggest({preventSearch:function(a){if(a===""||a==="书名、作者、ISBN"){return true}return false},parse:function(b){if(b.r&&b.r===1){return null}var a=b.suggests;if(!a.length){return null}if(a.length>8){return a.slice(0,8)}return a},tmplEngine:_.template,tmplPanel:'<ul id="nav-srh-suggest"></ul>',tmplItem:$("#suggest-item").html(),url:"/j/suggest_text",form:navSearchForm,queryArg:"q"});
      })
    }else{
      Do.add('widget/suggest', {
        path: staticUrl['widget/suggest']
      , type: 'js'
      })
      Do.add('mod/template', {
        path: staticUrl['mod/template']
      , type: 'js'
      })
      Do.ready('widget/suggest', 'mod/template', function(){
        var navSearchForm=$(".nav-srh form[name=ssform]");if(!navSearchForm.length){var navSearchForm=$(".nav-search form")}var navSearch=navSearchForm.find("input[name=search_text]");navSearch.searchSuggest({preventSearch:function(a){if(a===""||a==="书名、作者、ISBN"){return true}return false},parse:function(b){if(b.r&&b.r===1){return null}var a=b.suggests;if(!a.length){return null}if(a.length>8){return a.slice(0,8)}return a},tmplEngine:_.template,tmplPanel:'<ul id="nav-srh-suggest"></ul>',tmplItem:$("#suggest-item").html(),url:"/j/suggest_text",form:navSearchForm,queryArg:"q"});
      })
    }
  
    var Book = window.Book || {}
    Book.pageLength = 15
    Do("mod/ga",function(){var l=Book.ga,e=Book.pageLength,m=window.location.search,a=0,h="",i=0,k=/start=(\d+)/g,c=/search_text=(.*?)(?=&|#|$)/g,b="search",d="";if(!m){return}d=k.exec(m);if(d&&d[1]){a=+d[1]}d=c.exec(m);if(d&&d[1]){h=decodeURIComponent(d[1])}i=a/e+1;l.trackEvent(b,"page",h,i);var g=$(".article"),f=g.find(".item");if(!f.length){if(i===1){l.trackEvent(b,"noResult",h)}return}var j=function(p){var o=$(p.delegateTarget),n=o.data("index");l.trackEvent(b,"click",h,n+a)};f.each(function(n,p){var o=$(p);o.data("index",n+1).on("click",".nbg",j).on("click",".pl2 a",j)})});
  