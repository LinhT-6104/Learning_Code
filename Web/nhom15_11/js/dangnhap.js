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

// thêm sự kiện enter cho nút đăng nhập 
const butname = document.getElementById('namelogin');
const butpass = document.getElementById('password');

function funcenter(event){
    if(event.key === 'Enter'){
        kiemtradangnhap();
    }
}
butname.addEventListener('keyup', funcenter);
butpass.addEventListener('keyup',funcenter);


// save và down người dùng
function down_local_user(){
    danhsachnguoidung = JSON.parse(localStorage.getItem('nguoidung')) || []
    return danhsachnguoidung
}

function save_local_user(danhsachnguoidung){
    localStorage.setItem('nguoidung',JSON.stringify(danhsachnguoidung))
}

// xử lý form đăng nhập
function kiemtradangnhap(){
    namelogin = document.getElementById("namelogin").value
    pass = document.getElementById("password").value
    danhsachnguoidung = down_local_user()
    let nguoidung = {
        tennguoidung : namelogin,
        matkhau : pass
    }
    if (nguoidung.tennguoidung === 'admin123' && nguoidung.matkhau === 'admin123'){
        localStorage.setItem('nguoihoatdong',JSON.stringify(nguoidung))
        alert('Quản trị viên đăng nhập thành công!');
        console.log('Chuyển hướng đến trang chủ cho quản trị viên');
        window.location.href = 'trangchu.html';
    }
    else{
        let ktra = false
        for (let index = 0; index < danhsachnguoidung.length; index++) {
            if (namelogin === danhsachnguoidung[index].tennguoidung && pass === danhsachnguoidung[index].matkhau){
                    localStorage.setItem('nguoihoatdong',JSON.stringify(danhsachnguoidung[index]))
                    alert("Đăng nhập thành công")
                    console.log('Chuyển hướng đến trang chủ cho quản trị viên');
                    window.location.href = "trangchu.html"
                    ktra = true
                }
        }
        if (ktra === false){
            alert('Kiểm tra lại tên người dùng và mật khẩu')
            return
        }
    }
}


