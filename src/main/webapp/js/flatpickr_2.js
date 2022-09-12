config_start = {
    dateFormat: "Y-m-d",
    altInput: true,
    altFormat: "D, j M Y",
    minDate: "today",
    maxDate: new Date().fp_incr(90),
    monthSelectorType: "static",
    onChange: changeEndDate,
    defaultDate: getStartDateFromRequest()
}

function getStartDateFromRequest() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const date = urlParams.get('startDate');
    return new Date(date);
}

function changeEndDate() {
    let date = new Date(startDate.selectedDates[0]);
    endDate.config.minDate = date.fp_incr(1);

    if (endDate.selectedDates.length === 0) {
        endDate.jumpToDate(date, true);
        endDate.open();
    } else {
        search_button.type = "submit";
    }
}

const startDate = flatpickr(".content__start-date-field", config_start);

config_end = {
    dateFormat: "Y-m-d",
    altInput: true,
    altFormat: "D, j M Y",
    minDate: new Date().fp_incr(1),
    maxDate: new Date().fp_incr(91),
    monthSelectorType: "static",
    onChange: changeStartDate,
    defaultDate: getEndDateFromRequest()
}

function getEndDateFromRequest() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const date = urlParams.get('endDate');
    return new Date(date);
}

function changeStartDate() {
    let date = new Date(endDate.selectedDates);
    startDate.config.maxDate = date.fp_incr(-1);

    if (startDate.selectedDates.length === 0) {
        startDate.open();
    } else {
        search_button.type = "submit";
    }
}

const endDate = flatpickr(".content__end-date-field", config_end);


const guests_field = document.getElementById('guests_filed');
const guests_field_hidden = document.getElementById('guests_filed_hidden');
const dropdown = document.getElementById('myDropdown');
const room_content = document.getElementById('room_content');
const add_btn = document.getElementById('add_room_btn');
const done_btn = document.getElementById('done_btn');
const srch_btn = document.getElementById('srch_btn');

let currentRoomsAmount = 0;
let lastRoomNumber = 0;
let roomsArray = [];
let guestsArray = [];

function actualize_guests_filed () {
    let guests_total = 0;
    let rooms_total = 0;
    for (let i = 0; i < guestsArray.length; i++) {
        if (guestsArray[i] !== 0) {
            guests_total += guestsArray[i];
            rooms_total++;
        }
    }
    guests_field.value = guests_total + ' guests, ' + rooms_total + ' room' + (rooms_total > 1 ? 's' : '');
}

guests_field.onclick = function() {
    if (dropdown.style.display === "none") {
        dropdown.style.display = "block";
    } else {
        dropdown.style.display = "none";
    }
}

done_btn.onclick = function() {
    srch_btn.click();
}

add_btn.onclick = function () {
    add_new_room_row();
    actualize_guests_filed();
}

function add_new_room_row() {
    if (lastRoomNumber < 6) {
        lastRoomNumber++;
        createRoomRow(currentRoomsAmount++);
    }
}

srch_btn.onclick = function() {
    let guests_in_request = '';
    for (let i = 0; i < guestsArray.length; i++) {
        if (guestsArray[i] !== 0) {
            guests_in_request += guestsArray[i];
        }
    }
    guests_field_hidden.value = guests_in_request;
    srch_btn.type = 'submit';
}

function createRoomRow(number) {
    const div = document.createElement('div');
    div.innerHTML = `
                <div id="room_row_` + number + `">
                    <div id="room_header">
                        <div id="room_number_` + number + `">Room ` + lastRoomNumber + `</div>
                        <button class="close" id="room_close_` + number + `" type="button"
                            onclick="close_onclick(` + number + `)" 
                        >&#x2715</button>
                    </div>
                    <div id="room_selector">
                        <div>Guests</div>
                        <div id="amount_changer">
                            <button class="minus" id="minus_sign_` + number + `" type="button"
                                onclick="minus_onclick(
                                    ` + number + `,
                                    document.getElementById('digit_` + number + `'),
                                    document.getElementById('minus_sign_` + number + `'),
                                    document.getElementById('plus_sign_` + number + `')
                                )"                
                            >&#x2013</button>

                            <div class="digit" id="digit_` + number + `">1</div>

                            <button class="plus" id="plus_sign_` + number + `" type="button" 
                                onclick="plus_onclick(
                                    ` + number + `,
                                    document.getElementById('digit_` + number + `'),
                                    document.getElementById('minus_sign_` + number + `'),
                                    document.getElementById('plus_sign_` + number + `')
                                )"
                            >&#x002B</button>
                        </div>
                    </div>
                </div>`;
    room_content.appendChild(div);
    roomsArray[number] = div;
    guestsArray[number] = 1;
}

function plus_onclick(number, digit, minus, plus) {
    minus.style.opacity = '1.0';
    let value =  digit.textContent;
    value++;
    if (value < 4) {
        digit.textContent = value;
        guestsArray[number]++;
        if (value === 3) {
            plus.style.opacity = '0.6';
        }
    }
    actualize_guests_filed();
}

function minus_onclick(number, digit, minus, plus) {
    plus.style.opacity = '1.0';
    let value = digit.textContent;
    value--;
    if (value > 0) {
        digit.textContent = value;
        guestsArray[number]--;
        if (value === 1) {
            minus.style.opacity = '0.6';
        }
    }
    actualize_guests_filed();
}

function close_onclick(number) {
    if (number > 0) {
        lastRoomNumber--;
        room_content.removeChild(roomsArray[number]);
        roomsArray[number] = 0;
        guestsArray[number] = 0;

        for (let i = 0; i < roomsArray.length; i++) {
            if (i > number) {
                try {
                    let b = document.getElementById('room_number_' + i);
                    let text = b.textContent;
                    let new_number = b.textContent.charAt(text.length - 1) - 1;
                    b.textContent = 'Room ' + new_number;
                } catch (err) {
                }
            }
        }
    }
    actualize_guests_filed();
}

document.onreadystatechange = function() {
    if (document.readyState === "complete") {
        dropdown.style.display = "none"
        activateRoomFromRequest();
    }
}

function activateRoomFromRequest() {
    const guestsInRooms = getGuestsInRoomsParameterFromRequest();
    const array = Array.from(guestsInRooms);

    for (let i = 0; i < array.length; i++) {
        add_new_room_row();
        const plus_button = document.getElementById('plus_sign_' + i);
        for (let j = 1; j < array[i]; j++) {
            plus_button.click();
        }
    }
    actualize_guests_filed();
}

function getGuestsInRoomsParameterFromRequest() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    return urlParams.get('guestsInRooms');
}