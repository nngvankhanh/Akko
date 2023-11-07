function login() {
    //lay du lieu
    let email = $('#email').val();
    let password = $('#password').val();
    let login = {
        email: email,
        password: password,
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(login),
        //tên API
        url: "/seller/login",
        //xử lý khi thành công
        success: function (response){
            // dashboard();
            console.log("success");
        }

    });
    //chặn sự kiện mặc định của thẻ
    // event.preventDefault();
}
function register() {
    //lay du lieu
    let email = $('#email').val();
    let password = $('#password').val();
    let confirmPassword = $('#confirmPassword').val();
    let register = {
        email: email,
        password: password,
        confirmPassword: confirmPassword,
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(register),
        //tên API
        url: "/seller/register",
        //xử lý khi thành công
        success: function (response){
            // dashboard();
            console.log("success");
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}
// function dashboard(){
//     // let request = {};
//     $.ajax({
//         // headers: {
//         //     'Accept': 'application/json',
//         //     'Content-Type': 'application/json'
//         // },
//         type: "GET",
//         // data: JSON.stringify(request),
//         //tên API
//         url: "/seller",
//         //xử lý khi thành công
//         success: function (response){
//             console.log("success");
//         }
//
//     });
//     //chặn sự kiện mặc định của thẻ
//     event.preventDefault();
// }