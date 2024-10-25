function haveuser(){
    //Lấy thông tin đăng nhập
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    //nếu không tồn tại người dùng thì quay về đăng
    if (!nguoihoatdong){
        window.location.href='dangnhap.html';
    }
}

// lấy ngày tháng
function dateDate() {
    
    const now = new Date();
    const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];
    const dayName = days[now.getDay()];
    const day = now.getDate();
    const month = now.getMonth() + 1;
    const year = now.getFullYear();
    return `${dayName}, ${day}/${month}/${year}`
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
        out.style.display = "none"
    }
    else{
        if (nguoihoatdong.tennguoidung != "admin123"){
            quanli.style.display = "none"
            trangduyet.style.display = "none"
        }
    }
}

//điều chỉnh thanh menu theo width
function toggleMenu() {
    const menu = document.getElementById('menu');
    menu.classList.toggle('show');
}

document.addEventListener('DOMContentLoaded', function() {
    // ngày tháng
    const dateDisplay = document.getElementById('date');
    dateDisplay.textContent = dateDate();
    haveuser()
    isAdmin()
    let dangxuat = document.getElementById("logoutBt")
    dangxuat.addEventListener('click',function () {
        localStorage.removeItem('nguoihoatdong');
        window.location.href='../index.html';
    })
    let hienformthem = document.getElementById("hienformthem")
    hienformthem.addEventListener('click',function () {
        let postform = document.getElementById("post-form")
        const isSearchBarVisible = postform.style.display === 'block'
        postform.style.display = isSearchBarVisible ? 'none' : 'block'
    })
});


function dangbai(){
    let tieude = document.getElementById("title").value
    let anh = document.getElementById("anhnoibat").files[0]
    let mota = document.getElementById("describe").value
    let noidung = document.getElementById("content").value
    let nguoidung = JSON.parse(localStorage.getItem('nguoihoatdong'))
    let nguoidang = nguoidung.tennguoidung

    if (!anh || tieude.trim() == ""  || mota.trim() == "" || noidung.trim() == "") { 
        alert("Vui lòng điền đầy đủ thông tin.")
        return
    }

    let readFile = new FileReader()
    readFile.onload = function (e) {
        const base64String = e.target.result;
        let danhsachbaidang = JSON.parse(localStorage.getItem('baidang')) || []

        let baidang = {
            tieude : tieude,
            mota: mota,
            anh : base64String,
            noidung : noidung,
            nguoidang : nguoidang,
            thoigian : dateDate(),
            like : [],
            trangthai : "Chờ duyệt",
            comment : []

        }

        danhsachbaidang.push(baidang)
        localStorage.setItem('baidang',JSON.stringify(danhsachbaidang))
        themhang()
    }
    readFile.onerror = function (error) {
        console.log('Error: ', error);
        alert("Có lỗi xảy ra khi đọc file ảnh.");
    };
    // Chuyển đổi ảnh sang base64
    readFile.readAsDataURL(anh);
    alert('Gửi bài đăng thành công, đang trong trạng thái chờ duyệt')
}

document.getElementById('anhnoibat').addEventListener('change', function(e) {
    const file = e.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imagePreview = document.getElementById('hienthianh');
            imagePreview.src = e.target.result;
            imagePreview.style.display = 'block';
        };
        reader.readAsDataURL(file);
    }
});
document.getElementById('re_anhnoibat').addEventListener('change', function(e) {
    const file = e.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imagePreview = document.getElementById('re_hienthianh');
            imagePreview.src = e.target.result;
            imagePreview.style.display = 'block';
        };
        reader.readAsDataURL(file);
    }
});

function down_local_baidang(){
    danhsachnguoidung = JSON.parse(localStorage.getItem('baidang')) || []
    return danhsachnguoidung
}

function save_local_baidang(danhsachbaidang){
    localStorage.setItem('baidang',JSON.stringify(danhsachbaidang))
}



function themhang(){
    let danhsachbaidang = down_local_baidang()
    let nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'))
    let table = document.getElementById("bangthem")
    table.innerHTML = "";
    var a = 1
    danhsachbaidang.forEach((baidang, index) => {
        if (baidang.nguoidang === nguoihoatdong.tennguoidung){
            let row = table.insertRow();

            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            let cell5 = row.insertCell(4);
            let cell6 = row.insertCell(5);

            cell1.innerHTML = a ;
            cell2.innerHTML = baidang.tieude;
            cell3.innerHTML = baidang.noidung;
            cell3.style.width = "700px"
            cell4.innerHTML = baidang.thoigian;
            cell5.innerHTML = baidang.trangthai;
            cell6.innerHTML = `<button id="sua" onclick="formsua(${index})">Sửa</button>`
            a++ 
        } 
})
}
window.onload = themhang

// save và down người dùng
function down_local_user(){
    danhsachnguoidung = JSON.parse(localStorage.getItem('nguoidung')) || []
    return danhsachnguoidung
}

function save_local_user(danhsachnguoidung){
    localStorage.setItem('nguoidung',JSON.stringify(danhsachnguoidung))
}

function formsua(i) {
    const formsua = document.getElementById('sua-form');
    const isSearchBarVisible = formsua.style.display === 'block';
    formsua.style.display = isSearchBarVisible ? 'none' : 'block';

    let danhsachbaidang = down_local_baidang()
    
    let tieude = document.getElementById("re_title")
    let anh = document.getElementById("re_hienthianh")
    let mota = document.getElementById("re_describe")
    let noidung = document.getElementById("re_content")
    tieude.value = danhsachbaidang[i].tieude
    anh.src = danhsachbaidang[i].anh
    mota.value = danhsachbaidang[i].mota
    noidung.value = danhsachbaidang[i].noidung
    const btnsua = document.getElementById('btnsua');
    btnsua.onclick = function (){
        suabaidang(i)
    }
}

function suabaidang(i){
    let tieude = document.getElementById("re_title").value
    let anh = document.getElementById("re_anhnoibat").files[0]
    let mota = document.getElementById("re_describe").value
    let noidung = document.getElementById("re_content").value
    let nguoidung = JSON.parse(localStorage.getItem('nguoihoatdong'))
    let nguoidang = nguoidung.tennguoidung

    if (!anh || tieude.trim() == ""  || mota.trim() == "" || noidung.trim() == "") { 
        alert("Vui lòng điền đầy đủ thông tin.")
        return
    }

    let readFile = new FileReader()
    readFile.onload = function (e) {
        const base64String = e.target.result;
        let danhsachbaidang = JSON.parse(localStorage.getItem('baidang')) || []

        let baidang = {
            tieude : tieude,
            mota: mota,
            anh : base64String,
            noidung : noidung,
            nguoidang : nguoidang,
            thoigian : dateDate(),
            like : [],
            trangthai : "Chờ duyệt",
            comment : []

        }

        danhsachbaidang[i] = baidang
        localStorage.setItem('baidang',JSON.stringify(danhsachbaidang))
        themhang()
    }
    readFile.onerror = function (error) {
        console.log('Error: ', error);
        alert("Có lỗi xảy ra khi đọc file ảnh.");
    };
    // Chuyển đổi ảnh sang base64
    readFile.readAsDataURL(anh);
    
    alert('Gửi bài đăng thành công, đang trong trạng thái chờ duyệt')
}

function xem(i) {
    localStorage.setItem('baidangchuyenhuong',i)
    window.location.href = "tus.html"
}