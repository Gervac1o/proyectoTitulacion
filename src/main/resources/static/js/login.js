$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

const login = document.getElementById("loginForm");
const registro = document.getElementById("registro");
const mensaje = $("#messageError");

let password = document.getElementById("passwords")
    , confirm_password = document.getElementById("confirm_password");

function validatePassword() {
    if (password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Con coincide la contraseña");
    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

$("#sendLogin").click(function () {
    if (login.checkValidity()) {
        let email = $("#email").val();
        let password = $("#password").val();
        const dataToSend =
            {email: email, password: password};

        $.ajax({
            type: 'POST',
            url: '/auth/validation',
            data: dataToSend
        }).done(function (data) {
            if (data) {
                login.submit();
            } else {
                mensaje.text("Usuario o Contraseña no validos");
                mensaje.removeClass("done");
                mensaje.addClass("error");
                mensaje.show();
                confirm_password.setCustomValidity("Usuario o Contraseña no validos");
            }

        });
    } else {
        login.requestSubmit();
    }

});

$("#sendReg").click(function () {
    if (registro.checkValidity()) {
        let email = $("#emailR").val();
        let password = $("#passwords").val();
        const dataToSend =
            {email: email, password: password};
        $.post('/auth/registration', dataToSend, function () {
            alert("success");
        }, "application/json").done(function () {
            alert("second success");
        })
            .fail(function (response) {

                if (response.status && response.status == 403) {
                    mensaje.text(response.responseText);
                    mensaje.removeClass("done");
                    mensaje.addClass("error");
                    mensaje.show();
                    $("#confirm_password").val("");
                    confirm_password.setCustomValidity(response.responseText);

                } else {
                    mensaje.hide();
                    confirm_password.setCustomValidity("");
                    mensaje.removeClass("error");
                    mensaje.addClass("done");
                    $("#inicSes").click();
                    mensaje.text("Nuevo Usuario Registrado exitosamente");
                    mensaje.show();
                    registro.reset();
                }
            });
    } else {
        registro.requestSubmit();
    }

});




