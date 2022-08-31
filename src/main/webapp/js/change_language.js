const flagIcon = document.getElementById('flag-icon');
const ukrFlag = "img/ukr-flag.png";
const gbFlag ="img/gb-flag.png";

// var actual_language = document.cookie("");


flagIcon.onclick = function(event) {

    // TODO change-language servlet with reloading of page from server
    //      change flagIcon on servlet

    if (flagIcon.getAttribute('name') == 'gb') {
        flagIcon.src = ukrFlag;
        flagIcon.setAttribute('name', 'ukr');
    } else {
        flagIcon.src = gbFlag;
        flagIcon.setAttribute('name', 'gb');
    }
}

flagIcon.addEventListener('mouseover', (e) => {
    flagIcon.style.scale = "1.1";
});

flagIcon.addEventListener('mouseout', (e) => {
    flagIcon.style.scale = "1";
});