

document.addEventListener('DOMContentLoaded', function() {
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    
    let trangduyet = document.getElementById("trangduyet")
    let trangdang = document.getElementById("trangdang")
    let quanli = document.getElementById("quanli")
    let out = document.getElementById("logoutBt")
    let inb = document.getElementById("loginBt")
    if (!nguoihoatdong){
        quanli.style.display = "none"
        trangduyet.style.display = "none"
        trangdang.style.display = "none"
        out.style.display = "none"
    }
    else{
        if (nguoihoatdong.tennguoidung != "admin123"){
            quanli.style.display = "none"
            trangduyet.style.display = "none"
        }
        inb.style.display = "none"
    }
    // ngày tháng
    dateDate();
    // đăng xuất
    let dangxuat = document.getElementById("logoutBt")
    dangxuat.addEventListener('click',function () {
        localStorage.removeItem('nguoihoatdong');
        window.location.href='../index.html';
    })
});

// lấy ngày tháng
function dateDate() {
    const dateDisplay = document.getElementById('date');
    const now = new Date();
    const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];
    const dayName = days[now.getDay()];
    const day = now.getDate();
    const month = now.getMonth() + 1;
    const year = now.getFullYear();

    dateDisplay.textContent = `${dayName}, ${day}/${month}/${year}`;
}

//điều chỉnh thanh menu theo width
function toggleMenu() {
    const menu = document.getElementById('menu');
    menu.classList.toggle('active');
}
