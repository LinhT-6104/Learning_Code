document.addEventListener('DOMContentLoaded', function() {
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    if (nguoihoatdong){
        window.location.href = "html/trangchu.html";
    }
    // Thanh tìm kiếm
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
    // Ngày tháng
    dateDate(dateDisplay);
    hienthimoinhat();

    let news = document.getElementById("newtin");
    let old = document.getElementById("old");
    let all = document.getElementById("all");

    all.addEventListener('click', function() {
        hienthitatca();
    });

    news.addEventListener('click', function() {
        hienthimoinhat();
    });

    old.addEventListener('click', function() {
        hienthicunhat();
    });

   
    Themkhoi2();
});

function dateDate(dateDisplay) {
    const now = new Date();
    const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];
    const dayName = days[now.getDay()];
    const day = now.getDate();
    const month = now.getMonth() + 1;
    const year = now.getFullYear();

    dateDisplay.textContent = `${dayName}, ${day}/${month}/${year}`;
}

function toggleMenu() {
    const menu = document.getElementById('menu');
    menu.classList.toggle('active');
}

function down_local_baidang() {
    return JSON.parse(localStorage.getItem('baidang')) || [];
}

function save_local_baidang(danhsachbaidang) {
    localStorage.setItem('baidang', JSON.stringify(danhsachbaidang));
}

function xem(i) {
    localStorage.setItem('baidangchuyenhuong', i);
    window.location.href = "html/tus.html";
}

function hienthitatca() {
    let danhsachbaidang = down_local_baidang();
    let news = document.getElementById("news");
    let tintuc = document.getElementById("tintuc");
    tintuc.innerHTML = "Tin tức tất cả bài đăng";
    news.innerHTML = "";

    danhsachbaidang.forEach((baidang, index) => {
        if (baidang.trangthai === "Đã duyệt") {
            let khoi = themkhoi(baidang, index);
            news.appendChild(khoi);
        }
    });
}

function hienthicunhat() {
    let danhsachbaidang = down_local_baidang();
    let news = document.getElementById("news");
    let tintuc = document.getElementById("tintuc");
    tintuc.innerHTML = "Tin tức bài đăng cũ nhất";
    news.innerHTML = "";
    let a = 1;

    for (let index = 0; index < danhsachbaidang.length; index++) {
        if (a <= 10 && danhsachbaidang[index].trangthai === "Đã duyệt") {
            let baidang = danhsachbaidang[index];
            let khoi = themkhoi(baidang, index);
            news.appendChild(khoi);
            a++;
        }
    }
}

function hienthimoinhat() {
    let danhsachbaidang = down_local_baidang();
    let news = document.getElementById("news");
    let tintuc = document.getElementById("tintuc");
    tintuc.innerHTML = "Tin tức bài đăng mới nhất";
    news.innerHTML = "";
    let a = 1;

    for (let index = danhsachbaidang.length - 1; index >= 0; index--) {
        if (a <= 10 && danhsachbaidang[index].trangthai === "Đã duyệt") {
            let baidang = danhsachbaidang[index];
            let khoi = themkhoi(baidang, index);
            news.appendChild(khoi);
            a++;
        }
    }
}

function themkhoi(baidang, index) {
    let khoi = document.createElement("div");
    khoi.style.display = "flex";
    khoi.style.margin = "20px";

    let anh = document.createElement("img");
    anh.style.height = "200px";
    anh.style.width = "300px";
    anh.src = baidang.anh;

    let khoitieude = document.createElement("span");

    let tieude = document.createElement("h3");
    tieude.innerHTML = baidang.tieude;
    tieude.onclick = function() {
        xem(index);
    };

    let mota = document.createElement("div");
    mota.innerHTML = baidang.mota;

    khoitieude.appendChild(tieude);
    khoitieude.appendChild(mota);

    khoi.appendChild(anh);
    khoi.appendChild(khoitieude);

    return khoi;
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


function Themkhoi2() {
    let danhsachbaidang = down_local_baidang();
    let verMenu = document.getElementById("ver-menu");
    verMenu.innerHTML = "";

    danhsachbaidang.forEach((baidang, index) => {
        if (baidang.trangthai === "Đã duyệt") {
            let post = document.createElement("div");
            post.className = "post";
            post.onclick = function() {
                xem(index);
            };

            let img = document.createElement("img");
            img.src = baidang.anh;

            let title = document.createElement("p");
            title.innerHTML = baidang.tieude;

            post.appendChild(img);
            post.appendChild(title);
            verMenu.appendChild(post);
            
        }
    });
}
