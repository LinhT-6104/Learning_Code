
document.addEventListener('DOMContentLoaded', function() {
    // thanh tìm kiếm
    const searchIcon = document.getElementById('icon');
    const searchBar = document.getElementById('search');

    searchIcon.addEventListener('click', function() {
        const isSearchBarVisible = searchBar.style.display === 'flex';
        searchBar.style.display = isSearchBarVisible ? 'none' : 'flex';
    });
    searchIcon.addEventListener('click', function() {
        searchPosts();
    });

    searchBar.addEventListener('keyup', function(event) {
        if (event.key === 'Enter') {
            searchPosts();
        }
    });
    const dateDisplay = document.getElementById('date');
    // ngày tháng
    dateDate(dateDisplay);
    haveuser()
    isAdmin()
    
    hienthimoinhat()

    let news = document.getElementById("newtin")
    let old = document.getElementById("old")
    let all = document.getElementById("all")
    all.addEventListener('click',function () {
        hienthitatca()
    })
    news.addEventListener('click',function () {
        hienthimoinhat()
    })
    old.addEventListener('click',function () {
        hienthicunhat()
    })

    let dangxuat = document.getElementById("logoutBt")
    dangxuat.addEventListener('click',function () {
        localStorage.removeItem('nguoihoatdong');
        window.location.href='../index.html';
    })
});

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
        out.style.display = "none"
    }
    else{
        if (nguoihoatdong.tennguoidung != "admin123"){
            quanli.style.display = "none"
            trangduyet.style.display = "none"
        }
    }
}

// lấy ngày tháng
function dateDate(dateDisplay) {
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

// save và down bài đăng
function down_local_baidang(){
    danhsachbaidang = JSON.parse(localStorage.getItem('baidang')) || []
    return danhsachbaidang
}

function save_local_baidang(danhsachbaidang){
    localStorage.setItem('baidang',JSON.stringify(danhsachbaidang))
}



// hiển thị bài đăng
function hienthi() {
    let  danhsachbaidang = down_local_baidang()
    let news = document.getElementById("news")
    news.innerHTML = ""
    danhsachbaidang.forEach((baidang,index) => {
        
        let khoi = document.createElement("div")
        let anh = document.createElement("img")
        let tieude = document.createElement("span")
        khoi.className = "khoi"
        khoi.id= `khoi${index}`
        khoi.onclick = function () {
            xem(index)
        }
        anh.src = baidang.anh
        tieude.innerHTML= baidang.tieude

        news.appendChild(khoi)
        khoi.appendChild(anh)
        khoi.appendChild(tieude)
    });
}

function xem(i) {
    localStorage.setItem('baidangchuyenhuong',i)
    window.location.href = "../html/tus.html"
}

// hiển thị bài đăng
function hienthitatca() {
    let  danhsachbaidang = down_local_baidang()
    let news = document.getElementById("news")
    let tintuc = document.getElementById("tintuc")
    tintuc.innerHTML = "Tin tức tất cả bài đăng "
    news.innerHTML = ""
    danhsachbaidang.forEach((baidang,index) => {
        if(danhsachbaidang[index].trangthai == "Đã duyệt"){
            let khoi = themkhoi(baidang,index)
            news.appendChild(khoi)
        }
    });
}

function hienthicunhat() {
    let danhsachbaidang = down_local_baidang();
    let news = document.getElementById("news");
    let tintuc = document.getElementById("tintuc")
    tintuc.innerHTML = "Tin tức bài đăng cũ nhất"
    news.innerHTML = "";
    let a = 1;

    for (let index = 0; index < danhsachbaidang.length; index++) {
        if (a <= 10 && danhsachbaidang[index].trangthai == "Đã duyệt") {
            let baidang = danhsachbaidang[index];
            let khoi = themkhoi(baidang,index)
            news.appendChild(khoi)
            a++;
        }
    }
}
function hienthimoinhat(){
    let danhsachbaidang = down_local_baidang();
    let news = document.getElementById("news");
    let tintuc = document.getElementById("tintuc")
    tintuc.innerHTML = "Tin tức bài đăng mới nhất"
    news.innerHTML = "";
    let a = 1;

    for (let index = danhsachbaidang.length - 1; index >= 0; index--) {
        if (a <= 10 && danhsachbaidang[index].trangthai == "Đã duyệt") {
            let baidang = danhsachbaidang[index];
            let khoi = themkhoi(baidang,index)
            news.appendChild(khoi)
            a++;
        }
    }
}
function themkhoi(baidang,index){
    let khoi = document.createElement("div")
    khoi.style.display = "flex"

    let anh = document.createElement("img")
    anh.style.height = "200px"

    let khoitieude = document.createElement("span")
    let tieude = document.createElement("h3")
    let mota = document.createElement("div")
    tieude.innerHTML = baidang.tieude
    mota.innerHTML = baidang.mota
    khoitieude.appendChild(tieude)
    khoitieude.appendChild(mota)
    tieude.onclick = function () {
        xem(index)
    }
    anh.src = baidang.anh
    khoi.style.margin = "20px"

    khoi.appendChild(anh)
    khoi.appendChild(khoitieude)

    return khoi
}
function searchPosts() {
    let searchBar = document.getElementById('search');
    let searchTerm = searchBar.value.toLowerCase();
    let danhsachbaidang = down_local_baidang();
    let news = document.getElementById("news");
    let tintuc = document.getElementById("tintuc");

    tintuc.innerHTML = "Kết quả tìm kiếm";
    news.innerHTML = "";

    danhsachbaidang.forEach((baidang, index) => {
        if ((baidang.trangthai === "Đã duyệt" && baidang.tieude.toLowerCase().includes(searchTerm)) || (baidang.trangthai === "Đã duyệt" && baidang.noidung.toLowerCase().includes(searchTerm))) {
            let khoi = themkhoi(baidang, index);
            news.appendChild(khoi);
        }
    });
}

