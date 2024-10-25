function toggleMenu() {
    const menu = document.getElementById('menu')
    menu.classList.toggle('show')
}

document.addEventListener('DOMContentLoaded', function() {
    
    // cập nhật ngày tháng
    function updateDate() {
        const dateDisplay = document.getElementById('date')
        const now = new Date()
        const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy']
        const dayName = days[now.getDay()]
        const day = now.getDate()
        const month = now.getMonth() + 1
        const year = now.getFullYear() 

        dateDisplay.textContent = `${dayName}, ${day}/${month}/${year}`
    }
    updateDate();
    
    // đăng xuất
    let dangxuat = document.getElementById("logoutBt")
    dangxuat.addEventListener('click',function () {
        localStorage.removeItem('nguoihoatdong')
        window.location.href='../index.html'
    })

    // quản lí hiện
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'))
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

    // hiện bài đăng 
    let danhsachbaidang = down_local_baidang()
    let i = JSON.parse(localStorage.getItem('baidangchuyenhuong'))
    let tieude = document.getElementById("tieude")
    let hinhanh = document.getElementById("hinhanh")
    let noidung = document.getElementById("noidung")
    let ngaydang = document.getElementById("ngaydang")
    tieude.innerHTML = danhsachbaidang[i].tieude
    hinhanh.src = danhsachbaidang[i].anh
    noidung.innerHTML = danhsachbaidang[i].noidung
    ngaydang.innerHTML = danhsachbaidang[i].thoigian

    // hiện like
    let like = document.getElementById("like")
    like.innerHTML = danhsachbaidang[i].like.length
    let btnlike = document.getElementById("likeButton");
    quanlilike()
    hienthilike()
    btnlike.addEventListener('click',function () {
        let i = JSON.parse(localStorage.getItem('baidangchuyenhuong'))
        var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
        if (!nguoihoatdong){
            window.location.href = "dangnhap.html"
        }
        else{
            let danhsachbaidang = down_local_baidang()
            if (!danhsachbaidang[i].like.includes(nguoihoatdong.tennguoidung)){
                danhsachbaidang[i].like.push(nguoihoatdong.tennguoidung);
            }
            else {
                danhsachbaidang[i].like = danhsachbaidang[i].like.filter(user => user !== nguoihoatdong.tennguoidung);
            }
            save_local_baidang(danhsachbaidang);
            let like = document.getElementById("like")
            like.innerHTML = danhsachbaidang[i].like.length;
            quanlilike()
            hienthilike()
        }
    })

    // truyền hàm thêm bình luận
    let cmtbtn = document.getElementById("cmtbtn")
    cmtbtn.onclick = function () {
        themcmt(i)
    }

    // hiển thị bình luận
    hienthibinhluan(danhsachbaidang[i].comment)
    
});

function quanlilike() {
    let danhsachbaidang = down_local_baidang()
    let i = JSON.parse(localStorage.getItem('baidangchuyenhuong'))
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    let btnlike = document.getElementById("likeButton")
    if(nguoihoatdong){
        if (danhsachbaidang[i].like.includes(nguoihoatdong.tennguoidung)){
            btnlike.style.color = "pink"
        }
        else{
            btnlike.style.color = "black"
        }
    }
}

// save và down bài đăng
function down_local_baidang(){
    danhsachbaidang = JSON.parse(localStorage.getItem('baidang')) || []
    return danhsachbaidang
}

function save_local_baidang(danhsachbaidang){
    localStorage.setItem('baidang',JSON.stringify(danhsachbaidang))
}

function down_local_nguoihoatdong(){
    a = JSON.parse(localStorage.getItem('nguoihoatdong')) || []
    return a
}


function hienthibinhluan(a) {
    let com = document.getElementById("cmt")
    let list = document.getElementById("listcmt")
    list.innerHTML = ""
    a.forEach((cmt,index) => {
        var newli = document.createElement("li")
        newli.innerHTML = `<i class="fas fa-user" class="logo"></i>  ${a[index].nguoicmt} : ${a[index].cmt}`
        list.appendChild(newli)
    });
    
}
function themcmt(i) {
    let cmt = document.getElementById("cmt").value
    let nguoihoatdong = down_local_nguoihoatdong()
        let danhsachbaidang = down_local_baidang()
        let comment = {
            cmt: cmt,
            nguoicmt : nguoihoatdong.tennguoidung || "Khách"
        }
        danhsachbaidang[i].comment.push(comment)
        save_local_baidang(danhsachbaidang)
        hienthibinhluan(danhsachbaidang[i].comment)
}
function hienthilike(){
    let listlike = document.getElementById("listlike")
    let danhsachbaidang = down_local_baidang()
    let i = JSON.parse(localStorage.getItem('baidangchuyenhuong'))
    let b = danhsachbaidang[i].like.join(", ")
    listlike.innerHTML = "Người like: " +b
    listlike.style.marginBottom = "10px"
}
