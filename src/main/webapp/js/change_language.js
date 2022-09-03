const flagIcon = document.getElementById('flag-icon');
// const ukrFlag = "img/ukr-flag.png";
// const gbFlag ="img/gb-flag.png";

// flagIcon.onclick = function(event) {
//
//     // TODO change-language servlet with reloading of page from server
//     //      change flagIcon on servlet
//
//     if (flagIcon.getAttribute('name') === 'gb') {
//         sendChangeLangRequest("ua");
//         // flagIcon.src = ukrFlag;
//         // flagIcon.setAttribute('name', 'ukr');
//     } else {
//         sendChangeLangRequest("en");
//         // flagIcon.src = gbFlag;
//         // flagIcon.setAttribute('name', 'gb');
//     }
// }
//
// async function sendChangeLangRequest(language) {
//     let response = await fetch('controller?cmd=SET_LOCALE', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded'
//         },
//         body: 'lang=' +  language,
//     });
//     if (response.status === 200) {
//         history.go(0);
//     } else {
//         //
//     }
// }
//
// flagIcon.addEventListener('mouseover', (e) => {
//     flagIcon.style.scale = "1.1";
// });
//
// flagIcon.addEventListener('mouseout', (e) => {
//     flagIcon.style.scale = "1";
// });