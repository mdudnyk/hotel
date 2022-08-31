// Get all components

const sing_in_btn = document.querySelector(".header__sing-in-btn");
const sign_in_btn_modal = document.querySelector(".header__sign-in-btn-modal");
const sing_out_btn = document.querySelector(".header__sing-out-btn");

const modal = document.getElementById('id02');

const email_label = document.getElementById('id03');
const email_field = document.getElementById('id04');

const password_label = document.getElementById('id05');
const password_field = document.getElementById('id06');

const wrong_auth_data = document.getElementById('id01');

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
    wrong_auth_data.style.display = "none";
}




sign_in_btn_modal.onclick = function (event) {
    wrong_auth_data.style.display = "none";
    tryToSignIn();
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
            wrong_auth_data.style.display = "block";
            console.log("test");
        }
    }
}

function validate() {
    let valid = true;
    if (!validateEmail(email_field.value)) {
        email_label.style.color="red";
        email_label.textContent = "email: not valid";
        valid = false;
    } else {
        email_label.style.color="#444";
        email_label.textContent = "email:";
    }
    if (!validatePassword(password_field.value)) {
        password_label.style.color="red";
        password_label.textContent = "password: not valid";
        valid = false;
    } else {
        password_label.style.color="#444";
        password_label.textContent = "password:";
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







// window.onload = function() {
//
//     var userName = getCookie("name");
//     console.log("username: " + userName);
//     if (userName.length < 1) {
//         header__user_managment.style.display = "none";
//     } else {
//         sing_in_btn.style.display = "none";
//     }
// }
// function getCookie(cname) {
//
//     // if (document.cookie.split(';').filter(function(item) {
//     //     return item.indexOf('reader=1') >= 0
//     // }).length) {
//     //     console.log('The cookie "reader" has "1" for value')
//     // }
//
//
//     let name = cname + "=";
//     let decodedCookie = decodeURIComponent(document.cookie);
//     let ca = decodedCookie.split(';');
//     for(let i = 0; i <ca.length; i++) {
//         let c = ca[i];
//         while (c.charAt(0) === ' ') {
//             c = c.substring(1);
//         }
//         if (c.indexOf(name) === 0) {
//             return c.substring(name.length, c.length);
//         }
//     }
//     return "";
// }