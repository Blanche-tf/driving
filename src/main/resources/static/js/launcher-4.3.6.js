!function(e,o){var i=e.Simple,t=i.Module.require("simple:main");i.Application=t.Application,i.Component=t.Component,i.Utils=t.Utils,i.Object=t.Object,i.Queue=t.Queue,i.View=t.View,i.Message=t.Message,i.Deferred=t.Deferred,i.Tools=t.Tools,i.Store=t.Store,i.Template=t.Template,i.Router=t.Router.create({root:i.root}),i.Module({name:"simple:launcher",require:[i.config.initialize,i.config.router],root:!0},function(e,o,i,t){if(t.config.initialize&&e(t.config.initialize),t.config.router&&e(t.config.router),t.Utils.isFunction(t.ready)&&t.ready(),t.Utils.platform.browser)try{app=t.Router.go(location.href,{send:function(){},store:function(){},request:null,response:null}),app&&app.then&&app["catch"](function(e){})}catch(n){}})}("undefined"!=typeof global?global:this);