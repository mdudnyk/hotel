config_start = {
    dateFormat: "Y-m-d",
    altInput: true,
 
    altFormat: "D, j M Y",
    minDate: "today",
    maxDate: new Date().fp_incr(90),
    monthSelectorType: "static",
    onChange: changeEndDate
}

function changeEndDate() {
    let date = new Date(startDate.selectedDates[0]);
    endDate.config.minDate = date.fp_incr(1);

    if (endDate.selectedDates.length == 0) {
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
    onChange: changeStartDate
}

function changeStartDate() {
    let date = new Date(endDate.selectedDates);
    startDate.config.maxDate = date.fp_incr(-1);
    
    if (startDate.selectedDates.length == 0) {
        startDate.open();
    } else {
        search_button.type = "submit";
    }
}

const endDate = flatpickr(".content__end-date-field", config_end);



const search_button = document.querySelector(".content__search-button");
const startD = document.querySelector(".content__start-date-field.form-control.input");
const endD = document.querySelector(".content__end-date-field.form-control.input");

search_button.type = "button";

search_button.addEventListener('mouseover', (e) => {
    if (startDate.selectedDates.length == 0) {
        startD.style.animation="shake 0.2s ease-in 0.3s 20";
    }
    if (endDate.selectedDates.length == 0) {
      endD.style.animation="shake 0.2s ease-in 0.3s 20";
    }
});

search_button.addEventListener('mouseout', (e) => {
    startD.style.animation="none";
    endD.style.animation="none";
});
