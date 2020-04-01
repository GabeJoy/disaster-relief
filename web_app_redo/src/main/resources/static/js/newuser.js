 function checkFields(form){
        if (form.first.value === '' || form.last.value === '' || form.user.value === '' || form.password1.value === '' || form.password2.value === '' || form.email.value === ''){
            alert("Required field missing!");
            return false;
        } else {
            return true;
        }
    }
function checkPasswords(form){
    if ((form.password1.value !== form.password2.value)){
        alert("Passwords don't match!");
        return false;
    } else {
        return true;
    }
}