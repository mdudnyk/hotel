const sign_in_btn_modal = document.querySelector(".header__sign-in-btn-modal");
const wrong_auth_data = document.getElementById('id01');
const modal = document.getElementById('id02');
const email_label = document.getElementById('id03');const email_field = document.getElementById('id04');
const password_label = document.getElementById('id05');
const password_field = document.getElementById('id06');
let is_sign_in_btn_modal_blocked = false;


window.onclick = function(event) {
    if (event.target === modal) {
        closeModal();
    }
}

function closeModal() {
    modal.style.display = "none";
    email_label.style.color ="#444";
    email_label.textContent = "email:";
    email_field.value = "";
    password_label.style.color ="#444";
    password_label.textContent = "password:";
    password_field.value = "";
    wrong_auth_data.style.opacity = "0";
    is_sign_in_btn_modal_blocked = false;
}

sign_in_btn_modal.onclick = function (event) {
    if (!is_sign_in_btn_modal_blocked) {
        wrong_auth_data.style.opacity = "0";
        tryToSignIn();
    }
}

email_field.onfocus = function (event) {
    is_sign_in_btn_modal_blocked = false;
}

password_field.onfocus = function (event) {
    is_sign_in_btn_modal_blocked = false;
}

async function tryToSignIn() {
    if(validate()) {
        let response = await fetch('controller?cmd=SIGN_IN', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'email=' +  email_field.value + '&password=' +  password_field.value,
        });
        if (response.status === 200) {
            history.go(0);
        } else {
            wrong_auth_data.style.opacity = "100%";
            is_sign_in_btn_modal_blocked = true;
        }
    }
}

function validate() {
    let valid = true;
    if (!validateEmail(email_field.value)) {
        email_label.style.color="red";
        email_label.textContent = "Email: not valid";
        valid = false;
    } else {
        email_label.style.color="#444";
        email_label.textContent = "Email:";
    }
    if (!validatePassword(password_field.value)) {
        password_label.style.color="red";
        password_label.textContent = "Password: not valid";
        valid = false;
    } else {
        password_label.style.color="#444";
        password_label.textContent = "Password:";
    }
    return valid;
}

function validateEmail(email) {
    const regex = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/;
    return regex.test(email);
}

function validatePassword(password) {
    const regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    return regex.test(password);
}