$(document).ready(function () {
    if (window.top.location.href != location.href) {
        window.top.location.href = location.href;
    }

    // 如果在用户中心则跳回去首页
    var usercenterhome = $("#usercenterhome");
    if (usercenterhome[0] != undefined) {
        window.location.href = contextPath + "/login";
    }

    var userName = document.getElementById("username").value;
    if (userName == null || userName == '') {
        document.getElementById("username").focus();
    } else {
        document.getElementById("pwd").focus();
    }

    $("#username").focus(function () {
        $("#loginError").removeClass('item-con_error');
        $("#loginError").text("");
    }).blur(function () {
        if ($("#username").val() == '' || $.trim($("#username").val()) == '') {
            $("#loginError").addClass("item-con_error");
            $("#loginError").text("用户名不能为空");
            return false;
        }
    });

    $("#pwd").focus(function () {
        $("#pwdError").removeClass('item-con_error');
        $("#pwdError").text("");
    }).blur(function () {
        if ($("#pwd").val() == '') {
            $("#pwdError").addClass("item-con_error");
            $("#pwdError").text("用户密码不能为空");
            return false;
        }
    });

    // 图形验证码
    $("#randNum").focus(function () {
        $("#randNumError").removeClass('item-con_error');
        $("#randNumError").text(null);
    }).blur(function () {
        if ($("#randNum").val() == '') {
            $("#randNumError").addClass("item-con_error");
            $("#randNumError").text("验证码不能为空");
            return false;
        }
    });

    $("#randNum2").focus(function () {
        $("#randNumError").removeClass('item-con_error');
        $("#randNumError").text("");
    }).blur(function () {
        if ($("#randNum2").val() == '') {
            $("#randNumError").addClass("item-con_error");
            $("#randNumError").text("验证码不能为空");
            return false;
        }
    });

    $("#phone").focus(function () {
        $("#phoneError").removeClass('item-con_error');
        $("#phoneError").text("");
    }).blur(function () {
        if ($("#phone").val() == '') {
            $("#phoneError").addClass("item-con_error");
            $("#phoneError").text("手机号码不能为空");
            return false;
        }
    });

    $("#readme").click(function () {
        if (!$("#readme").attr("checked")) {
            $("#submit").attr('disabled', 'disabled');
            $("#submit").val("请阅读并同意网络服务和使用协议");
        }
        else {
            $("#submit").attr('disabled', null);
            $("#submit").val("登    录");
        }
    });

    $("#SMSCode").focus(function () {
        $("#SMSCodeError").removeClass('item-con_error');
        $("#SMSCodeError").text("");
    });

    if (error == 1 || error == 2) {
        normalLogin();
    }

});

// 用户登录逻辑处理
function loginForm() {
    var result = true;
    if ($("#username").val() == '' || $.trim($("#username").val()) == '') {
        $("#loginError").addClass("item-con_error");
        $("#loginError").text("用户名不能为空");
        return false;
    }
    if (isEmpty($("#pwd").val())) {
        $("#pwdError").addClass("item-con_error");
        $("#pwdError").text("密码不能为空");
        return false;
    }
    if ($("#randNum").val() == '') {
        $("#randNumError").addClass("item-con_error");
        $("#randNumError").text("验证码不能为空");
        return false;
    }
    if (!checkRandNum()) {
        $("#randNumError").addClass("item-con_error");
        $("#randNumError").text("验证码错误");
        return false;
    }
    if (!result) {
        var pwdIncorrect = $("#pwdIncorrect");
        if (pwdIncorrect != undefined) {
            pwdIncorrect.show();
        }
    }
    return result;

}

// 用户短信登录逻辑处理
function mobileloginForm() {
    var result = true;
    var phone = $("#phone").val()

    if (!checkTel()) {
        return false;
    }

    if ($("#SMSCode").val() == '') {
        $("#SMSCodeError").addClass("item-con_error");
        $("#SMSCodeError").text("短信验证码不能为空");
        return false;
    }
    if ($("#randNum").val() == '') {
        $("#randNumError").addClass("item-con_error");
        $("#randNumError").text("图片验证码不能为空");
        return false;
    }

    if (!checkVarification()) {
        return false;
    }
    if (!result) {
        var pwdIncorrect = $("#pwdIncorrect");
        if (pwdIncorrect != undefined) {
            pwdIncorrect.show();
        }
    }
    return result;

}

function normalLogin() {
    $("#normalLoginTab").attr("class", "active");
    $("#mobileLoginTab").removeAttr("class");
    $("#normalForm").show();
    $("#moblieForm").hide();
}

function mobileLogin() {
    $("#mobileLoginTab").attr("class", "active");
    $("#normalLoginTab").removeAttr("class");
    $("#moblieForm").show();
    $("#normalForm").hide();
}

function checkTel() {
    /*var isPhone = /^1[3|4|5|7|8][0-9]\d{4,8}$/*/
    var isPhone = /^1[3-8][0-9]{9}$/;
    var telValue = $("#phone").val();
    if (isEmpty(telValue)) {
        $("#phoneError").addClass("item-con_error");
        $("#phoneError").text("手机号码不能为空");
        return false;
    }
    if (!(telValue.length == 11 && isPhone.test(telValue))) {
        $("#phoneError").addClass("item-con_error");
        $("#phoneError").text("手机号码格式不正确");
        return false;
    }
    if (!isPhone.test(telValue)) {
        $("#phoneError").addClass("item-con_error");
        $("#phoneError").text("电话号码无效或存在特殊字符");
        return false;
    }
    // 如果用户不存在, 弹出图形验证码, 否则隐藏
    return isPhoneExist(randomModel);
}

function checkRandNum2() {
    var error;
    var inputVal = document.getElementById('randNum2');
    if (inputVal.value == null || inputVal.value == '') {
        error = document.getElementById("cannonull").value;
        $("#authCode_error").text(error);
        $("#randNum").attr("class", "text highlight2");
        return false;
    }
    if (inputVal.value.length != 4) {
        error = document.getElementById("charactors4").value;
        $("#authCode_error").text(error);
        $("#randNum").attr("class", "text highlight2");
        return false;
    }
    $("#authCode_error").text("");
    // 服务器端验证
    return validateRandNum2();
}

// 服务器端验证
function validateRandNum2() {
    var randNum = document.getElementById("randNum2").value;
    var result = true;
    var data = {
        "randNum": randNum
    };
    jQuery.ajax({
        url: contextPath + "/validateRandImg",
        type: 'POST',
        data: data,
        async: false,
        dataType: 'json',
        error: function (jqXHR, textStatus, errorThrown) {
        },
        success: function (retData) {
            if (!retData) {
                result = retData;
                changeRandImg2(contextPath);
            }
        }
    });
    return result;
}

// 重新生成图片验证码
function changeRandImg2() {
    var obj = document.getElementById("randImage2");
    obj.src = contextPath + "/validCoder.random?d=" + new Date();
}

// 图片验证码
function randomModel(flag) {
    if (!flag) {
        $(".login-model").show();
        var random = $("#randNum2").val();
        if (isEmpty(random)) {
            $("#randNumError").addClass("item-con_error");
            $("#randNumError").text("请输入验证码");
            return false;
        }
        else {
            // 检查验证码
            if (!checkRandNum2()) {
                $("#randNumError").addClass("item-con_error");
                $("#randNumError").text("图片验证码错误");
                return false;
            }
        }
    }
    else {
        $("#readme").attr("checked", true);
        $("#submit").attr('disabled', null);
        $("#submit").val("登    录");
        $(".login-model").hide();
    }
    return true;
}

function sendMobileCode() {
    if (checkTel()) {
        var tel = $("#phone").val();
        jQuery.ajax({
            url: contextPath + "/sendSMSCodeByLogin",
            type: 'post',
            data: {
                "tel": tel,
                "randNum2":$("#randNum2").val()
            },
            async: false, // 默认为true 异步
            dataType: 'json',
            error: function (jqXHR, textStatus, errorThrown) {
            },
            success: function (retData) {
                if (!retData == "OK") {
                    alert('短信发送失败');
                    $("#SMScodeBtn").val("重新发送");
                } else {
                    $("#SMSCode").removeAttr("readonly");
                    time($("#SMScodeBtn"));
                }
            }
        });
    }
}

/**
 * 校验手机是否存在
 */
function isPhoneExist(callback) {
    var flag = false;
    var phone = $("#phone").val();
    $.ajax({
        url: contextPath + "/isPhoneExist",
        data: {
            Phone: phone,
        },
        type: 'post',
        dataType: 'json',
        async: false,
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus, errorThrown);
        },
        success: function (data) {
            flag = callback(data);
        }
    });
    return flag;
}


var wait = 60;

function time(btn) {
    $btn = $(btn);
    if (wait == 0) {
        $btn.removeAttr("disabled");
        $btn.val("获取短信校验码");
        wait = 60;
    } else {
        $btn.attr("disabled", true);
        $btn.val(wait + "秒后重新获取");
        wait--;
        setTimeout(function () {
            time($btn);
        }, 1000)
    }
}

// 表单提交前对短信进行验证
function checkVarification() {
    var phone = $("#phone").val();
    var smsCode = $("#SMSCode").val();
    var result = false;
    $.ajax({
        url: contextPath + "/checkSMSCode",
        data: {
            j_username_mobile: phone,
            j_password_mobile: smsCode,
        },
        type: 'post',
        dataType: 'json',
        async: false,
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus, errorThrown);
        },
        success: function (msg) {
            if (msg == "OK") {
                result = true;
            } else {
                $("#SMSCodeError").addClass("item-con_error");
                $("#SMSCodeError").text(msg);
                result = false;
            }
        }
    });
    return result;
}

function isEmpty(value) {
    if (value == null || value == "" || value == "undefined"
        || value == undefined || value == "null") {
        return true;
    } else {
        value = (value + "").replace(/\s/g, '');
        if (value == "") {
            return true;
        }
        return false;
    }
}
