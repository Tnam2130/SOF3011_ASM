$('#newPass').keyup(function () {
    if ($('#currentPass').val() === "") {
        $('#newPass').val("")
        $('#currentPass').focus()
        Swal.fire({
            position: 'top',
            icon: 'info',
            text: 'Please enter Your current password first!',
        })
    }
})

$('#confPass').keyup(function () {
    if ($('#currentPass').val() === "") {
        $('#confPass').val("")
        $('#currentPass').focus()
        Swal.fire({
            position: 'top',
            icon: 'info',
            text: 'Please enter Your current password first!',
        })
    } else if ($('#newPass').val() === "") {
        $('#confPass').val("")
        $('#newPass').focus()
        Swal.fire({
            position: 'top',
            icon: 'info',
            text: 'Please enter Your new password first!',
        })
    }
})

$('#changeBtn').click(function () {
    if ($('#currentPass').val() !== "" && $('#confPass').val() !== "" && $('#newPass').val() !== "") {
        if ($('#confPass').val() === $('#newPass').val()) {
            var newPass = $('#newPass').val();
            var currentPass = $('#currentPass').val();
            var formData = {
                'CurrentPass': currentPass,
                'NewPass': newPass
            };
            $.ajax({
                url: 'changePass',
                type: 'POST',
                data: formData
            }).then(function () {
                Swal.fire({
                    position: 'top',
                    icon: 'success',
                    text: 'Change password successfully',
                })
            }).fail(function () {
                $('#currentPass').val("")
                $('#currentPass').focus()
                Swal.fire({
                    position: 'top',
                    icon: 'error',
                    text: 'Wrong current password!',
                })
                // alert("error")
            })
        } else {
            $('#confPass').val("")
            $('#confPass').focus()
            Swal.fire({
                position: 'top',
                icon: 'info',
                text: 'Your confirm password is not match the new password field!',
            })
        }

    } else {
        if ($('#currentPass').val() === "") {
            $('#currentPass').focus()
            Swal.fire({
                position: 'top',
                icon: 'info',
                text: 'Please enter Your current password!',
            })
        } else if ($('#newPass').val() === "") {
            $('#newPass').focus()
            Swal.fire({
                position: 'top',
                icon: 'info',
                text: 'Please enter Your new password!',
            })
        } else if ($('#confPass').val() === "") {
            $('#confPass').focus()
            Swal.fire({
                position: 'top',
                icon: 'info',
                text: 'Please enter Your Confirm password!',
            })
        }
    }

})