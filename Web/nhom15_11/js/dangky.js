document.addEventListener('DOMContentLoaded', function() {
    
    const dateDisplay = document.getElementById('date');


    function updateDate() {
        const now = new Date();
        const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];
        const dayName = days[now.getDay()];
        const day = now.getDate();
        const month = now.getMonth() + 1;
        const year = now.getFullYear();

        dateDisplay.textContent = `${dayName}, ${day}/${month}/${year}`;
    }

    updateDate(); 
});

// Điều chỉnh thanh menu theo width
function toggleMenu() {
    const menu = document.getElementById('menu');
    menu.classList.toggle('active');
}
// save và down người dùng
function down_local_user(){
    danhsachnguoidung = JSON.parse(localStorage.getItem('nguoidung')) || []
    return danhsachnguoidung
}

function save_local_user(danhsachnguoidung){
    localStorage.setItem('nguoidung',JSON.stringify(danhsachnguoidung))
}
//thêm sự kiện enter cho form
const rename = document.getElementById("fullname");
const pass = document.getElementById("register-password");
const repassword = document.getElementById("re-register-password");

function repass(event){
    if(event.key === 'Enter'){
        kiemtradangky();
    }
}
        rename.addEventListener('keyup', repass);
        pass.addEventListener('keyup', repass);
        repassword.addEventListener('keyup', repass);


// xử lý form đăng ký
function kiemtradangky(){
    let namesignin = document.getElementById("fullname").value
    let pass1 = document.getElementById("register-password").value
    let pass2 = document.getElementById("re-register-password").value

    let danhsachnguoidung = down_local_user()

    if (namesignin.trim() == "" || pass1.trim() == "" || pass2.trim() == ""){
        alert('Vui lòng điền đầy đủ thông tin')
        return
    }
    else if (!(namesignin.length >= 6) || namesignin.trim().includes(" ")){
        alert('Tên người dùng phải có ít nhất 6 ký tự không dấu không cách')
        return
    }
    else if (!(pass1.length >=8 ) || pass1.trim().includes(" ")){
        alert ('Mật khẩu phải có độ dài ít nhất 8 ký tự không dấu không cách')
        return
    }
    else if (pass1 != pass2){
        alert ('Mật khẩu chưa trùng khớp vui lòng nhập lại')
        return
    }
    else{
        tendatontai = false
        for (let index = 0; index < danhsachnguoidung.length; index++) {
            if (namesignin === danhsachnguoidung[index].tennguoidung){
                tendatontai = true
            }
        }

        if (tendatontai){
            alert ('Tên tài khoản đã tồn tại vui lòng nhập tên khác')
            return
        }
        let nguoidung = {
            tennguoidung : namesignin,
            matkhau : pass1
        }

        danhsachnguoidung.push(nguoidung)
        save_local_user(danhsachnguoidung)
        alert("Đăng ký thành công")
        window.location.href = "dangnhap.html"
}

}