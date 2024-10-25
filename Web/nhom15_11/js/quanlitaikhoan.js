function haveuser(){
    //Lấy thông tin đăng nhập
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    //nếu không tồn tại người dùng thì quay về đăng
    if (!nguoihoatdong){
        window.location.href='dangnhap.html';
    }
}

// Kiểm tra kiểu người dùng
function isAdmin() {
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
        inb.style.display = "none"
    }
    else{
        if (nguoihoatdong.tennguoidung != "admin123"){
            quanli.style.display = "none"
            trangduyet.style.display = "none"
            out.style.display = "none"
        }
    }
}

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
    menu.classList.toggle('show');
}

document.addEventListener('DOMContentLoaded', function() {
    // ngày tháng
    dateDate();
    haveuser()
    isAdmin()
    
    // thêm tài khoản
    const themtaikhoan = document.getElementById('themtaikhoan');
    const formthem = document.getElementById('formthem');
    themtaikhoan.addEventListener('click', function() {
        const isSearchBarVisible = formthem.style.display === 'block';
        formthem.style.display = isSearchBarVisible ? 'none' : 'block';
    });

    let dangxuat = document.getElementById("logoutBt")
    dangxuat.addEventListener('click',function () {
        localStorage.removeItem('nguoihoatdong');
        window.location.href='../index.html';
    })
});
// save và down người dùng
function down_local_user(){
    danhsachnguoidung = JSON.parse(localStorage.getItem('nguoidung')) || []
    return danhsachnguoidung
}

function save_local_user(danhsachnguoidung){
    localStorage.setItem('nguoidung',JSON.stringify(danhsachnguoidung))
}

function themhang(){
    let danhsachnguoidung = down_local_user()
    let table = document.getElementById("bangthem")
    table.innerHTML = "";
    let a = 1
    danhsachnguoidung.forEach((nguoidung, index) => {
        let row = table.insertRow();

        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);

        cell1.innerHTML = a
        cell2.innerHTML = nguoidung.tennguoidung
        cell3.innerHTML = nguoidung.matkhau
        cell4.innerHTML =`<button id="showsua" onclick="hienthiformsua(${index})">Sửa</button> 
                        <button id="xoa" onclick="xoa(${index})">Xóa</button>`
        a++ 
    
})
}


window.onload = themhang

function hienthiformsua(i) {
    const formsua = document.getElementById('formsua');
    const isSearchBarVisible = formsua.style.display === 'block';
    formsua.style.display = isSearchBarVisible ? 'none' : 'block';

    let danhsachnguoidung = down_local_user()
    
    let namelogin = document.getElementById("renamelogin")
    let pass = document.getElementById("repassword")
    namelogin.value = danhsachnguoidung[i].tennguoidung
    pass.value = danhsachnguoidung[i].matkhau

    const btnsua = document.getElementById('btnsua');
    btnsua.onclick = function (){
        suanguoidung(i)
    }
}

function suanguoidung(i) {
    let renamelogin = document.getElementById("renamelogin").value
    let repass = document.getElementById("repassword").value
    let danhsachnguoidung = down_local_user()
    danhsachnguoidung[i].tennguoidung = renamelogin
    danhsachnguoidung[i].matkhau = repass
    save_local_user(danhsachnguoidung)

    themhang()
}

function xoa(i){
    let danhsachnguoidung = down_local_user()
    danhsachnguoidung.splice(i,1)
    save_local_user(danhsachnguoidung)
    themhang()
}

function kiemtradangky(){
    
    let name = document.getElementById("namelogin").value
    let pass = document.getElementById("password").value

    let danhsachnguoidung = down_local_user()

    if (name.trim() == "" || pass.trim() == "" ){
        alert('Vui lòng điền đầy đủ thông tin')
        return
    }
    else if (!(name.length >= 6) || name.trim().includes(" ")){
        alert('Tên người dùng phải có ít nhất 6 ký tự không dấu không cách')
        return
    }
    else if (!(pass.length >=8 ) || pass.trim().includes(" ")){
        alert ('Mật khẩu phải có độ dài ít nhất 8 ký tự không dấu không cách')
        return
    }
    else{
        tendatontai = false
        for (let index = 0; index < danhsachnguoidung.length; index++) {
            if (name === danhsachnguoidung[index].tennguoidung){
                tendatontai = true
            }
        }

        if (tendatontai){
            alert ('Tên tài khoản đã tồn tại vui lòng nhập tên khác')
            return
        }
        let nguoidung = {
            tennguoidung : name,
            matkhau : pass
        }

        danhsachnguoidung.push(nguoidung)
        save_local_user(danhsachnguoidung)
        alert("Đăng ký thành công")
        themhang()
}
}