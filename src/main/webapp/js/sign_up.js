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

let alert_msg = "";

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
        //REDIRECT TO SUCCESS REGISTRATION PAGE
    } else {
        //WRITE ALLERT MESSAGE WITH REASONS
    }
}

function validateName(name) {
    const regex =  /\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+/;
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