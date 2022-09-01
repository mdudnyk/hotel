const succs_registr__s_u = document.getElementById('succs_registr__s_u');
const sign_in_text_s_u = document.getElementById('sign_in_text_s_u');
const text_block_s_u = document.getElementById('text_block_s_u');
const input_block_s_u = document.getElementById('input_block_s_u');


const text_alert_s_u = document.getElementById('text_alert_s_u');
const name_text_s_u = document.getElementById('name_text_s_u');
const name_field_s_u = document.getElementById('name_field_s_u');
const surname_text_s_u = document.getElementById('surname_text_s_u');
const surname_field_s_u = document.getElementById('surname_field_s_u');
const email_text_s_u = document.getElementById('email_text_s_u');
const email_field_s_u = document.getElementById('email_field_s_u');
const password_text_s_u = document.getElementById('password_text_s_u');
const password_field_s_u = document.getElementById('password_field_s_u');
const password_repeat_text_s_u = document.getElementById('password_repeat_text_s_u');
const password_repeat_field_s_u = document.getElementById('password_repeat_field_s_u');
const btn_s_u = document.getElementById('btn_s_u');

email_field_s_u.onfocus = function (event) {
    text_alert_s_u.textContent = "";
}

sign_in_text_s_u.onclick = function(event) {
    modal.style.display = 'block';
}

btn_s_u.onclick = function (event) {
    if (validateInput()) {
        sendSignUpRequest();
    } else {

    }
}

function validateInput() {
    let valid_form = true;
    let valid_password = false;

    if (!validateName(name_field_s_u.value)) {
        name_text_s_u.style.color="red";
        name_text_s_u.textContent = "Name: not valid";
        valid_form = false;
    } else {
        name_text_s_u.style.color="#444";
        name_text_s_u.textContent = "Name:";
    }

    if (!validateName(surname_field_s_u.value)) {
        surname_text_s_u.style.color="red";
        surname_text_s_u.textContent = "Surname: not valid";
        valid_form = false;
    } else {
        surname_text_s_u.style.color="#444";
        surname_text_s_u.textContent = "Surname:";
    }

    if (!validateEmail(email_field_s_u.value)) {
        email_text_s_u.style.color="red";
        email_text_s_u.textContent = "Email: not valid";
        valid_form = false;
    } else {
        email_text_s_u.style.color="#444";
        email_text_s_u.textContent = "Email:";
    }

    if (!validatePassword(password_field_s_u.value)) {
        password_text_s_u.style.color="red";
        password_text_s_u.textContent = "Password: not valid";
        valid_form = false;
    } else {
        valid_password = true;
        password_text_s_u.style.color="#444";
        password_text_s_u.textContent = "Password:";
    }

    if (!validatePassword(password_repeat_field_s_u.value)) {
        password_repeat_text_s_u.style.color="red";
        password_repeat_text_s_u.textContent = "Password: not valid";
        valid_form = false;
    } else {
        password_repeat_text_s_u.style.color="#444";
        password_repeat_text_s_u.textContent = "Password:";
        if (valid_password && password_field_s_u.value !== password_repeat_field_s_u.value) {
            password_repeat_text_s_u.style.color="red";
            password_repeat_text_s_u.textContent = "Password: the passwords must be identical";
        }
    }

    return valid_form;
}

async function sendSignUpRequest() {
    let response = await fetch('controller?cmd=SIGN_UP', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        body: 'name=' + name_field_s_u.value + '&surname=' + surname_field_s_u.value +
            '&email=' +  email_field_s_u.value + '&password=' +  password_field_s_u.value,
    });
    if (response.status === 200) {
        text_block_s_u.style.display = "none";
        input_block_s_u.style.display = "none";
        succs_registr__s_u.style.display = "block";
    } else {
        text_alert_s_u.textContent = await response.text();
    }
}

function validateName(name) {
    const regex =  /^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$/;
    return regex.test(name);
}

function validateEmail(email) {
    const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    return regex.test(email);
}

function validatePassword(password) {
    const regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    return regex.test(password);
}