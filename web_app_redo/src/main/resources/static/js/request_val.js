function checkFields(form){
    if (form.item.value === '' || form.reason.value === ''){
        alert("Required field missing!");
        return false;
    } else {
        return true;
    }
}