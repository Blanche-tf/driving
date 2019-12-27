/******/ (function(modules) { // webpackBootstrap
    /******/ 	// The module cache
    /******/ 	var installedModules = {};

    /******/ 	// The require function
    /******/ 	function __webpack_require__(moduleId) {

        /******/ 		// Check if module is in cache
        /******/ 		if(installedModules[moduleId])
        /******/ 			return installedModules[moduleId].exports;

        /******/ 		// Create a new module (and put it into the cache)
        /******/ 		var module = installedModules[moduleId] = {
            /******/ 			exports: {},
            /******/ 			id: moduleId,
            /******/ 			loaded: false
            /******/ 		};

        /******/ 		// Execute the module function
        /******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

        /******/ 		// Flag the module as loaded
        /******/ 		module.loaded = true;

        /******/ 		// Return the exports of the module
        /******/ 		return module.exports;
        /******/ 	}


    /******/ 	// expose the modules object (__webpack_modules__)
    /******/ 	__webpack_require__.m = modules;

    /******/ 	// expose the module cache
    /******/ 	__webpack_require__.c = installedModules;

    /******/ 	// __webpack_public_path__
    /******/ 	__webpack_require__.p = "";

    /******/ 	// Load entry module and return exports
    /******/ 	return __webpack_require__(0);
    /******/ })
/************************************************************************/
/******/ ([
    /* 0 */
    /***/ (function(module, exports) {

        "use strict";

        /*
         * @Author: jiaolong
         * @Date: 2018-11-22 17:31:43
         * @Last Modified by: jiaolong
         * @Last Modified time: 2019-03-07 15:26:40
         * 58滑块变更网易盾
         */

        $(document).ready(function () {
            // 初始化注册类型
            var obj = {
                text: "驾校入驻",
                url: "/register/jx"
            };
            //根据路径判断注册去向
            var guidance_type = window.location.href.split("/")[4];
            if (guidance_type == "jl") {
                obj.text = "教练入驻";
                obj.url = "/register";
                $('#registerfrom')[0].removeChild($("#registerfrom").children("div")[0]);
                $("#usertype").val(1);
            } else if (guidance_type == "pl") {
                obj.text = "陪练入驻";
                obj.url = "/register";
                $("#usertype").val(0);
                // $('#registerfrom')[0].removeChild($("#registerfrom").children("div")[0]);
            } else if (guidance_type == "jx") {
                obj.text = "驾校入驻";
                obj.url = "/register";
                $("#usertype").val("");
                // $(".code-block").hide();
                $("#registerfrom h4").prop("data-type", "jx");
            } else if (guidance_type == "xy") {
                obj.text = "学员注册";
                obj.url = "/register";
                $("#usertype").val("");
                $(".code-block").show();
                $(".register-submit").text("注册");
                $("#registerfrom h4").prop("data-type", "xy");
            }

            $(".register-code-btn").attr("data-send", "true");

            //动态改版注册文字提示
            $("#registerfrom h4").text(obj.text);
            // $(".register-jx").keyup(function () {
            //     jxNameReg();
            // });

            // function jxNameReg() {
            //     var jxName = $.trim($(".register-jx").val());
            //     if (jxName == "" || jxName == $(".register-jx").attr("placeholder")) {
            //         $(".register-jx").next().css("visibility", "visible");
            //         $(".register-jx").next().text("请输入驾校全称");
            //         $(".register-jx").next().next().hide();
            //         return false;
            //     } else if ($(".register-jx").val().length >= 40) {
            //         $(".register-jx").next().css("visibility", "visible");
            //         $(".register-jx").next().text("驾校名称过长");
            //         $(".register-jx").next().next().hide();
            //         return false;
            //     } else {
            //         $(".register-jx").next().css("visibility", "hidden");
            //         $(".register-jx").next().text("");
            //         $(".register-jx").next().next().show();
            //     }
            //     return true;
            // }

            $(".register-phone").keyup(function () {
                jxPhoneReg();
            });

            function jxPhoneReg() {
                var phone = $.trim($(".register-phone").val());
                var regPhone = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
                if (phone == "" || phone == $(".register-phone").attr("placeholder")) {
                    $(".register-phone").next().css("visibility", "visible");
                    $(".register-phone").next().text("请输入手机号码");
                    $(".register-phone").next().next().hide();
                    return false;
                } else if (!regPhone.test($(".register-phone").val())) {
                    $(".register-phone").next().css("visibility", "visible");
                    $(".register-phone").next().text("请输入正确的手机号");
                    $(".register-phone").next().next().hide();
                    return false;
                } else {
                    $(".register-phone").next().css("visibility", "hidden");
                    $(".register-phone").next().text("");
                    $(".register-phone").next().next().show();
                }
                return true;
            }

            $(".register-code").keyup(function () {
                jxCodeReg();
            });

            // function jxCodeReg() {
            //     var code = $.trim($(".register-code").val());
            //     if (code == "" || code == $(".register-code").attr("placeholder")) {
            //         $(".register-code").next().next().css("visibility", "visible");
            //         $(".register-code").next().next().text("请输入验证码");
            //         $(".register-code").next().next().next().hide();
            //         return false;
            //     } else if ($(".register-code").val().length != 4) {
            //         $(".register-code").next().next().css("visibility", "visible");
            //         $(".register-code").next().next().text("短信验证码错误");
            //         $(".register-code").next().next().next().hide();
            //         return false;
            //     } else {
            //         $(".register-code").next().next().css("visibility", "hidden");
            //         $(".register-code").next().next().text("");
            //         $(".register-code").next().next().next().show();
            //     }
            //     return true;
            // }

            $(".register-pwd").keyup(function () {
                jxPwdReg();
            });

            function jxPwdReg() {
                var pwd = $.trim($(".register-pwd").val());
                var regpwd = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,20}$/;
                if (pwd == "" || pwd == $(".register-pwd").attr("placeholder")) {
                    if (navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/9./i) == "9.") {
                        $(".register-pwd").next().next().css("visibility", "visible");
                        $(".register-pwd").next().next().text("请输入密码");
                        $(".register-pwd").next().next().next().hide();
                    } else {
                        $(".register-pwd").next().css("visibility", "visible");
                        $(".register-pwd").next().text("请输入密码");
                        $(".register-pwd").next().next().hide();
                    }
                    return false;
                } else if (!regpwd.test($(".register-pwd").val())) {
                    if (navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/9./i) == "9.") {
                        $(".register-pwd").next().next().css("visibility", "visible");
                        $(".register-pwd").next().next().text("密码格式有误(字母、数字或者符号,最短8位,最长20位)");
                        $(".register-pwd").next().next().next().hide();
                    } else {
                        $(".register-pwd").next().css("visibility", "visible");
                        $(".register-pwd").next().text("密码格式有误(字母、数字或者符号,最短8位,最长20位)");
                        $(".register-pwd").next().next().hide();
                    }
                    return false;
                } else if (null) {
                    // if (navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/9./i) == "9.") {
                    //     $(".register-pwd").next().next().css("visibility", "visible");
                    //     $(".register-pwd").next().next().text("密码不能包含手机号码");
                    //     $(".register-pwd").next().next().next().hide();
                    // } else {
                    //     $(".register-pwd").next().css("visibility", "visible");
                    //     $(".register-pwd").next().text("密码不能包含手机号码");
                    //     $(".register-pwd").next().next().hide();
                    // }
                    // return false;
                } else {
                    if (navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/9./i) == "9.") {
                        $(".register-pwd").next().next().css("visibility", "hidden");
                        $(".register-pwd").next().next().text("");
                        $(".register-pwd").next().next().next().show();
                    } else {
                        $(".register-pwd").next().css("visibility", "hidden");
                        $(".register-pwd").next().text("");
                        $(".register-pwd").next().next().show();
                    }
                }
                return true;
            }

            $("#register_checkbox").click(function () {
                jxisCheckedReg();
            });

            function jxisCheckedReg() {
                var isChecked = $('#register_checkbox').is(":checked");
                if (!isChecked) {
                    $(".register-submit").addClass("register-submit-on").text("您还未接受注册条款");
                    return false;
                } else {
                    $(".register-submit").removeClass("register-submit-on").text("注册");
                }
                return true;
            }

            var captchaIns = "";
            initNECaptcha({
                // config对象，参数配置
                captchaId: "e11978dc94fe431eb2ec9c510ddf97b9",
                element: "#captcha",
                mode: "popup",
                width: "380px",
                // 用户验证码验证成功后，进行实际的提交行为
                onVerify: function onVerify(err, data) {
                    if (data) {
                        // var type = $(".register-code-btn");
                        $("#successToken").val(data.validate);
                        // if ( $("#registerfrom h4").prop("data-type") === "jx"){
                        //     type = $("#send_code");
                        // }
                        getVerificationCode($(".register-phone").val());
                    }
                }
            }, function onload(instance) {
                // 初始化成功后得到验证实例instance，可以调用实例的方法
                console.log(instance);
                captchaIns = instance;
            }, function onerror(err) {
                console.log("error", err);
                // 初始化失败后触发该函数，err对象描述当前错误信息
            });
            $(".register-code-btn").click(function () {

                if (!jxPhoneReg()) {
                    return false;
                }
                $(".code-block p").css("visibility", "hidden").text("");
                if ($(".register-code-btn").attr("data-send") && $(".register-code-btn").text() === "获取验证码") {
                    captchaIns && captchaIns.refresh();
                    captchaIns && captchaIns.popUp();
                }
            });

            $("#send_code").click(function () {
                if ($("#send_code").attr("data-send") === "true" && $("#send_code").text() === "获取验证码") {
                    captchaIns && captchaIns.refresh();
                    captchaIns && captchaIns.popUp();
                }
            });

            function getVerificationCode(phone) {
                var d = new Date();
                var time = d.getTime();
                $.ajax({
                    dataType: 'json',
                    type: 'get',
                    url: '/captcha/pcSendCode',
                    data: {
                        t: 1,
                        m: 1,
                        p: 1,
                        mobile: phone,
                        successToken: $("#successToken").val(),
                        _: time
                    },
                    success: function success(res) {
                        if (res.code == 0) {
                            var n = 60;
                            window.rid = res.result.rid;
                            $(".register-code-btn").css({
                                "background-color": "#F2F2F2",
                                "color": "#00C356",
                                "cursor": "default"
                            }).attr("data-send", "false");
                            window.timer = setInterval(function () {
                                if (n <= '1') {
                                    clearInterval(timer);
                                    $($(".register-code-btn")).css({
                                        "background-color": "#00C356",
                                        "color": "#FFFFFF",
                                        "cursor": "pointer"
                                    });
                                    $($(".register-code-btn")).text('获取验证码');
                                    $("#successToken").val("");
                                    $(".register-code-btn").attr("data-send", "true");
                                } else {
                                    $(".register-code-btn").text(--n + '秒后重新获取');
                                }
                            }, 1000);
                        } else {
                            $(".register-code").next().next().css("visibility", "visible").text(res.msg);
                            $(".rep_md_panel #keywordsMsg3").css("visibility", "visible").text(res.msg);
                            $(".register-code-btn").css({
                                "background-color": "#00C356",
                                "color": "#FFFFFF",
                                "cursor": "pointer"
                            }).text('获取验证码');
                        }
                    }
                });
            }

            $(".register-submit").click(function () {

                if (!jxPhoneReg()) {
                    return false;
                }
                if (!jxPwdReg()) {
                    return false;
                }
                if (!jxisCheckedReg()) {
                    return false;
                }

                // if ($("#successToken").val() == "") {
                //     $("#captcha").next().css("visibility", "visible");
                //     $("#captcha").next().text("请完成滑块验证后登陆");
                //     return false;
                // }
                if ($("#registerfrom h4").prop("data-type") === "jx") {
                    $(".floating-wrap").show();
                    $("#send_code").attr("data-send", "true");
                    $(".title-phone").text("接收验证码的手机号为：" + $(".register-phone").val());
                } else {
                    if (!jxCodeReg()) {
                        return false;
                    }
                }



                // if ($("#successToken").val() == "") {
                //     $("#captcha").next().css("visibility", "visible");
                //     $("#captcha").next().text("请完成滑块验证后登陆");
                //     return false;
                // }
                var r_id = window.rid;
                $("#phonerid").val(r_id);
                var t = $('#registerfrom').serializeArray();
                // getCapthaSession();
                $.ajax({
                    dataType: "json",
                    type: "post",
                    url: obj.url,
                    data: t,
                    success: function success(data) {
                        console.log(data);
                        if (data.code == "0") {
                            $("#successToken").val("");
                            window.location.href = data.url;
                        } else if (data.code == "-102") {
                            $(".register-code").next().next().css("visibility", "visible");
                            $(".register-code").next().next().text(data.msg);
                            $(".register-code").next().next().next().hide();
                        } else {
                            $(".register-phone").next().css("visibility", "visible");
                            $(".register-phone").next().text(data.msg);
                            $(".register-phone").next().next().hide();
                        }
                    },
                    error: function error(data) {}
                });
            });

            //省市区初始化
            ajaxSortArea($("#sortOneId"), "0", "");
            $("#sortTwoId").append('<option value="1">北京市</option>');
            ajaxSortArea($("#sortThreeId"), "1", "");
            $("#sortOneId").change(function () {
                if ($("#sortOneId").val() != "请选择" && $("#sortOneId").val() != "") {
                    if ($("#sortOneId").val() == 1 || $("#sortOneId").val() == 2 || $("#sortOneId").val() == 3 || $("#sortOneId").val() == 4) {
                        $("#sortTwoId").empty();
                        $("#sortTwoId").append('<option value="' + $("#sortOneId").val() + '">' + $("#sortOneId option:selected").html() + '</option>');
                        ajaxSortArea($("#sortThreeId"), $("#sortOneId").val(), "");
                    } else {
                        ajaxSortArea($("#sortTwoId"), $("#sortOneId").val(), 2);
                    }
                }
            });
            $("#sortTwoId").change(function () {
                if ($("#sortTwoId").val() != "请选择" && $("#sortTwoId").val() != "") {
                    ajaxSortArea($("#sortThreeId"), $("#sortTwoId").val(), "");
                }
            });

            function ajaxSortArea(element, code, init) {
                $.ajax({
                    // url:  "http://jxedtsaas.58v5.cn/ydtschool/ajaxSortArea",
                    url: "https://saas.jxedt.com/ydtschool/ajaxSortArea?sortOneIds=" + code,
                    type: "get",
                    dataType: "json",
                    success: function success(data) {
                        element.empty();
                        if (data.length > 0) {
                            $.each(data, function (i) {
                                if (this.name != "") {
                                    if (2 == init && i == 0) {
                                        //等待市填充成功,再去请求区，否则获取不到市的id
                                        ajaxSortArea($("#sortThreeId"), this.id, "");
                                    }
                                    element.append('<option value="' + this.id + '">' + this.name + '</option>');
                                }
                            });
                        } else {
                            element.append('<option value="' + $("#sortTwoId").val() + '">' + $("#sortTwoId option:selected").html() + '</option>');
                        }
                    },
                    error: function error(result) {}
                });
            }

            //驾校简称切换
            $("#jxkeywordOne").show();
            $("#jxkeywordTwo").hide();
            $("#jxkeywordThree").hide();
            $("#jxnature").change(function () {
                if ($("#jxnature").val() == "1") {
                    $("#jxkeywordOne").show();
                    $("#jxkeywordTwo").hide();
                    $("#jxkeywordThree").hide();
                }
                if ($("#jxnature").val() == "2") {
                    $("#jxkeywordTwo").show();
                    $("#jxkeywordOne").hide();
                    $("#jxkeywordThree").hide();
                }
                if ($("#jxnature").val() == "3") {
                    $("#jxkeywordThree").show();
                    $("#jxkeywordOne").hide();
                    $("#jxkeywordTwo").hide();
                }
            });

            $("#registerJXfrom .form-group input").blur(function () {
                if ($(this).hasClass("jxkeyword")) {
                    $("#keywordsMsg2").css("visibility", "hidden");
                } else {
                    $(this).next().css("visibility", "hidden");
                }
            });
            /**
             * 驾校注册提交
             */
            $("#submit_btn").click(function () {
                var sortTwoId = $("#sortTwoId").val();
                var jxnature = $("#jxnature").val();
                var keywords;
                if ($("#jxnature").val() == 1) {
                    keywords = $("#jxkeywordOne input").val();
                }
                if ($("#jxnature").val() == 2) {
                    keywords = $("#jxkeywordTwo input").val();
                }
                if ($("#jxnature").val() == 3) {
                    keywords = $("#jxkeywordThree input").val();
                }

                if ($("#company").val() == "") {
                    $("#keywordsMsg1").text("驾校全称不能为空！");
                    $("#keywordsMsg1").css("visibility", "visible");
                    return false;
                } else if ($("#company").val().length > 40) {
                    $("#keywordsMsg1").text("驾校全称不能大于40个文字！");
                    $("#keywordsMsg1").css("visibility", "visible");
                    return false;
                } else {
                    $("#keywordsMsg1").css("visibility", "hidden");
                }
                if (!checkKeywordsEnd(jxnature, keywords)) {
                    return false;
                }
                if ($(".rep_item_input #code").val() == "") {
                    $("#keywordsMsg3").text("验证码不能为空！");
                    $("#keywordsMsg3").css("visibility", "visible");
                    return false;
                } else if ($(".rep_item_input #code").val().length != 4) {
                    $("#keywordsMsg3").text("验证码不正确！");
                    $("#keywordsMsg3").css("visibility", "visible");
                    return false;
                } else {
                    $("#keywordsMsg3").css("visibility", "hidden");
                }
                if (keywords != "") {
                    checkKeywordsWithParam(sortTwoId, jxnature, keywords);
                }
            });

            // $(".jxkeyword").blur(function () {
            //     var sortTwoId = $("#sortTwoId").val();
            //     var jxnature = $("#jxnature").val();
            //     var keywords;
            //     if($("#jxnature").val() == 1){
            //         keywords = $("#jxkeywordOne input").val();
            //     }
            //     if($("#jxnature").val() == 2){
            //         keywords = $("#jxkeywordTwo input").val();
            //     }
            //     if($("#jxnature").val() == 3){
            //         keywords = $("#jxkeywordThree input").val();
            //     }
            //     if (keywords != "") {
            //         checkKeywordsWithParam(sortTwoId, jxnature, keywords);
            //     }
            // });
            $(".close").click(function () {
                $(".floating-wrap").hide();
            });
        });

        /**
         * 校验驾校简称
         * ret false:简称不合法 true:简称合法
         */
        function checkKeywordsWithParam(sortTwoId, jxnature, keywords) {
            if (keywords == "") {
                $("#keywordsMsg2").text("驾校简称不能为空！");
                $("#keywordsMsg2").css("visibility", "hidden");
                return false;
            }
            var ret = checkKeywordsEnd(jxnature, keywords);
            $(".loading-submit").show();
            if (ret == true) {
                $.ajax({
                    url: "https://saas.jxedt.com/ydtrenzhengdata/checkKeywordsPC",
                    data: { sortTwoId: sortTwoId, jxnature: jxnature, keywords: keywords },
                    type: "post",
                    dataType: "json",
                    success: function success(result) {
                        //验证失败
                        //46, "该驾校简称不能包含特殊字符"
                        //47, "该驾校简称未以【总校】结尾"
                        //48, "该驾校简称未以【分校】结尾"
                        //49, "该驾校简称未以【报名点】结尾"
                        //50, "该驾校简称不能包含城市名称"
                        //51, "该驾校简称系统中已存在"
                        if (result.checkCode == 1) {
                            $(".loading-submit").hide();
                            var message = "";
                            if (result.keywords == 46) {
                                message = "该驾校简称不能包含特殊字符，请再选一个!";
                            } else if (result.keywords == 47) {
                                message = "该驾校简称要以【驾校】结尾，请再选一个!";
                            } else if (result.keywords == 48) {
                                message = "该驾校简称要以【分校】结尾，请再选一个!";
                            } else if (result.keywords == 49) {
                                message = "该驾校简称要以【报名点】结尾，请再选一个!";
                            } else if (result.keywords == 50) {
                                message = "该驾校简称不能包含城市名称,请再选一个!";
                            } else {
                                message = "该驾校简称系统中已存在,请再选一个!";
                            }
                            $("#keywordsMsg2").text(message);
                            $("#keywordsMsg2").css("visibility", "visible");
                            ret = false;
                        } else {
                            //清理
                            $("#keywordsMsg2").css("visibility", "hidden");
                            submitJX();
                        }
                    },
                    error: function error(result) {
                        alert("服务器繁忙！");
                    }
                });
            }
            return ret;
        }

        /**
         * 驾校信息提交
         */
        function submitJX() {
            var r_id = window.rid;
            var keywords;
            if ($("#jxnature").val() == 1) {
                keywords = $("#jxkeywordOne input").val();
            }
            if ($("#jxnature").val() == 2) {
                keywords = $("#jxkeywordTwo input").val();
            }
            if ($("#jxnature").val() == 3) {
                keywords = $("#jxkeywordThree input").val();
            }
            $("#registerJXfrom .keywords").val(keywords);
            $("#registerJXfrom .phonerid").val(r_id);
            $("#registerJXfrom .pwd").val($(".div-wrap .register-pwd").val());
            $("#registerJXfrom .mobile").val($("#registerfrom .register-phone").val());
            var t = $('#registerJXfrom').serializeArray();
            $.ajax({
                dataType: "json",
                type: "post",
                url: "//user.jxedt.com/register",
                data: t,
                success: function success(data) {
                    if (data.code == "0") {
                        window.location.href = data.url;
                    } else {
                        $(".loading-submit").hide();
                        $("#keywordsMsg3").text(data.msg);
                        $("#keywordsMsg3").css("visibility", "visible");
                    }
                },
                error: function error(result) {
                    $(".loading-submit").hide();
                }
            });
        }

        /**
         * 驾校简称后缀验证
         * 根据驾校性质(总校、分校、报名点)简称结尾：驾校、分校、报名点
         * @param jxnature
         * @param keywords
         */
        function checkKeywordsEnd(jxnature, keywords) {
            var sortTwoId = $("#sortTwoId").val();
            var jxnature = $("#jxnature").val();
            var keywords = "";
            if ($("#jxnature").val() == 1) {
                keywords = $("#jxkeywordOne input").val();
            }
            if ($("#jxnature").val() == 2) {
                keywords = $("#jxkeywordTwo input").val();
            }
            if ($("#jxnature").val() == 3) {
                keywords = $("#jxkeywordThree input").val();
            }

            if (keywords == "") {
                $("#keywordsMsg2").text("驾校简称不能为空！");
                $("#keywordsMsg2").css("visibility", "visible");
                return false;
            }

            if (jxnature == 1) {
                var endStr = "驾校";
                if (keywords.substring(keywords.length - endStr.length) != endStr) {
                    $("#keywordsMsg2").text("驾校简称要以【驾校】结尾！");
                    $("#keywordsMsg2").css("visibility", "visible");
                    return false;
                }
            }
            if (jxnature == 2) {
                var endStr = "分校";
                if (keywords.substring(keywords.length - endStr.length) != endStr) {
                    $("#keywordsMsg2").text("驾校简称要以【分校】结尾！");
                    $("#keywordsMsg2").css("visibility", "visible");
                    return false;
                }
            }
            if (jxnature == 3) {
                var endStr = "报名点";
                if (keywords.substring(keywords.length - endStr.length) != endStr) {
                    $("#keywordsMsg2").text("驾校简称要以【报名点】结尾！");
                    $("#keywordsMsg2").css("visibility", "visible");
                    return false;
                }
            }
            if (!nameCheck(keywords)) {
                $("#keywordsMsg2").text("驾校简称不能包含特殊字符和敏感词语！");
                $("#keywordsMsg2").css("visibility", "visible");
                return false;
            }
            return true;
        }

        /**
         **驾校简称不能包含特殊字符和敏感词语
         **/
        function nameCheck(name) {
            var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im,
                regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
            var cizu = ["保过", "包过", "推荐", "官方", "拿证"];
            if (regEn.test(name) || regCn.test(name)) {
                return false;
            }
            for (var i = 0; i < cizu.length; i++) {
                if (name.indexOf(cizu[i]) != -1) {
                    return false;
                }
            }
            return true;
        }

        /***/ })
    /******/ ]);