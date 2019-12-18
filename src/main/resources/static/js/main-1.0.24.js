Simple.Module({name:"jkbd:router/context",require:[]},function(e,t,a,k){var g={jxedt:{key:"jxedt",tagId:6,tagName:"\u9a7e\u6821\u4e00\u70b9\u901a"},ybjk:{key:"ybjk",tagId:7,tagName:"\u5143\u8d1d\u9a7e\u8003"},jsyks:{key:"jsyks",tagId:8,tagName:"\u9a7e\u9a76\u5458\u8003\u8bd5"},jszks:{key:"jszks",tagId:9,tagName:"\u9a7e\u9a76\u8bc1\u8003\u8bd5"},chelun:{key:"chelun",tagId:10,tagName:"\u8f66\u8f6e\u8003\u9a7e\u7167"}};t.exports={competitors:g}});
Simple.Module({name:"jkbd:router/default",require:["./error"]},function(e,t,o,s){var r,n=s.Router,c=e("./error"),a=function(e){"m.jiakaobaodian.com"===e.request.headers.host?e.send({code:200,type:"file",context:s.Server.root+"../static/robots.txt"}):e.send({code:200,type:"file",context:s.Server.root+"../static/robots-test.txt"})};s.platform.node&&(r=e("fs")),n.use("/api/mucang/monitor.htm",function(e,t){t&&t.send({code:200,type:"json",context:{success:!0,errorCode:0,message:null,data:"easy! it's ok => "+ +new Date}})}),n.use("/apple-touch-icon.png",function(e,t){t&&t.send({code:200,type:"file",context:"static:images/logo2.png"})}),n.use(function(e,t){var o,n=t.request.headers.referer;n&&(n=n.replace(/^https?:\/\//,"").replace(/\/.*$/,"")),t&&(e||(e=""),e=e.replace(/^[^\/]*/,""),e=e.split("?"),o=/\.\w+$/gi.exec(e[0]),n=n||"",n.indexOf("www.jiakaobaodian.com")>-1?t.send({code:302,context:"/"}):"/robots.txt"===e[0]?a(t):o?r&&r.existsSync(s.Server.root+"../static"+e[0])?t.send({code:200,type:"file",context:s.Server.root+"../static"+e[0],callback:function(e){e&&t.response.status(404).sendFile(s.Module.path.source("static:404.html",null))}}):c.c404(null,t):"/"!==e[0].substr(-1)?t.send({code:301,context:e[0]+"/"+(e[1]?"?"+e[1]:"")}):c.c404(e,t))})});
Simple.Module({name:"jkbd:router/error",require:[]},function(e,t,n,o){var c=function(e,t){t.send({code:404,type:"file",context:"static:404.html"})},r=function(e,t,n){e.send({code:n||301,context:t})};t.exports={c404:c,c301:r}});
Simple.Module({name:"jkbd:router/main",require:["./base/assets","./home/main","./enroll/main","./tiku/main","./mnks/main","./keywords/main","./media/main","./news/main","./ground/main","./kaoshi/main","./download/main","./competitor/main","./sign/main","./set/main","./member/main","./school/main","./search/main","./peilian/main","./coach/main","./topschool/main","./topcoach/main","./comment/main","./images/main","./courses/main","./match/main","./ksyy/main","./jsq-enroll/main","./my/main","./default","./error"]},function(a,m,n,i){a("./base/assets"),a("./home/main"),a("./enroll/main"),a("./tiku/main"),a("./mnks/main"),a("./keywords/main"),a("./media/main"),a("./news/main"),a("./ground/main"),a("./kaoshi/main"),a("./download/main"),a("./competitor/main"),a("./sign/main"),a("./set/main"),a("./member/main"),a("./school/main"),a("./search/main"),a("./peilian/main"),a("./coach/main"),a("./topschool/main"),a("./topcoach/main"),a("./comment/main"),a("./images/main"),a("./courses/main"),a("./match/main"),a("./ksyy/main"),a("./jsq-enroll/main"),a("./my/main"),a("./default"),a("./error")});
Simple.Module({name:"jkbd:router/base/assets",require:[]},function(e,t,n,o){var s=o.Router,c=function(e){return e=e.replace(/(^[^\/]+)\//gi,"$1:"),o.Module.path.source(e,null)},u=function(e,t){var n=e.path&&c(e.path);n&&"string"==typeof n?t.send({code:200,type:"file",context:n}):t.send({code:404,context:"404"})};s.use(["/web-m-assets/*","/core-m-assets/*"],function(e,t){u(e,t)}),s.use(["/favicon.png","/favicon.ico"],function(e,t){t&&t.send({code:200,type:"file",context:"static:"+t.request.url.substring(1)})})});
Simple.Module({name:"jkbd:router/base/default",require:["../error"]},function(e,t,o,r){var s,c=r.Router,n=e("../error"),a=function(e){"m.jiakaobaodian.com"===e.request.headers.host?e.send({code:200,type:"file",context:r.Server.root+"../static/robots.txt"}):e.send({code:200,type:"file",context:r.Server.root+"../static/robots-test.txt"})};r.platform.node&&(s=e("fs")),c.use("/api/mucang/monitor.htm",function(e,t){t&&t.send({code:200,type:"json",context:{success:!0,errorCode:0,message:null,data:"easy! it's ok => "+ +new Date}})}),c.use(function(e,t){var o,c=t.request.headers.referer;c&&(c=c.replace(/^https?:\/\//,"").replace(/\/.*$/,"")),t&&(e||(e=""),e=e.replace(/^[^\/]*/,""),e=e.split("?"),o=/\.\w+$/gi.exec(e[0]),c=c||"",c.indexOf("www.jiakaobaodian.com")>-1?t.send({code:302,context:"/"}):"/robots.txt"===e[0]?a(t):o?s&&s.existsSync(r.Server.root+"../static"+e[0])?t.send({code:200,type:"file",context:r.Server.root+"../static"+e[0],callback:function(e){e&&t.response.status(404).sendFile(r.Module.path.source("static:404.html",null))}}):n.c404(null,t):"/"!==e[0].substr(-1)?t.send({code:301,context:e[0]+"/"+(e[1]?"?"+e[1]:"")}):n.c404(e,t))})});
Simple.Module({name:"jkbd:router/coach/main",require:["jkbd:store/common/district","jkbd:application/coach/home/main","jkbd:application/coach/detail/main"]},function(t,e,a,c){var r=c.Router,i=t("jkbd:store/common/district"),n={c1:1,c2:2,c3:3,a:4,b:5,def:6},o=function(t){var e,a,c,r,i,o={},h=[],p={};if(t&&0!==t.length&&(e=t.split("-"),Array.isArray(e))){for(i=e.length,c=0;c<e.length;c++)a=e[c],r=a.match(/^(\d*_\d*)d$/),r&&r.length>1?(p.d=r,i--):(r=a.match(/^(\d+)[e,b]$/),r?(p.e=r,i--):(r=n[a])&&(p.a=a,i--));if(!(i>0))return p.d&&p.d.length>1&&(h=p.d[1].split("_"),Array.isArray(h)&&h.length>1&&(o.startPrice=h[0],o.endPrice=h[1])),p.e&&p.e.length>1?o.sortType=parseInt(r[1]):o.sortType=10,p.a&&(o.courseType=p.a),o}};r.use(["/:city/:type/","/amp/:city/:type/","/amp/:city/:type/:filter.html","/coach/","/coach/:filter.html","/:city/:type/:filter.html"],function(e,a){return e.hasAMP=!0,e.path.city=e.path.city||{},t("jkbd:application/coach/home/main").create({params:e,context:a}).render()},{city:function(t){return i.getCodeByPY(t)||!1},type:function(t){var e=t?t.match(/^coach$/):void 0;return!!e&&(e[0]||!1)},filter:function(t){return o(t)||!1}}),r.use(["/:type/:coachId/","/amp/:type/:coachId/"],function(e,a){return e.hasAMP=!0,t("jkbd:application/coach/detail/main").create({params:e,context:a}).render()},{jiaxiaoId:function(t){return t.match(/^\d+$/)[0]||!1},type:function(t){var e=t.match(/^coach|peilian$/);return!!e&&(e[0]||!1)}})});
Simple.Module({name:"jkbd:router/comment/main",require:["jkbd:application/comment/home/main"]},function(t,e,m,n){var o=n.Router;o.use("/:type/:id/commenta-1b.html",function(t,e){e.send({code:301,context:"/"+t.path.type+"/"+t.path.id+"/commenta-1b.html"})}),o.use(["/:type/:id/comment.html","/amp/:type/:id/comment.html","/mip/:type/:id/comment.html"],function(e,m){return e.hasAMP=!0,e.hasMIP=!0,t("jkbd:application/comment/home/main").create({params:e,context:m}).render()},{id:function(t){return t.match(/^\d+$/)[0]||!1},type:function(t){return t.match(/^peilian|coach|school$/)[0]||!1}})});
Simple.Module({name:"jkbd:router/competitor/main",require:["../context","jkbd:application/keywords/home/competitor","jkbd:application/kaoshi/home/competitor","jkbd:application/kaoshi/home/competitor"]},function(t,e,o,i){var r=i.Router,n=i.Utils,p=t("../context").competitors;r.use(["/:competitor/kw/","/:competitor/kw/:page/"],function(e,o){return t("jkbd:application/keywords/home/competitor").create({params:e,context:o}).render()},{competitor:function(t){return n.keys(p).indexOf(t)>=0&&(t=p[t])},page:function(t){var e=t&&t.match(/^p(\d+)$/);return!!e&&((!e[1]||1!==parseInt(e[1].replace("p","")))&&(!!e&&e[1]))}}),r.use(["/:competitor/"],function(e,o){return i.Utils.extend(e.path,e.path.id),t("jkbd:application/kaoshi/home/competitor").create({params:e,context:o}).render()},{competitor:function(t){return n.keys(p).indexOf(t)>=0&&(t=p[t])}}),r.use(["/:competitor/:id/"],function(e,o){return i.Utils.extend(e.path,e.path.id),t("jkbd:application/kaoshi/home/competitor").create({params:e,context:o}).render()},{competitor:function(t){return n.keys(p).indexOf(t)>=0&&(t=p[t])},id:function(t){var e=t.split("_");return{id:e[0],cityCode:e[1]||""}}})});
Simple.Module({name:"jkbd:router/courses/main",require:["jkbd:application/courses/detail/main","jkbd:application/courses/home/main","jkbd:application/courses/home/main"]},function(e,t,a,c){var o=c.Router;o.use("/:type/:id/coursea-1b.html",function(e,t){t.send({code:301,context:"/"+e.path.type+"/"+e.path.id+"/course.html"})}),o.use(["/coach/:id/course.html","/:type/:id/:courseId.html","/amp/:type/:id/course.html"],function(t,a){return t.hasAMP=!0,t.path.courseId?e("jkbd:application/courses/detail/main").create({params:t,context:a}).render():(t.path.coachId,e("jkbd:application/courses/home/main").create({params:t,context:a}).render())},{type:function(e){return("school"===e||"peilian"===e||"coach"===e)&&e},id:function(e){var t=e.match(/^\d+$/);return!!t&&(t[0]||!1)},courseId:function(e){var t=e.match(/course-(\d+)$/);return!!(t&&t.length>1)&&(t[1]||!1)}})});
Simple.Module({name:"jkbd:router/download/main",require:["../context","jkbd:application/download/home/main","jkbd:application/download/home/main"]},function(o,n,e,t){var a=t.Router,i=t.Utils,d=o("../context").competitors;a.use(["/:competitor/download/"],function(n,e){return o("jkbd:application/download/home/main").create({params:n,context:e}).render()},{competitor:function(o){return i.keys(d).indexOf(o)>=0&&(o=d[o])}}),a.use(["/download/"],function(n,e){return o("jkbd:application/download/home/main").create({params:n,context:e}).render()})});
Simple.Module({name:"jkbd:router/enroll/main",require:["jkbd:application/enroll/home/main","jkbd:application/enroll/pop/main"]},function(e,n,o,r){var a=r.Router;a.use("/school/key.html",function(n,o){return e("jkbd:application/enroll/home/main").create({params:n,context:o}).render()}),a.use("/enroll/pop/",function(n,o){return e("jkbd:application/enroll/pop/main").create({params:n,context:o}).render()})});
Simple.Module({name:"jkbd:router/ground/main",require:["jkbd:application/ground/home/main"]},function(o,n,t,r){var e=r.Router;e.use("/:type/:id/traina-1b.html",function(o,n){n.send({code:301,context:"/school/"+o.path.id+"/ground.html"})}),e.use(["/school/:id/ground.html","/amp/school/:id/ground.html","/mip/school/:id/ground.html"],function(n,t){return n.hasAMP=!0,n.hasMIP=!0,o("jkbd:application/ground/home/main").create({params:n,context:t}).render()},{id:function(o){var n=o&&o.match(/^\d+$/);return!!n&&n[0]}})});
Simple.Module({name:"jkbd:router/home/main",require:["jkbd:store/common/district","jkbd:application/home/main"]},function(e,t,o,i){var n=i.Router,r=e("jkbd:store/common/district");n.use(["/","/:city/"],function(t,o){return e("jkbd:application/home/main").create({params:t,context:o}).render()},{city:function(e){return r.getCodeByPY(e)||void 0||!1}})});
Simple.Module({name:"jkbd:router/images/main",require:["jkbd:application/images/home/main"]},function(t,e,o,i){var n=i.Router;n.use("/:type/:id/photosa-1b.html",function(t,e){e.send({code:301,context:"/"+t.path.type+"/"+t.path.id+"/photos.html"})}),n.use(["/:type/:id/photos.html","/mip/:type/:id/photos.html"],function(e,o){return e.hasMIP=!0,t("jkbd:application/images/home/main").create({params:e,context:o}).render()},{id:function(t){return t.match(/^\d+$/)[0]||!1},type:function(t){return("school"===t||"coach"===t||"peilian"===t)&&t}})});
Simple.Module({name:"jkbd:router/jsq-enroll/main",require:["jkbd:application/jsq-enroll/home/main","jkbd:application/jsq-enroll/result/main"]},function(e,r,n,t){var l=t.Router;l.use(["/other/:type.html","/other/:type.html"],function(r,n){return e("jkbd:application/jsq-enroll/home/main").create({params:r,context:n}).render()},{type:function(e){return("jsq-enroll"===e||"xdj-enroll"===e)&&e}}),l.use("/other/jsq-result.html",function(r,n){return e("jkbd:application/jsq-enroll/result/main").create({params:r,context:n}).render()})});
Simple.Module({name:"jkbd:router/kaoshi/main",require:["jkbd:application/kaoshi/home/main","jkbd:application/kaoshi/home/normal","jkbd:application/kaoshi/home/kemu"]},function(e,i,t,a){var n=a.Router;n.use(["/kaoshi/:id.html"],function(i,t){return a.Utils.extend(i.path,i.path.id),e("jkbd:application/kaoshi/home/main").create({params:i,context:t}).render()},{id:function(e){var i=e.split("_");return{id:i[0],cityCode:i[1]||""}}}),n.use(["/rd/:id/","/mip/rd/:id/"],function(i,t){return i.hasMIP=!0,a.Utils.extend(i.path,i.path.id),e("jkbd:application/kaoshi/home/normal").create({params:i,context:t}).render()},{id:function(e){var i=e.split("_");return{id:i[0],cityCode:i[1]||""}}}),n.use(["/:course/"],function(i,t){return a.Utils.extend(i.path,i.path.course),e("jkbd:application/kaoshi/home/kemu").create({params:i,context:t}).render()},{course:function(e){var i={km1:"kemu1",km4:"kemu3"},t={km1:"\u79d1\u76ee\u4e00",km4:"\u79d1\u76ee\u56db"};return!!i[e]&&{course:i[e],key:e,title:t[e]}}})});
Simple.Module({name:"jkbd:router/keywords/main",require:["jkbd:application/keywords/home/main","jkbd:application/keywords/detail/main","jkbd:application/keywords/video/main","jkbd:application/keywords/jx/main","jkbd:application/keywords/cgs/main"]},function(e,r,a,n){var t=n.Router;t.use(["/kw/","/kw/:page/"],function(r,a){return e("jkbd:application/keywords/home/main").create({params:r,context:a}).render()},{page:function(e){var r,a=e&&e.match(/^p(\d+)$/);return!!a&&((!a[1]||!(1===(r=parseInt(a[1].replace("p","")))||r>5))&&(!!a&&a[1]))},item:function(e){var r=e&&e.match(/^t(\d+)$/);return!!r&&r[1]}}),t.use(["/wd/:id/","/mip/wd/:id/"],function(r,a){return r.hasMIP=!0,e("jkbd:application/keywords/detail/main").create({params:r,context:a}).render()},{id:function(e){var r=e&&e.match(/^\w+$/);return!!r&&r[0]}}),t.use(["/:course/"],function(r,a){return n.Utils.extend(r.path,r.path.course),e("jkbd:application/keywords/video/main").create({params:r,context:a}).render()},{course:function(e){var r={km2:"\u79d1\u76ee\u4e8c",km3:"\u79d1\u76ee\u4e09"};return!!r[e]&&{course:e,title:r[e]}}}),t.use(["/jx/:id/","/mip/jx/:id/"],function(r,a){return r.hasMIP=!0,e("jkbd:application/keywords/jx/main").create({params:r,context:a}).render()},{id:function(e){var r=e&&e.match(/^\w+$/);return!!r&&r[0]}}),t.use(["/cgs/:id/","/mip/cgs/:id/"],function(r,a){return r.hasMIP=!0,e("jkbd:application/keywords/cgs/main").create({params:r,context:a}).render()},{id:function(e){var r=e&&e.match(/^\w+$/);return!!r&&r[0]}})});
Simple.Module({name:"jkbd:router/ksyy/main",require:["jkbd:application/ksyy/home/store/data","jkbd:application/ksyy/home/main","jkbd:application/ksyy/detail/main"]},function(e,a,n,t){var i=t.Router,o=e("jkbd:application/ksyy/home/store/data");i.use(["/ksyy/"],function(a,n){return e("jkbd:application/ksyy/home/main").create({params:a,context:n}).render()}),i.use(["/ksyy/:options/"],function(a,n){return e("jkbd:application/ksyy/detail/main").create({params:a,context:n}).render()},{options:function(e){return!!e&&{cityInfo:o.getInfoByCode(e)}}})});
Simple.Module({name:"jkbd:router/match/main",require:["jkbd:application/match/home/main"]},function(e,a,t,n){n.Router.use(["/match/"],function(a,t){return e("jkbd:application/match/home/main").create({params:a,context:t}).render()})});
Simple.Module({name:"jkbd:router/media/main",require:["jkbd:application/media/detail/main"]},function(e,a,i,t){t.Router.use(["/news/media/:id/"],function(a,i){return t.Utils.extend(a.path,a.path.id),e("jkbd:application/media/detail/main").create({params:a,context:i}).render()},{id:function(e){var a,i=e.match(/^m(\d+)(-p\d+)?$/);return!!i&&(!i[2]||1!==(a=parseInt(i[2].replace("-p",""))))&&{id:parseInt(i[1]),page:a||1}}})});
Simple.Module({name:"jkbd:router/member/main",require:["jkbd:application/member/home/main","jkbd:application/member/protocol/main"]},function(e,t,r,a){var i=a.Router,o=a.Utils;a.Deferred;i.use(["/member/login.html","/member/"],function(t,r){return e("jkbd:application/member/home/main").create({params:t,context:r}).render()}),i.use(["/member/qqlogin.html"],function(e,t){var r={appId:"101336553",targetUrl:encodeURIComponent("http://m.jiakaobaodian.com/member/login.html?third=qq"),display:"mobile",href:"https://graph.qq.com/oauth2.0/authorize?"},e={display:r.display,client_id:r.appId,response_type:"token",scope:"get_user_info",redirect_uri:r.targetUrl};o.each(e,function(e,t){r.href+=t+"="+e+"&"}),r.script='<script type="text/javascript" data-appid="APPID" data-redirecturi="TARGETURL" charset="utf-8" src="https://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js"><\/script>',r.script=r.script.replace(/APPID/,r.appId).replace(/TARGETURL/,r.targetUrl),t.send({code:302,context:r.href})}),i.use("/member/protocol.html",function(t,r){return e("jkbd:application/member/protocol/main").create({params:t,context:r}).render()})});
Simple.Module({name:"jkbd:router/mnks/main",require:["jkbd:store/common/district","jkbd:store/common/constant","jkbd:application/mnks/record/main","jkbd:application/mnks/home/main","jkbd:application/mnks/home/main","jkbd:application/mnks/chapter/main","jkbd:application/mnks/strengthen/main","jkbd:application/mnks/exercise/main","jkbd:application/mnks/kemu1_4/main","jkbd:application/mnks/kemu2_3/main","jkbd:application/mnks/kemu1_4/main","jkbd:application/mnks/kemu2_3/main"]},function(e,t,n,i){var r=i.Router,a=e("jkbd:store/common/district"),o=e("jkbd:store/common/constant"),c=i.Utils,p=function(e){var t,n,i=0,r={},p={index:void 0,carType:void 0,course:void 0,city:void 0,typeData:0},u=c.allKeys(o.carNames);if(e&&(t=e.split("-")),t&&t.length>0)for(i=0;i<t.length;i++)if(r=t[i],"number"!=typeof p.index&&(n=r.match(/^[0-8]$/))&&n[0])p.index=parseInt(n[0]);else{if(!p.carType){if(n=c.contains(u,r)){p.carType=r,p.zigezheng=!o.isJSZ(r);continue}if(carTypeInfo=o.getInfoByDaihao(r),p.zigezheng=!o.isJSZ(r),carTypeInfo&&carTypeInfo.daihao){p.carType=carTypeInfo.carType,p.daihao=carTypeInfo.daihao;continue}}p.course||("kemu3"===r&&(r="kemu4"),"kemu1"!==r&&"kemu4"!==r&&"zigezheng"!==r)?p.city||!(n=a.getCodeByPY(r))?!p.typeData&&(n=r.match(/^\d+$/))&&n[0]&&(p.typeData=parseInt(n[0])):p.city=n:p.course=r}if(p.index=p.index||0,p.carType=p.carType||"car","kemu1"===p.course||"kemu4"===p.course||"zigezheng"===p.course)return p.typeData=p.typeData||0,p},u=function(e,t){var n,i,r,p=0,u={},h={carType:void 0,city:void 0},m=c.allKeys(o.carNames);if(e&&(n=e.split("-")),n&&n.length>0)for(p=0;p<n.length;p++){if(u=n[p],!h.carType){if(i=c.contains(m,u)){h.carType=u,h.zigezheng=!o.isJSZ(u);continue}if(r=o.getInfoByDaihao(u),h.zigezheng=!o.isJSZ(u),r&&r.daihao){h.carType=r.carType,h.daihao=r.daihao;continue}}h.city||(i=a.getCodeByPY(u))&&(h.city=i)}return t&&(h.carType=h.carType||"car"),h},h=function(e,t){var n,i,r,p=0,u={},h={carType:void 0,course:void 0,city:void 0},m=c.allKeys(o.carNames);if(e&&(n=e.split("-")),n&&n.length>0)for(p=0;p<n.length;p++){if(u=n[p],!h.carType){if(i=c.contains(m,u)){h.carType=u,h.zigezheng=!o.isJSZ(u);continue}if(r=o.getInfoByDaihao(u),h.zigezheng=!o.isJSZ(u),r&&r.daihao){h.carType=r.carType,h.daihao=r.daihao;continue}}h.course||"kemu1"!==u&&"kemu4"!==u&&"zigezheng"!==u&&"kemu2"!==u&&"kemu3"!==u?h.city||(i=a.getCodeByPY(u))&&(h.city=i):h.course=u}if(t&&(h.carType=h.carType||"car"),"kemu1"===h.course||"kemu4"===h.course||"zigezheng"===h.course||"kemu2"===h.course||"kemu3"===h.course)return h};r.use("/mnks/record/:filter.html",function(t,n){return t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url,delete t.path.filter,e("jkbd:application/mnks/record/main").create({params:t,context:n}).render()},{filter:function(e){var t=h(e,!0);return!!t&&{info:t,url:e}}}),r.use("/mnks/huoyun-0-zigezheng-0.html",function(e,t){t.send({code:302,context:"/mnks/zigezheng/huoyun.html"})}),r.use(["/mnks/:city/"],function(e,t){t.send({code:302,context:"/mnks/"+e.path.city.pinyin+".html"})},{city:function(e){var t=a.getCodeByPY(e);return t||!1}}),r.use(["/mnks/:city.html","/mnks/"],function(t,n){return t.path.info={},t.path.url=t.path.city?t.path.city.pinyin:"beijing",e("jkbd:application/mnks/home/main").create({params:t,context:n}).render()},{city:function(e){var t=a.getCodeByPY(e);return t||!1}}),r.use(["/mnks/:filter.html"],function(t,n){if(t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url,t.path.info.city){if(t.path.info.daihao)return n.send({code:302,context:"/mnks/"+t.path.info.carType+"-"+t.path.info.city.pinyin+".html"}),!0;if(t.path.info.zigezheng)return n.send({code:302,context:"/mnks/zigezheng/"+t.path.info.carType+"-"+t.path.info.city.pinyin+".html"}),!0;if(t.path.info.course)return n.send({code:302,context:"/mnks/"+t.path.info.course+"/"+t.path.info.carType+"-"+t.path.info.city.pinyin+".html"}),!0}else{if(t.path.info.zigezheng)return n.send({code:302,context:"/mnks/zigezheng/"+t.path.info.carType+".html"}),!0;if(t.path.info.course)return n.send({code:302,context:"/mnks/"+t.path.info.course+"/"+t.path.info.carType+".html"}),!0}return delete t.path.filter,e("jkbd:application/mnks/home/main").create({params:t,context:n}).render()},{filter:function(e){var t;return!(!(t=e.split("-").length>2&&e.match(/(kemu\d)|(zigezheng)/)?h(e):u(e))||!t.carType)&&{info:t,url:e}}}),r.use(["/mnks/chapter/:filter.html"],function(t,n){return t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url.replace("kemu3","kemu4"),t.path.filter.url.match("kemu3")?(n.send({code:302,context:"/mnks/chapter/"+t.path.url+".html"}),!0):(delete t.path.filter,e("jkbd:application/mnks/chapter/main").create({params:t,context:n}).render())},{filter:function(e){var t=h(e,!0);return!!t&&("kemu2"!==t.course&&{info:t,url:e})}}),r.use(["/mnks/strengthen/:filter.html"],function(t,n){return t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url.replace("kemu3","kemu4"),t.path.filter.url.match("kemu3")?(n.send({code:302,context:"/mnks/strengthen/"+t.path.url+".html"}),!0):(delete t.path.filter,e("jkbd:application/mnks/strengthen/main").create({params:t,context:n}).render())},{filter:function(e){var t=h(e,!0);return!!t&&("kemu2"!==t.course&&{info:t,url:e})}}),r.use(["/mnks/:type/:filter.html"],function(t,n){return t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url.replace("kemu3","kemu4"),t.path.filter.url.match("kemu3")?(n.send({code:302,context:"/mnks/"+t.path.type+"/"+t.path.url+".html"}),!0):t.path.info.zigezheng&&!t.path.filter.url.match("zigezheng")?(n.send({code:404,type:"file",context:"static:404.html"}),!0):(delete t.path.filter,e("jkbd:application/mnks/exercise/main").create({params:t,context:n}).render())},{filter:function(e){var t=p(e);return!!t&&{info:t,url:e}},type:function(e){return("exercise"===e||"exam"===e)&&e}}),r.use(["/mnks/:course/"],function(t,n){return t.path.info={},e("jkbd:application/mnks/kemu1_4/main").create({params:t,context:n}).render()},{course:function(e){return("kemu1"===e||"kemu4"===e||"zigezheng"===e)&&e}}),r.use(["/mnks/:course/"],function(t,n){return t.path.info={},e("jkbd:application/mnks/kemu2_3/main").create({params:t,context:n}).render()},{course:function(e){return("kemu2"===e||"kemu3"===e)&&e}}),r.use(["/mnks/:course/:filter.html"],function(t,n){return t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url,delete t.path.filter,e("jkbd:application/mnks/kemu1_4/main").create({params:t,context:n}).render()},{filter:function(e){return{info:u(e,!0),url:e}},course:function(e){return("kemu1"===e||"kemu4"===e||"zigezheng"===e)&&e}}),r.use(["/mnks/:course/:filter.html"],function(t,n){return t.path.city=t.path.filter.info.city,t.path.info=t.path.filter.info,t.path.url=t.path.filter.url,delete t.path.filter,e("jkbd:application/mnks/kemu2_3/main").create({params:t,context:n}).render()},{filter:function(e){return{info:u(e,!0),url:e}},course:function(e){return("kemu2"===e||"kemu3"===e)&&e}})});
Simple.Module({name:"jkbd:router/my/main",require:["jkbd:application/my/home/main"]},function(e,n,a,m){m.Router.use(["/my/"],function(n,a){return n.hasAMP=!0,e("jkbd:application/my/home/main").create({params:n,context:a}).render()})});
Simple.Module({name:"jkbd:router/news/main",require:["jkbd:application/news/home/main","jkbd:application/news/detail/main","jkbd:application/news/list/main"]},function(e,a,t,n){var r=n.Router,i=n.Utils,c=function(e){var a;return e.path.articleId&&(a=e.path.articleId.split("_"),e.path.articleId=a[0],e.path.articlePage=a[1]||1),e};r.use(["/news/","/amp/news/"],function(a,t){return a.hasAMP=!0,e("jkbd:application/news/home/main").create({params:a,context:t}).render()}),r.use(["/news/detail/:articleId.html","/mip/news/detail/:articleId.html","/amp/news/detail/:articleId.html"],function(a,t){return t&&t.send&&i.keys(a.search).length>0&&!a.search.from?(t.send({code:301,context:"/news/detail/"+a.path.articleId+".html"}),!1):(a.hasMIP=!0,a.hasAMP=!0,e("jkbd:application/news/detail/main").create({params:c(a),context:t}).render())}),r.use(["/news/:category/","/news/:category/:page/","/amp/news/:category/","/amp/news/:category/:page/"],function(a,t){return a.hasAMP=!0,e("jkbd:application/news/list/main").create({params:a,context:t}).render()},{category:function(e){var a=e&&e.match(/^\w+$/);return!!a&&a[0]},page:function(e){var a=e&&e.match(/^p(\d+)$/);return!!a&&((!a[1]||1!==parseInt(a[1].replace("p","")))&&(!!a&&a[1]))}})});
Simple.Module({name:"jkbd:router/peilian/main",require:["jkbd:store/common/district","jkbd:application/peilian/home/main","jkbd:application/peilian/detail/main"]},function(i,e,t,a){var n=a.Router,r=i("jkbd:store/common/district"),c={c1:1,c2:2,c3:3,a:4,b:5,def:6},l=function(i){var e,t,a,n,r,l={},p=[],o={};if(i&&0!==i.length&&(e=i.split("-"),Array.isArray(e))){for(r=e.length,a=0;a<e.length;a++)t=e[a],n=t.match(/^(\d*_\d*)d$/),n&&n.length>1?(o.d=n,r--):(n=t.match(/^(\d+)[e,b]$/),n?(o.e=n,r--):(n=c[t])&&(o.a=t,r--));if(!(r>0))return o.d&&o.d.length>1&&(p=o.d[1].split("_"),Array.isArray(p)&&p.length>1&&(l.startPeilianPrice=p[0],l.endPeilianPrice=p[1])),o.e&&o.e.length>1?l.sortType=parseInt(n[1]):l.sortType=10,o.a&&(l.courseType=o.a),l}};n.use(["/:city/peilian/","/amp/:city/peilian/","/amp/:city/peilian/:filter.html","/peilian/","/:city/peilian/:filter.html","/peilian/:filter.html"],function(e,t){return e.hasAMP=!0,e.path.city=e.path.city||{},i("jkbd:application/peilian/home/main").create({params:e,context:t}).render()},{city:function(i){return r.getCodeByPY(i)||!1},filter:function(i){return l(i)||!1}}),n.use(["/peilian/:coachId/","/amp/peilian/:coachId/"],function(e,t){return e.hasAMP=!0,i("jkbd:application/peilian/detail/main").create({params:e,context:t}).render()},{coachId:function(i){return i.match(/^\d+$/)[0]||!1}})});
Simple.Module({name:"jkbd:router/school/main",require:["jkbd:store/common/district","jkbd:application/school/home/main","jkbd:application/school/list/list","jkbd:application/school/detail/main"]},function(t,i,o,e){var a=e.Router,c=t("jkbd:store/common/district"),n={c1:1,c2:2,c3:3,a:4,b:5,def:6},r={course:-1,introduce:1,train:2,coach:3,enroll:5},s=function(t){var i,o,e,a,c,r={},s=[],l={};if(t&&0!==t.length&&(i=t.split("-"),Array.isArray(i))){for(c=i.length,e=0;e<i.length;e++)o=i[e],a=o.match(/^(\d*_\d*)d$/),a&&a.length>1?(l.d=a,c--):(a=o.match(/^(\d+)e$/),a?(l.e=a,c--):(a=n[o])&&(l.a=o,c--));if(!(c>0))return l.d&&l.d.length>1&&(s=l.d[1].split("_"),Array.isArray(s)&&s.length>1&&(r.startPrice=s[0],r.endPrice=s[1])),l.e&&l.e.length>1?r.sortType=parseInt(a[1]):r.sortType=10,l.a&&(r.courseType=l.a),r}};a.use(["/:city/school/","/:city/school/:filter.html","/:city/school/:businessCircle/:filter.html","/:city/school/:businessCircle/","/amp/:city/school/","/mip/:city/school/","/mip/:city/school/:businessCircle/"],function(i,o){return i.hasAMP=!0,i.hasMIP=!0,t("jkbd:application/school/home/main").create({params:i,context:o}).render()},{city:function(t){return c.getCodeByPY(t)||!1},filter:function(t){return s(t)||!1},businessCircle:function(t){var i=t.match(/^[r,g,q]_\w+$/);return!!i&&(!!i&&(i[0]||!1))}});var l=["banxing","coach","dianping","info","fields"];a.use(["/school/:jiaxiaoId/list/:type.html","/amp/school/:jiaxiaoId/list/:type.html","/mip/school/:jiaxiaoId/list/:type.html"],function(i,o){return i.hasAMP=!0,i.hasMIP=!0,t("jkbd:application/school/list/list").create({params:i,context:o}).render()},{jiaxiaoId:function(t){var i=t.match(/^\d+$/);return!!i&&(i[0]||!1)},type:function(t){return!!(l.indexOf(t.split("-")[0])>-1)&&t}}),a.use(["/school/:jiaxiaoId/","/amp/school/:jiaxiaoId/","/mip/school/:jiaxiaoId/","/school/:jiaxiaoId/:type.html"],function(i,o){return i.hasAMP=!0,i.hasMIP=!0,-1===i.path.type&&(i.path.type=0,o.send({code:301,context:"/school/"+i.path.jiaxiaoId+"/"})),t("jkbd:application/school/detail/main").create({params:i,context:o}).render()},{jiaxiaoId:function(t){var i=t.match(/^\d+$/);return!!i&&(i[0]||!1)},type:function(t){var i=r[t];return i||!1}})});
Simple.Module({name:"jkbd:router/search/main",require:["jkbd:store/common/district","jkbd:application/search/home/main"]},function(e,r,a,c){var s=c.Router;e("jkbd:store/common/district");s.use(["/search/","/amp/search/"],function(r,a){return r.search.s=c.Utils.escape(r.search.s||""),r.hasAMP=!0,e("jkbd:application/search/home/main").create({params:r,context:a}).render()})});
Simple.Module({name:"jkbd:router/set/main",require:["jkbd:application/set/home/main"]},function(e,t,n,a){a.Router.use(["/set/"],function(t,n){return e("jkbd:application/set/home/main").create({params:t,context:n}).render()})});
Simple.Module({name:"jkbd:router/sign/main",require:["jkbd:application/sign/home/main","jkbd:application/sign/home/main","jkbd:application/sign/police/main","jkbd:application/sign/view2list/main","jkbd:application/sign/detail/main","jkbd:application/sign/view2list/main"]},function(a,i,e,n){var t=n.Router;t.use(["/sign/","/mip/sign/"],function(i,e){return i.path.category="home",i.hasMIP=!0,a("jkbd:application/sign/home/main").create({params:i,context:e}).render()}),t.use(["/sign/:category/"],function(i,e){return"flag"===i.path.category?a("jkbd:application/sign/home/main").create({params:i,context:e}).render():"police"===i.path.category?(i.path.type="home",a("jkbd:application/sign/police/main").create({params:i,context:e}).render()):(i.path.type="home",a("jkbd:application/sign/view2list/main").create({params:i,context:e}).render())},{category:function(a){return!!{flag:"\u4ea4\u901a\u6807\u5fd7\u5927\u5168",dashboard:"\u6c7d\u8f66\u4eea\u8868\u76d8",keypad:"\u8f66\u5185\u529f\u80fd\u6309\u952e",police:"\u65b0\u7248\u4ea4\u8b66\u624b\u52bf",accident:"\u4ea4\u901a\u4e8b\u6545\u56fe\u89e3"}[a]&&a}}),t.use(["/sign/:category/:type.html"],function(i,e){return"police"===i.path.category?a("jkbd:application/sign/detail/main").create({params:i,context:e}).render():a("jkbd:application/sign/view2list/main").create({params:i,context:e}).render()},{category:function(a){return!!{flag:"\u4ea4\u901a\u6807\u5fd7\u5927\u5168",dashboard:"\u6c7d\u8f66\u4eea\u8868\u76d8",keypad:"\u8f66\u5185\u529f\u80fd\u6309\u952e",police:"\u65b0\u7248\u4ea4\u8b66\u624b\u52bf",accident:"\u4ea4\u901a\u4e8b\u6545\u56fe\u89e3"}[a]&&a},type:function(a){var i=a&&a.match(/^\w+$/);return!!i&&i[0]}})});
Simple.Module({name:"jkbd:router/tiku/main",require:["jkbd:store/common/district","jkbd:application/tiku/home/main","jkbd:application/tiku/chapter/main","jkbd:application/tiku/detail/main"]},function(t,i,e,n){var a=n.Router,r=t("jkbd:store/common/district");a.use(["/tiku/:city.html","/tiku/"],function(i,e){return i.path.city=i.path.city||{},t("jkbd:application/tiku/home/main").create({params:i,context:e}).render()},{city:function(t){return t.indexOf("-")<0&&(r.getCodeByPY(t)||void 0||!1)}}),a.use(["/tiku/chapter/:id/","/tiku/chapter/:id/:page/"],function(i,e){return t("jkbd:application/tiku/chapter/main").create({params:i,context:e}).render()},{id:function(t){return!!t.match(/^\d+$/)&&t},page:function(t){var i,e=t&&t.match(/^p(\d+)$/);return!!e&&((!e[1]||(i=parseInt(e[1].replace("p","")),console.log(i),1!==i))&&(!!e&&e[1]))}}),a.use("/tiku/shiti/:id.html",function(i,e){return t("jkbd:application/tiku/detail/main").create({params:i,context:e}).render()},{id:function(t){return!!t.match(/^\d+$/)&&t}})});
Simple.Module({name:"jkbd:router/topcoach/main",require:["jkbd:store/common/district","jkbd:application/topcoach/home/main"]},function(t,o,c,e){var i=e.Router,n=t("jkbd:store/common/district");i.use(["/:type/:info/topcoach.html","/:city/topcoach/"],function(o,c){return t("jkbd:application/topcoach/home/main").create({params:o,context:c}).render()},{city:function(t){return n.getCodeByPY(t)||!1},type:function(t){return t.match(/^school|coach$/)[0]||!1},info:function(t){var o=t.match(/^(\d+)jx$/);return o?!!o&&({id:o[1],type:"jiaxiao"}||!1):!!(o=t.match(/^\d+$/))&&({id:o[0],type:"coach"}||!1)}})});
Simple.Module({name:"jkbd:router/topschool/main",require:["jkbd:store/common/district","jkbd:application/topschool/home/main"]},function(o,t,e,c){var i=c.Router,n=o("jkbd:store/common/district");i.use(["/:city/topschool/","/school/","/mip/:city/topschool/"],function(t,e){return t.path.type=t.path.city?1:2,t.hasMIP=!0,o("jkbd:application/topschool/home/main").create({params:t,context:e}).render()},{city:function(o){return n.getCodeByPY(o)||!1}})});